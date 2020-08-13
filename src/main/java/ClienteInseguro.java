public class ClienteInseguro extends Cliente {
    @Override
    public boolean puedeSerAtendido(Vendedor vendedor) {
        return vendedor.esVersatil() && vendedor.esFirme();
    }
}
