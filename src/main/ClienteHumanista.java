package main;

public class ClienteHumanista extends Cliente {
    @Override
    public boolean puedeSerAtendido(Vendedor vendedor) {
        return vendedor instanceof VendedorFijo || vendedor instanceof Viajero;
    }
}
