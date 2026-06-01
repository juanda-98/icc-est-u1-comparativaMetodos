package app;
import java.util.ArrayList;
import java.util.List;

import controles.SortPersonaMethods;
import models.Persona;
import models.Resultado;
import utils.Benchmarking;

public class App {
    public static Persona[] generarPersonas(int cantidad) {
            Persona[] personas = new Persona[cantidad];

            for(int i = 0; i < cantidad; i++) {
                String nombre = "Persona" + (i+1);
                int edad = (int) (Math.random() * 101);
                personas[i] = new Persona(nombre, edad);
            }
            return personas;
        }

        public static void main(String[] args) throws Exception {
        int[] tamanos = {10000, 50000, 100000};
        List<Resultado> resultados = new ArrayList<>();
        SortPersonaMethods sorter = new SortPersonaMethods();

        System.out.println("=== ESCENARIO 1: Arreglo completamente desordenado ===\n");

        for (int size : tamanos) {
            // Copias independientes para cada algoritmo
            Persona[] base = generarPersonas(size);
            Persona[] copiaInsercion = base.clone();
            Persona[] copiaQuickSort = base.clone();

            // Medir Inserción
            Resultado resInsercion = Benchmarking.medirTiempo(
                    () -> { sorter.insertionSort(copiaInsercion); return null; },
                    "Inserción",
                    "Desordenado",
                    size
            );
             resultados.add(resInsercion);
            System.out.println(resInsercion);
    }
}
