package com.nebulastore.domain.valueobject;

import com.nebulastore.domain.exception.ExceedsBuildVolumeException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

@DisplayName("PrintDimensions value object")
class PrintDimensionsTest {

    @ParameterizedTest
    @CsvSource({
            "300, 100, 100",
            "100, 300, 100",
            "100, 100, 300"
    })
    @DisplayName("Deberia lanzar ExceedsBuildVolumeException cuando alguna dimension excede el limite")
    void shouldThrowWhenAnyDimensionExceedsLimit(double x, double y, double z) {
        assertThrows(ExceedsBuildVolumeException.class, () -> new PrintDimensions(x, y, z));
    }

    @Test
    @DisplayName("No deberia lanzar excepcion cuando la pieza cabe en el volumen")
    void shouldNotThrowWhenPieceFits() {
        assertDoesNotThrow(() -> new PrintDimensions(100, 100, 100));
    }
}