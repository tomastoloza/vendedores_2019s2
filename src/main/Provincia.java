package main;

public class Provincia {
    private long poblacion;
    private String nombre;

    public Provincia(String nombre, long poblacion) {
        this.poblacion = poblacion;
        this.nombre = nombre;
    }

    public long getPoblacion() {
        return poblacion;
    }
}
