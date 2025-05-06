package com.example.tatsbytatspos.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.tatsbytatspos.R
import com.example.tatsbytatspos.model.Order
import com.example.tatsbytatspos.model.OrderStatus
import java.text.NumberFormat
import java.text.SimpleDateFormat
import java.util.Locale

class OrderHistoryAdapter(
    private val orders: List<Order>,
    private val onOrderClick: (Order) -> Unit
) : RecyclerView.Adapter<OrderHistoryAdapter.OrderViewHolder>() {
    
    class OrderViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val orderNumber: TextView = itemView.findViewById(R.id.order_number)
        val orderDate: TextView = itemView.findViewById(R.id.order_date)
        val orderItems: TextView = itemView.findViewById(R.id.order_items)
        val orderTotal: TextView = itemView.findViewById(R.id.order_total)
        val orderStatus: TextView = itemView.findViewById(R.id.order_status)
        val orderCard: LinearLayout = itemView.findViewById(R.id.order_card)
    }
    
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OrderViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.order_cards, parent, false)
        return OrderViewHolder(view)
    }
    
    override fun onBindViewHolder(holder: OrderViewHolder, position: Int) {
        val currentOrder = orders[position]
        val formatter = NumberFormat.getCurrencyInstance(Locale("en", "PH"))
        val dateFormatter = SimpleDateFormat("MMM dd, yyyy HH:mm", Locale.getDefault())
        
        // Set order ID (shortened for display)
        holder.orderNumber.text = "Order #${currentOrder.orderId.substring(0, 8)}"
        
        // Set date
        holder.orderDate.text = dateFormatter.format(currentOrder.orderDate)
        
        // Set items count
        holder.orderItems.text = "Items: ${currentOrder.items.size}"
        
        // Set total
        holder.orderTotal.text = "Total: ${formatter.format(currentOrder.totalAmount)}"
        
        // Set status
        holder.orderStatus.text = currentOrder.status.name
        
        // Set status color based on order status
        when (currentOrder.status) {
            OrderStatus.COMPLETED -> holder.orderStatus.setBackgroundResource(R.drawable.status_completed)
            OrderStatus.CANCELED -> holder.orderStatus.setBackgroundResource(R.drawable.status_canceled)
            OrderStatus.PENDING -> holder.orderStatus.setBackgroundResource(R.drawable.status_pending)
        }
        
        // Set click listener
        holder.orderCard.setOnClickListener {
            onOrderClick(currentOrder)
        }
    }
    
    override fun getItemCount(): Int {
        return orders.size
    }
}