package es.udc.sistemasinteligentes.e2;

import es.udc.sistemasinteligentes.Accion;
import es.udc.sistemasinteligentes.Estado;
import es.udc.sistemasinteligentes.ProblemaBusqueda;

public class ProblemaCuadradoMagico extends ProblemaBusqueda {

    public ProblemaCuadradoMagico(EstadoMagico estadoInicial){
        super(estadoInicial);
    }

    @Override
    public boolean esMeta(Estado es) {
        return false;
    }

    @Override
    public Accion[] acciones(Estado es) {
        return new Accion[0];
    }
}
