package com.nebulastore.domain.entity;

import java.util.ArrayList;
import java.util.List;

public class Order {

    private final String id;
    private double total;
    private List<String> items;

    public Order(String id) {
        if (id == null || id.isBlank()) {
            throw new IllegalArgumentException("El ID del pedido no puede ser nulo ni vacio");
        }
        this.id = id;
        this.total = 0.0;
        this.items = new ArrayList<>();
    }

    public void addItem(String item, double price) {
        this.items.add(item);
        this.total += price;
    }

    public String getId() {
        return id;
    }

    public double getTotal() {
        return total;
    }

    public List<String> getItems() {
        return items;
    }
}