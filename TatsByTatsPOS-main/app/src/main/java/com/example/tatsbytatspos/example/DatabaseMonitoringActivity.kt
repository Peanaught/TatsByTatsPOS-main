package com.example.tatsbytatspos.example

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.tatsbytatspos.database.DatabaseConnectionMonitor

/**
 * Example activity showing how to implement continuous database connection monitoring
 * This demonstrates real-time connection status updates using DatabaseConnectionMonitor
 */
class DatabaseMonitoringActivity : AppCompatActivity(), DatabaseConnectionMonitor.ConnectionStatusListener {

    private lateinit var dbConnectionMonitor: DatabaseConnectionMonitor
    private lateinit var statusTextView: TextView
    private lateinit var startMonitoringButton: Button
    private lateinit var stopMonitoringButton: Button
    private lateinit var checkNowButton: Button
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Layout file has been created
        setContentView(R.layout.activity_database_monitoring)
        
        // Initialize views
        statusTextView = findViewById(R.id.statusTextView)
        startMonitoringButton = findViewById(R.id.startMonitoringButton)
        stopMonitoringButton = findViewById(R.id.stopMonitoringButton)
        checkNowButton = findViewById(R.id.checkNowButton)
        
        // Initialize the database connection monitor
        dbConnectionMonitor = DatabaseConnectionMonitor.getInstance(this)
        dbConnectionMonitor.setConnectionStatusListener(this)
        
        // Set up button click listeners
        setupButtonListeners()
        
        // Initial connection check
        performInitialConnectionCheck()
    }
    
    private fun setupButtonListeners() {
        // Connect buttons to their respective functions
        startMonitoringButton.setOnClickListener {
            startDatabaseMonitoring()
        }
        
        stopMonitoringButton.setOnClickListener {
            stopDatabaseMonitoring()
        }
        
        checkNowButton.setOnClickListener {
            checkConnectionNow()
        }
    }
    
    private fun performInitialConnectionCheck() {
        // Check connection status immediately when activity starts
        val isStable = dbConnectionMonitor.checkConnectionsNow()
        updateStatusDisplay(isStable)
    }
    
    /**
     * Starts continuous monitoring of database connections
     */
    private fun startDatabaseMonitoring() {
        // Start monitoring with 15-second interval
        dbConnectionMonitor.startMonitoring(15)
        updateButtonStates(isMonitoring = true)
    }
    
    /**
     * Stops continuous monitoring of database connections
     */
    private fun stopDatabaseMonitoring() {
        dbConnectionMonitor.stopMonitoring()
        updateButtonStates(isMonitoring = false)
    }
    
    /**
     * Performs an immediate check of database connections
     */
    private fun checkConnectionNow() {
        val isStable = dbConnectionMonitor.checkConnectionsNow()
        updateStatusDisplay(isStable)
    }
    
    /**
     * Updates the UI based on connection status
     */
    private fun updateStatusDisplay(isStable: Boolean) {
        // Update the status TextView with connection status
        if (isStable) {
            statusTextView.text = "Database Connection: STABLE"
            statusTextView.setTextColor(getColor(android.R.color.holo_green_dark))
        } else {
            statusTextView.text = "Database Connection: UNSTABLE"
            statusTextView.setTextColor(getColor(android.R.color.holo_red_dark))
        }
    }
    
    /**
     * Updates button enabled states based on monitoring status
     */
    private fun updateButtonStates(isMonitoring: Boolean) {
        // Update button states based on monitoring status
        startMonitoringButton.isEnabled = !isMonitoring
        stopMonitoringButton.isEnabled = isMonitoring
    }
    
    /**
     * Implementation of ConnectionStatusListener interface
     * Called when database connection status changes
     */
    override fun onConnectionStatusChanged(isStable: Boolean, statusMap: Map<String, Boolean>) {
        // Update UI with connection status
        updateStatusDisplay(isStable)
        
        // Show detailed status for each database connection
        val detailsBuilder = StringBuilder()
        statusMap.forEach { (dbName, status) ->
            val statusText = if (status) "OK" else "ERROR"
            detailsBuilder.append("$dbName: $statusText\n")
        }
        findViewById<TextView>(R.id.detailsTextView).text = detailsBuilder.toString()
    }
    
    override fun onDestroy() {
        super.onDestroy()
        // Clean up resources
        dbConnectionMonitor.stopMonitoring()
        dbConnectionMonitor.setConnectionStatusListener(null)
    }
}