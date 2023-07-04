package org.example;

import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class MainStreamOfCollection {

    public static void main(String[] args) {
        IntStream numStream = Arrays.stream(new int[]{1,2,3,4,5,6});//duble[] o long[]
        numStream.forEach(System.out::println);

        Stream<String> nombres = Arrays.stream(new String[]{"Juan","Paola","Luis","Triccy"});
        nombres.forEach(System.out::println);

        System.out.println("Stream apartir de HashSet");
        Set<String> lenguajesSet = new HashSet<>();
        lenguajesSet.add("Java");
        lenguajesSet.add("C#");
        lenguajesSet.add("Phyton");

        Stream<String> lenguajesStream = lenguajesSet.stream();
        lenguajesStream.forEach(System.out::println);

        System.out.println("Stream de estudiando con paralelo");
        List<Estudiante> estudiantes = new ArrayList<>();
        estudiantes.add(new Estudiante("Juan",25,10.0,10.0));
        estudiantes.add(new Estudiante("Juan2",25,10.0,10.0));
        estudiantes.add(new Estudiante("Juan3",25,10.0,10.0));
        estudiantes.add(new Estudiante("Juan4",25,10.0,10.0));

        Stream<Estudiante> estudianteStream = estudiantes.parallelStream();
        estudianteStream.forEach(estudiante -> System.out.println(estudiante.getIdentificacion()));
    }
}
