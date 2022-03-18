package es.udc.sistemasinteligentes.g2_18.e1;
import es.udc.sistemasinteligentes.g2_18.Accion;
import es.udc.sistemasinteligentes.g2_18.EstrategiaBusqueda;
import es.udc.sistemasinteligentes.g2_18.Nodo;
import es.udc.sistemasinteligentes.g2_18.ProblemaBusqueda;

import java.util.*;

public class EstrategiaBusquedaGrafo implements EstrategiaBusqueda {

    @Override
    public Nodo[] soluciona(ProblemaBusqueda p) throws Exception {
            ArrayList<Nodo> explorados = new ArrayList<>(); // Lista de Nodos usada para guardas solamente aquellos nodos que han sido expandidos
            ArrayList<Nodo> sucesores;  // Lista de nodos usada como apoyo para guardar temporalmente los nodos sucesores a cada nodo explorado
            Queue<Nodo> frontera = new LinkedList<>();  // Nodos a espera de ser explorados Se guardan en una cola ya que Usamos una implementacion de busqueda en anchura
            Nodo nodoactual = new Nodo(p.getEstadoInicial(),null,null,0,0); // Creamos el nodo raíz del problema
            frontera.add(nodoactual); // Añadimos el nodo raíz a la frontera primeramente

            while(!p.esMeta(nodoactual.getEs())){ // Utilizamos condicion de parada encontrar un nodo meta
                if(frontera.isEmpty()) throw new Exception("Lista de Frontera Vacía"); // Si llegamos a Frontera vacía se lanza una excepcion frontera vacía
                nodoactual = frontera.poll(); // Obtenemos el primer nodos de frontera y lo eliminamos de la misma
                explorados.add(nodoactual); // Añadimos el nodo a la lista de explorados
                sucesores = sucesores(nodoactual,p); // Calculamos los sucesores del nodo
                for (Nodo n: sucesores) { // Para cada nodo sucesor comprobamos que se pueda añadir a frontera
                    if(!explorados.contains(n) && !frontera.contains(n) ){ // Para añadir a forntera alguno de los sucesores comprobamos que este nodo no haya sido explorado o este pendiente de serlo
                        frontera.add(n);
                    }
                }
            }
        return reconstruye_sol(nodoactual).toArray(new Nodo[0]); // Finalmente deolvemos un objeto tipo Nodo[] con la solucion final del problema
    }
    /**
     * Devuelve la solcion final de un problema dado partiendo de un nodo n
     * @param n Nodo del recrearemos la solucion
     * @return un arraylist con los nodos correspondientes a la solucion oredenados del meta al inicial
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
    /**
     * Devuelve una lista de nodos que se claculan a partir de un nodo dado n y un problemna p
     * @param n Nodo a partir del cual queremos clacular los que le suceden
     * @param p Problema de busqueda necesario para obtener los nodos sucesores pues aqui tenemos las funciones para calcularlos
     * @return un Arraylist de nodos con los nodos hijos del nodo pasado por parametro
     * */
    private ArrayList<Nodo> sucesores(Nodo n, ProblemaBusqueda p) throws Exception {
        ArrayList<Nodo> sucesores = new ArrayList<>();
        Accion[] acciones = p.acciones(n.getEs()); // Obtenemos la lista de acciones aplicables al nodo
        for(Accion acc: acciones){ // para cada accion calculamos su hijo correspondiente y lo añadimos a la lista
            Nodo nuevo = new Nodo(p.result(n.getEs(),acc),acc,n,0,0);
            sucesores.add(nuevo);
        }
        return sucesores;
    }
}
