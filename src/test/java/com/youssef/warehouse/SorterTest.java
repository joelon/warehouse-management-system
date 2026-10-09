package com.youssef.warehouse;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import org.junit.jupiter.api.Test;

class SorterTest {


// Helper: builds a fresh, unsorted list for every test, so tests never share data.
// Prices in cents: 104=24900, 201=9999, 305=1299, 410=7950, 512=2500.
    private ArrayList<Product> sampleList() {
        ArrayList<Product> list = new ArrayList<>();
        list.add(new Product(512, "Mouse", "Accessories", 2500, 30));
        list.add(new Product(104, "AirPods Pro", "Audio", 24900, 7));
        list.add(new Product(305, "USB-C Cable", "Accessories", 1299, 2));
        list.add(new Product(201, "Kindle", "Tablets", 9999, 20));
        list.add(new Product(410, "Keyboard", "Accessories", 7950, 15));
        return list;
    }

// Helper: turns a list of products into a list of just their IDs. 
// Comparing short ID lists is easier than comparing whole Product objects.
    private List<Integer> ids(ArrayList<Product> list) {
        ArrayList<Integer> result = new ArrayList<>();
        for (Product p : list) {
            result.add(p.getProductId());
        }
        return result;
    }
    
@Test
    void sortsByPriceLowToHigh() {
        ArrayList<Product> list = sampleList();

        Sorter.bubbleSort(list, Comparator.comparingInt(Product::getPriceInCents));

        // List.of(...) builds the expected list. assertEquals compares it element by element.
        assertEquals(List.of(305, 512, 410, 201, 104), ids(list));
    }

@Test
    void sortsByPriceHighToLow() {
        ArrayList<Product> list = sampleList();

        Sorter.bubbleSort(list, Comparator.comparingInt(Product::getPriceInCents).reversed());

        assertEquals(List.of(104, 201, 410, 512, 305), ids(list));
    }

@Test
    void sortsByNameAToZ() {
        ArrayList<Product> list = sampleList();

        Sorter.bubbleSort(list, Comparator.comparing(Product::getName));

        // AirPods Pro, Keyboard, Kindle, Mouse, USB-C Cable
        assertEquals(List.of(104, 410, 201, 512, 305), ids(list));
    }

// Edge case: an empty list must not crash. The loops simply never run.
@Test
    void emptyListStaysEmpty() {
        ArrayList<Product> list = new ArrayList<>();

        Sorter.bubbleSort(list, Comparator.comparingInt(Product::getPriceInCents));

        assertEquals(0, list.size());
    }

// Edge case: a list that is already in order must come out unchanged.
@Test
    void alreadySortedListStaysTheSame() {
        ArrayList<Product> list = new ArrayList<>();
        list.add(new Product(1, "A", "X", 100, 1));
        list.add(new Product(2, "B", "X", 200, 1));
        list.add(new Product(3, "C", "X", 300, 1));

        Sorter.bubbleSort(list, Comparator.comparingInt(Product::getPriceInCents));

        assertEquals(List.of(1, 2, 3), ids(list));
    }

// Edge case: equal prices. We only swap when compare(...) > 0, never on equal, so products with the same price keep their original relative order.
// That property is called stability.
@Test
    void equalPricesKeepTheirOriginalOrder() {
        ArrayList<Product> list = new ArrayList<>();
        list.add(new Product(1, "A", "X", 500, 1));
        list.add(new Product(2, "B", "X", 500, 1));
        list.add(new Product(3, "C", "X", 100, 1));

        Sorter.bubbleSort(list, Comparator.comparingInt(Product::getPriceInCents));

        // C is cheapest, then A and B stay in their original order.
        assertEquals(List.of(3, 1, 2), ids(list));
    }
}
