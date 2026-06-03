package app;

import controles.SortPersonaMethods;
import models.Persona;
import models.Resultado;
import utils.Benchmarking;

public class App {
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
        int[] tamanos = {10000, 50000, 100000};
        SortPersonaMethods sorter = new SortPersonaMethods();
 
        // ── ESCENARIO 1: arreglo completamente desordenado ──────────────────
        for (int size : tamanos) {
            Persona[] base           = generarPersonas(size);
            Persona[] copiaInsercion = base.clone();
            Persona[] copiaQuickSort = base.clone();
 
            Resultado resIns = Benchmarking.medirTiempo(
                    () -> { sorter.insertionSort(copiaInsercion); return null; },
                    "Inserción", "Desordenado", size);
 
            Resultado resQS = Benchmarking.medirTiempo(
                    () -> { sorter.quickSort(copiaQuickSort, 0, copiaQuickSort.length - 1); return null; },
                    "QuickSort", "Desordenado", size);
 
            System.out.println(resIns);
            System.out.println(resQS);
        }
 
        // ── ESCENARIO 2: arreglo casi ordenado + 1 nueva persona ────────────
        for (int size : tamanos) {
            Persona[] base = generarPersonas(size);
            sorter.quickSort(base, 0, base.length - 1);   // ordenar base
 
            // nuevo arreglo con una posición extra al final
            Persona[] baseConNueva = new Persona[size + 1];
            System.arraycopy(base, 0, baseConNueva, 0, size);
            baseConNueva[size] = new Persona("Persona " + (size + 1),
                                             (int)(Math.random() * 101));
 
            Persona[] copiaInsercion = baseConNueva.clone();
            Persona[] copiaQuickSort = baseConNueva.clone();
            int newSize = size + 1;
 
            Resultado resIns = Benchmarking.medirTiempo(
                    () -> { sorter.insertionSort(copiaInsercion); return null; },
                    "Inserción", "Casi ordenado + 1 persona", newSize);
 
            Resultado resQS = Benchmarking.medirTiempo(
                    () -> { sorter.quickSort(copiaQuickSort, 0, copiaQuickSort.length - 1); return null; },
                    "QuickSort", "Casi ordenado + 1 persona", newSize);
 
            System.out.println(resIns);
            System.out.println(resQS);
        }
    }
}