package com.youssef.warehouse;

public class Product {
    
    private final int productId; 
    private String name ;
    private String category ; 
    private int priceInCents ; 
    private int quantity ;

    public Product(int productId , String name , String category , int priceInCents , int quantity){
        this.productId = productId ; 
        this.name = name ; 
        this.category = category ; 
        this.priceInCents = priceInCents ; 
        this.quantity = quantity ; 
    }

    // Getters allows other classes to read the values of the private fields without modifying them.

    public int getProductId() { return productId; }
    public String getName() { return name; }
    public String getCategory() { return category; }
    public int getPriceInCents() { return priceInCents; }
    public int getQuantity() { return quantity; }

    // Adds units to the stock. Zero or negative amounts make no sense, so we reject them.
    
    public void addStock(int amount){

        if (amount <= 0){
             throw new IllegalArgumentException("Amount must be positive");
        }
        quantity += amount;
    }

    public void removeStock(int amount){

        if (amount <= 0){
            throw new IllegalArgumentException("Amount must be positive");
        } 
        if (amount > quantity){
            throw new IllegalStateException("Not enough stock for " + name);
        }

        quantity -= amount;
        
    }

    // toString() is called automatically whenever we print a Product.
    // Here we simply join text and values together with +.
    
    @Override
    public String toString() {
        return "#" + productId + " " + name + " (" + category + ") - $"
                + priceInCents / 100.0 + " - stock: " + quantity;
    }
    






}
