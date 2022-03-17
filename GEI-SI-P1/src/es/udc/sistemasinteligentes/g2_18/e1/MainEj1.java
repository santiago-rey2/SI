package es.udc.sistemasinteligentes.g2_18.e1;

import es.udc.sistemasinteligentes.g2_18.EstrategiaBusqueda;
import es.udc.sistemasinteligentes.g2_18.Nodo;
import es.udc.sistemasinteligentes.g2_18.ProblemaBusqueda;
import es.udc.sistemasinteligentes.g2_18.ejemplo.ProblemaAspiradora;

public class MainEj1 {

    public static void main(String[] args) throws Exception {
        es.udc.sistemasinteligentes.g2_18.ejemplo.ProblemaAspiradora.EstadoAspiradora estadoInicial = new es.udc.sistemasinteligentes.g2_18.ejemplo.ProblemaAspiradora.EstadoAspiradora(es.udc.sistemasinteligentes.g2_18.ejemplo.ProblemaAspiradora.EstadoAspiradora.PosicionRobot.IZQ,
                                                                                                    es.udc.sistemasinteligentes.g2_18.ejemplo.ProblemaAspiradora.EstadoAspiradora.PosicionBasura.AMBAS);
        ProblemaBusqueda aspiradora = new ProblemaAspiradora(estadoInicial);

        EstrategiaBusqueda buscador = new Estrategia4();
        Nodo[] solucion = buscador.soluciona(aspiradora);
        System.out.println("Solucion Aplicando Estrategia4: \n");
        for (Nodo n: solucion) {
            System.out.println(n);
        }
        System.out.println("\nSolucion Aplicando BusquedaGrafo: \n");
        EstrategiaBusqueda buscador2 = new EstrategiaBusquedaGrafo();
        solucion = buscador2.soluciona(aspiradora);
        for (Nodo n: solucion) {
            System.out.println(n);
        }
    }
}
