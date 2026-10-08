package com.youssef.warehouse;

// The * imports every assertion method
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class InventoryTest {

    private Inventory inventory;

// @BeforeEach runs before EVERY @Test method, so each test starts with a brand-new inventory holding the same three products.
@BeforeEach
    void setUp() {
        inventory = new Inventory();
        inventory.addProduct(new Product(104, "AirPods Pro", "Audio", 24900, 7));
        inventory.addProduct(new Product(201, "Kindle", "Tablets", 9999, 20));
        inventory.addProduct(new Product(305, "USB-C Cable", "Accessories", 1299, 2));
    }

@Test
    void findProductReturnsTheProductWithThatId() {
        
        Product found = inventory.findProduct(201);
        assertEquals("Kindle", found.getName());
    }

@Test
    void findProductReturnsNullForUnknownId() {
        assertNull(inventory.findProduct(999));
    }

@Test
    void addingDuplicateIdThrows() {
        
        Product duplicate = new Product(104, "Fake AirPods", "Audio", 100, 1);
        // The code after "() ->" must throw IllegalArgumentException for the test to pass.
        assertThrows(IllegalArgumentException.class, () -> inventory.addProduct(duplicate));
    }
@Test
    void findLowStockReturnsOnlyProductsAtOrBelowThreshold() {
        ArrayList<Product> low = inventory.findLowStock(7);

        // AirPods (7 units) and the cable (2 units) qualify. The Kindle (20 units) does not.
        assertEquals(2, low.size());
    }
@Test
    void getAllProductsReturnsEveryProduct() {
        assertEquals(3, inventory.getAllProducts().size());
    }


}