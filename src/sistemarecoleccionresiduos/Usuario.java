
package sistemarecoleccionresiduos;

import java.util.*;


public class Usuario {
    
    private String nombreUsuario;
    private String contraseña;
    private String direccion;
    private int edad;
    private List<Residuo> listaReciclajes; 
    private ZonaRecoleccion zonaRecoleccionSeleccionada;

    
    
     public void seleccionarZonaRecoleccion(ZonaRecoleccion zona) {
            zonaRecoleccionSeleccionada = zona;
           if (listaReciclajes == null) {
        listaReciclajes = new ArrayList<>();
    } 
     }    

    public void registrarReciclaje(Residuo residuo) {
    residuo.registrarReciclaje();
    listaReciclajes.add(residuo); // Agrega el residuo a la lista de reciclajes del usuario
    // Acceder a la cantidad total y hacer lo que necesites con ella
    double cantidadTotal = Residuo.getCantidadTotal();
}



       public String obtenerInformacionUsuario() {
        StringBuilder informacion = new StringBuilder();
        informacion.append("Nombre: ").append(nombreUsuario).append("\n");
        informacion.append("Dirección: ").append(direccion).append("\n");
        informacion.append("Edad: ").append(edad).append("\n");
        informacion.append("==============================").append("\n");

        if (zonaRecoleccionSeleccionada != null) {
            informacion.append("Zona de Recolección Seleccionada: Zona ").append(zonaRecoleccionSeleccionada.getNumero()).append(" - ").append(zonaRecoleccionSeleccionada.getUbicacion()).append("\n");

            if (!zonaRecoleccionSeleccionada.getHorarioDiurno().isEmpty()) {
                informacion.append("Turno Diurno: ").append(zonaRecoleccionSeleccionada.getHorarioDiurno()).append("\n");
            }

            if (!zonaRecoleccionSeleccionada.getHorarioNocturno().isEmpty()) {
                informacion.append("Turno Nocturno: ").append(zonaRecoleccionSeleccionada.getHorarioNocturno()).append("\n");
            }
        } else {
            informacion.append("No has seleccionado un punto de recolección.").append("\n");
        }

        informacion.append("==============================").append("\n");
        return informacion.toString();
       }

    public void mostrarInformacionUsuario() {
        System.out.println(obtenerInformacionUsuario());
    }

    public void mostrarInformeReciclajes() {
    System.out.println("Informe de Reciclajes Registrados:");
    System.out.println("===============================");

    if (!listaReciclajes.isEmpty()) {
        for (Residuo residuo : listaReciclajes) {
            System.out.println("Tipo: " + residuo.getTipo());
            System.out.println("Cantidad: " + residuo.getCantidad() + " kg");
            System.out.println("Descripción: " + residuo.getDescripcion());
            System.out.println("--------------------------------");
        }
    } else {
        System.out.println("No has registrado reciclajes.");
    }
}


    public Usuario(String nombreUsuario, String contraseña, String direccion, int edad) {
        this.nombreUsuario = nombreUsuario;
        this.contraseña = contraseña;
        this.direccion = direccion;
        this.edad = edad;
        this.listaReciclajes = new ArrayList<>();
    }

    public ZonaRecoleccion getZonaRecoleccionSeleccionada() {
    return zonaRecoleccionSeleccionada;
}

     public String getNombreUsuario() {
        return nombreUsuario;
    }

    public List<Residuo> getListaReciclajes() {
        return listaReciclajes;
    }

    public boolean validarCredenciales(String nombreUsuario, String contraseña) {
        return this.nombreUsuario.equals(nombreUsuario) && this.contraseña.equals(contraseña);
    }
    
}
