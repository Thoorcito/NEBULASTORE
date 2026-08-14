package com.nebulastore.domain.valueobject;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("OrderItem value object")
class OrderItemTest {

    @Test
    @DisplayName("Deberia crear un OrderItem valido")
    void shouldCreateValidOrderItem() {
        OrderItem item = new OrderItem("Filamento PLA 1kg", new Quantity(2), 15990.0);

        assertEquals("Filamento PLA 1kg", item.productName());
        assertEquals(2, item.quantity().value());
        assertEquals(15990.0, item.unitPrice());
    }

    @Test
    @DisplayName("Deberia lanzar IllegalArgumentException cuando el nombre del producto es nulo")
    void shouldThrowWhenProductNameIsNull() {
        assertThrows(IllegalArgumentException.class,
                () -> new OrderItem(null, new Quantity(1), 100.0));
    }

    @Test
    @DisplayName("Deberia lanzar IllegalArgumentException cuando el nombre del producto esta vacio")
    void shouldThrowWhenProductNameIsBlank() {
        assertThrows(IllegalArgumentException.class,
                () -> new OrderItem("   ", new Quantity(1), 100.0));
    }

    @Test
    @DisplayName("Deberia lanzar IllegalArgumentException cuando el precio unitario es negativo")
    void shouldThrowWhenUnitPriceIsNegative() {
        assertThrows(IllegalArgumentException.class,
                () -> new OrderItem("Filamento PLA", new Quantity(1), -10.0));
    }
}