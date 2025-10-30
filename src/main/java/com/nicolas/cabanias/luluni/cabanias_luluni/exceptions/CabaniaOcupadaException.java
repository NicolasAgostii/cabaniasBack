package com.nicolas.cabanias.luluni.cabanias_luluni.exceptions;

public class CabaniaOcupadaException extends RuntimeException {

    public CabaniaOcupadaException(String mensaje) {
        super(mensaje);
    }

    public static CabaniaOcupadaException yaOcupada() {
        return new CabaniaOcupadaException("La cabaña ya está ocupada.");
    }

    public static CabaniaOcupadaException yaOcupadaEnLaManiana() {
        return new CabaniaOcupadaException("La cabaña ya está ocupada en la mañana.");
    }

    public static CabaniaOcupadaException yaOcupadaEnLaTarde() {
        return new CabaniaOcupadaException("La cabaña ya está ocupada en la tarde.");
    }
}
