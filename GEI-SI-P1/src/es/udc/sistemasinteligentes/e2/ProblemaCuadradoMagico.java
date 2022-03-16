package es.udc.sistemasinteligentes.e2;

import es.udc.sistemasinteligentes.Accion;
import es.udc.sistemasinteligentes.Estado;
import es.udc.sistemasinteligentes.ProblemaBusqueda;

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
        //System.out.println("Vamos a mirar si es meta : "+esMag);
        for (int i = 0; i < tamMatriz; i++) {
            //System.out.println(" Suma columna  " + i + ": "+esMag.getColSum(i));
            //System.out.println(" Suma filas  "+ i + ": "+esMag.getRowSum(i));
             if(esMag.getColSum(i) != magicNumber || esMag.getRowSum(i) != magicNumber )
                 return false;
        }
        //System.out.println(" Suma Diagonal: " + esMag.getDiagSum());
        //System.out.println(" Suma Diagoinal Invertida: " + esMag.getInvDiagSum());

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
        System.out.println(listacciones);
        return listacciones.toArray(new Accion[0]);
    }
}
