package es.udc.sistemasinteligentes.g2_18.e2;

import es.udc.sistemasinteligentes.g2_18.Estado;
import es.udc.sistemasinteligentes.g2_18.Heuristica;

public class HeuristiscaMagica extends Heuristica {

    //Nuestra formula de heuristica sera ver la cantidad de casillas de
    // la matriz que faltan por ser rellenadas con numeros
    @Override
    public float evalua(Estado e) {
        EstadoMagico esMag = (EstadoMagico) e;
        int matriz[][] = esMag.getMAtrix();
        int tamMatriz = esMag.getTamMatriz();
        float count = 0;
        for (int i = 0; i < tamMatriz; i++) {
            for (int j = 0; j < tamMatriz; j++) {
                if(matriz[i][j] == 0)
                    count++;
            }
        }
        return count;
    }
}
