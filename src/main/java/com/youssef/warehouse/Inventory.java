package com.youssef.warehouse;
import java.util.HashMap;
import java.util.ArrayList;

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

    public ArrayList <Product> findLowStock(int threshold){

        // Start with an empty list and add matching products as we find them.
        ArrayList<Product> lowStock = new ArrayList<>();

        // products.values() gives all the Product objects (without their ID keys).
        // checking every product, which is a linear search: the time grows with the product count.
        for (Product p : products.values()){
            
            if(p.getQuantity() <= threshold){
                lowStock.add(p);

            }
        }
        return  lowStock ; 
    }

    // Returns all products as a NEW list, so sorting it later never disturbs the HashMap.
    // new ArrayList<>(products.values()) builds a list by copying the map's values.
    public ArrayList<Product> getAllProducts() {
        return new ArrayList<>(products.values());
    }




}
