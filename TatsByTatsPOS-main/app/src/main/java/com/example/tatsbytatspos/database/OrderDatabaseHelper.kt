package com.example.tatsbytatspos.database

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.example.tatsbytatspos.model.Order
import com.example.tatsbytatspos.model.OrderItem
import com.example.tatsbytatspos.model.OrderStatus
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class OrderDatabaseHelper(context: Context) : 
    SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    companion object {
        private const val DATABASE_VERSION = 1
        private const val DATABASE_NAME = "OrdersDatabase.db"
        
        // Orders table
        private const val TABLE_ORDERS = "orders"
        private const val COLUMN_ORDER_ID = "order_id"
        private const val COLUMN_DATE_TIME = "date_time"
        private const val COLUMN_ITEMS = "items"
        private const val COLUMN_TOTAL_AMOUNT = "total_amount"
        private const val COLUMN_STATUS = "status"
    }

    override fun onCreate(db: SQLiteDatabase) {
        val createOrdersTable = """
            CREATE TABLE $TABLE_ORDERS (
                $COLUMN_ORDER_ID TEXT PRIMARY KEY,
                $COLUMN_DATE_TIME TEXT,
                $COLUMN_ITEMS TEXT,
                $COLUMN_TOTAL_AMOUNT REAL,
                $COLUMN_STATUS TEXT
            )
        """.trimIndent()
        
        db.execSQL(createOrdersTable)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL("DROP TABLE IF EXISTS $TABLE_ORDERS")
        onCreate(db)
    }
    
    fun saveOrder(order: Order): Long {
        val db = this.writableDatabase
        val values = ContentValues()
        
        values.put(COLUMN_ORDER_ID, order.orderId)
        values.put(COLUMN_DATE_TIME, SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault()).format(order.dateTime))
        
        // Convert items list to JSON string
        val gson = Gson()
        val itemsJson = gson.toJson(order.items)
        values.put(COLUMN_ITEMS, itemsJson)
        
        values.put(COLUMN_TOTAL_AMOUNT, order.totalAmount)
        values.put(COLUMN_STATUS, order.status.name)
        
        val result = db.insert(TABLE_ORDERS, null, values)
        db.close()
        return result
    }
    
    fun getAllOrders(): List<Order> {
        val ordersList = mutableListOf<Order>()
        val selectQuery = "SELECT * FROM $TABLE_ORDERS ORDER BY $COLUMN_DATE_TIME DESC"
        
        val db = this.readableDatabase
        val cursor = db.rawQuery(selectQuery, null)
        
        if (cursor.moveToFirst()) {
            val gson = Gson()
            val itemType = object : TypeToken<List<OrderItem>>() {}.type
            
            do {
                val orderId = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_ORDER_ID))
                val dateTimeStr = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_DATE_TIME))
                val itemsJson = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_ITEMS))
                val totalAmount = cursor.getDouble(cursor.getColumnIndexOrThrow(COLUMN_TOTAL_AMOUNT))
                val statusStr = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_STATUS))
                
                val dateFormat = SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault())
                val dateTime = dateFormat.parse(dateTimeStr) ?: Date()
                
                val items = gson.fromJson<List<OrderItem>>(itemsJson, itemType)
                val status = OrderStatus.valueOf(statusStr)
                
                val order = Order(orderId, dateTime, items.toMutableList(), totalAmount, status)
                ordersList.add(order)
            } while (cursor.moveToNext())
        }
        
        cursor.close()
        db.close()
        return ordersList
    }
    
    fun getOrderById(orderId: String): Order? {
        val db = this.readableDatabase
        val cursor = db.query(
            TABLE_ORDERS,
            null,
            "$COLUMN_ORDER_ID = ?",
            arrayOf(orderId),
            null, null, null
        )
        
        var order: Order? = null
        
        if (cursor.moveToFirst()) {
            val gson = Gson()
            val itemType = object : TypeToken<List<OrderItem>>() {}.type
            
            val dateTimeStr = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_DATE_TIME))
            val itemsJson = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_ITEMS))
            val totalAmount = cursor.getDouble(cursor.getColumnIndexOrThrow(COLUMN_TOTAL_AMOUNT))
            val statusStr = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_STATUS))
            
            val dateFormat = SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault())
            val dateTime = dateFormat.parse(dateTimeStr) ?: Date()
            
            val items = gson.fromJson<List<OrderItem>>(itemsJson, itemType)
            val status = OrderStatus.valueOf(statusStr)
            
            order = Order(orderId, dateTime, items.toMutableList(), totalAmount, status)
        }
        
        cursor.close()
        db.close()
        return order
    }
    
    fun updateOrderStatus(orderId: String, status: OrderStatus): Int {
        val db = this.writableDatabase
        val values = ContentValues()
        values.put(COLUMN_STATUS, status.name)
        
        val result = db.update(
            TABLE_ORDERS,
            values,
            "$COLUMN_ORDER_ID = ?",
            arrayOf(orderId)
        )
        
        db.close()
        return result
    }
}