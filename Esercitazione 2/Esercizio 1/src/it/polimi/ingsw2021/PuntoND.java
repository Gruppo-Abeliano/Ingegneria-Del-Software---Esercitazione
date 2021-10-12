package it.polimi.ingsw2021;

import java.util.Arrays;

public class PuntoND {
    private double[] coordinate;

    /**
    * double... è un elemento sintattico per ricevere in ingresso un array di double di lunghezza ancora non
    * specificata.
    */
    public PuntoND(double... coordinate) {
        this.coordinate = new double[coordinate.length];
        for (int i = 0; i < coordinate.length; i++) {
            this.coordinate[i] = coordinate[i];
        }
    }

    public double getCoordinata(int axis) {
        return this.coordinate[axis - 1];
    }

    public void setCoordinata(int axis, double coordinata) {
        this.coordinate[axis - 1] = coordinata;
    }

    public int getDimensioni() {
        return coordinate.length;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PuntoND puntoND = (PuntoND) o;
        return Arrays.equals(coordinate, puntoND.coordinate);
    }
}
