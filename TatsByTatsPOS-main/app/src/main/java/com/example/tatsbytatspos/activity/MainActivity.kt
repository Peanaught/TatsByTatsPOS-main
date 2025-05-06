package com.example.tatsbytatspos.activity

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.tatsbytatspos.R
import com.example.tatsbytatspos.adapter.ProductAdapter
import com.example.tatsbytatspos.database.ProductDatabaseHelper
import com.example.tatsbytatspos.fragment.TransactionFragment
import com.example.tatsbytatspos.model.Order
import com.example.tatsbytatspos.model.OrderItem
import com.example.tatsbytatspos.model.Product
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity(), TransactionFragment.OrderCompletionListener {
    
    private lateinit var drawerLayout: DrawerLayout
    private lateinit var navigationView: NavigationView
    private lateinit var toolbar: Toolbar
    private lateinit var recyclerView: RecyclerView
    private lateinit var productAdapter: ProductAdapter
    private lateinit var confirmButton: Button
    private lateinit var resetButton: Button
    private lateinit var searchEditText: EditText
    
    private val productList = mutableListOf<Product>()
    private val currentOrder = Order()
    private lateinit var dbHelper: ProductDatabaseHelper
    
    private val currentOrderItems = mutableListOf<OrderItem>()
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        
        // Initialize views
        drawerLayout = findViewById(R.id.drawer_layout)
        navigationView = findViewById(R.id.navigationView)
        toolbar = findViewById(R.id.toolbar)
        recyclerView = findViewById(R.id.menuRecyclerView)
        confirmButton = findViewById(R.id.confirm_button)
        resetButton = findViewById(R.id.resetButton)
        searchEditText = findViewById(R.id.searchProducts)
        
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
                    // Already on home screen
                    drawerLayout.closeDrawer(GravityCompat.START)
                }
                R.id.nav_inventory -> {
                    val intent = Intent(this, Inventory::class.java)
                    startActivity(intent)
                }
                R.id.nav_order_history -> {
                    val intent = Intent(this, OrderHistory::class.java)
                    startActivity(intent)
                }
                R.id.nav_db_monitor -> {
                    val intent = Intent(this, com.example.tatsbytatspos.example.DatabaseMonitoringActivity::class.java)
                    startActivity(intent)
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
        dbHelper = ProductDatabaseHelper(this)
        
        // Load products from database
        loadProducts()
        
        // Set up RecyclerView
        recyclerView.layoutManager = GridLayoutManager(this, 2)
        productAdapter = ProductAdapter(productList, object : ProductAdapter.OnProductListener {
            override fun onProductClick(position: Int) {
                val product = productList[position]
                addToOrder(product)
            }
            
            override fun onQuantityChanged(position: Int, quantity: Int) {
                val product = productList[position]
                updateOrderItem(product, quantity)
            }
        })
        recyclerView.adapter = productAdapter
        
        // Set up confirm button
        val confirmButton = findViewById<Button>(R.id.confirm_button)
        confirmButton.setOnClickListener {
            if (currentOrderItems.isNotEmpty()) {
                showTransactionFragment()
            } else {
                // Show message that cart is empty
                Toast.makeText(this, "Please add items to cart first", Toast.LENGTH_SHORT).show()
            }
        }
        
        // Set up reset button
        val resetButton = findViewById<Button>(R.id.resetButton)
        resetButton.setOnClickListener {
            resetOrder()
        }
        
        // Set up search functionality
        searchEditText.addTextChangedListener(object : android.text.TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                filterProducts(s.toString())
            }
            
            override fun afterTextChanged(s: android.text.Editable?) {}
        })
    }
    
    private fun loadProducts() {
        productList.clear()
        productList.addAll(dbHelper.getAllProducts())
        productAdapter.notifyDataSetChanged()
    }
    
    private fun filterProducts(query: String) {
        val filteredList = if (query.isEmpty()) {
            dbHelper.getAllProducts()
        } else {
            dbHelper.searchProducts(query)
        }
        
        productList.clear()
        productList.addAll(filteredList)
        productAdapter.notifyDataSetChanged()
    }
    
    private fun addToOrder(product: Product) {
        val orderItem = OrderItem(
            productId = product.id,
            productName = product.name,
            price = product.price,
            quantity = 1,
            imageUrl = product.imageUrl
        )
        currentOrder.addItem(orderItem)
    }
    
    private fun updateOrderItem(product: Product, quantity: Int) {
        val existingItem = currentOrder.items.find { it.productId == product.id }
        
        if (existingItem != null) {
            if (quantity <= 0) {
                currentOrder.removeItem(product.id)
            } else {
                existingItem.quantity = quantity
                currentOrder.calculateTotal()
            }
        } else if (quantity > 0) {
            addToOrder(product)
        }
    }
    
    private fun showTransactionFragment() {
        val fragment = TransactionFragment.newInstance(ArrayList(currentOrderItems))
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_layout, fragment)
            .addToBackStack(null)
            .commit()
    }
    
    private fun resetOrder() {
        currentOrderItems.clear()
        // Update UI to reflect empty cart
        // This depends on how you're displaying the current order
        Toast.makeText(this, "Order reset", Toast.LENGTH_SHORT).show()
    }
    
    // Add this method to add items to the current order
    fun addItemToOrder(item: OrderItem) {
        // Check if item already exists in order
        val existingItemIndex = currentOrderItems.indexOfFirst { it.productId == item.productId }
        
        if (existingItemIndex != -1) {
            // Update quantity of existing item
            val existingItem = currentOrderItems[existingItemIndex]
            val updatedItem = existingItem.copy(quantity = existingItem.quantity + item.quantity)
            currentOrderItems[existingItemIndex] = updatedItem
        } else {
            // Add new item
            currentOrderItems.add(item)
        }
        
        // Update UI to reflect changes
        // This depends on how you're displaying the current order
    }
    
    override fun onOrderCompleted() {
        // Clear the current order after completion
        resetOrder()
    }
    
    override fun onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }
}