package com.nebulastore.domain.valueobject;

public record OrderItem(String productName, Quantity quantity, double unitPrice) {
    public OrderItem {
        if (productName == null || productName.isBlank()) {
            throw new IllegalArgumentException("El nombre del producto no puede ser nulo ni vacio");
        }
        if (unitPrice < 0) {
            throw new IllegalArgumentException("El precio unitario no puede ser negativo");
        }
    }
}