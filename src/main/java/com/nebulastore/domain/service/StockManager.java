package com.nebulastore.domain.service;

import com.nebulastore.domain.exception.OutOfStockException;
import com.nebulastore.domain.valueobject.Quantity;

public class StockManager {
    public void validateStock(Quantity available, Quantity requested) {
        if (requested.value() > available.value()) {
            throw new OutOfStockException(
                "Stock insuficiente: disponible " + available.value() +
                ", solicitado " + requested.value());
        }
    }
}