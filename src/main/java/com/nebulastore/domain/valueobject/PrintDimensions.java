package com.nebulastore.domain.valueobject;

import com.nebulastore.domain.exception.ExceedsBuildVolumeException;

public record PrintDimensions(double x, double y, double z) {

    private static final double MAX_X = 220.0;
    private static final double MAX_Y = 220.0;
    private static final double MAX_Z = 250.0;

    public PrintDimensions {
        if (x > MAX_X || y > MAX_Y || z > MAX_Z) {
            throw new ExceedsBuildVolumeException(
                "La pieza excede el volumen de impresion (" +
                MAX_X + "x" + MAX_Y + "x" + MAX_Z + " mm). " +
                "Recibido: " + x + "x" + y + "x" + z);
        }
    }
}