package src.models;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class Venta {
    private final Cliente cliente;
    private final List<Sombrero> lineasDeVenta;
    private final LocalDate fecha;


    public Venta(Cliente cliente) {
        this.cliente = cliente;
        this.lineasDeVenta = new ArrayList<>();
        this.fecha = LocalDate.now();
    }

    //añadir producto a la venta
    public void addSombrero(Sombrero s) {
        lineasDeVenta.add(s);
    }


    public double calcularTotal() {
        double total = 0.0;
        for (Sombrero s : lineasDeVenta) {
            total += s.getPrecio();
        }
        return total;
    }


    public Cliente getCliente() {
        return cliente;
    }

    public List<Sombrero> getLineasDeVenta() {
        return lineasDeVenta;
    }

    public LocalDate getFecha() {
        return fecha;
    }

}
