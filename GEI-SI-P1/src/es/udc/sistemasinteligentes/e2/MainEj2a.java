package es.udc.sistemasinteligentes.e2;

import es.udc.sistemasinteligentes.EstrategiaBusqueda;
import es.udc.sistemasinteligentes.Nodo;
import es.udc.sistemasinteligentes.ProblemaBusqueda;
import es.udc.sistemasinteligentes.e1.Estrategia4;
import es.udc.sistemasinteligentes.e1.EstrategiaBusquedaGrafo;
import es.udc.sistemasinteligentes.ejemplo.ProblemaAspiradora;

public class MainEj2a {
    public static void main(String[] args) throws Exception {
        int matriz[][] = {{4,9,2},{3,5,0},{0,1,0}};
        int matriz2[][] = {{2,0,0},{0,0,0},{0,0,0}};
       EstadoMagico estadoInicial  = new EstadoMagico(matriz);
        ProblemaBusqueda cuadrado = new ProblemaCuadradoMagico(estadoInicial);
        Nodo[] solucion;
        System.out.println("\nSolucion Aplicando BusquedaGrafo: \n");
        EstrategiaBusqueda buscador = new BusquedaGrafoProfundidad();
        solucion = buscador.soluciona(cuadrado);
        System.out.println("Solucion : ");
        for (Nodo n: solucion) {
            System.out.println(n);
        }

//        EstadoMagico estadoInicial2  = new EstadoMagico(matriz2);
//        ProblemaBusqueda cuadrado2 = new ProblemaCuadradoMagico(estadoInicial2);
//        System.out.println("\nSolucion Aplicando BusquedaGrafo: \n");
//        solucion = buscador.soluciona(cuadrado2);
//        System.out.println("Solucion : ");
//        for (Nodo n: solucion) {
//            System.out.println(n);
//        }
    }
}
