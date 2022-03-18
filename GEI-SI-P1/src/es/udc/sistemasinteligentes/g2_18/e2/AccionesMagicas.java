package es.udc.sistemasinteligentes.g2_18.e2;

import es.udc.sistemasinteligentes.g2_18.Accion;
import es.udc.sistemasinteligentes.g2_18.Estado;

public class AccionesMagicas extends Accion {

    private int accion;  // Accion que queremos

    /**
     * Constructor de la clase
     * @param accion accion que queremos crear  debe de ser un tipo int
     * */
    public AccionesMagicas(int accion ) {
        this.accion = accion;
    }

    @Override
    public String toString() {
        return "Add " + accion;
    }

    /*
    * En este caso como admitimos que una acción es cualquier tipo int la función es aplicable
    * solo devolvera true en caso de que el valor accion se encuentre entre 1 y n ^ 2 siendo n
    * el tamaño de la matriz cuadrada
    * */
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

    /*
    * Devolvemos un estadomagico nuevo aplicandole una accion basicamente
    * llamaremos un metodo propio del estado que nos rellene la matriz interna del mismo
    * con la acción indicada
    * */
    @Override
    public Estado aplicaA(Estado es) throws Exception {
        EstadoMagico esMag = (EstadoMagico) es;
        if(esAplicable(es))
            return esMag.addAccion(accion);
        else
            return esMag;
    }
}
