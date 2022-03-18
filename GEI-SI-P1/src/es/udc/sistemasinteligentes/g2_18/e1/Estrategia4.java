package es.udc.sistemasinteligentes.g2_18.e1;

import es.udc.sistemasinteligentes.g2_18.Accion;
import es.udc.sistemasinteligentes.g2_18.EstrategiaBusqueda;
import es.udc.sistemasinteligentes.g2_18.Nodo;
import es.udc.sistemasinteligentes.g2_18.ProblemaBusqueda;

import java.util.ArrayList;

public class Estrategia4 implements EstrategiaBusqueda {

    public Estrategia4() {
    }

    @Override
    public Nodo[] soluciona(ProblemaBusqueda p) throws Exception{
        ArrayList<Nodo> nodos = new ArrayList<>();  // Declaramos un arraylist de Nodos
        Nodo nodoactual = new Nodo(p.getEstadoInicial(),null,null,0,0); // Creamos el nodo inicial
        nodos.add(nodoactual); //Añadimos el nodo a la lista

        int i = 1;
        System.out.println((i++) + " - Empezando búsqueda en " + nodoactual.getEs());

        while (!p.esMeta(nodoactual.getEs())){ // comprobamos que el nodo no sea  meta
            System.out.println((i++) + " - " + nodoactual.getEs() + " no es meta");
            Accion[] accionesDisponibles = p.acciones(nodoactual.getEs()); // Obtenemos la lista de acciones aplicables al estado correspondiente
            boolean modificado = false;
            for (Accion acc: accionesDisponibles) {
                Nodo nsc =  new Nodo( p.result(nodoactual.getEs(), acc),acc,nodoactual,0,0);// Creamos un nodo nuevo para cada accion aplicada
                System.out.println((i++) + " - RESULT( " + nodoactual.getEs() + ","+ acc + " )=" + nsc.getEs());
                if (!nodos.contains(nsc)) {
                    nodoactual = nsc;
                    System.out.println((i++) + " - " + nsc.getEs() + " NO explorado");
                    nodos.add(nodoactual); // añadimos el nodo a la lista de nodos
                    modificado = true;
                    System.out.println((i++) + " - Estado actual cambiado a " + nodoactual.getEs());
                    break;
                }
                else
                  System.out.println((i++) + " - " + nsc.getEs() + " ya explorado");
            }
            if (!modificado) throw new Exception("No se ha podido encontrar una solución");
        }
        System.out.println((i++) + " - FIN - " + nodoactual.getEs());
        return  reconstruye_sol(nodoactual).toArray(new Nodo[0]);
    }

    /**
     * Obtiene el camino de solucion real a partir de un nodo meta n
     * @param n Nodo desde el que partimos a reconstruir la solucion
     * @return Un arraylist con los nodos pertenecientes al camino solucion
    * */
    private ArrayList<Nodo> reconstruye_sol(Nodo n) {
        ArrayList<Nodo>  solucion = new ArrayList<>();
        Nodo actual = n;
        while(actual.getFha() != null){
            solucion.add(actual);
            actual = actual.getFha();
        }
        return  solucion;
    }
}
