package com.nebulastore.domain.entity;

import com.nebulastore.domain.valueobject.OrderItem;
import com.nebulastore.domain.valueobject.Quantity;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;

@DisplayName("Order carrito de pedidos")
class OrderTest {

    @Test
    @DisplayName("Deberia iniciar con total 0.0 y lista de items vacia")
    void shouldStartEmptyWithZeroTotal() {
        Order order = new Order("ORD-001");

        assertEquals(0.0, order.getTotal());
        assertTrue(order.getItems().isEmpty());
    }

    @Test
    @DisplayName("Deberia guardar el id recibido en el constructor")
    void shouldStoreTheGivenId() {
        Order order = new Order("ORD-001");

        assertEquals("ORD-001", order.getId());
    }

    @Test
    @DisplayName("Deberia lanzar IllegalArgumentException cuando el id es nulo")
    void shouldThrowWhenIdIsNull() {
        assertThrows(IllegalArgumentException.class, () -> new Order(null));
    }

    @Test
    @DisplayName("Deberia lanzar IllegalArgumentException cuando el id esta vacio")
    void shouldThrowWhenIdIsBlank() {
        assertThrows(IllegalArgumentException.class, () -> new Order("   "));
    }

    @Test
    @DisplayName("Deberia agregar un item a la lista al usar addItem")
    void shouldAddItemToList() {
        Order order = new Order("ORD-001");
        OrderItem item = new OrderItem("Filamento PLA 1kg", new Quantity(1), 15990.0);

        order.addItem(item);

        assertEquals(1, order.getItems().size());
        assertTrue(order.getItems().contains(item));
    }

    @Test
    @DisplayName("Deberia sumar precio por cantidad al total al agregar items")
    void shouldAddPriceTimesQuantityToTotal() {
        Order order = new Order("ORD-001");

        order.addItem(new OrderItem("Filamento PLA 1kg", new Quantity(2), 15990.0));
        order.addItem(new OrderItem("Boquilla 0.4mm", new Quantity(1), 3990.0));

        assertEquals(35970.0, order.getTotal());
    }
}