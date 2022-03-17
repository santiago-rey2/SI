package es.udc.sistemasinteligentes.g2_18.e2;

import es.udc.sistemasinteligentes.g2_18.*;

public class MainEj2b {
    public static void main(String[] args) throws Exception {
        int matriz[][] = {{4, 9, 2}, {3, 5, 0}, {0, 1, 0}};
        int matriz2[][] = {{2, 0, 0}, {0, 0, 0}, {0, 0, 0}};
        int matriz3[][] = {{2, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 0, 0}, {0, 1, 0, 0}};

        EstadoMagico estadoInicial = new EstadoMagico(matriz2);
        ProblemaBusqueda cuadrado = new ProblemaCuadradoMagico(estadoInicial);
        Heuristica h = new HeuristiscaMagica();
        Nodo[] solucion;
        System.out.println("Solucion Aplicando BusquedaA*:");
        EstrategiaBusquedaInformada buscador = new BusquedaA_Estrella();
        solucion = buscador.soluciona(cuadrado, h);
        BusquedaA_Estrella busqueda = (BusquedaA_Estrella) buscador;
        System.out.println("Solucion : ");
        System.out.println("Nodos expandidos: " + busqueda.getNodosExplorados());
        System.out.println("Nodos Creados: " + busqueda.getNodosCreados());
        for (Nodo n : solucion) {
            System.out.println(n);
        }
    }
}
