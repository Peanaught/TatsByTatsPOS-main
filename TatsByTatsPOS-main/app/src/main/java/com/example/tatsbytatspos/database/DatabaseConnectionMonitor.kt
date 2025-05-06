package com.example.tatsbytatspos.database

import android.content.Context
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.widget.Toast
import com.example.tatsbytatspos.util.DatabaseConnectionManager
import java.util.concurrent.Executors
import java.util.concurrent.TimeUnit

/**
 * A monitor class that periodically checks database connection stability
 * and provides real-time status updates.
 */
class DatabaseConnectionMonitor private constructor(private val context: Context) {
    private val handler = Handler(Looper.getMainLooper())
    private val executor = Executors.newSingleThreadScheduledExecutor()
    private val dbConnectionManager = DatabaseConnectionManager(context)
    private var isMonitoring = false
    private var monitoringInterval = DEFAULT_INTERVAL_SECONDS
    private var connectionStatusListener: ConnectionStatusListener? = null
    
    companion object {
        private const val TAG = "DatabaseConnectionMonitor"
        private const val DEFAULT_INTERVAL_SECONDS = 30L
        
        @Volatile
        private var INSTANCE: DatabaseConnectionMonitor? = null
        
        fun getInstance(context: Context): DatabaseConnectionMonitor {
            return INSTANCE ?: synchronized(this) {
                INSTANCE ?: DatabaseConnectionMonitor(context.applicationContext).also {
                    INSTANCE = it
                }
            }
        }
    }
    
    /**
     * Interface for listening to connection status changes
     */
    interface ConnectionStatusListener {
        fun onConnectionStatusChanged(isStable: Boolean, statusMap: Map<String, Boolean>)
    }
    
    /**
     * Sets a listener to receive connection status updates
     */
    fun setConnectionStatusListener(listener: ConnectionStatusListener) {
        this.connectionStatusListener = listener
    }
    
    /**
     * Starts monitoring database connections at specified interval
     * @param intervalSeconds How often to check connections (in seconds)
     */
    fun startMonitoring(intervalSeconds: Long = DEFAULT_INTERVAL_SECONDS) {
        if (isMonitoring) return
        
        monitoringInterval = intervalSeconds
        isMonitoring = true
        
        executor.scheduleAtFixedRate({
            try {
                val statusMap = dbConnectionManager.getDatabaseConnectionStatus()
                val isStable = statusMap.all { it.value }
                
                // Notify on main thread
                handler.post {
                    connectionStatusListener?.onConnectionStatusChanged(isStable, statusMap)
                    
                    // If connection is unstable, attempt recovery
                    if (!isStable) {
                        Log.w(TAG, "Unstable database connection detected")
                        val recovered = DatabaseConnectionChecker.recoverDatabaseConnections(context)
                        if (recovered) {
                            Log.i(TAG, "Database connection recovered successfully")
                        } else {
                            Log.e(TAG, "Failed to recover database connection")
                        }
                    }
                }
            } catch (e: Exception) {
                Log.e(TAG, "Error monitoring database connection: ${e.message}")
            }
        }, 0, monitoringInterval, TimeUnit.SECONDS)
        
        Log.i(TAG, "Database connection monitoring started (interval: $monitoringInterval seconds)")
    }
    
    /**
     * Stops monitoring database connections
     */
    fun stopMonitoring() {
        if (!isMonitoring) return
        
        executor.shutdown()
        isMonitoring = false
        Log.i(TAG, "Database connection monitoring stopped")
    }
    
    /**
     * Performs an immediate check of database connections
     * @return true if all connections are stable, false otherwise
     */
    fun checkConnectionsNow(): Boolean {
        val statusMap = dbConnectionManager.getDatabaseConnectionStatus()
        val isStable = statusMap.all { it.value }
        
        connectionStatusListener?.onConnectionStatusChanged(isStable, statusMap)
        
        if (!isStable) {
            // Show toast on main thread
            handler.post {
                Toast.makeText(
                    context,
                    "Database connection issue detected",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
        
        return isStable
    }
    
    /**
     * Cleans up resources when no longer needed
     */
    fun cleanup() {
        stopMonitoring()
        connectionStatusListener = null
        INSTANCE = null
    }
}