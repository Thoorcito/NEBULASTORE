package com.nebulastore.domain.valueobject;

import com.nebulastore.domain.exception.InvalidQuantityException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Quantity value object")
class QuantityTest {

    @ParameterizedTest
    @ValueSource(ints = {0, -1, -5})
    @DisplayName("Deberia lanzar InvalidQuantityException cuando el valor no es positivo")
    void shouldThrowWhenValueIsNotPositive(int invalidValue) {
        assertThrows(InvalidQuantityException.class, () -> new Quantity(invalidValue));
    }

    @Test
    @DisplayName("Deberia crear una Quantity valida cuando el valor es positivo")
    void shouldCreateWhenValueIsPositive() {
        Quantity quantity = new Quantity(5);
        assertEquals(5, quantity.value());
    }
}