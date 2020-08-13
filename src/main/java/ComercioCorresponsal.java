import java.util.HashSet;

public class ComercioCorresponsal extends Vendedor {

    private HashSet<Ciudad> sucursales;
    private HashSet<Vendedor> vendedores;

    public ComercioCorresponsal(HashSet<Ciudad> sucursales) {
        this.sucursales = sucursales;
    }

    @Override
    public boolean puedeVender(Ciudad ciudad) {
        return sucursales.contains(ciudad);
    }

    @Override
    public boolean esInfluyente() {
        return false;
    }

    @Override
    public boolean tieneAfinidad(CentroDeDistribucion centroDeDistribucion) {
        boolean adicional = false;
        for (Ciudad ciudad : sucursales) {
            if (!centroDeDistribucion.puedeCubrir(ciudad)) {
                adicional = true;
            }
        }
        return super.tieneAfinidad(centroDeDistribucion) && adicional;
    }
}
