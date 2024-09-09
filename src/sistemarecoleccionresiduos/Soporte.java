
package sistemarecoleccionresiduos;

import java.util.ArrayList;

public class Soporte  {
   
    
    private String descripcion;

    private static ArrayList<Soporte> listaProblemas = new ArrayList<>();

    public Soporte(String descripcion) {
        this.descripcion = descripcion;
        // Agrega el problema actual a la lista global
        listaProblemas.add(this);
    }

    public String getDescripcion() {
        return descripcion;
    }

    public static ArrayList<Soporte> getListaProblemas() {
        return listaProblemas;
    }
   
 
}

