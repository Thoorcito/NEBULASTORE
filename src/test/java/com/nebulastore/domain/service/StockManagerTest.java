package com.nebulastore.domain.service;

import com.nebulastore.domain.exception.OutOfStockException;
import com.nebulastore.domain.valueobject.Quantity;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

@DisplayName("StockManager  validacion de inventario")
class StockManagerTest {

    @Test
    @DisplayName("Deberia lanzar OutOfStockException cuando el stock es insuficiente")
    void shouldThrowWhenStockIsInsufficient() {
        StockManager stockManager = new StockManager();

        assertThrows(OutOfStockException.class,
                () -> stockManager.validateStock(new Quantity(5), new Quantity(10)));
    }

    @Test
    @DisplayName("No deberia lanzar excepcion cuando hay stock suficiente")
    void shouldNotThrowWhenStockIsSufficient() {
        StockManager stockManager = new StockManager();

        assertDoesNotThrow(() -> stockManager.validateStock(new Quantity(5), new Quantity(3)));
    }
}