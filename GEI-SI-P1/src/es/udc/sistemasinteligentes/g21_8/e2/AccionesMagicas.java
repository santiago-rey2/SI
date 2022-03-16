package es.udc.sistemasinteligentes.g21_8.e2;

import es.udc.sistemasinteligentes.g21_8.Accion;
import es.udc.sistemasinteligentes.g21_8.Estado;

public class AccionesMagicas extends Accion {

    private int accion;  // Accion que queremos

    public AccionesMagicas(int accion ) {
        this.accion = accion;
    }

    @Override
    public String toString() {
        return "Add " + accion;
    }

    @Override
    public boolean esAplicable(Estado es) {
        EstadoMagico esMag = (EstadoMagico) es;
        int tamMatriz = esMag.getTamMatriz();
        if(accion <= 0)
            return false;
        if(accion > tamMatriz * tamMatriz)
            return false;
        return esMag.chechEquals(accion);
    }

    @Override
    public Estado aplicaA(Estado es) throws Exception {
        EstadoMagico esMag = (EstadoMagico) es;
        if(esAplicable(es))
            return esMag.addAccion(accion);
        else
            return esMag;
    }
}
