package com.nebulastore.domain.entity;

import com.nebulastore.domain.valueobject.OrderItem;
import java.util.ArrayList;
import java.util.List;

public class Order {

    private final String id;
    private double total;
    private List<OrderItem> items;

    public Order(String id) {
        if (id == null || id.isBlank()) {
            throw new IllegalArgumentException("El ID del pedido no puede ser nulo ni vacio");
        }
        this.id = id;
        this.total = 0.0;
        this.items = new ArrayList<>();
    }

    public void addItem(OrderItem item) {
        this.items.add(item);
        this.total += item.unitPrice() * item.quantity().value();
    }

    public String getId() {
        return id;
    }

    public double getTotal() {
        return total;
    }

    public List<OrderItem> getItems() {
        return items;
    }
}