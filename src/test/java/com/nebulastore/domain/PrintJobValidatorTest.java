package com.nebulastore.domain;

import com.nebulastore.domain.exception.ExceedsBuildVolumeException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

@DisplayName("PrintJobValidator  validacion de volumen de impresion")
class PrintJobValidatorTest {

    @ParameterizedTest
    @CsvSource({
            "300, 100, 100",   // se pasa en X
            "100, 300, 100",   // se pasa en Y
            "100, 100, 300"    // se pasa en Z
    })
    @DisplayName("Deberia lanzar ExceedsBuildVolumeException cuando alguna dimension excede el limite")
    void shouldThrowWhenAnyDimensionExceedsLimit(double x, double y, double z) {
        // Arrange
        PrintJobValidator validator = new PrintJobValidator();

        // Act & Assert
        assertThrows(ExceedsBuildVolumeException.class,
                () -> validator.validateDimensions(x, y, z));
    }

    @Test
    @DisplayName("No deberia lanzar excepcion cuando la pieza cabe en el volumen")
    void shouldNotThrowWhenPieceFits() {
        // Arrange
        PrintJobValidator validator = new PrintJobValidator();

        // Act & Assert: pieza que cabe holgada
        assertDoesNotThrow(() -> validator.validateDimensions(100, 100, 100));
    }
}