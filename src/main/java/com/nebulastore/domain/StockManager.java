package com.nebulastore.domain;

import com.nebulastore.domain.exception.OutOfStockException;

public class StockManager {
    public void validateStock(int stockDisponible, int cantidadPedida) {
        if (cantidadPedida>stockDisponible) {
            throw new OutOfStockException(
                "Stock insuficiente: disponible " + stockDisponible +
                ", solicitado " + cantidadPedida);
        }
    }
    
}
