package es.udc.sistemasinteligentes.e2;

import es.udc.sistemasinteligentes.Accion;
import es.udc.sistemasinteligentes.Estado;

public class AccionesMagicas extends Accion {

    private int[] acciones = {1,2,3,4,5,6,7,8,9};

    private int accion;

    public AccionesMagicas(int accion ) throws Exception {
        boolean ok = true;
        for (int acc:acciones) {
            if(accion != acc)
                ok = false;
        }
        if(ok){
            this.accion = accion;
        }else {
            throw new Exception("Invalid action");
        }
    }

    @Override
    public String toString() {
        return "Add " + accion;
    }

    @Override
    public boolean esAplicable(Estado es) {
        EstadoMagico esMag = (EstadoMagico) es;
        return esMag.checkAction(accion);
    }

    @Override
    public Estado aplicaA(Estado es) {
        EstadoMagico esMag = (EstadoMagico) es;
        if(esMag.checkAction(accion)){
            
        }

        return null;
    }
}
