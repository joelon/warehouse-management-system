package com.youssef.warehouse;

import java.util.ArrayList;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {

        Inventory inventory = new Inventory();
        inventory.addProduct(new Product(104, "AirPods Pro", "Audio", 24900, 7));
        inventory.addProduct(new Product(201, "Kindle", "Tablets", 9999, 20));
        inventory.addProduct(new Product(305, "USB-C Cable", "Accessories", 1299, 2));
        inventory.addProduct(new Product(410, "Keyboard", "Accessories", 7950, 15));
        inventory.addProduct(new Product(512, "Mouse", "Accessories", 2500, 30));

        // One list, re-sorted several times with different rules.
        ArrayList<Product> list = inventory.getAllProducts();

        // Product::getPriceInCents is a method reference. It is shorthand for
        // "take a Product and call getPriceInCents() on it".
        // comparingInt builds a Comparator that orders products by that number, smallest first.
        Sorter.bubbleSort(list, Comparator.comparingInt(Product::getPriceInCents));
        printList("Price, low to high", list);

        // .reversed() flips any comparator, so the same rule now runs backwards.
        Sorter.bubbleSort(list, Comparator.comparingInt(Product::getPriceInCents).reversed());
        printList("Price, high to low", list);

        // comparing(...) works on any type that has a natural order, such as text (A to Z).
        Sorter.bubbleSort(list, Comparator.comparing(Product::getName));
        printList("Name, A to Z", list);

        Sorter.bubbleSort(list, Comparator.comparing(Product::getName).reversed());
        printList("Name, Z to A", list);

        Sorter.bubbleSort(list, Comparator.comparingInt(Product::getQuantity));
        printList("Stock, low to high", list);
    }

    // A helper that prints a title and then every product in the list.
    // It is static because main is static: a static method can only call another static
    // method of the same class directly, without first creating a Main object.
    // void: it returns nothing, it only prints.
    private static void printList(String title, ArrayList<Product> list) {
        System.out.println(title + ":");
        for (Product p : list) {
            System.out.println("  " + p);
        }
    }
}