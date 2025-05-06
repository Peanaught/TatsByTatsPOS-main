package com.example.tatsbytatspos.repository

import android.content.Context
import android.content.SharedPreferences
import com.example.tatsbytatspos.model.Order
import com.example.tatsbytatspos.model.OrderItem
import com.example.tatsbytatspos.model.OrderStatus
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.google.gson.reflect.TypeToken
import java.util.Date

class OrderRepository(context: Context) {
    
    private val sharedPreferences: SharedPreferences = context.getSharedPreferences(
        "orders_prefs", Context.MODE_PRIVATE
    )
    private val gson: Gson = GsonBuilder()
        .setDateFormat("yyyy-MM-dd'T'HH:mm:ss")
        .create()
    
    fun saveOrder(order: Order) {
        val orders = getAllOrders().toMutableList()
        orders.add(order)
        
        val ordersJson = gson.toJson(orders)
        sharedPreferences.edit().putString(ORDERS_KEY, ordersJson).apply()
    }
    
    fun getAllOrders(): List<Order> {
        val ordersJson = sharedPreferences.getString(ORDERS_KEY, null) ?: return emptyList()
        val type = object : TypeToken<List<Order>>() {}.type
        return gson.fromJson(ordersJson, type)
    }
    
    fun getOrderById(orderId: String): Order? {
        return getAllOrders().find { it.orderId == orderId }
    }
    
    fun updateOrderStatus(orderId: String, status: OrderStatus) {
        val orders = getAllOrders().toMutableList()
        val index = orders.indexOfFirst { it.orderId == orderId }
        
        if (index != -1) {
            val updatedOrder = orders[index].copy(status = status)
            orders[index] = updatedOrder
            
            val ordersJson = gson.toJson(orders)
            sharedPreferences.edit().putString(ORDERS_KEY, ordersJson).apply()
        }
    }
    
    companion object {
        private const val ORDERS_KEY = "orders"
    }
}