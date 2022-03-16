package es.udc.sistemasinteligentes.g21_8.e2;

import es.udc.sistemasinteligentes.g21_8.Accion;
import es.udc.sistemasinteligentes.g21_8.EstrategiaBusqueda;
import es.udc.sistemasinteligentes.g21_8.Nodo;
import es.udc.sistemasinteligentes.g21_8.ProblemaBusqueda;

import java.util.*;

public class BusquedaAnchura implements EstrategiaBusqueda {

    private int nodoscreados;
    private int nodosexplorados;

    @Override
    public Nodo[] soluciona(ProblemaBusqueda p) throws Exception {
        nodoscreados = 0;
        nodosexplorados = 0;
        ArrayList<Nodo> explorados = new ArrayList<>();
        ArrayList<Nodo> sucesores;
        Queue<Nodo> frontera = new LinkedList<>();
        Nodo nodoactual = new Nodo(p.getEstadoInicial(),null,null);
        frontera.add(nodoactual);
        nodoscreados++;
        int i = 0;
        while(!p.esMeta(nodoactual.getEs())){
            if(frontera.isEmpty()) throw new Exception("Lista de Frontera Vacía");
            nodoactual = frontera.poll();
            nodosexplorados++;
            explorados.add(nodoactual);
            sucesores = sucesores(nodoactual,p);
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
            nodoscreados++;
            sucesores.add(nuevo);
        }
        return sucesores;
    }

    public int getNodosCreados() {
        return nodoscreados;
    }

    public int getNodosExplorados() {
        return nodosexplorados;
    }
}
