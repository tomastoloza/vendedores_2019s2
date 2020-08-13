import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashSet;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

class CentroDeDistribucionTest {

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
    void testSumaCertificaciones() {
        centroDeDistribucion.repartirCertificacion(new Certificacion(10, true));
        assertEquals(1, vendedorFijo.getCertificaciones().size());
        assertEquals(centroDeDistribucion.getVendedores().iterator().next(), vendedorFijo);
    }

    @Test
    void testVendedorEstrella() {
        centroDeDistribucion.repartirCertificacion(new Certificacion(10, true));
        assertEquals(centroDeDistribucion.getVendedorEstrella(), vendedorFijo);
    }

    @Test
    void testNoHayVendedorEstrella() {
        assertNull(centroDeDistribucion.getVendedorEstrella());
    }

}