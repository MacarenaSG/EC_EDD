package models;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDate;

/**
 * Tests unitarios para la clase Venta.
 * Valida la correcta creación de ventas, adición de sombreros y cálculo de totales.
 */
class VentaTest {

    private Cliente cliente;
    private Venta venta;
    private Sombrero sombrero1;
    private Sombrero sombrero2;

    @BeforeEach
    void setUp() {
        cliente = new Cliente("Ana López", "11111111A", "123456789", "ana@email.com");
        venta = new Venta(cliente);
        sombrero1 = new Sombrero("Gorra", "Roja", 12.50);
        sombrero2 = new Sombrero("Sombrero", "Marrón", 35.00);
    }

    @Test
    void testConstructorAndInitialState() {
        assertEquals(cliente, venta.getCliente());
        assertEquals(LocalDate.now(), venta.getFecha());
        assertTrue(venta.getLineasDeVenta().isEmpty());
        assertEquals(0.0, venta.calcularTotal(), 0.01);
    }

    @Test
    void testAddSombrero() {
        venta.addSombrero(sombrero1);

        assertEquals(1, venta.getLineasDeVenta().size());
        assertTrue(venta.getLineasDeVenta().contains(sombrero1));
    }

    @Test
    void testAddMultipleSombreros() {
        venta.addSombrero(sombrero1);
        venta.addSombrero(sombrero2);

        assertEquals(2, venta.getLineasDeVenta().size());
        assertTrue(venta.getLineasDeVenta().contains(sombrero1));
        assertTrue(venta.getLineasDeVenta().contains(sombrero2));
    }

    @Test
    void testCalcularTotalConUnSombrero() {
        venta.addSombrero(sombrero1);
        assertEquals(12.50, venta.calcularTotal(), 0.01);
    }

    @Test
    void testCalcularTotalConVariosSombreros() {
        venta.addSombrero(sombrero1);
        venta.addSombrero(sombrero2);
        assertEquals(47.50, venta.calcularTotal(), 0.01);
    }

    @Test
    void testCalcularTotalVentaVacia() {
        assertEquals(0.0, venta.calcularTotal(), 0.01);
    }

    @Test
    void testFechaActual() {
        assertEquals(LocalDate.now(), venta.getFecha());
    }
}
