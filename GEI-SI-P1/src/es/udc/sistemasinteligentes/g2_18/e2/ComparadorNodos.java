package es.udc.sistemasinteligentes.g2_18.e2;

import es.udc.sistemasinteligentes.g2_18.Nodo;
import java.util.Comparator;

public class ComparadorNodos implements Comparator<Nodo> {
    @Override
    public int compare(Nodo o1, Nodo o2) {
        if(o1.getF() < o2.getF())
            return 1;
        if(o1.getF() > o2.getF())
            return -1;
        return 0;
    }
}
