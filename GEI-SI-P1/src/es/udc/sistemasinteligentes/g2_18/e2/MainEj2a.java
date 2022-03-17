package es.udc.sistemasinteligentes.g2_18.e2;

import es.udc.sistemasinteligentes.g2_18.EstrategiaBusqueda;
import es.udc.sistemasinteligentes.g2_18.Nodo;
import es.udc.sistemasinteligentes.g2_18.ProblemaBusqueda;

public class MainEj2a {
    public static void main(String[] args) throws Exception {
        int matriz[][] = {{4,9,2},{3,5,0},{0,1,0}};
        int matriz2[][] = {{2,0,0},{0,0,0},{0,0,0}};
        int matriz3[][] = {{2,0,0,0},{0,0,0,0},{0,0,0,0},{0,1,0,0}};

       EstadoMagico estadoInicial  = new EstadoMagico(matriz);
        ProblemaBusqueda cuadrado = new ProblemaCuadradoMagico(estadoInicial);
        Nodo[] solucion;
        System.out.println("Solucion Aplicando BusquedaAnchura:");
        EstrategiaBusqueda buscador = new BusquedaAnchura();
        solucion = buscador.soluciona(cuadrado);
        BusquedaAnchura busqueda = (BusquedaAnchura) buscador;
        System.out.println("Solucion : ");
        System.out.println("Nodos Explorados: "+ busqueda.getNodosExplorados());
        System.out.println("Nodos Creados: "+ busqueda.getNodosCreados() );
        for (Nodo n: solucion) {
            System.out.println(n);
        }

        System.out.println("\nSolucion Aplicando BusquedaProfundiad:");
        buscador = new BusquedaGrafoProfundidad();
        solucion = buscador.soluciona(cuadrado);
        BusquedaGrafoProfundidad busqueda2 = (BusquedaGrafoProfundidad) buscador;
        System.out.println("Solucion : ");
        System.out.println("Nodos Explorados: "+ busqueda2.getNodosExplorados());
        System.out.println("Nodos Creados: "+ busqueda2.getNodosCreados() );
        for (Nodo n: solucion) {
            System.out.println(n);
        }


        EstadoMagico estadoInicial2  = new EstadoMagico(matriz2);
        ProblemaBusqueda cuadrado2 = new ProblemaCuadradoMagico(estadoInicial2);
//        System.out.println("\nSolucion cuadrado 2 Aplicando BusquedaAnchura: \n");
//        buscador = new BusquedaAnchura();
//        solucion = buscador.soluciona(cuadrado2);
//        System.out.println("Solucion : ");
//        busqueda = (BusquedaAnchura) buscador;
//        System.out.println("Nodos Explorados: "+ busqueda.getNodosExplorados());
//        System.out.println("Nodos Creados: "+ busqueda.getNodosCreados() );
//        for (Nodo n: solucion) {
//            System.out.println(n);
//        }

        System.out.println("\nSolucion cuadrad 2 Aplicando BusquedaProfundiad:");
        buscador = new BusquedaGrafoProfundidad();
        solucion = buscador.soluciona(cuadrado2);
        busqueda2 = (BusquedaGrafoProfundidad) buscador;
        System.out.println("Nodos Explorados: "+ busqueda2.getNodosExplorados());
        System.out.println("Nodos Creados: "+ busqueda2.getNodosCreados() );
        System.out.println("Solucion : ");
        for (Nodo n: solucion) {
            System.out.println(n);
        }


    }
}
