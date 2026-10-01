package com.youssef.warehouse;

public class Customer {

    private final int customerId; 
    private String name;
    private String email; 

    public Customer(int customerId , String name , String email) { 

        this.customerId = customerId;
        this.name = name;
        this.email = email;

    }

    // Getters let other classes read the private fields without changing them.
    public int getCustomerId(){return customerId ;}
    public String getName(){return name ;}
    public String getEmail(){return email ;}

    // toString() is called automatically whenever we print a Customer.
    @Override 
    public String toString(){

        return "Customer #" + customerId + ": " + name + " <" + email + ">";

    }



}
