package com.youssef.warehouse;

import java.util.ArrayList;

public class Order {

    private final int orderId;

    private final Customer customer;
    private final ArrayList<OrderItem> items = new ArrayList<>();
    private OrderStatus status;  //not final because the status changes over time.

public Order (int orderId , Customer customer){

    this.orderId = orderId;
    this.customer = customer;
    // Every new order starts in the first stage.

    this.status = OrderStatus.PLACED;
}

public void addItem (OrderItem item){
    if (status != OrderStatus.PLACED){
        throw new IllegalStateException("Cannot change an order that is already " + status);
    }

    items.add(item);
}

public int getTotalInCents(){
    int total = 0;
    
    for(OrderItem item : items){
        total += item.getTotalinCents();
    }
    return total;
}
//getters let other classes read the ID, customer, status and items.
public int getOrderId(){ return orderId;}
public Customer getCustomer(){ return customer;}
public OrderStatus getOrderStatus(){ return status;}
public ArrayList<OrderItem> getItems() { return items; }

public void setStatus (OrderStatus status){
    this.status = status;
}

@Override 
public String toString(){
    String text = "ORDER #" + orderId + " for " + customer.getName() + "\n";

    for (OrderItem item : items) {
            text += "  " + item + "\n";
        }

    text += "Total: $" + getTotalInCents() / 100.0 + "\n";
    text += "Status: " + status;
    return text;
    }
}
