package main;

import java.util.ArrayList;

public abstract class Vendedor {
    private ArrayList<Certificacion> certicaciones;

    //Test: ver si es firme antes y despues de una certificacion otorgada
    public boolean esVersatil() {
        return certicaciones.size() > 3 && certicaciones.stream().anyMatch(c -> !c.esProducto());
    }

    //Test: ver si es firme antes y despues de una certificacion otorgada
    public boolean esFirme() {
        return this.getPuntaje() >= 30;
    }


    public abstract boolean puedeVender(Ciudad ciudad);

    public abstract boolean esInfluyente();

    public int getPuntaje() {
        int counter = 0;
        for (Certificacion certificacion : certicaciones) {
            counter += certificacion.getPuntos();
        }
        return counter;
    }

    public ArrayList<Certificacion> getCertificaciones() {
        return certicaciones;
    }

    public boolean tieneAfinidad(CentroDeDistribucion centroDeDistribucion) {
        return this.puedeVender(centroDeDistribucion.getCiudad());
    }
}
