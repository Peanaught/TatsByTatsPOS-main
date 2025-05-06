package com.example.tatsbytatspos.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.tatsbytatspos.R
import com.example.tatsbytatspos.adapter.OrderItemAdapter
import com.example.tatsbytatspos.model.Order
import com.example.tatsbytatspos.model.OrderItem
import com.example.tatsbytatspos.model.OrderStatus
import com.example.tatsbytatspos.repository.OrderRepository
import java.text.NumberFormat
import java.util.Date
import java.util.Locale

class TransactionFragment : Fragment() {
    
    private lateinit var orderItemAdapter: OrderItemAdapter
    private lateinit var orderItems: List<OrderItem>
    private lateinit var totalAmountText: TextView
    private lateinit var orderRepository: OrderRepository
    
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_transaction, container, false)
        
        // Initialize the order repository
        orderRepository = OrderRepository(requireContext())
        
        // Get order items from arguments
        orderItems = arguments?.getParcelableArrayList("orderItems") ?: emptyList()
        
        // Set up RecyclerView
        val recyclerView = view.findViewById<RecyclerView>(R.id.orderItemsRecyclerView)
        orderItemAdapter = OrderItemAdapter(orderItems)
        recyclerView.adapter = orderItemAdapter
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        
        // Set up total amount
        totalAmountText = view.findViewById(R.id.totalAmountText)
        updateTotalAmount()
        
        // Set up buttons
        val exitButton = view.findViewById<ImageButton>(R.id.exit)
        exitButton.setOnClickListener {
            parentFragmentManager.popBackStack()
        }
        
        val cancelOrderButton = view.findViewById<Button>(R.id.cancelOrderButton)
        cancelOrderButton.setOnClickListener {
            parentFragmentManager.popBackStack()
        }
        
        val completeOrderButton = view.findViewById<Button>(R.id.completeOrderButton)
        completeOrderButton.setOnClickListener {
            completeOrder()
        }
        
        return view
    }
    
    private fun updateTotalAmount() {
        val total = orderItemAdapter.calculateTotal()
        val formatter = NumberFormat.getCurrencyInstance(Locale("en", "PH"))
        totalAmountText.text = "Total: ${formatter.format(total)}"
    }
    
    private fun completeOrder() {
        // Create and save the order
        val order = Order(
            orderDate = Date(),
            items = orderItems,
            totalAmount = orderItemAdapter.calculateTotal(),
            status = OrderStatus.COMPLETED
        )
        
        orderRepository.saveOrder(order)
        
        // Show confirmation message
        // You can use a Toast or Snackbar here
        
        // Return to main activity and clear the current order
        parentFragmentManager.popBackStack()
        (activity as? OrderCompletionListener)?.onOrderCompleted()
    }
    
    interface OrderCompletionListener {
        fun onOrderCompleted()
    }
    
    companion object {
        fun newInstance(orderItems: ArrayList<OrderItem>): TransactionFragment {
            val fragment = TransactionFragment()
            val args = Bundle()
            args.putParcelableArrayList("orderItems", orderItems)
            fragment.arguments = args
            return fragment
        }
    }
}