package com.example.tatsbytatspos.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.tatsbytatspos.R
import com.example.tatsbytatspos.model.OrderItem
import java.text.NumberFormat
import java.util.Locale

class OrderItemAdapter(
    private val items: List<OrderItem>
) : RecyclerView.Adapter<OrderItemAdapter.OrderItemViewHolder>() {
    
    class OrderItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val productName: TextView = itemView.findViewById(R.id.item_name)
        val productPrice: TextView = itemView.findViewById(R.id.item_price)
        val productQuantity: TextView = itemView.findViewById(R.id.item_quantity)
        val productSubtotal: TextView = itemView.findViewById(R.id.item_subtotal)
        val productImage: ImageView = itemView.findViewById(R.id.item_image)
    }
    
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OrderItemViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.order_item_card, parent, false)
        return OrderItemViewHolder(view)
    }
    
    override fun onBindViewHolder(holder: OrderItemViewHolder, position: Int) {
        val currentItem = items[position]
        val formatter = NumberFormat.getCurrencyInstance(Locale("en", "PH"))
        
        holder.productName.text = currentItem.productName
        holder.productPrice.text = formatter.format(currentItem.productPrice)
        holder.productQuantity.text = "Qty: ${currentItem.quantity}"
        
        val subtotal = currentItem.productPrice * currentItem.quantity
        holder.productSubtotal.text = formatter.format(subtotal)
        
        // Set the product image if available
        currentItem.productImageResId?.let {
            holder.productImage.setImageResource(it)
        }
    }
    
    override fun getItemCount(): Int {
        return items.size
    }
    
    fun calculateTotal(): Double {
        return items.sumOf { it.productPrice * it.quantity }
    }
}