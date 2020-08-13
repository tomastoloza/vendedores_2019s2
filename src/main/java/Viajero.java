import java.util.ArrayList;

public class Viajero extends Vendedor {
    private ArrayList<Provincia> provinciasHabilitadas;

    public Viajero(ArrayList<Provincia> provinciasHabilitadas) {
        this.provinciasHabilitadas = provinciasHabilitadas;
    }


    @Override
    public boolean puedeVender(Ciudad ciudad) {
        for (Provincia provincia : provinciasHabilitadas) {
            if (ciudad.getProvincia().equals(provincia)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean esInfluyente() {
        long counter = 0;
        for (Provincia provincia : provinciasHabilitadas) {
            counter += provincia.getPoblacion();
        }
        return counter >= 10000000;
    }
}
