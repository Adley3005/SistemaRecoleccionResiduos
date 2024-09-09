
package sistemarecoleccionresiduos;

import java.util.Scanner;

public class Plastico extends Residuo {
    public Plastico(double cantidad, String descripcion) {
        super("Plastico", cantidad, descripcion);
    }

    @Override
    public void registrarReciclaje() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Registrando reciclaje de Plástico...");
        System.out.print("Ingrese la cantidad (en kilogramos): ");
        double cantidad = scanner.nextDouble();
        scanner.nextLine(); // Consumir el salto de línea después del número

        System.out.print("Ingrese la descripción: ");
        String descripcion = scanner.nextLine();

        // Actualizar la cantidad y descripción en la superclase Residuo
        setCantidad(cantidad);
        setDescripcion(descripcion);

        // Lógica adicional si es necesario para el reciclaje de plástico
    }
}
