
package sistemarecoleccionresiduos;

import java.util.*;

public class SistemaRecoleccionResiduos {


    private static Scanner scanner = new Scanner(System.in);
    protected static ArrayList<Usuario> listaUsuarios = new ArrayList<>();
    private static ArrayList<Colaborador> listaColaboradores = new ArrayList<>();
    private static Usuario usuarioActual = null;
    private static Colaborador colaboradorActual = null;
    private static ArrayList<ZonaRecoleccion> zonasRecoleccion = new ArrayList<>();
    

    public static void main(String[] args) {
        inicializarZonasRecoleccion();

        while (true) {
            System.out.println("============================================================");
            System.out.println("Bienvenido al Sistema de Gestion de Residuos Reciclables:");
            System.out.println("1. Usuario");
            System.out.println("2. Colaborador");
            System.out.println("3. Salir");
            System.out.println("============================================================");
            System.out.print("Seleccione una opcion: ");
            

            int opcion = scanner.nextInt();
            scanner.nextLine(); 

            switch (opcion) {
                case 1:
                    gestionarUsuario();
                    break;
                case 2:
                    gestionarColaborador();
                    break;
                case 3:
                    System.out.println("Hasta luego");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opcion invalida. Por favor, seleccione una opcion valida.");
            }
        }
    }

    private static void inicializarZonasRecoleccion() {
        zonasRecoleccion.add(new ZonaRecoleccion(1, "Club Campestre La Laguna, Portada de la Panicie, La Planicie, La Planicie Zona Este, Parcelas A, C, D, E y F, Alameda de la Planicie, Coop. Musa, Los Arbolitos, Los Sauces, Asoc. II de Marzo", "7:00am - 7:30am", ""));
        zonasRecoleccion.add(new ZonaRecoleccion(2, "El Sol de la Molina I, II y III Etapa, Asoc. Nueva Molina, Molina Real, Laderas de La Molina, Los Huertos de la Molina, Resid. San Remo", "7:45am - 8:15am", ""));
        zonasRecoleccion.add(new ZonaRecoleccion(3, "Club Campestre Las Lagunas, La Rinconada del Lago I, II, y III etapa", "8:30am - 9:00am", ""));
        zonasRecoleccion.add(new ZonaRecoleccion(4, "El Haras, Rinconada Baja, La Estancia Oeste, La Estancia, La Pradra, La Quebrada de La Rinconada, Rinconada de Ate, El Sauce de la Rinconada, Los Portales, Asoc. Viento Nuevo, Rinconada Alta, Habilitación Lotes A, B, C y A-B", "9:15am - 9:45am", ""));
        zonasRecoleccion.add(new ZonaRecoleccion(5, "Portada del Sol (APVHA), Las Praderas de La Molina", "", "7:00pm - 7:30pm"));
        zonasRecoleccion.add(new ZonaRecoleccion(6, "Las Lomas de La Molina Vieja, Coop. Constructores, Portada del Sol (AEMG)", "", "7:45pm - 8:15pm"));
        zonasRecoleccion.add(new ZonaRecoleccion(7, "Valle de La Molina. El Cascajal, La Capilla, Los Robles, Los Girasoles, parte de Portada del Sol (AEMG)", "", "8:30pm - 9:00pm"));
        zonasRecoleccion.add(new ZonaRecoleccion(8, "El Remanso de La Molina desde Av. La Arboleda hasta la Av. La Alameda de la Paz, parte de Sirius, El Corregidor, Islas del Sol, La Ensenada", "10:00am - 10:30am", ""));
        zonasRecoleccion.add(new ZonaRecoleccion(9, "El Remanso de La Molina, parte de Sirius, La Molina Vieja I y II Etapa A.H. Los Pinos, A.H. Viña alta, UNALM", "10:45am - 11:15am", ""));
        zonasRecoleccion.add(new ZonaRecoleccion(10, "Santa Patricia II Etapa, Pablo Bonner, Aprovisa, A.A.H.H. Las Hormigas", "11:30am - 12:00pm", ""));
        zonasRecoleccion.add(new ZonaRecoleccion(11, "Parte de Covima, Sta. Patricia I, Laderas de Melgarejo, Far West Villas, Campo Verde, Los Cactus", "", "12:15pm - 12:45pm"));
        zonasRecoleccion.add(new ZonaRecoleccion(12, "Covima desde Av. Constructores hasta Prolog. Javier Prado, Santa Raquel desde Av. Constructores hasta Calle Pablo de Olavide, Santa Patricia III Etapa, Pablo Cánepa", "", "9:15pm - 9:45pm"));
        zonasRecoleccion.add(new ZonaRecoleccion(13, "Residencial Ingenieros, La Riviera de Monterrico, Las Acacias, Proyecto La Fontana, El Sol, San César", "", "10:00pm - 10:30pm"));
        zonasRecoleccion.add(new ZonaRecoleccion(14, "Santa Raquel, Covima, Santa Felicia", "", "10:45pm - 11:15pm"));
        zonasRecoleccion.add(new ZonaRecoleccion(15, "Residencial Monterrico, Ampl. Residencial Monterrico, La Fontana, Residencial Monterrico Ampliación Sur", "", "01:00pm - 01:30pm"));
        zonasRecoleccion.add(new ZonaRecoleccion(16, "Los Cactus, Camino Real I y II etapa, Santa Magdalena Sofía, Camacho, A.A.H.H. Matazango, Villa FAP, El Parque de Monterrico","", "01:45pm - 02:15pm"));
    }

