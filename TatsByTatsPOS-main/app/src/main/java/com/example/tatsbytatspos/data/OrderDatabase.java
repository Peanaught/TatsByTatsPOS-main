package com.example.tatsbytatspos.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class OrderDatabase extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "OrderHistory.db";
    private static final int DATABASE_VERSION = 1;

    public static final String TABLE_ORDERS = "orders";

    public static final String COLUMN_ID = "id"; // Order number
    public static final String COLUMN_PRODUCT_NAME = "product_name";
    public static final String COLUMN_PRODUCT_PRICE = "product_price";
    public static final String COLUMN_PRODUCT_QUANTITY = "product_quantity";
    public static final String COLUMN_PAYMENT_METHOD = "payment_method";
    public static final String COLUMN_DATE = "date";
    public static final String COLUMN_TIME = "time";

    public OrderDatabase(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_TABLE = "CREATE TABLE " + TABLE_ORDERS + "("
                + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + COLUMN_PRODUCT_NAME + " TEXT,"
                + COLUMN_PRODUCT_PRICE + " REAL,"
                + COLUMN_PRODUCT_QUANTITY + " INTEGER,"
                + COLUMN_PAYMENT_METHOD + " TEXT,"
                + COLUMN_DATE + " TEXT,"
                + COLUMN_TIME + " TEXT"
                + ")";
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_ORDERS);
        onCreate(db);
    }

    // Insert a single product order entry
    public boolean insertOrder(String productName, double productPrice, int quantity, String paymentMethod, String date, String time) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(COLUMN_PRODUCT_NAME, productName);
        values.put(COLUMN_PRODUCT_PRICE, productPrice);
        values.put(COLUMN_PRODUCT_QUANTITY, quantity);
        values.put(COLUMN_PAYMENT_METHOD, paymentMethod);
        values.put(COLUMN_DATE, date);
        values.put(COLUMN_TIME, time);

        long result = db.insert(TABLE_ORDERS, null, values);
        return result != -1;
    }

    // Retrieve all orders
    public Cursor getAllOrders() {
        SQLiteDatabase db = this.getReadableDatabase();
        return db.rawQuery("SELECT * FROM " + TABLE_ORDERS + " ORDER BY " + COLUMN_ID + " DESC", null);
    }
}