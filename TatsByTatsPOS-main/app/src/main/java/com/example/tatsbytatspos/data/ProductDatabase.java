package com.example.tatsbytatspos.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.tatsbytatspos.model.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductDatabase extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "ProductDB.db";
    private static final int DATABASE_VERSION = 1;

    public static final String TABLE_NAME = "products";
    public static final String COLUMN_ID = "id";
    public static final String COLUMN_NAME = "name";
    public static final String COLUMN_PRICE = "price";
    public static final String COLUMN_QUANTITY = "quantity";
    public static final String COLUMN_IMAGE = "image";

    public ProductDatabase(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTableSQL = "CREATE TABLE " + TABLE_NAME + " (" +
                COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_NAME + " TEXT NOT NULL, " +
                COLUMN_PRICE + " REAL NOT NULL, " +
                COLUMN_QUANTITY + " INTEGER NOT NULL, " +
                COLUMN_IMAGE + " BLOB)";
        db.execSQL(createTableSQL);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    // Insert a product
    public boolean insertProduct(String name, double price, int quantity, byte[] image) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_NAME, name);
        values.put(COLUMN_PRICE, price);
        values.put(COLUMN_QUANTITY, quantity);
        values.put(COLUMN_IMAGE, image);
        long result = db.insert(TABLE_NAME, null, values);
        return result != -1;
    }

    // Get all products
    public Cursor getAllProducts() {
        SQLiteDatabase db = this.getReadableDatabase();
        return db.rawQuery("SELECT * FROM " + TABLE_NAME, null);
    }

    // Update product by ID
    public boolean updateProduct(int id, String name, double price, int quantity, byte[] image) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("name", name);
        values.put("price", price);
        values.put("quantity", quantity);
        values.put("image", image);
        int rows = db.update("products", values, "id=?", new String[]{String.valueOf(id)});
        return rows > 0;
    }

    public boolean deleteProduct(int id) {
        SQLiteDatabase db = this.getWritableDatabase();
        int rows = db.delete("products", "id=?", new String[]{String.valueOf(id)});
        return rows > 0;
    }

    public Product getProductById(int id) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM products WHERE id = ?", new String[]{String.valueOf(id)});

        if (cursor != null && cursor.moveToFirst()) {
            String name = cursor.getString(cursor.getColumnIndexOrThrow("name"));
            double price = cursor.getDouble(cursor.getColumnIndexOrThrow("price"));
            int quantity = cursor.getInt(cursor.getColumnIndexOrThrow("quantity"));
            byte[] image = cursor.getBlob(cursor.getColumnIndexOrThrow("image"));
            cursor.close();
            return new Product(id, name, price, quantity, image);
        }
        return null;
    }
}

