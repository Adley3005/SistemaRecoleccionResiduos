
package sistemarecoleccionresiduos;

import java.util.Scanner;
import static sistemarecoleccionresiduos.SistemaRecoleccionResiduos.listaUsuarios;

public class Colaborador {
    private String nombreColaborador;
    private int edad;
    private String contraseña;
    private double codigoColaborador;
    private int cantidadRecolectada;

    // Constructor
    public Colaborador(String nombreColaborador, String contraseña, double codigoColaborador) {
        this.nombreColaborador = nombreColaborador;
        this.contraseña = contraseña;
        this.codigoColaborador = codigoColaborador;
        this.cantidadRecolectada = 0;
    }

    // Método para registrar la cantidad recolectada por el colaborador
    public void registrarRecoleccion(int cantidad) {
        this.cantidadRecolectada += cantidad;
    }

    // Método para evaluar si ha alcanzado la meta para el bono
    public void evaluarMeta() {
        System.out.println("Cantidad total recolectada por " + nombreColaborador + ": " + cantidadRecolectada + " kilos");

        if (cantidadRecolectada > 100) {
            System.out.println("Felicidades, has alcanzado la meta para el bono!");
            System.out.println("Se te otorgara un bono de 100 soles.");
        } else {
            System.out.println("Sigue intentando, aun no has alcanzado la meta para el bono.");
        }
    }

    // Método para mostrar el menú
    public void mostrarMenu() {
        Scanner scanner = new Scanner(System.in);

        int opcion;
        do {
            System.out.println("============================================================");
            System.out.println("Bienvenido, " + nombreColaborador + "!");
            System.out.println("1. Reporte reciclaje usuarios");
            System.out.println("2. Registrar reciclaje");
            System.out.println("3. Evaluar meta para el bono");
            System.out.println("4. Soporte usuarios");
            System.out.println("5. Salir");
            System.out.println("============================================================");
            System.out.print("Seleccione una opcion: ");
            

            opcion = scanner.nextInt();
            scanner.nextLine(); 

            switch (opcion) {
                case 1:
                    mostrarInformeReciclajes();
                    break;
                case 2:
                    System.out.print("Ingrese la cantidad recolectada en kilos: ");
                    int cantidadReciclada = scanner.nextInt();
                    registrarRecoleccion(cantidadReciclada);
                    System.out.println("Reciclaje registrado exitosamente.");
                    break;
                case 3:
                    evaluarMeta();
                    break;
                case 4:
                    System.out.println("Lista de problemas reportados:");
                    for (Soporte problema : Soporte.getListaProblemas()) {
                        System.out.println(problema.getDescripcion());
                    }
                    break;    
                case 5:
                    System.out.println("Hasta luego, " + nombreColaborador + "!");
                    break;
                default:
                    System.out.println("Opción no válida. Intente nuevamente.");
            }

        } while (opcion != 5);
    }

    public boolean validarCredenciales(String nombreColaborador, String contraseña) {
        return this.nombreColaborador.equals(nombreColaborador) && this.contraseña.equals(contraseña);
    }

    public void mostrarInformeReciclajes() {
    System.out.println("Informe de Reciclajes Registrados:");
    System.out.println("===============================");

    for (Usuario usuario : listaUsuarios) {
        System.out.println("Usuario: " + usuario.getNombreUsuario());
        if (!usuario.getListaReciclajes().isEmpty()) {
            for (Residuo residuo : usuario.getListaReciclajes()) {
                System.out.println("Tipo: " + residuo.getTipo());
                System.out.println("Cantidad: " + residuo.getCantidad() + " kg");
                System.out.println("Descripción: " + residuo.getDescripcion());
                System.out.println("--------------------------------");
            }
        } else {
            System.out.println("El usuario " + usuario.getNombreUsuario() + " no ha registrado reciclajes.");
        }
        System.out.println("===============================");
    }
   }
}
