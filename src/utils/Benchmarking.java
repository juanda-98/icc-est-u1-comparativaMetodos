package utils;

import java.util.concurrent.Callable;
import models.Resultado;

public class Benchmarking {
    public Resultado medirTiempo(Callable<Void> funcion, String algoritmo,String escenario, int sample){
        
        try{
            long inicio = System.nanoTime();
            funcion.call();
            long fin = System.nanoTime();

            double duracion = (fin - inicio);

            Resultado resultado = new Resultado(algoritmo, escenario, sample, duracion);
            return resultado;
        } catch (Exception e){
            throw new RuntimeException("Error en la funcion");
        }
    }
}
