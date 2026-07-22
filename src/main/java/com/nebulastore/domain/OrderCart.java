package com.nebulastore.domain;

import java.util.ArrayList;
import java.util.List;

public class OrderCart {
    private double total;
    private List<String> items;
    
    // constructor vacio
    public OrderCart() {
        this.total= 0.0;
        this.items= new ArrayList<>();
    }

    //Getters y Setters
    public double getTotal() {
        return total;
    }
    
    public List<String>getItems() {
        return items;
    }
    
}