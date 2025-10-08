package models;

/**
 * Representa un sombrero disponible en el inventario de la tienda.
 * Almacena la información básica del producto: tipo, color y precio.
 *
 * @author MacarenaSG
 * @version 1.0
 * @since 2025
 */
public class Sombrero {

    /** Tipo o modelo del sombrero (ej: fedora, gorra, boina) */
    private String tipo;

    /** Color del sombrero */
    private String color;

    /** Precio del sombrero en euros */
    private double precio;

    /** Stock de sombreros */
    private int stock;

    /**
     * Constructor que crea un nuevo sombrero con sus características básicas.
     *
     * @param tipo Tipo o modelo del sombrero
     * @param color Color del sombrero
     * @param precio Precio del sombrero en euros
     * @param stock Stock de sombreros
     */
    public Sombrero(String tipo, String color, double precio, int stock) {
        this.tipo = tipo;
        this.color = color;
        this.precio = precio;
        this.stock = stock;
    }

    /**
     * Obtiene el tipo del sombrero.
     *
     * @return El tipo o modelo del sombrero
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * Establece el tipo del sombrero.
     *
     * @param tipo El nuevo tipo o modelo del sombrero
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    /**
     * Obtiene el color del sombrero.
     *
     * @return El color del sombrero
     */
    public String getColor() {
        return color;
    }

    /**
     * Establece el color del sombrero.
     *
     * @param color El nuevo color del sombrero
     */
    public void setColor(String color) {
        this.color = color;
    }

    /**
     * Obtiene el precio del sombrero.
     *
     * @return El precio del sombrero en euros
     */
    public double getPrecio() {
        return precio;
    }

    /**
     * Establece el precio del sombrero.
     *
     * @param precio El nuevo precio del sombrero en euros
     */
    public void setPrecio(double precio) {
        this.precio = precio;
    }

    /**
     * Obtiene el stock de sombreros.
     *
     * @return El stock de sombreros
     */
    public int getStock() { return stock; }

    /**
     * Establece el stock sombrero.
     *
     * @param stock El nuevo stock de sombreros
     */
    public void setStock(int stock) { this.stock = stock; }

}
