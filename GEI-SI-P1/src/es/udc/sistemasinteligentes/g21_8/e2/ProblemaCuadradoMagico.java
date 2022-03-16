package es.udc.sistemasinteligentes.g21_8.e2;

import es.udc.sistemasinteligentes.g21_8.Accion;
import es.udc.sistemasinteligentes.g21_8.Estado;
import es.udc.sistemasinteligentes.g21_8.ProblemaBusqueda;

import java.util.ArrayList;

public class ProblemaCuadradoMagico extends ProblemaBusqueda {

    public ProblemaCuadradoMagico(EstadoMagico estadoInicial){
        super(estadoInicial);
    }

    @Override
    public boolean esMeta(Estado es) {
        EstadoMagico esMag = (EstadoMagico) es;
        int tamMatriz = esMag.getTamMatriz();
        int magicNumber = (tamMatriz * (tamMatriz*tamMatriz + 1))/2;

        for (int i = 0; i < tamMatriz; i++) {
             if(esMag.getColSum(i) != magicNumber || esMag.getRowSum(i) != magicNumber )
                 return false;
        }

        if(esMag.getDiagSum() != magicNumber || esMag.getInvDiagSum() != magicNumber)
            return false;
        return true;
    }
    @Override
    public Accion[] acciones(Estado es) {
        ArrayList<Accion> listacciones = new ArrayList<>();
        EstadoMagico esMag  = (EstadoMagico) es;
        int tamMatriz = esMag.getTamMatriz();
        AccionesMagicas action;
        for (int i = 1; i <= tamMatriz* tamMatriz; i++) {
            if(esMag.chechEquals(i)) {
                action = new AccionesMagicas(i);
                listacciones.add(action);
            }
        }
        return listacciones.toArray(new Accion[0]);
    }
}
