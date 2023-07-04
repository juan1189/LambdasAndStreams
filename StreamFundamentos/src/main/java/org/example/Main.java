package org.example;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {

        //Iteracion externa
        List<Integer> numeros = Arrays.asList(1,2,3,4,5);
        int suma = 0;

        for (int num : numeros) {
            if (num % 2 == 1) {
                int cuadrado = num *num;
                suma = suma + cuadrado;
            }
        }

        System.out.println("Resulta con iteracion externa es: " + suma);

        //Iteracion externa
        //parallelStream() -> procesamiento multinucleo
        int suma2 = numeros.parallelStream() //Operacion del Stream pipeline
                .filter(n -> n % 2 == 1) // Operacion intermedia
                .map(n -> n * n) // Operacion intermedia
                .reduce(0,Integer::sum); // Operacion terminal

        System.out.println("Resulta con iteracion interna es: " + suma);

        //STREAM PIPELINE
        //1. Es un canalizador de flujo
        //2. Comienza con un origen de datos
        //3. Realiza una o mas operaciones intermedias
        //3.1. Procesa los elementos y genera otro Stream
        //3.2. Son Peresozas, Se ejecutan luego de invocar a una operacion terminal.
        //4. Finaliza con una operacion terminal
        //5. Se forma mediantes encadenamiento de llamdas a metodos.

        //Algunas operaciones intermedias:
        //filter: Produce un stream que contiene solo elementos que satisfacen una condicion
        //distinct: Produce un stream que contiene solo elementos unicos
        //limit: Produce un stream con el numero especificado de elementos a partir del inicial del stream original.
        //map: Produce un stream en el que cada elemento del stream original esta asociado a un nuevo valor.
        //sorted: Produce un stream en el que los elementos estan ordenados.

        //OPERACIONES TERMINALES
        //No produce Stream, solo resultados

        //forEach: Recorre los elementos de un Stream
        //Average: Calcula el promedio de los elementos de Stream numerico
        //Count: Devuelve el numero de elementos en el Stream
        //Max: Localiza el mayor valor de un Stream numerico
        //Min: Localiza el menor valor de un Stream numerico
        //reduce: Reduce los elementos de una coleccion a un solo valor o los acumula
        //collect: Crea una coleccion de elementos que contiene los resultados de las operaciones anteriores del Stream.
        //toArray: Crea un arreglo que contiene los resultados
        //findFirst: Encuentra el primer elemento del Stream
        //finAny: Encuentra cualquier elemento del stream
        //anyMatch: Determina si alguno de los elementos del Stream coincide con alguna condicion especificada.
        //allMatch: Determina si todos los elementos en el Stream coinciden con una condicion especificada.

        List<Integer> numeros2 = Arrays.asList(1,2,3,4,5);

        Stream<Integer> numStream = numeros2.stream();

        int suma3 = numStream
                .filter(n -> n % 2 == 1) // {1,2,3}
                .map(n -> n * n) // {1, 4, 9}
               // .reduce(0, (n1,n2)-> n1+n2);
                .reduce(0,Integer::sum);

        System.out.println("La suma de los numeros impares es:" + suma3);

    }
}