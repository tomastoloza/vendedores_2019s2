import java.util.HashSet;

public class CentroDeDistribucion {
    private HashSet<Vendedor> vendedores;
    private Ciudad ciudad;

    public CentroDeDistribucion(HashSet<Vendedor> vendedores, Ciudad ciudad) {
        this.vendedores = vendedores;
        this.ciudad = ciudad;
    }

    public void agregarVendedor(Vendedor vendedor) throws Exception {
        if (!vendedores.contains(vendedor)) {
            throw new Exception("Vendedor ya está registrado");
        }
        this.vendedores.add(vendedor);
    }

    public void repartirCertificacion(Certificacion certificacion) {
        for (Vendedor vendedor : vendedores) {
            vendedor.getCertificaciones().add(certificacion);
        }
    }

    public Vendedor getVendedorEstrella() {
        int puntajeMax = 0;
        Vendedor vendedorEstrella = null;
        for (Vendedor vendedor : this.vendedores) {
            if (vendedor.getPuntaje() > puntajeMax) {
                puntajeMax = vendedor.getPuntaje();
                vendedorEstrella = vendedor;
            }
        }
        return vendedorEstrella;
    }


    public boolean puedeCubrir(Ciudad ciudad) {
        for (Vendedor vendedor : vendedores) {
            if (vendedor.puedeVender(ciudad)) {
                return true;
            }
        }
        return false;
    }


    public boolean esRobusto() {
        int counter = 0;
        for (Vendedor vendedor : vendedores) {
            if (vendedor.esFirme() && counter < 3) {
                counter++;
            }
        }
        return counter >= 3;
    }

    public Ciudad getCiudad() {
        return ciudad;
    }

    public boolean esVendedorCandidato(Vendedor vendedor) {
        return vendedor.esVersatil() && vendedor.tieneAfinidad(this);
    }

    public HashSet<Vendedor> getVendedores(){
        return this.vendedores;
    }
}
