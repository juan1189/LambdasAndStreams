package org.example;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class MainStreamOfValues {
    public static void main(String[] args) {

        System.out.println("Creacion de Stream a partir de valores");
        Stream<String> stream = Stream.of("Usando la funcion of para crear Stream");
        stream.forEach(System.out::println);

        Stream<String> stream2 = Stream.of("Usando","varios","parametros");
        stream2.forEach(System.out::println);

        String[] arreglo = {"Este","es","con","arreglo"};
        Stream<String> stream3 = Stream.of(arreglo);
        stream3.forEach(System.out::println);

        Stream<Estudiante> streamEstudiante = Stream.<Estudiante>builder()
                .add(new Estudiante("n01",17,1.70,9.5))
                .add(new Estudiante("n02",21,1.70,12.5))
                .build();

        streamEstudiante.forEach(System.out::println);

        IntStream unoAVeinte = IntStream.rangeClosed(1,5); // llega de 1 al 5
        unoAVeinte.forEach(System.out::println);

    }
}