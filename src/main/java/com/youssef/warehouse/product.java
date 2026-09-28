package com.youssef.warehouse;

public class product {
    
    private final int productId; 
    private String name ;
    private String category ; 
    private int priceInCents ; 
    private int quantity ;

    public product(int productId , String name , String category , int priceInCents , int quantity){
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






}
