package com.youssef.warehouse;

public class Main {
    public static void main(String[] args) {
        
        product airpods = new product(104, "AirPods Pro", "Audio", 24900, 7);

        // We can't write airpods.name because the field is private,
        // so we read each value through its getter method.

        System.out.println("ID: " + airpods.getProductId());
        System.out.println("Name: " + airpods.getName());
        System.out.println("Category: " + airpods.getCategory());
        // The price is stored in cents, so we divide by 100.0 (a double)
        // to display it in dollars. Dividing by 100.0 keeps the decimal part.

        System.out.println("Price: $" + airpods.getPriceInCents() / 100.0);
        System.out.println("Quantity: " + airpods.getQuantity());




    }
}