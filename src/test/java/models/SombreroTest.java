package models;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests unitarios para la clase Sombrero.
 * Valida la correcta creación, modificación y obtención de datos del sombrero.
 */
class SombreroTest {

    private Sombrero sombrero;

    @BeforeEach
    void setUp() {
        sombrero = new Sombrero("Fedora", "Negro", 25.99);
    }

    @Test
    void testConstructorAndGetters() {
        assertEquals("Fedora", sombrero.getTipo());
        assertEquals("Negro", sombrero.getColor());
        assertEquals(25.99, sombrero.getPrecio(), 0.01);
    }

    @Test
    void testSetters() {
        sombrero.setTipo("Boina");
        sombrero.setColor("Azul");
        sombrero.setPrecio(15.50);

        assertEquals("Boina", sombrero.getTipo());
        assertEquals("Azul", sombrero.getColor());
        assertEquals(15.50, sombrero.getPrecio(), 0.01);
    }

    @Test
    void testPrecioPositivo() {
        assertTrue(sombrero.getPrecio() > 0);
    }

    @Test
    void testTipoNotNull() {
        assertNotNull(sombrero.getTipo());
        assertFalse(sombrero.getTipo().isEmpty());
    }

    @Test
    void testColorNotNull() {
        assertNotNull(sombrero.getColor());
        assertFalse(sombrero.getColor().isEmpty());
    }
}
