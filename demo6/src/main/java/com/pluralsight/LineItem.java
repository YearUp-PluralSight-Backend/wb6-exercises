package com.pluralsight;

public class LineItem {
    private int productId;
    private String productName;
    private double price;
    private int quantity;
//... constructor getters and setters
    public double getLineTotal(){
        return quantity * price;
    }
}