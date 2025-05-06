package com.example.tatsbytatspos.activity

import android.content.Intent
import android.os.Bundle
import android.widget.EditText
import android.widget.ImageButton
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.tatsbytatspos.R
import com.example.tatsbytatspos.adapter.OrderAdapter
import com.example.tatsbytatspos.database.OrderDatabaseHelper
import com.example.tatsbytatspos.fragment.OrderDetailsFragment
import com.example.tatsbytatspos.model.Order
import com.google.android.material.navigation.NavigationView

class OrderHistory : AppCompatActivity() {
    
    private lateinit var drawerLayout: DrawerLayout
    private lateinit var navigationView: NavigationView
    private lateinit var toolbar: Toolbar
    private lateinit var recyclerView: RecyclerView
    private lateinit var orderAdapter: OrderAdapter
    private lateinit var searchEditText: EditText
    
    private val ordersList = mutableListOf<Order>()
    private lateinit var dbHelper: OrderDatabaseHelper
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_order_history)
        
        // Initialize views
        drawerLayout = findViewById(R.id.drawer_layout)
        navigationView = findViewById(R.id.navigationView)
        toolbar = findViewById(R.id.toolbar)
        recyclerView = findViewById(R.id.menuRecyclerView)
        searchEditText = findViewById(R.id.searchOrders)
        
        // Set up toolbar and navigation drawer
        setSupportActionBar(toolbar)
        val toggle = ActionBarDrawerToggle(
            this, drawerLayout, toolbar,
            R.string.navigation_drawer_open, R.string.navigation_drawer_close
        )
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()
        
        // Set up navigation view item selection
        navigationView.setNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.nav_home -> {
                    val intent = Intent(this, MainActivity::class.java)
                    intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
                    startActivity(intent)
                }
                R.id.nav_inventory -> {
                    val intent = Intent(this, Inventory::class.java)
                    startActivity(intent)
                    finish()
                }
                R.id.nav_order_history -> {
                    // Already on order history screen
                    drawerLayout.closeDrawer(GravityCompat.START)
                }
            }
            drawerLayout.closeDrawer(GravityCompat.START)
            true
        }
        
        // Set up sidebar button
        val sideBarButton = findViewById<ImageButton>(R.id.sideBarButton)
        sideBarButton.setOnClickListener {
            if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
                drawerLayout.closeDrawer(GravityCompat.START)
            } else {
                drawerLayout.openDrawer(GravityCompat.START)
            }
        }
        
        // Initialize database helper
        dbHelper = OrderDatabaseHelper(this)
        
        // Load orders from database
        loadOrders()
        
        // Set up RecyclerView
        recyclerView.layoutManager = LinearLayoutManager(this)
        orderAdapter = OrderAdapter(ordersList) { position ->
            val order = ordersList[position]
            showOrderDetails(order)
        }
        recyclerView.adapter = orderAdapter
        
        // Set up search functionality
        searchEditText.addTextChangedListener(object : android.text.TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                filterOrders(s.toString())
            }
            
            override fun afterTextChanged(s: android.text.Editable?) {}
        })
    }
    
    private fun loadOrders() {
        ordersList.clear()
        ordersList.addAll(dbHelper.getAllOrders())
        orderAdapter.notifyDataSetChanged()
    }
    
    private fun filterOrders(query: String) {
        val allOrders = dbHelper.getAllOrders()
        val filteredList = if (query.isEmpty()) {
            allOrders
        } else {
            allOrders.filter { 
                it.orderId.contains(query, ignoreCase = true) || 
                it.items.any { item -> item.productName.contains(query, ignoreCase = true) }
            }
        }
        
        ordersList.clear()
        ordersList.addAll(filteredList)
        orderAdapter.notifyDataSetChanged()
    }
    
    private fun showOrderDetails(order: Order) {
        val fragment = OrderDetailsFragment.newInstance(order)
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .addToBackStack(null)
            .commit()
    }
    
    override fun onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }
}