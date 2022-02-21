package es.udc.sistemasinteligentes.practica;

import es.udc.sistemasinteligentes.*;
import java.util.ArrayList;

public class Estrategia4 implements EstrategiaBusqueda {

    public Estrategia4() {
    }
    @Override
    public ArrayList<Nodo> soluciona(ProblemaBusqueda p) throws Exception{
        ArrayList<Estado> explorados = new ArrayList<Estado>();
        ArrayList<Nodo> nodos = new ArrayList<>();
        Estado estadoActual = p.getEstadoInicial();
        Nodo nodoactual = new Nodo(estadoActual,null,null);
        nodos.add(nodoactual);
        explorados.add(estadoActual);

        int i = 1;

        System.out.println((i++) + " - Empezando búsqueda en " + estadoActual);

        while (!p.esMeta(estadoActual)){
            System.out.println((i++) + " - " + estadoActual + " no es meta");
            Accion[] accionesDisponibles = p.acciones(estadoActual);
            boolean modificado = false;
            for (Accion acc: accionesDisponibles) {
                Estado sc = p.result(estadoActual, acc);
                System.out.println((i++) + " - RESULT(" + estadoActual + ","+ acc + ")=" + sc);
                if (!explorados.contains(sc)) {
                    estadoActual = sc;
                    nodoactual = new Nodo(estadoActual,acc,nodoactual);
                    System.out.println((i++) + " - " + sc + " NO explorado");
                    nodos.add(nodoactual);
                    explorados.add(estadoActual);
                    modificado = true;
                    System.out.println((i++) + " - Estado actual cambiado a " + estadoActual);
                    break;
                }
                else
                    System.out.println((i++) + " - " + sc + " ya explorado");
            }
            if (!modificado) throw new Exception("No se ha podido encontrar una solución");
        }
        System.out.println((i++) + " - FIN - " + estadoActual);

        return nodos;
    }
}
