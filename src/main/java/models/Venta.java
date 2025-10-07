package models;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Representa una transacción de venta en el sistema de gestión de sombreros.
 * Asocia un cliente con una lista de sombreros comprados en una fecha específica.
 * Permite calcular el importe total de la venta.
 *
 * @author MacarenaSG
 * @version 1.0
 * @since 2025
 */
public class Venta {

    /** Cliente que realiza la compra */
    private final Cliente cliente;

    /** Lista de sombreros incluidos en la venta */
    private final List<Sombrero> lineasDeVenta;

    /** Fecha en que se realizó la venta */
    private final LocalDate fecha;

    /**
     * Constructor que crea una nueva venta asociada a un cliente.
     * La fecha se establece automáticamente al momento actual y se inicializa
     * una lista vacía para los sombreros.
     *
     * @param cliente El cliente que realiza la compra
     */
    public Venta(Cliente cliente) {
        this.cliente = cliente;
        this.lineasDeVenta = new ArrayList<>();
        this.fecha = LocalDate.now();
    }

    /**
     * Añade un sombrero a la venta.
     *
     * @param s El sombrero a añadir a la venta
     */
    public void addSombrero(Sombrero s) {
        lineasDeVenta.add(s);
    }

    /**
     * Calcula el importe total de la venta sumando los precios
     * de todos los sombreros incluidos.
     *
     * @return El importe total de la venta en euros
     */
    public double calcularTotal() {
        double total = 0.0;
        for (Sombrero s : lineasDeVenta) {
            total += s.getPrecio();
        }
        return total;
    }

    /**
     * Obtiene el cliente asociado a esta venta.
     *
     * @return El cliente que realizó la compra
     */
    public Cliente getCliente() {
        return cliente;
    }

    /**
     * Obtiene la lista de sombreros incluidos en la venta.
     *
     * @return Lista no modificable de los sombreros comprados
     */
    public List<Sombrero> getLineasDeVenta() {
        return lineasDeVenta;
    }

    /**
     * Obtiene la fecha en que se realizó la venta.
     *
     * @return La fecha de la venta
     */
    public LocalDate getFecha() {
        return fecha;
    }

}
