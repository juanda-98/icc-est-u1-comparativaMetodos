package app;

import controles.SortPersonaMethods;
import models.Persona;

public class App {
    // Genera un arreglo de personas con nombres y edades aleatorias
    public static Persona[] generarPersonas(int cantidad) {
        Persona[] personas = new Persona[cantidad];
        for (int i = 0; i < cantidad; i++) {
            String nombre = "Persona " + (i + 1);
            int edad = (int) (Math.random() * 101);
            personas[i] = new Persona(nombre, edad);
        }
        return personas;
    }
 
    public static void main(String[] args) {
 
        SortPersonaMethods sorter = new SortPersonaMethods();
 
        // ══════════════════════════════════════════════
        // ESCENARIO 1: arreglo completamente desordenado
        // ══════════════════════════════════════════════
 
        int[] tamanos = {10000, 50000, 100000};
 
        for (int i = 0; i < tamanos.length; i++) {
            int size = tamanos[i];
 
            // Generar arreglo base desordenado
            Persona[] base = generarPersonas(size);
 
            // Crear copias independientes para cada algoritmo
            Persona[] copiaInsercion = base.clone();
            Persona[] copiaQuickSort = base.clone();
 
            // Medir Inserción
            long inicio1 = System.nanoTime();
            sorter.insertionSort(copiaInsercion);
            long fin1 = System.nanoTime();
            double tiempoInsercion = (fin1 - inicio1) / 1_000_000.0;
 
            // Medir QuickSort
            long inicio2 = System.nanoTime();
            sorter.quickSort(copiaQuickSort, 0, copiaQuickSort.length - 1);
            long fin2 = System.nanoTime();
            double tiempoQuickSort = (fin2 - inicio2) / 1_000_000.0;
 
            // Imprimir resultados
            System.out.printf("Desordenado | Inserción | %d | %.3f ms%n", size, tiempoInsercion);
            System.out.printf("Desordenado | QuickSort | %d | %.3f ms%n", size, tiempoQuickSort);
        }
 
        // ══════════════════════════════════════════════════════
        // ESCENARIO 2: arreglo ordenado + 1 nueva persona al final
        // ══════════════════════════════════════════════════════
 
        for (int i = 0; i < tamanos.length; i++) {
            int size = tamanos[i];
 
            // Generar y ordenar el arreglo base
            Persona[] base = generarPersonas(size);
            sorter.quickSort(base, 0, base.length - 1);
 
            // Crear nuevo arreglo con una posición extra
            Persona[] baseConNueva = new Persona[size + 1];
            for (int j = 0; j < size; j++) {
                baseConNueva[j] = base[j];
            }
            // Agregar nueva persona al final
            baseConNueva[size] = new Persona("Persona " + (size + 1), (int)(Math.random() * 101));
 
            // Crear copias independientes para cada algoritmo
            Persona[] copiaInsercion = baseConNueva.clone();
            Persona[] copiaQuickSort = baseConNueva.clone();
            int newSize = size + 1;
 
            // Medir Inserción
            long inicio1 = System.nanoTime();
            sorter.insertionSort(copiaInsercion);
            long fin1 = System.nanoTime();
            double tiempoInsercion = (fin1 - inicio1) / 1_000_000.0;
 
            // Medir QuickSort
            long inicio2 = System.nanoTime();
            sorter.quickSort(copiaQuickSort, 0, copiaQuickSort.length - 1);
            long fin2 = System.nanoTime();
            double tiempoQuickSort = (fin2 - inicio2) / 1_000_000.0;
 
            // Imprimir resultados
            System.out.printf("Casi ordenado + 1 persona | Inserción | %d | %.3f ms%n", newSize, tiempoInsercion);
            System.out.printf("Casi ordenado + 1 persona | QuickSort | %d | %.3f ms%n", newSize, tiempoQuickSort);
        }
    }
}