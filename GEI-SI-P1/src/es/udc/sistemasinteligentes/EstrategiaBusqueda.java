package es.udc.sistemasinteligentes;

import java.util.ArrayList;

public interface EstrategiaBusqueda {
    /**
     * Soluciona el problema de búsqueda, obteniendo un estado meta o arrojando una Excepcion si no encuentra una
     * @param p Problema a solucionar
     * @return Estado meta obtenido
     */
    //Para que se pueda retornar una lista de nodos simplemente cambiamos la implementacion de Estado a
    //Lista de nodos, obligandonos ya a devolver la lista de nodos
    public abstract Nodo[] soluciona(ProblemaBusqueda p) throws Exception;
}
