
package sistemarecoleccionresiduos;

import java.util.Scanner;

public abstract class Residuo {
    private String tipo;
    private double cantidad;
    private String descripcion;
    private static double cantidadTotal = 0;

    // Constructor
    public Residuo(String tipo, double cantidad, String descripcion) {
        this.tipo = tipo;
        this.cantidad = cantidad;
        this.descripcion = descripcion;
        sumarCantidadTotal(cantidad);
    }

    // Getters y setters
    public String getTipo() {
        return tipo;
    }

    public double getCantidad() {
        return cantidad;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    } 
    
    // Método abstracto para registrar el reciclaje en las subclases
    public abstract void registrarReciclaje();

   private static void sumarCantidadTotal(double cantidad) {
        cantidadTotal += cantidad;
    }

    // Método para obtener la cantidad total
    public static double getCantidadTotal() {
        return cantidadTotal;
    }       
}
