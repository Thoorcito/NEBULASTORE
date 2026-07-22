package com.nebulastore.domain;

import com.nebulastore.domain.exception.OutOfStockException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;


@DisplayName("StockManager  validacion de inventario")
class StockManagerTest {
    
    @Test
    @DisplayName("Deberia lanzar OutOfStockException cuando el stock es insuficiente")
    void shouldThrowWhenStockIsInsufficient() {
        // Arrange
        StockManager stockManager = new StockManager();

        // Act & Assert: pedir 10 cuando solo hay 5 debe fallar
        assertThrows(OutOfStockException.class,
                () -> stockManager.validateStock(5, 10));
    }

    @Test
    @DisplayName("No deberia lanzar excepcion cuando hay stock suficiente")
    void shouldNotThrowWhenStockIsSufficient() {
        // Arrange
        StockManager stockManager = new StockManager();

        // Act & Assert: pedir 3 cuando hay 5 debe pasar sin error
        assertDoesNotThrow(() -> stockManager.validateStock(5, 3));
    }
}