    private static void gestionarUsuario() {
        while (true) {
            System.out.println("============================================================");
            System.out.println(" Bienvenido, Usuario!");
            System.out.println("1. Registrarse");
            System.out.println("2. Iniciar sesion");
            System.out.println("3. Volver al menu principal");
            System.out.println("============================================================");
            System.out.print("Seleccione una opcion: ");
            

            int opcionUsuario = scanner.nextInt();
            scanner.nextLine(); 

            switch (opcionUsuario) {
                case 1:
                    registrarUsuario();
                    break;
                case 2:
                    iniciarSesionUsuario();
                    break;
                case 3:
                    return; 
                default:
                    System.out.println("Opcion invalida. Por favor, seleccione una opción valida.");
            }
        }
    }

    private static void registrarUsuario() {
        System.out.print("Ingrese su nombre de usuario: ");
        String nombreUsuario = scanner.nextLine();
        System.out.print("Ingrese su contrasena: ");
        String contraseña = scanner.nextLine();
        System.out.print("Ingrese su direccion: ");
        String direccion = scanner.nextLine();
        int edad = 0;
        boolean entradaCorrecta = false;

        while (!entradaCorrecta) {
            try {
                System.out.print("Ingrese su edad: ");
                edad = scanner.nextInt();
                scanner.nextLine(); // Consumir el salto de línea después del número
                entradaCorrecta = true; // La entrada es válida, salimos del bucle
            } catch (InputMismatchException e) {
                System.out.println("Error: Ingrese un número entero válido para la edad.");
                scanner.nextLine(); // Limpiar el buffer del scanner para evitar un bucle infinito
            }
        }
        
        
        //Creamos un usuario nuevo
        Usuario nuevoUsuario = new Usuario(nombreUsuario, contraseña, direccion, edad);
        listaUsuarios.add(nuevoUsuario);

        System.out.println("Usuario registrado correctamente.");
    }

    private static void iniciarSesionUsuario() {
        System.out.print("Ingrese su nombre de usuario: ");
        String nombreUsuario = scanner.nextLine();
        System.out.print("Ingrese su contrasena: ");
        String contraseña = scanner.nextLine();

        // Es para buscar el usuario en la lista
        for (Usuario usuario : listaUsuarios) {
            if (usuario.validarCredenciales(nombreUsuario, contraseña)) {
                usuarioActual = usuario;
                menuUsuario();
                return;
            }
        }

        System.out.println("Nombre de usuario o contraseña incorrectos. Intente nuevamente.");
    }

