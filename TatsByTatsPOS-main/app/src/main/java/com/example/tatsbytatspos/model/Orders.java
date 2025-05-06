package com.example.tatsbytatspos.model;

public class Orders {
    private int id;
    private String productName;
    private double productPrice;
    private int productQuantity;
    private String date;
    private String time;

    public Orders(int id, String productName, double productPrice, int productQuantity, String date, String time) {
        this.id = id;
        this.productName = productName;
        this.productPrice = productPrice;
        this.productQuantity = productQuantity;
        this.date = date;
        this.time = time;
    }

    // Getters (and setters if needed)
    public int getId() { return id; }
    public String getProductName() { return productName; }
    public double getProductPrice() { return productPrice; }
    public int getProductQuantity() { return productQuantity; }
    public String getDate() { return date; }
    public String getTime() { return time; }
}