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

class OrderAdapter(
    private val ordersList: List<Order>,
    private val onOrderClickListener: (Int) -> Unit
) : RecyclerView.Adapter<OrderAdapter.OrderViewHolder>() {
    
    class OrderViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val orderCard: LinearLayout = itemView.findViewById(R.id.order_card)
        val orderNumber: TextView = itemView.findViewById(R.id.order_number)
        val orderDate: TextView = itemView.findViewById(R.id.order_date)
        val orderTotal: TextView = itemView.findViewById(R.id.order_total)
        val orderStatus: TextView = itemView.findViewById(R.id.order_status)
    }
    
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OrderViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.order_cards, parent, false)
        return OrderViewHolder(view)
    }
    
    override fun onBindViewHolder(holder: OrderViewHolder, position: Int) {
        val order = ordersList[position]
        
        // Format order ID
        holder.orderNumber.text = "Order #${order.orderId.takeLast(8)}"
        
        // Format date
        val dateFormat = SimpleDateFormat("MMM dd, yyyy HH:mm", Locale.getDefault())
        holder.orderDate.text = dateFormat.format(order.dateTime)
        
        // Format total amount
        val formatter = NumberFormat.getCurrencyInstance(Locale.getDefault())
        holder.orderTotal.text = formatter.format(order.totalAmount)
        
        // Set status
        holder.orderStatus.text = order.status.name
        
        // Set status color
        val statusColor = when (order.status) {
            OrderStatus.COMPLETED -> R.color.green
            OrderStatus.PENDING -> R.color.orange
            OrderStatus.CANCELED -> R.color.red
        }
        holder.orderStatus.setTextColor(holder.itemView.context.getColor(statusColor))
        
        // Set click listener
        holder.orderCard.setOnClickListener {
            onOrderClickListener(position)
        }
    }
    
    override fun getItemCount(): Int = ordersList.size
}