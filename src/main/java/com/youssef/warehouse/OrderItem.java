package com.youssef.warehouse;

public class OrderItem {

    private final Product product;
    private final int quantity;

    // We copy the price at the moment the order is made. If the product's price
    // changes later, old orders must keep the price the customer actually paid.
    private final int unitPriceInCents;

public OrderItem (Product product , int quantity){

    if (quantity<=0){ 
        throw new IllegalArgumentException("Quantity must be positive ");
    }

    this.product = product;
    this.quantity = quantity;
    this.unitPriceInCents = product.getPriceInCents();
}

public Product getProduct() { return product; }
public int getQuantity() { return quantity; }

public int getTotalinCents (){ return unitPriceInCents * quantity;}

@Override
    
    public String toString() {
        return quantity + " x " + product.getName();
    }

    
}
