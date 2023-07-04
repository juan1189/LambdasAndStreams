package org.example;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class Main {
    public static void main(String[] args) {

        //Consumer: Hace algo con el unico valor de entrada
        Consumer<String> cons = x -> System.out.println(x.toUpperCase());
        cons.accept("Hola");

        //Consumer.accept: Imprimer el estudiante y aumentar 10% la calificacion
        List<Estudiante> listaEstudiantes= Arrays.asList(
                new Estudiante("Juan",15),
                new Estudiante("Juan2",05),
                new Estudiante("Juan3",12),
                new Estudiante("Juan4",8),
                new Estudiante("Juan5",19),
                new Estudiante("Juan6",20),
                new Estudiante("Juan7",11),
                new Estudiante("Juan8",15),
                new Estudiante("Juan10",15));

        System.out.println("Estudiantes sin calificacion actualizado");
        Consumer<Estudiante> consImprime = x -> System.out.println("Nombre: " + x.getNombre() + " - Calificacion: " + x.getCalificacion());
       // aceptaTodos(listaEstudiantes,consImprime);
        System.out.println("Estudiantes con calificacion actualizado");
        Consumer<Estudiante> consCalcula = x -> x.setCalificacion(x.getCalificacion()*1.1);
        //aceptaTodos(listaEstudiantes,consCalcula);
        //aceptaTodos(listaEstudiantes,consImprime);

        //Consumer.andThen: Se usa para combinar 2 interfaces Consumer
        System.out.println("Ejemplo combinando Consumer");
        Consumer<Estudiante> consumerCombi = consCalcula.andThen(consImprime);
        aceptaTodos(listaEstudiantes,consumerCombi);
    }

    public static void aceptaTodos(List<Estudiante> listEst, Consumer<Estudiante> cons){

        for (Estudiante est : listEst) {
            cons.accept(est);
        }

    }
}