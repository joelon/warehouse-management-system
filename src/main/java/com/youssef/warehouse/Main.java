package com.youssef.warehouse;

public class Main {
    public static void main(String[] args) {

        Inventory inventory = new Inventory();
        inventory.addProduct(new Product(104, "AirPods Pro", "Audio", 24900, 7));
        inventory.addProduct(new Product(201, "Kindle", "Tablets", 9999, 20));
        inventory.addProduct(new Product(305, "USB-C Cable", "Accessories", 1299, 2));

        // Create a customer and an empty order that belongs to them.
        Customer customer = new Customer(1, "Youssef", "youssef@example.com");
        Order order = new Order(10482, customer);

        // Look each product up by ID, then add it to the order with a quantity.
        order.addItem(new OrderItem(inventory.findProduct(104), 2));
        order.addItem(new OrderItem(inventory.findProduct(305), 1));

        // println calls Order's toString() automatically.
        System.out.println(order);

        // Move the order to the next stage.
        order.setStatus(OrderStatus.PROCESSING);

        // The order is no longer PLACED, so addItem should throw.
        // try/catch handles the exception instead of crashing the program.
        try {
            order.addItem(new OrderItem(inventory.findProduct(201), 1));
        } catch (IllegalStateException e) {
            System.out.println("Rejected: " + e.getMessage());
        }



    }
}
    