    private static void menuUsuario() {
        boolean salir = false;
        while (!salir) {
            System.out.println("============================================================");
            System.out.println(" Bienvenido, " + usuarioActual.getNombreUsuario()+ " :");
            System.out.println("1. Buscar puntos de reciclaje");
            System.out.println("2. Seleccionar punto de recoleccion");
            System.out.println("3. Registrar reciclaje");
            System.out.println("4. Ver informacion de usuario");
            System.out.println("5. Enviar consulta o reportar problema");
            System.out.println("6. Volver al menu principal");
            System.out.println("============================================================");
            System.out.print("Seleccione una opcion: ");
            

            int opcionUsuario = scanner.nextInt();
            scanner.nextLine(); 

            switch (opcionUsuario) {
                case 1:
                    mostrarInformacionPuntosRecoleccion(zonasRecoleccion);
                    break;
                case 2:
                    seleccionarZonaRecoleccion();
                    break;
                case 3:
                   // Registrar reciclaje
                    registrarReciclaje();
                    break;
                case 4:
                    usuarioActual.mostrarInformacionUsuario();
                    break;

                case 5:
                    System.out.println("============================================================");
                    System.out.println("1. Enviar consulta");
                    System.out.println("2. Reportar problema");
                    System.out.println("============================================================");
                    int opcionSoporte = scanner.nextInt();
                    scanner.nextLine();
                    switch (opcionSoporte) {
                        case 1:
                            System.out.println("¡Gracias por contactarnos! Estaremos encantados de resolver sus dudas. Para ello, diríjase al siguiente enlace: \n https://emausreciclajeperu.org.pe/contactanos.html");
                            break;
                        case 2:
                            System.out.println("Ingrese la descripción del problema:");
                            String descripcionProblema = scanner.nextLine();
                            Soporte soporte = new Soporte(descripcionProblema);
                            System.out.println("Problema reportado correctamente.");
                            break;
                        default:
                            System.out.println("Opcion invalida. Por favor, seleccione una opción valida.");
                            break;
                    }
                    break;

                case 6:
                    salir = true; // Para salir del bucle 
                    break;
                default:
                    System.out.println("Opcion invalida. Por favor, seleccione una opción valida.");
                    break;
            }
        }
    } 

    private static void gestionarColaborador() {
        while (true) {
            System.out.println("============================================================");
            System.out.println(" Bienvenido, Colaborador :");
            System.out.println("1. Registrar Colaborador");
            System.out.println("2. Iniciar Sesion como Colaborador");
            System.out.println("3. Mostrar Informacion de Puntos de Recoleccion");
            System.out.println("4. Volver al menu principal");
            System.out.println("============================================================");
            System.out.print("Seleccione una opcion: ");
            

            int opcionColaborador = scanner.nextInt();
            scanner.nextLine(); 

            switch (opcionColaborador) {
                case 1:
                    registrarColaborador();
                    break;
                case 2:
                    iniciarSesionColaborador();
                    break;
                case 3:
                    mostrarInformacionPuntosRecoleccion(zonasRecoleccion);
                    break;
                case 4:
                    return; // Volver al menú principal
                default:
                    System.out.println("Opcion invalida. Por favor, seleccione una opción valida.");
            }
        }
    }
    
    private static void seleccionarZonaRecoleccion(){
    System.out.println("Lista de Zonas de Recoleccion:");
                    for (ZonaRecoleccion zona : zonasRecoleccion) {
                        System.out.println(zona.getNumero() + ". " + zona.getUbicacion());
                    }
                    System.out.print("Ingrese el numero de la zona de recoleccion: ");
                    int numeroZona = scanner.nextInt();
                    scanner.nextLine();
                    if (numeroZona >= 1 && numeroZona <= zonasRecoleccion.size()) {
                        ZonaRecoleccion zonaSeleccionada = zonasRecoleccion.get(numeroZona - 1);
                        usuarioActual.seleccionarZonaRecoleccion(zonaSeleccionada);
                        System.out.println("Zona de recoleccion seleccionada correctamente.");
                    } else {
                        System.out.println("Numero de zona invalido. Por favor, seleccione una zona valida.");
                    }
}
    

