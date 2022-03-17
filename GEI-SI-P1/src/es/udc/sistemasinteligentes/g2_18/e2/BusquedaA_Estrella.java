package es.udc.sistemasinteligentes.g2_18.e2;

import es.udc.sistemasinteligentes.g2_18.*;
import java.util.ArrayList;
import java.util.PriorityQueue;

public class BusquedaA_Estrella implements EstrategiaBusquedaInformada {
    private int nodoscreados;
    private int nodosexplorados;
    @Override
    public Nodo[] soluciona(ProblemaBusqueda p, Heuristica h) throws Exception {
        nodoscreados = 0;
        nodosexplorados = 0;
        ArrayList<Nodo> explorados = new ArrayList<>();
        ArrayList<Nodo> sucesores;
        ComparadorNodos comparador = new ComparadorNodos();
        PriorityQueue<Nodo> frontera = new PriorityQueue<>(1,comparador);
        Nodo nodoactual = new Nodo(p.getEstadoInicial(),null,null,h.evalua(p.getEstadoInicial()),0);
        frontera.add(nodoactual);
        nodoscreados++;
        int i = 0;
        while(!p.esMeta(nodoactual.getEs())){
            if(frontera.isEmpty()) throw new Exception("Lista de Frontera Vacía");
            nodoactual = frontera.poll();
            nodosexplorados++;
            explorados.add(nodoactual);
            sucesores = sucesores(nodoactual,p,h);
            for (Nodo n: sucesores) {
                n.setCoste(n.getCoste() + nodoactual.getCoste());
                n.setFunction(n.getCoste()+h.evalua(n.getEs()));
                if(!explorados.contains(n)){
                    if(!frontera.contains(n)){
                        frontera.add(n);
                    }else{
                        while(frontera.iterator().hasNext()){
                            Nodo aux = frontera.iterator().next();
                            if(aux.equals(n)){
                                frontera.iterator().remove();
                                frontera.add(n);
                                break;
                            }
                        }
                    }
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

    private ArrayList<Nodo> sucesores(Nodo n, ProblemaBusqueda p,Heuristica h) throws Exception {
        ArrayList<Nodo> sucesores = new ArrayList<>();
        Accion[] acciones = p.acciones(n.getEs());
        Estado es;
        for(Accion acc: acciones){
            es = p.result(n.getEs(),acc);
            Nodo nuevo = new Nodo(es,acc,n,h.evalua(es),0);
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
