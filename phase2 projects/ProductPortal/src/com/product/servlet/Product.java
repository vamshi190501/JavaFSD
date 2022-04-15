package com.product.servlet;

public class Product {
    private int id;
    private String name;
    private double price;
    // Parameterized Constructor to set Student
    // name, age, course enrolled in.
    public Product(int a, String n, double p)
    {
        this.name = n;
        this.id = a;
        this.price = p;
    }
    // Setter Methods to set table data to be
    // displayed
    public String getName() { return name; }
    public int getId() { return id; }
    public double getPrice() { return price; }
}