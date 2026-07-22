package com.nebulastore.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


@DisplayName("OrderCart carrito de pedidos")
class OrderCartTest {
    @Test
    @DisplayName("Deberia iniciar con total 0.0 y lista de items vacia")
    void shouldStartEmptyWithZeroTotal() {
        
        // Arrange & Act: creamos un carrito nuevo
        OrderCart orderCart = new OrderCart();

         // Assert: verificamos el estado inicial
        assertEquals(0.0, orderCart.getTotal());
        assertTrue(orderCart.getItems().isEmpty());

    }


    
}
