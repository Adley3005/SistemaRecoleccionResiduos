
package sistemarecoleccionresiduos;

import java.util.ArrayList;

public class ZonaRecoleccion {
    
        
    private int numero;
    private String ubicacion;
    private String horarioDiurno;
    private String horarioNocturno;

    public ZonaRecoleccion(int numero, String ubicacion, String horarioDiurno, String horarioNocturno) {
        this.numero = numero;
        this.ubicacion = ubicacion;
        this.horarioDiurno = horarioDiurno;
        this.horarioNocturno = horarioNocturno;
    }   
    
    public int getNumero() {
        return numero;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public String getHorarioDiurno() {
        return horarioDiurno;
    }

    public String getHorarioNocturno() {
        return horarioNocturno;
    }

}
