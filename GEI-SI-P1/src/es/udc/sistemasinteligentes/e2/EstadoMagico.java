package es.udc.sistemasinteligentes.e2;

import es.udc.sistemasinteligentes.Estado;

import java.util.ArrayList;

public class EstadoMagico extends Estado {

    private int matriz[][];

    public EstadoMagico(int matrizinicial[][]){
        this.matriz = matrizinicial;
    } // Añadir trow pars rsgged matrix

    public boolean checkAction(int n){
        boolean result = true;
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                if(matriz[i][j] == n){
                    result = false;
                }
            }
        }
        return result;
    }

    @Override
    public String toString() {
        StringBuilder aux = new StringBuilder();
        for (int i = 0; i < matriz.length;i++){
            aux.append("[ ");
            for (int j = 0; j < matriz[i].length; j++) {
                aux.append(matriz[i][j]+" ");
            }
            aux.append("]\n");
        }
        return aux.toString();
    }

    @Override
    public boolean equals(Object obj) {
        boolean equals = true;
        if(this == obj) return true;
        if(obj == null || getClass() != obj.getClass()) return false;

        EstadoMagico that = (EstadoMagico) obj;

        if(matriz.length != that.matriz.length) return false;
        if(matriz[0].length != that.matriz[0].length) return false;

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                if(matriz[i][j] != that.matriz[i][j]) equals = false;
            }
        }
        return equals;
    }

    @Override
    public int hashCode() {
        int result = 31* matriz.hashCode();
        return result;
    }
}
