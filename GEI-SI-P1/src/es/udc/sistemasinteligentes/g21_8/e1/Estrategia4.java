package es.udc.sistemasinteligentes.g21_8.e1;

import es.udc.sistemasinteligentes.g21_8.Accion;
import es.udc.sistemasinteligentes.g21_8.EstrategiaBusqueda;
import es.udc.sistemasinteligentes.g21_8.Nodo;
import es.udc.sistemasinteligentes.g21_8.ProblemaBusqueda;

import java.util.ArrayList;

/*Apartado A completado, preguntar sobre la segunda parte ya que lo propuesto esta solucionadio solo palicando
el constructor de Nodo */
public class Estrategia4 implements EstrategiaBusqueda {

    public Estrategia4() {
    }
    @Override
    public Nodo[] soluciona(ProblemaBusqueda p) throws Exception{
        ArrayList<Nodo> nodos = new ArrayList<>();
        Nodo nodoactual = new Nodo(p.getEstadoInicial(),null,null);
        nodos.add(nodoactual);

        int i = 1;
        System.out.println((i++) + " - Empezando búsqueda en " + nodoactual.getEs());

        while (!p.esMeta(nodoactual.getEs())){
            System.out.println((i++) + " - " + nodoactual.getEs() + " no es meta");
            Accion[] accionesDisponibles = p.acciones(nodoactual.getEs());
            boolean modificado = false;
            for (Accion acc: accionesDisponibles) {
                Nodo nsc =  new Nodo( p.result(nodoactual.getEs(), acc),acc,nodoactual);
                System.out.println((i++) + " - RESULT( " + nodoactual.getEs() + ","+ acc + " )=" + nsc.getEs());
                if (!nodos.contains(nsc)) {
                    nodoactual = nsc;
                    System.out.println((i++) + " - " + nsc.getEs() + " NO explorado");
                    nodos.add(nodoactual);
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
