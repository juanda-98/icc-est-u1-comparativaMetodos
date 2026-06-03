# Práctica 4 – Ordenamiento de Objetos con Inserción y QuickSort

### Tabla 1. Escenario 1: arreglo completamente desordenado

| Tamaño de muestra | Tiempo Inserción | Tiempo QuickSort | Algoritmo más rápido | Observación |
|:-----------------:|:----------------:|:----------------:|:--------------------:|-------------|
| 10.000 | 1005.945 ms | 12.291 ms | QuickSort | QuickSort fue ~100x más rápido |
| 50.000 | 39959.603 ms | 45.565 ms | QuickSort | La diferencia aumenta drásticamente conel tamaño |
| 100.000 | 177655.765 ms | 128.810 ms | QuickSort | Con 100k, QuickSort fue ~1000x más rápido |

### Tabla 2. Escenario 2: arreglo ordenado más una nueva persona

| Tamaño de muestra | Tiempo Inserción | Tiempo QuickSort | Algoritmo más rápido | Observación |
|:-----------------:|:----------------:|:----------------:|:--------------------:|-------------|
| 10.001 | 0,697 ms | 6.991 ms | Inserción | Inserción fue ~632x más rápida |
| 50.001 | 3.123 ms | 45.623 ms | Inserción | Inserción fue ~15x más rápido que QuickSort |
| 100.001 | 11.373 ms | 143.770 ms | Inserción | Inserción fue ~12x más rápido que QuickSort |

---

## Análisis requerido

**¿Qué algoritmo fue más rápido en el escenario desordenado?**  
QuickSort fue significativamente más rápido en el escenario completamente desordenado en los tres tamaños de muestra. La diferencia se hace cada vez más pronunciada al aumentar el tamaño: para 10.000 elementos QuickSort fue aproximadamente 100 veces más veloz, y para 100.000 elementos la ventaja llegó a ser de casi 1000 veces.

**¿Qué algoritmo fue más rápido en el escenario casi ordenado?**  
Inserción fue mucho más rápido cuando el arreglo ya estaba casi ordenado. Para 10.001 elementos tardó apenas 0,697 ms frente a los 440,820 ms de QuickSort, una diferencia de más de 600 veces. Esto se debe a que Inserción recorre el arreglo casi sin realizar intercambios cuando los datos ya están en orden.

**¿El crecimiento del tamaño de muestra afectó por igual a los dos algoritmos?**  
No. Inserción se ve afectado de forma cuadrática O(n²): al pasar de 10.000 a 100.000 elementos (10x más), su tiempo se multiplicó aproximadamente por 130. QuickSort, con complejidad promedio O(n log n), aumentó su tiempo de forma mucho más moderada al pasar de 10.000 a 100.000 elementos, siendo mucho menos sensible al crecimiento del tamaño.

**¿Por qué Inserción puede mejorar cuando el arreglo ya está casi ordenado?**  
El algoritmo de Inserción tiene un mejor caso de O(n) cuando el arreglo está ordenado o casi ordenado. En ese caso, el bucle interno casi nunca ejecuta intercambios, ya que cada elemento nuevo ya se encuentra en su posición correcta o muy cerca de ella. Al agregar solo una persona al final de un arreglo ordenado, Inserción simplemente la desplaza hasta su lugar sin afectar el resto.

**¿Por qué QuickSort suele ser mejor cuando los datos están muy desordenados?**  
QuickSort divide el arreglo en particiones de forma recursiva mediante un pivote, logrando una complejidad promedio de O(n log n) independientemente del estado inicial de los datos. Al estar desordenado el arreglo, el pivote tiende a dividir las particiones de forma más equilibrada, lo que maximiza la eficiencia del algoritmo. En contraste, Inserción debe comparar y mover cada elemento con todos los anteriores, lo que resulta en O(n²) operaciones.

---

## CONCLUSIONES

- **Conclusión 1:** QuickSort es claramente superior para ordenar arreglos grandes completamente desordenados. Los resultados mostraron que para 100.000 elementos tardó 132 ms frente a los 129.853 ms de Inserción, confirmando que su complejidad O(n log n) le da una ventaja práctica enorme en escenarios del mundo real con datos sin orden previo.

- **Conclusión 2:** Inserción supera ampliamente a QuickSort cuando el arreglo está casi ordenado. El resultado de 0,697 ms vs 440,820 ms para 10.001 elementos demuestra que conocer la naturaleza de los datos antes de elegir un algoritmo es fundamental; Inserción puede ser la mejor opción cuando se sabe que los datos ya tienen un orden previo.

- **Conclusión 3:** El crecimiento del tiempo de ejecución de Inserción es mucho más agresivo que el de QuickSort al aumentar el tamaño de la muestra. Mientras QuickSort escala de manera controlada, Inserción se vuelve impráctica para volúmenes grandes de datos desordenados, lo que confirma que la elección del algoritmo debe considerar tanto el tamaño de la entrada como su estado inicial.

---