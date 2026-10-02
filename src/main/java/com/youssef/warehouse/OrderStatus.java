package com.youssef.warehouse;

public enum OrderStatus {
    
// An enum is a type with a fixed set of allowed values.
// An order's status can only be one of these, so a typo like "shiped" is impossible:
// the compiler would reject OrderStatus.SHIPED because it doesn't exist.
// The values are written in capitals by convention, and they are listed in the order
// an order normally moves through them.


    PLACED,
    PROCESSING,
    PICKING,
    PACKAGING,
    SHIPPED,
    DELIVERED,
    CANCELLED,

}
