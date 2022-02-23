package es.udc.sistemasinteligentes.practica;

import es.udc.sistemasinteligentes.*;
import java.util.ArrayList;

/*Apartado A completado, preguntar sobre la segunda parte ya que lo propuesto esta solucionadio solo palicando
el constructor de Nodo */
public class Estrategia4 implements EstrategiaBusqueda {

    public Estrategia4() {
    }
    @Override
    public ArrayList<Nodo> soluciona(ProblemaBusqueda p) throws Exception{
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
        nodos = reconstruye_sol(nodos);
        return nodos;
    }

    private ArrayList<Nodo> reconstruye_sol(ArrayList<Nodo> explorados) throws Exception {
        if(explorados.isEmpty()) throw new Exception("Lista vacia");
        ArrayList<Nodo> solucion = new ArrayList<>();
        Nodo nodo = explorados.get(explorados.size()-1);
        while(nodo.getFha() != null){
            solucion.add(nodo);
            int i=explorados.size()-1;
            while(explorados.get(i) != nodo.getFha()){
                i--;
            }
            nodo = explorados.get(i);
        }
        solucion.add(nodo);
        return  solucion;
    }
}
