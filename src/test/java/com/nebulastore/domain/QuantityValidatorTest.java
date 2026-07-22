package com.nebulastore.domain;

import com.nebulastore.domain.exception.InvalidQuantityException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

@DisplayName("QuantityValidator validacion de cantidad")
class QuantityValidatorTest {

    @ParameterizedTest
    @ValueSource(ints = {0, -1, -5})
    @DisplayName("Deberia lanzar InvalidQuantityException cuando la cantidad no es positiva")
    void shouldThrowWhenQuantityIsNotPositive(int cantidadInvalida) {
        // Arrange
        QuantityValidator validator = new QuantityValidator();

        // Act & Assert
        assertThrows(InvalidQuantityException.class,
                () -> validator.validateQuantity(cantidadInvalida));
    }

    @Test
    @DisplayName("No deberia lanzar excepcion cuando la cantidad es positiva")
    void shouldNotThrowWhenQuantityIsPositive() {
        // Arrange
        QuantityValidator validator = new QuantityValidator();

        // Act & Assert
        assertDoesNotThrow(() -> validator.validateQuantity(5));
    }
    
}
