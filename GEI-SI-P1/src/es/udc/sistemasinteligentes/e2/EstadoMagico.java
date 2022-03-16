package es.udc.sistemasinteligentes.e2;

import es.udc.sistemasinteligentes.Estado;

import java.util.ArrayList;

public class EstadoMagico extends Estado {

    private int matriz[][];  // Matriz Estado
    private  int tamMatriz; // Tamaño de la matriz a partir de aqui podremos generar las acciones del estado

    // Constructor de Estado cada estado corresponde con  una matriz
    // con una distribucion en sus numeros de una forma concreta
    public EstadoMagico(int matrizinicial[][]) throws Exception {
        if(matrizinicial.length != matrizinicial[0].length)
            throw new Exception("Invalid Matrix tipe : Ragged");
        this.matriz = matrizinicial;
        this.tamMatriz = matrizinicial.length;
    }
    // Getter devuelve tamMatriz
    public int getTamMatriz() {
        return tamMatriz;
    }
    // Comprueba que una sea aplicable (No se admiten repetidos en la matriz)
    public boolean chechEquals(int accion){
        for (int i = 0; i < tamMatriz; i++) {
            for (int j = 0; j < tamMatriz; j++) {
                if(matriz[i][j] == accion)
                    return false;
            }
        }
        return  true;
    }
    private int[][] cloneMatrix(int[][] matrix, int tam ){
        int [][] aux  = new int[tam][tam];
         for (int i = 0; i < tam ; i++) {
            for (int j = 0; j < tam ; j++) {
                aux[i][j] = matrix[i][j];
            }
        }
         return aux;
    }
    // Añade un nuevo numero aplicable a la matriz y genera un nuevo estado
    public EstadoMagico addAccion(int accion) throws Exception {
        int aux [][] = cloneMatrix(matriz,tamMatriz);
        for (int i = 0; i < this.tamMatriz; i++) {
            for (int j = 0; j < this.tamMatriz; j++) {
                if(aux[i][j] == 0){
                    aux[i][j] = accion;
                    return new EstadoMagico(aux);
                }
            }
        }
        return new EstadoMagico(aux);
    }
    // Devuelve la suma de la columna pasada por parametro
    public int getColSum(int col){
        int suma = 0;
        for (int i = 0; i <tamMatriz ; i++) {
            suma += matriz[i][col];
        }
        return suma;
    }
    // Devuelve la suma de la fila pasada por parametro
    public int getRowSum(int row){
        int suma = 0;
        for (int i = 0; i <tamMatriz ; i++) {
            suma += matriz[row][i];
        }
        return suma;
    }
    // Devuelve la suma de la diagonal
    public int getDiagSum(){
        int suma = 0;
        for (int i = 0; i <tamMatriz ; i++) {
            suma += matriz[i][i];
        }
        return suma;
    }
    // Devuelve la suma de la diagonal invertida
    public int getInvDiagSum(){
        int suma = 0;
        int j = 0;
        for (int i = tamMatriz-1; i >= 0 ; i--) {
                suma += matriz[i][j];
                j++;
            }
        return suma;
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
