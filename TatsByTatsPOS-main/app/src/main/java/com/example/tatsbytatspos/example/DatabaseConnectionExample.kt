package com.example.tatsbytatspos.example

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.tatsbytatspos.database.DatabaseConnectionChecker
import com.example.tatsbytatspos.util.DatabaseConnectionManager

/**
 * Example class showing how to implement database connection checking
 * This is a reference implementation that can be integrated into existing activities
 */
class DatabaseConnectionExample : AppCompatActivity() {

    private lateinit var dbConnectionManager: DatabaseConnectionManager
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        
        // Initialize the database connection manager
        dbConnectionManager = DatabaseConnectionManager(this)
        
        // Check database connections on startup
        checkDatabaseConnection()
    }
    
    /**
     * Checks if database connections are stable
     * Shows appropriate messages and takes action based on connection status
     */
    private fun checkDatabaseConnection() {
        // Option 1: Simple check with automatic recovery attempt
        if (!dbConnectionManager.checkDatabaseConnections()) {
            // Connection issues that couldn't be recovered automatically
            showDatabaseErrorDialog()
        }
        
        // Option 2: Get detailed status of each database
        val connectionStatus = dbConnectionManager.getDatabaseConnectionStatus()
        if (!connectionStatus.all { it.value }) {
            // Some connections are unstable
            val unstableConnections = connectionStatus.filter { !it.value }.keys.joinToString(", ")
            Toast.makeText(this, "Unstable database connections: $unstableConnections", Toast.LENGTH_LONG).show()
        }
    }
    
    /**
     * Shows an error dialog when database connections are unstable
     */
    private fun showDatabaseErrorDialog() {
        AlertDialog.Builder(this)
            .setTitle("Database Connection Issue")
            .setMessage("There seems to be an issue with the database connection. Would you like to try again?")
            .setPositiveButton("Try Again") { _, _ ->
                // Attempt recovery again
                val recovered = DatabaseConnectionChecker.recoverDatabaseConnections(this)
                if (recovered) {
                    Toast.makeText(this, "Database connection recovered!", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(this, "Still having issues. Please restart the app.", Toast.LENGTH_LONG).show()
                }
            }
            .setNegativeButton("Cancel", null)
            .show()
    }
    
    /**
     * Example of how to check database connection before performing database operations
     */
    private fun performDatabaseOperation() {
        // Always check connection before database operations
        if (DatabaseConnectionChecker.areAllDatabaseConnectionsStable(this)) {
            // Proceed with database operation
            Toast.makeText(this, "Performing database operation...", Toast.LENGTH_SHORT).show()
            // Your database code here...
        } else {
            // Handle connection issue
            Toast.makeText(this, "Cannot perform operation - database connection issue", Toast.LENGTH_LONG).show()
        }
    }
}