    private static void registrarColaborador() {
        System.out.print("Ingrese su nombre: ");
        String nombreColaborador = scanner.nextLine();
        System.out.print("Ingrese su contrasena: ");
        String contraseña = scanner.nextLine();
        System.out.print("Ingrese el codigo de colaborador: ");
        double codigoColaborador = scanner.nextDouble();

        // Crear un nuevo colaborador y agregarlo a la lista
        Colaborador nuevoColaborador = new Colaborador(nombreColaborador, contraseña, codigoColaborador);
        listaColaboradores.add(nuevoColaborador);

        System.out.println("Colaborador registrado correctamente.");
    }

    private static void iniciarSesionColaborador() {
        System.out.print("Ingrese su nombre de colaborador: ");
        String nombreColaborador = scanner.nextLine();
        System.out.print("Ingrese su contrasena: ");
        String contraseña = scanner.nextLine();

        // Buscar el colaborador en la lista
        for (Colaborador colaborador : listaColaboradores) {
            if (colaborador.validarCredenciales(nombreColaborador, contraseña)) {
                colaboradorActual = colaborador;
                menuColaborador();
                return;
            }
        }

        System.out.println("Nombre de colaborador o contrasena incorrectos. Intente nuevamente.");
    }

    private static void menuColaborador() {
        colaboradorActual.mostrarMenu();
    }

    public static void mostrarInformacionPuntosRecoleccion(ArrayList<ZonaRecoleccion> zonasRecoleccion) {
    System.out.println("Informacion de los Puntos de Recoleccion:");
    System.out.println("======================================");
    for (ZonaRecoleccion zona : zonasRecoleccion) {
        System.out.println("Zona " + zona.getNumero() + ": " + zona.getUbicacion());
        System.out.println("Turno Diurno: " + zona.getHorarioDiurno());
        if (!zona.getHorarioNocturno().isEmpty()) {
            System.out.println("Turno Nocturno: " + zona.getHorarioNocturno());
        }
        System.out.println("======================================");
    }

    // Mostrar la información de la zona seleccionada por el usuario
    if (usuarioActual != null && usuarioActual.getZonaRecoleccionSeleccionada() != null) {
        ZonaRecoleccion zonaSeleccionada = usuarioActual.getZonaRecoleccionSeleccionada();
        System.out.println("Zona de Recolección Seleccionada: Zona " + zonaSeleccionada.getNumero() + " - " + zonaSeleccionada.getUbicacion());
        if (!zonaSeleccionada.getHorarioDiurno().isEmpty()) {
            System.out.println("Turno Diurno: " + zonaSeleccionada.getHorarioDiurno());
        }
        if (!zonaSeleccionada.getHorarioNocturno().isEmpty()) {
            System.out.println("Turno Nocturno: " + zonaSeleccionada.getHorarioNocturno());
        }
        System.out.println("======================================");
    }
  } 
    private static void registrarReciclaje() {
        System.out.println("Seleccione el tipo de residuo:");
        System.out.println("1. Papel");
        System.out.println("2. Vidrio");
        System.out.println("3. Plastico");
        System.out.print("Ingrese el número correspondiente al tipo de residuo: ");

        int tipoResiduo = scanner.nextInt();
        scanner.nextLine(); 

        Residuo residuo = null;

        switch (tipoResiduo) {
            case 1:
                residuo = new Papel(0, null); // Inicializar con cantidad y descripción vacías
                break;
            case 2:
                residuo = new Vidrio(0, null);
                break;
            case 3:
                residuo = new Plastico(0, null);
                break;
            default:
                System.out.println("Opción no válida. No se registrará ningún reciclaje.");
                return;
        }

        
        usuarioActual.registrarReciclaje(residuo);
        System.out.println("Reciclaje registrado correctamente.");
    }
}
    

