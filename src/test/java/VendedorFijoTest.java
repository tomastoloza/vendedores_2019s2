import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashSet;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

class VendedorFijoTest {

    VendedorFijo vendedorFijo;
    Provincia buenos_aires;
    Ciudad hurlingham;
    CentroDeDistribucion centroDeDistribucion;

    @BeforeEach
    void setUp() {
        buenos_aires = new Provincia("Buenos Aires", 100000);
        hurlingham = new Ciudad("Hurlingham", buenos_aires);
        vendedorFijo = new VendedorFijo(hurlingham);
        HashSet<Vendedor> vendedores = new HashSet<>();
        vendedores.add(vendedorFijo);
        centroDeDistribucion = new CentroDeDistribucion(vendedores, hurlingham);
    }

    @Test
    void testCiudadVendedor() {
        assertEquals(hurlingham, vendedorFijo.getCiudadEnLaQueVive());
    }

    @Test
    void testEmpiezaSinCertificaciones() {
        assertEquals(0, vendedorFijo.getCertificaciones().size());
    }

    @Test
    void testSumaCertificaciones() {
        centroDeDistribucion.repartirCertificacion(new Certificacion(10, true));
        assertEquals(1, vendedorFijo.getCertificaciones().size());
    }

    @Test
    void testNoEsVendedorInfluyente() {
        assertFalse(vendedorFijo.esInfluyente());
    }
}