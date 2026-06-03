package controles;

import java.util.Random;

import models.Persona;
public class SortPersonaMethods {

    private static final Random random = new Random();
 
    public void insertionSort(Persona[] personas) {
        int n = personas.length;
        for (int i = 1; i < n; i++) {
            Persona clave = personas[i];
            int j = i - 1;
            while (j >= 0 && personas[j].getCriterioOrdenamiento() > clave.getCriterioOrdenamiento()) {
                personas[j + 1] = personas[j];
                j--;
            }
            personas[j + 1] = clave;
        }
    }
 
    public void quickSort(Persona[] personas, int inicio, int fin) {
        if (inicio < fin) {
            int indicePivote = particionar(personas, inicio, fin);
            quickSort(personas, inicio, indicePivote - 1);
            quickSort(personas, indicePivote + 1, fin);
        }
    }
 
    private int particionar(Persona[] personas, int inicio, int fin) {
        // Pivote aleatorio: evita StackOverflow en arreglos casi ordenados
        int indicePivoteAleatorio = inicio + random.nextInt(fin - inicio + 1);
        intercambiar(personas, indicePivoteAleatorio, fin);
 
        Persona pivote = personas[fin];
        int i = inicio - 1;
 
        for (int j = inicio; j < fin; j++) {
            if (personas[j].getCriterioOrdenamiento() <= pivote.getCriterioOrdenamiento()) {
                i++;
                intercambiar(personas, i, j);
            }
        }
 
        intercambiar(personas, i + 1, fin);
        return i + 1;
    }
 
    private void intercambiar(Persona[] personas, int i, int j) {
        Persona aux = personas[i];
        personas[i] = personas[j];
        personas[j] = aux;
    }
}
