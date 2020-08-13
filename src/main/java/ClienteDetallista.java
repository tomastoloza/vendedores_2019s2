public class ClienteDetallista extends Cliente {
    @Override
    public boolean puedeSerAtendido(Vendedor vendedor) {
        int counter = 0;
        for (Certificacion certificacion : vendedor.getCertificaciones()) {
            if (certificacion.esProducto() && counter < 3) {
                counter++;
            }
        }
        return counter > 3;
    }
}
