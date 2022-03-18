package es.udc.sistemasinteligentes.g2_18.e2;

import es.udc.sistemasinteligentes.g2_18.Nodo;
import java.util.Comparator;

/**
 * Clase comparator utilizada para indicar a la cola de prioridad de la busqueda A_estrella
 * como ordenar los nodos en la misma
 * */
public class ComparadorNodos implements Comparator<Nodo> {
    /*
    * En este caso los nodos los ordemos segun la funcion de coste de los mismos
    * */
    @Override
    public int compare(Nodo o1, Nodo o2) {
        if(o1.getF() < o2.getF())
            return 1;
        if(o1.getF() > o2.getF())
            return -1;
        return 0;
    }
}
