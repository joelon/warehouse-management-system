package com.youssef.warehouse;

public class Main {
    public static void main(String[] args) {
        
        Inventory inventory = new Inventory();
        
        inventory.addProduct(new Product(104, "AirPods Pro", "Audio", 24900, 7));
        inventory.addProduct(new Product(201, "Kindle", "Tablets", 9999, 20));
        inventory.addProduct(new Product(305, "USB-C Cable", "Accessories", 1299, 2));

        // Look up a product that exists. println calls toString() on it automatically.
        Product found = inventory.findProduct(104);
        System.out.println("Found: " + found);

        // Look up an ID that doesn't exist. get() returns null, and printing null shows "null".
        Product missing = inventory.findProduct(999);
        System.out.println("Missing: " + missing);

        // Adding ID 104 a second time breaks our uniqueness rule, so addProduct throws.
        // try/catch lets the program handle that exception instead of crashing.
        try {
            inventory.addProduct(new Product(104, "Fake AirPods", "Audio", 100, 1));
        } catch (IllegalArgumentException e) {
            // e.getMessage() returns the text we wrote inside the exception.
            System.out.println("Rejected: " + e.getMessage());
        }
    }
}

    