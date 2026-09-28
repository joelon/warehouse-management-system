package com.youssef.warehouse;

public class Main {
    public static void main(String[] args) {
        
        Product airpods = new Product(104, "AirPods Pro", "Audio", 24900, 7);

        System.out.println(airpods);

        airpods.addStock(10);
        System.out.println("After adding 10 : " + airpods.getQuantity());
        
        airpods.removeStock(5);
        System.out.println("After removing 5 : " + airpods.getQuantity());

        airpods.removeStock(100);

        System.out.println("This line will not print");

    }
}