# Warehouse Management System

A Java console application that simulates a warehouse: it manages products, stock levels, customers, and orders. I'm building it to practice object-oriented design and core data structures and algorithms in a real application.

**Status:** in progress

## Features so far

- Product catalog with stock tracking (add and remove stock)
- Inventory stored in a `HashMap` keyed by product ID, with a low-stock check
- Customers and orders, including order items and order status
- Sorting products by price, name, or stock (ascending or descending) using my own bubble sort with comparators
- JUnit 5 unit tests for the product, inventory, and sorting classes

## How to run

Requires Java 17 and Maven.

```bash
# Run the tests
mvn test

# Compile the project
mvn compile
```

The entry point is `Main.java` in `com.youssef.warehouse`. You can run it from VS Code with the Run button above `main`.

## Planned

- Order processing (reserve stock and update inventory when an order is placed)
- Saving and loading data from a file
- Warehouse map, routing, and a JavaFX interface

## Notes

Developed with AI assistance (Claude) as a guide while learning.