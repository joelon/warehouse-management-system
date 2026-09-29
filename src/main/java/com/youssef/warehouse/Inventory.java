package com.youssef.warehouse;
import java.util.HashMap;

public class Inventory {

    private final HashMap<Integer, Product> products = new HashMap<>();

    public void addProduct(Product product){

        // Adds a product. IDs must be unique, so we refuse a duplicate instead of overwriting.

        if (products.containsKey(product.getProductId())){
            throw new IllegalArgumentException("Product ID already exists: " + product.getProductId());
        }
        
        // put(key, value) stores the product under its ID.
        products.put(product.getProductId() , product);

    }

    // Finds a product by its ID. get() returns null when no product has that ID.
    public Product findProduct(int productId) {
        
        return  products.get(productId);

    }

    


}
