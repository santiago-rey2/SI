package es.udc.sistemasinteligentes.practica;

import es.udc.sistemasinteligentes.EstrategiaBusqueda;
import es.udc.sistemasinteligentes.Nodo;
import es.udc.sistemasinteligentes.ProblemaBusqueda;
import es.udc.sistemasinteligentes.ejemplo.ProblemaAspiradora;

public class MainEj1 {

    public static void main(String[] args) throws Exception {
        ProblemaAspiradora.EstadoAspiradora estadoInicial = new ProblemaAspiradora.EstadoAspiradora(ProblemaAspiradora.EstadoAspiradora.PosicionRobot.IZQ,
                                                                                                    ProblemaAspiradora.EstadoAspiradora.PosicionBasura.AMBAS);
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
