package com.example.tatsbytatspos.activity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tatsbytatspos.data.OrderDatabase;
import com.example.tatsbytatspos.data.ProductDatabase;
import com.example.tatsbytatspos.fragment.PaymentFragment;
import com.example.tatsbytatspos.model.Product;
import com.example.tatsbytatspos.adapter.ProductAdapter;
import com.example.tatsbytatspos.R;
import com.google.android.material.navigation.NavigationView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    private DrawerLayout drawerLayout;
    private Toolbar toolbar;
    private ImageButton sideBarButton;
    private RecyclerView recyclerView;
    private ProductAdapter productAdapter;
    private List<Product> productList;
    private NavigationView navigationView;
    private Button confirmButton;
    private Button resetButton;
    private OrderDatabase orderDatabase;
    private Map<Integer, Integer> orderedQuantities = new HashMap<>(); // Product ID → Quantity
    ProductDatabase db;


    private FrameLayout fragmentLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize views
        drawerLayout = findViewById(R.id.drawer_layout);
        toolbar = findViewById(R.id.toolbar);
        sideBarButton = findViewById(R.id.sideBarButton);
        navigationView = findViewById(R.id.navigationView);
        confirmButton = findViewById(R.id.confirm_button);
        resetButton = findViewById(R.id.resetButton);
        recyclerView = findViewById(R.id.menuRecyclerView);
        fragmentLayout = findViewById(R.id.fragment_layout);

        db = new ProductDatabase(this);
        orderDatabase = new OrderDatabase(this);
        productList = new ArrayList<>();

        // Set up the Toolbar
        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setDisplayShowTitleEnabled(false);

        // Sidebar button opens drawer
        sideBarButton.setOnClickListener(v -> drawerLayout.openDrawer(GravityCompat.START));

        // Navigation drawer item clicks
        navigationView.setNavigationItemSelectedListener(item -> {
            int id = item.getItemId();
            if (id == R.id.nav_home) {
                Toast.makeText(MainActivity.this, "Already on this screen!", Toast.LENGTH_SHORT).show();
            } else if (id == R.id.nav_history) {
                startActivity(new Intent(MainActivity.this, OrderHistory.class));
                //Toast.makeText(MainActivity.this, "History clicked", Toast.LENGTH_SHORT).show();
            } else if (id == R.id.nav_inventory) {
                startActivity(new Intent(MainActivity.this, Inventory.class));
                //Toast.makeText(MainActivity.this, "Inventory clicked", Toast.LENGTH_SHORT).show();
            }
            drawerLayout.closeDrawer(GravityCompat.START);
            return true;
        });

         confirmButton.setOnClickListener(v->{
             PaymentFragment popup = new PaymentFragment();
             popup.show(getSupportFragmentManager(), "myPaymentTag");
         });


        // Reset button action
        resetButton.setOnClickListener(v ->
                Toast.makeText(MainActivity.this, "Order reset!", Toast.LENGTH_SHORT).show());

        // Set up RecyclerView
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2); // 2 columns
        recyclerView.setLayoutManager(gridLayoutManager);

        boolean showStarButton = false;
        boolean showInventoryQuantity = false;

        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        recyclerView.setAdapter(productAdapter);

        productAdapter = new ProductAdapter(this, productList, showStarButton, showInventoryQuantity, null);
        recyclerView.setAdapter(productAdapter);

        loadProductsFromDatabase();

    }
    private void loadProductsFromDatabase() {
        if (productList == null) {
            productList = new ArrayList<>();
        } else {
            productList.clear();
        }

        Cursor cursor = db.getAllProducts();
        if (cursor != null && cursor.moveToFirst()) {
            do {
                int id = cursor.getInt(cursor.getColumnIndexOrThrow("id"));
                String name = cursor.getString(cursor.getColumnIndexOrThrow("name"));
                double price = cursor.getDouble(cursor.getColumnIndexOrThrow("price"));
                int quantity = cursor.getInt(cursor.getColumnIndexOrThrow("quantity"));
                byte[] image = cursor.getBlob(cursor.getColumnIndexOrThrow("image"));

                productList.add(new Product(id, name, price, quantity, image));
            } while (cursor.moveToNext());
            cursor.close();
        }
        productAdapter.updateList(productList);
    }

    private void processOrder(String paymentMethod) {
        String date = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(new Date());
        String time = new SimpleDateFormat("HH:mm:ss", Locale.getDefault()).format(new Date());

        for (Map.Entry<Integer, Integer> entry : orderedQuantities.entrySet()) {
            int productId = entry.getKey();
            int quantity = entry.getValue();

            if (quantity > 0) {
                Product product = db.getProductById(productId);
                if (product != null) {
                    String name = product.getName();
                    double price = product.getPrice();
                    orderDatabase.insertOrder(name, price, quantity, paymentMethod, date, time);
                }
            }
        }

        Toast.makeText(this, "Order placed!", Toast.LENGTH_SHORT).show();
        orderedQuantities.clear(); // Reset after placing
        recyclerView.getAdapter().notifyDataSetChanged();
    }

}



