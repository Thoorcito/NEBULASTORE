package com.nebulastore.domain;

import com.nebulastore.domain.exception.InvalidQuantityException;

public class QuantityValidator {
    public void validateQuantity(int cantidad) {
        if (cantidad <= 0) {
            throw new InvalidQuantityException(
                "La cantidad debe ser positiva, recibido: " + cantidad);
        }
    }
}
