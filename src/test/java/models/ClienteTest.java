package models;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests unitarios para la clase Cliente.
 * Valida la correcta creación, modificación y obtención de datos del cliente.
 */
class ClienteTest {

    private Cliente cliente;

    @BeforeEach
    void setUp() {
        cliente = new Cliente("Juan Pérez", "12345678A", "666123456", "juan@email.com");
    }

    @Test
    void testConstructorAndGetters() {
        assertEquals("Juan Pérez", cliente.getNombre());
        assertEquals("12345678A", cliente.getDni());
        assertEquals("666123456", cliente.getTelefono());
        assertEquals("juan@email.com", cliente.getEmail());
    }

    @Test
    void testSetters() {
        cliente.setNombre("María García");
        cliente.setDni("87654321B");
        cliente.setTelefono("777654321");
        cliente.setEmail("maria@email.com");

        assertEquals("María García", cliente.getNombre());
        assertEquals("87654321B", cliente.getDni());
        assertEquals("777654321", cliente.getTelefono());
        assertEquals("maria@email.com", cliente.getEmail());
    }

    @Test
    void testNombreNotNull() {
        assertNotNull(cliente.getNombre());
        assertFalse(cliente.getNombre().isEmpty());
    }

    @Test
    void testDniNotNull() {
        assertNotNull(cliente.getDni());
        assertFalse(cliente.getDni().isEmpty());
    }
}
