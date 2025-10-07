package models;

/**
 * Representa un cliente del sistema de gestión de ventas de sombreros.
 * Almacena la información básica de contacto y identificación del cliente.
 *
 * @author MacarenaSG
 * @version 1.0
 * @since 2025
 */
public class Cliente {

    /** Nombre completo del cliente */
    private String nombre;

    /** Documento Nacional de Identidad del cliente */
    private String dni;

    /** Número de teléfono de contacto del cliente */
    private String telefono;

    /** Dirección de correo electrónico del cliente */
    private String email;

    /**
     * Constructor que crea un nuevo cliente con todos sus datos básicos.
     *
     * @param nombre Nombre completo del cliente
     * @param dni Documento Nacional de Identidad del cliente
     * @param telefono Número de teléfono de contacto
     * @param email Dirección de correo electrónico
     */
    public Cliente(String nombre, String dni, String telefono, String email) {
        this.nombre = nombre;
        this.dni = dni;
        this.telefono = telefono;
        this.email = email;
    }

    /**
     * Obtiene el nombre del cliente.
     *
     * @return El nombre completo del cliente
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del cliente.
     *
     * @param nombre El nuevo nombre del cliente
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene el DNI del cliente.
     *
     * @return El Documento Nacional de Identidad del cliente
     */
    public String getDni() {
        return dni;
    }

    /**
     * Establece el DNI del cliente.
     *
     * @param dni El nuevo DNI del cliente
     */
    public void setDni(String dni) {
        this.dni = dni;
    }

    /**
     * Obtiene el teléfono del cliente.
     *
     * @return El número de teléfono del cliente
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * Establece el teléfono del cliente.
     *
     * @param telefono El nuevo número de teléfono del cliente
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    /**
     * Obtiene el email del cliente.
     *
     * @return La dirección de correo electrónico del cliente
     */
    public String getEmail() {
        return email;
    }

    /**
     * Establece el email del cliente.
     *
     * @param email La nueva dirección de correo electrónico del cliente
     */
    public void setEmail(String email) {
        this.email = email;
    }

}
