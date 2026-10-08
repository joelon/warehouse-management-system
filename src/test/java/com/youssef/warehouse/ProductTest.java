package com.youssef.warehouse;

// A static import lets us write assertEquals(...) instead of Assertions.assertEquals(...).
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class ProductTest{

// @Test marks a method as a test. JUnit runs each one separately and reports pass or fail.
// A test passes if it finishes without a failed assertion or an unexpected exception.

@Test 

void addStockIncreasesQuantity() {

    Product product = new Product(1, "Mouse", "Accessories", 2500, 10);
    product.addStock(5);
    assertEquals(15, product.getQuantity());

}

@Test
    void removeStockDecreasesQuantity() {
        
        Product product = new Product(1, "Mouse", "Accessories", 2500, 10);
        product.removeStock(4);
        assertEquals(6, product.getQuantity());
    }

@Test
    void removingMoreThanAvailableThrows() {
        
        Product product = new Product(1, "Mouse", "Accessories", 2500, 3);
        assertThrows(IllegalStateException.class, () -> product.removeStock(4));
    }

@Test
    void addingZeroStockThrows() {
        Product product = new Product(1, "Mouse", "Accessories", 2500, 3);

        assertThrows(IllegalArgumentException.class, () -> product.addStock(0));
    }

}