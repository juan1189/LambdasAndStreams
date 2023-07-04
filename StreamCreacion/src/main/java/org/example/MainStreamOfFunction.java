package org.example;

import java.util.Random;
import java.util.stream.Stream;

public class MainStreamOfFunction {
    public static void main(String[] args) {
     //iterate: retorna un Stream secuencial ordenado y infinitio

     //Acumula el valor y los usa en el siguiente bucle para aplicar la funcion "n+1"
        Stream<Long> primerosDiez = Stream.iterate(1L, n -> n + 1)
                .limit(5);
        primerosDiez.forEach(System.out::println);

        System.out.println("Filtrando por numeros pares hasta 10");
        Stream.iterate(1L, n -> n +1)
                .filter(n -> n % 2 == 0)
                .limit(10)
                .forEach(System.out::println);

        System.out.println("Filtrando por numeros pares pero a partir de 100 numeros");
        Stream.iterate(1L, n -> n +1)
                .filter(n -> n % 2 == 0)
                .skip(100) // Los primeros 100 elementos no se considera
                .limit(10)
                .forEach(System.out::println);

        System.out.println("Numeros aleatorios");
        Stream.generate(Math::random)
                .limit(5)
                .forEach(System.out::println);

        System.out.println("Enteros aleatorios");
        new Random().ints() //ints: Genera un Stream
                .limit(5)
                .forEach(System.out::println);
    }
}
