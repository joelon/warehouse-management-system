package com.youssef.warehouse;

public class Main {
    public static void main(String[] args) {
        
    Inventory inventory = new Inventory();
        inventory.addProduct(new Product(104, "AirPods Pro", "Audio", 24900, 7));
        inventory.addProduct(new Product(201, "Kindle", "Tablets", 9999, 20));
        inventory.addProduct(new Product(305, "USB-C Cable", "Accessories", 1299, 2));

        // Look up a product that exists, then one that doesn't (get() returns null).
        System.out.println("Found: " + inventory.findProduct(104));
        System.out.println("Missing: " + inventory.findProduct(999));

        // A duplicate ID makes addProduct throw, and try/catch handles it.
        try {
            inventory.addProduct(new Product(104, "Fake AirPods", "Audio", 100, 1));
        } catch (IllegalArgumentException e) {
            System.out.println("Rejected: " + e.getMessage());
        }

        // Loop over every product with 10 units or fewer left.
        System.out.println("Low stock (10 or fewer):");
        for (Product p : inventory.findLowStock(10)) {
            System.out.println("  " + p);
        }

        // Create a Customer object and print it. println calls toString() automatically.
        Customer customer = new Customer(1, "Youssef", "youssef@example.com");
        System.out.println(customer);

        Customer customer2 = new Customer(2, "Omar", "Omar@example.com");
        // Getters read individual fields, since the fields themselves are private.
        System.out.println("Customer name: " + customer2.getName());


    }
}
    