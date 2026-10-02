package com.youssef.warehouse;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        Inventory inventory = new Inventory();
        inventory.addProduct(new Product(104, "AirPods Pro", "Audio", 24900, 7));
        inventory.addProduct(new Product(201, "Kindle", "Tablets", 9999, 20));
        inventory.addProduct(new Product(305, "USB-C Cable", "Accessories", 1299, 2));
        inventory.addProduct(new Product(410, "Keyboard", "Accessories", 7950, 15));
        inventory.addProduct(new Product(512, "Mouse", "Accessories", 2500, 30));

        // Copy all products into a list we can sort. The HashMap itself stays untouched.
        ArrayList<Product> list = inventory.getAllProducts();

        // A HashMap has no guaranteed order, so this order may look random.
        System.out.println("Before sorting:");
        for (Product p : list) {
            System.out.println("  " + p);
        }

        // Sort the list in place, cheapest first, using our own bubble sort.
        Sorter.bubbleSortByPrice(list);

        System.out.println("After sorting by price (low to high):");
        for (Product p : list) {
            System.out.println("  " + p);
        }
    }
}
    