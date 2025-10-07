package src.models;

public class Sombrero {
    private String tipo;
    private String color;
    private double precio;

    public Sombrero(String tipo, String color, double precio) {
        this.tipo = tipo;
        this.color = color;
        this.precio = precio;
    }

    public String getTipo() {
        return tipo;
    }
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }


}
