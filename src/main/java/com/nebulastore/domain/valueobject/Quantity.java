package com.nebulastore.domain.valueobject;

import com.nebulastore.domain.exception.InvalidQuantityException;

public record Quantity(int value) {
    public Quantity {
        if (value <= 0) {
            throw new InvalidQuantityException("La cantidad debe ser positiva, recibido: " + value);
        }
    }
}