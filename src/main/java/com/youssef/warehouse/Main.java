package com.youssef.warehouse;

public class Main {
    public static void main(String[] args) {
    Inventory inventory = new Inventory();
        inventory.addProduct(new Product(104, "AirPods Pro", "Audio", 24900, 7));
        inventory.addProduct(new Product(201, "Kindle", "Tablets", 9999, 20));
        inventory.addProduct(new Product(305, "USB-C Cable", "Accessories", 1299, 2));

        // Look up a product that exists. println calls toString() on it automatically.
        System.out.println("Found: " + inventory.findProduct(104));

        // Look up an ID that doesn't exist. get() returns null, so this prints "null".
        System.out.println("Missing: " + inventory.findProduct(999));

        // Adding ID 104 a second time breaks our uniqueness rule, so addProduct throws.
        // try/catch handles that exception instead of letting the program crash.
        try {
            inventory.addProduct(new Product(104, "Fake AirPods", "Audio", 100, 1));
        } catch (IllegalArgumentException e) {
            System.out.println("Rejected: " + e.getMessage());
        }

        // Ask for every product with 10 units or fewer left.
        // The method returns an ArrayList, so we can loop over the result.
        System.out.println("Low stock (10 or fewer):");
        for (Product p : inventory.findLowStock(10)) {
            System.out.println("  " + p);
        
       
    }
}
}
    