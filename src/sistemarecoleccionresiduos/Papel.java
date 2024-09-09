
package sistemarecoleccionresiduos;

import java.util.Scanner;

public class Papel extends Residuo {
    public Papel(double cantidad, String descripcion) {
        super("Papel", cantidad, descripcion);
    }

    @Override
    public void registrarReciclaje() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Registrando reciclaje de Papel...");
        System.out.print("Ingrese la cantidad (en kilogramos): ");
        double cantidad = scanner.nextDouble();
        scanner.nextLine(); 

        System.out.print("Ingrese la descripción: ");
        String descripcion = scanner.nextLine();

        // Actualizar la cantidad y descripción en la superclase Residuo
        setCantidad(cantidad);
        setDescripcion(descripcion);

    }
}
