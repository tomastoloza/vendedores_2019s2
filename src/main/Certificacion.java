package main;

public class Certificacion {
    private int puntos;
    private boolean esProducto;

    public int getPuntos() {
        return puntos;
    }

    public Certificacion(int puntos, boolean esProducto) {
        this.puntos = puntos;
        this.esProducto = esProducto;
    }


    public boolean esProducto() {
        return esProducto;
    }
}
