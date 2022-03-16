package es.udc.sistemasinteligentes.e2;

import es.udc.sistemasinteligentes.Accion;
import es.udc.sistemasinteligentes.EstrategiaBusqueda;
import es.udc.sistemasinteligentes.Nodo;
import es.udc.sistemasinteligentes.ProblemaBusqueda;

import java.util.*;

public class BusquedaAnchura implements EstrategiaBusqueda {

    @Override
    public Nodo[] soluciona(ProblemaBusqueda p) throws Exception {
        ArrayList<Nodo> explorados = new ArrayList<>();
        ArrayList<Nodo> sucesores;
        Queue<Nodo> frontera = new LinkedList<>();
        Nodo nodoactual = new Nodo(p.getEstadoInicial(),null,null);
        frontera.add(nodoactual);
        int i = 0;
        while(!p.esMeta(nodoactual.getEs())){

           // System.out.println((i++) + " - Nodo Actual :  " + nodoactual);
            if(frontera.isEmpty()) throw new Exception("Lista de Frontera Vacía");
           // System.out.println((i++)+"Frontera " + frontera);
            nodoactual = frontera.poll();
            explorados.add(nodoactual);
            sucesores = sucesores(nodoactual,p);
            //System.out.println("Sucesores : " + sucesores);
            for (Nodo n: sucesores) {
                if(!explorados.contains(n) && !frontera.contains(n) ){
                    frontera.add(n);
                }
            }
        }
        return reconstruye_sol(nodoactual).toArray(new Nodo[0]);
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

    private ArrayList<Nodo> sucesores(Nodo n, ProblemaBusqueda p) throws Exception {
        ArrayList<Nodo> sucesores = new ArrayList<>();
        Accion[] acciones = p.acciones(n.getEs());
        for(Accion acc: acciones){
            Nodo nuevo = new Nodo(p.result(n.getEs(),acc),acc,n);
            //System.out.println("Sucesor : " + nuevo);
            sucesores.add(nuevo);
        }
        return sucesores;
    }
}
