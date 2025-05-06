package com.example.tatsbytatspos.database

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteException
import android.util.Log
import com.example.tatsbytatspos.data.OrderDatabase
import com.example.tatsbytatspos.data.ProductDatabase

/**
 * Utility class to check database connection stability
 * This class provides methods to verify if database connections are working properly
 * and handles connection errors gracefully.
 */
class DatabaseConnectionChecker {
    companion object {
        private const val TAG = "DatabaseConnectionChecker"
        
        /**
         * Checks if the OrderDatabase connection is stable
         * @param context The application context
         * @return true if connection is stable, false otherwise
         */
        fun isOrderDatabaseConnectionStable(context: Context): Boolean {
            return try {
                val orderDb = OrderDatabase(context)
                val db = orderDb.readableDatabase
                val isOpen = db.isOpen
                db.close()
                orderDb.close()
                isOpen
            } catch (e: SQLiteException) {
                Log.e(TAG, "Order database connection error: ${e.message}")
                false
            } catch (e: Exception) {
                Log.e(TAG, "Unexpected error with order database: ${e.message}")
                false
            }
        }
        
        /**
         * Checks if the ProductDatabase connection is stable
         * @param context The application context
         * @return true if connection is stable, false otherwise
         */
        fun isProductDatabaseConnectionStable(context: Context): Boolean {
            return try {
                val productDb = ProductDatabase(context)
                val db = productDb.readableDatabase
                val isOpen = db.isOpen
                db.close()
                productDb.close()
                isOpen
            } catch (e: SQLiteException) {
                Log.e(TAG, "Product database connection error: ${e.message}")
                false
            } catch (e: Exception) {
                Log.e(TAG, "Unexpected error with product database: ${e.message}")
                false
            }
        }
        
        /**
         * Checks if the OrderDatabaseHelper connection is stable
         * @param context The application context
         * @return true if connection is stable, false otherwise
         */
        fun isOrderDatabaseHelperConnectionStable(context: Context): Boolean {
            return try {
                val orderDbHelper = OrderDatabaseHelper(context)
                val db = orderDbHelper.readableDatabase
                val isOpen = db.isOpen
                db.close()
                orderDbHelper.close()
                isOpen
            } catch (e: SQLiteException) {
                Log.e(TAG, "OrderDatabaseHelper connection error: ${e.message}")
                false
            } catch (e: Exception) {
                Log.e(TAG, "Unexpected error with OrderDatabaseHelper: ${e.message}")
                false
            }
        }
        
        /**
         * Checks if all database connections are stable
         * @param context The application context
         * @return true if all connections are stable, false if any connection fails
         */
        fun areAllDatabaseConnectionsStable(context: Context): Boolean {
            val orderDbStable = isOrderDatabaseConnectionStable(context)
            val productDbStable = isProductDatabaseConnectionStable(context)
            val orderHelperDbStable = isOrderDatabaseHelperConnectionStable(context)
            
            return orderDbStable && productDbStable && orderHelperDbStable
        }
        
        /**
         * Attempts to recover database connections if they're unstable
         * @param context The application context
         * @return true if recovery was successful, false otherwise
         */
        fun recoverDatabaseConnections(context: Context): Boolean {
            var recoverySuccessful = true
            
            try {
                // Try to close and reopen connections
                val orderDb = OrderDatabase(context)
                orderDb.close()
                val orderDbHelper = OrderDatabaseHelper(context)
                orderDbHelper.close()
                val productDb = ProductDatabase(context)
                productDb.close()
                
                // Check if connections are now stable
                recoverySuccessful = areAllDatabaseConnectionsStable(context)
            } catch (e: Exception) {
                Log.e(TAG, "Failed to recover database connections: ${e.message}")
                recoverySuccessful = false
            }
            
            return recoverySuccessful
        }
    }
}