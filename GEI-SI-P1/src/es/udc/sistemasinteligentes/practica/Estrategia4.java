package es.udc.sistemasinteligentes.practica;

import es.udc.sistemasinteligentes.*;
import java.util.ArrayList;

public class Estrategia4 implements EstrategiaBusqueda {

    public Estrategia4() {
    }

    @Override
    public  Estado soluciona(ProblemaBusqueda p) throws Exception{
        ArrayList<Nodo> explorados = new ArrayList<Nodo>();
        Estado estadoActual = p.getEstadoInicial();
        Nodo nodoActual = new Nodo(estadoActual,null,null);
        explorados.add(nodoActual);

        int i = 1;

        System.out.println((i++) + " - Empezando búsqueda en " + estadoActual);

        while (!p.esMeta(estadoActual)){
            System.out.println((i++) + " - " + estadoActual + " no es meta");
            Accion[] accionesDisponibles = p.acciones(estadoActual);
            boolean modificado = false;
            for (Accion acc: accionesDisponibles) {
                Estado sc = p.result(estadoActual, acc);
                Nodo nc = new Nodo(sc,acc,nodoActual);
                System.out.println((i++) + " - RESULT(" + estadoActual + ","+ acc + ")=" + sc);
                if (!explorados.contains(nc.getEs())) {
                    estadoActual = sc;
                    System.out.println((i++) + " - " + sc + " NO explorado");
                    explorados.add(nodoActual);
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
        return explorados.get(0).getEs();
    }
}
