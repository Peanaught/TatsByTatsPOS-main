package com.example.tatsbytatspos.util

import android.content.Context
import android.widget.Toast
import com.example.tatsbytatspos.database.DatabaseConnectionChecker

/**
 * Utility class to manage database connections in the application
 * This class provides methods to check database connection stability and handle connection issues
 */
class DatabaseConnectionManager(private val context: Context) {
    
    /**
     * Checks if all database connections are stable and shows appropriate messages
     * @return true if all connections are stable, false otherwise
     */
    fun checkDatabaseConnections(): Boolean {
        val isStable = DatabaseConnectionChecker.areAllDatabaseConnectionsStable(context)
        
        if (!isStable) {
            // Attempt to recover the connections
            val recoverySuccessful = DatabaseConnectionChecker.recoverDatabaseConnections(context)
            
            if (recoverySuccessful) {
                Toast.makeText(context, "Database connection recovered successfully", Toast.LENGTH_SHORT).show()
                return true
            } else {
                Toast.makeText(context, "Database connection issue detected. Please restart the app.", Toast.LENGTH_LONG).show()
                return false
            }
        }
        
        return true
    }
    
    /**
     * Example of how to use this in an activity or fragment:
     * 
     * // In your activity's onCreate or fragment's onCreateView
     * val dbManager = DatabaseConnectionManager(this)
     * if (!dbManager.checkDatabaseConnections()) {
     *     // Handle connection issues (e.g., disable database-dependent features)
     *     disableDatabaseFeatures()
     * }
     */
    
    /**
     * Checks specific database connection and returns detailed status
     * @return Map containing status of each database connection
     */
    fun getDatabaseConnectionStatus(): Map<String, Boolean> {
        return mapOf(
            "Order Database" to DatabaseConnectionChecker.isOrderDatabaseConnectionStable(context),
            "Product Database" to DatabaseConnectionChecker.isProductDatabaseConnectionStable(context),
            "Order Helper Database" to DatabaseConnectionChecker.isOrderDatabaseHelperConnectionStable(context)
        )
    }
    
    /**
     * Shows a toast with the current database connection status
     */
    fun showDatabaseConnectionStatus() {
        val statusMap = getDatabaseConnectionStatus()
        val allStable = statusMap.all { it.value }
        
        if (allStable) {
            Toast.makeText(context, "All database connections are stable", Toast.LENGTH_SHORT).show()
        } else {
            val unstableConnections = statusMap.filter { !it.value }.keys.joinToString(", ")
            Toast.makeText(context, "Unstable connections: $unstableConnections", Toast.LENGTH_LONG).show()
        }
    }
}