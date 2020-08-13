public class VendedorFijo extends Vendedor {

    private Ciudad ciudadEnLaQueVive;

    public Ciudad getCiudadEnLaQueVive() {
        return ciudadEnLaQueVive;
    }

    public VendedorFijo(Ciudad ciudadEnLaQueVive) {
        this.ciudadEnLaQueVive = ciudadEnLaQueVive;
    }


    @Override
    public boolean puedeVender(Ciudad ciudad) {
        return ciudad.equals(this.ciudadEnLaQueVive);
    }

    @Override
    public boolean esInfluyente() {
        return false;
    }
}
