package org.example;

import java.time.LocalDate;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        //Comparator
        //Compara datos para ordenar una coleccion de datos
        List<String> nombres = Arrays.asList("Juan","Anastasio","Daniel","Luis");
        System.out.println("Lista antes de ordenarse: " + nombres);

        Collections.sort(nombres);

        System.out.println("Lista despues de ordenarse: " + nombres);

        List<Persona> pers = new ArrayList<>();
        pers.add(new Persona(3,"Juan", new GregorianCalendar(2014, Calendar.FEBRUARY, 11).getTime()));
        pers.add(new Persona(2,"Anastasio",new GregorianCalendar(2014, Calendar.APRIL, 01).getTime()));
        pers.add(new Persona(5,"Daniel",new GregorianCalendar(2014, Calendar.NOVEMBER, 30).getTime()));
        pers.add(new Persona(4,"Luis",new GregorianCalendar(2014, Calendar.DECEMBER, 02).getTime()));

        //Se puede usar "sort" por que la clase Persona implementa de Comparable<Persona>
        Collections.sort(pers);
        System.out.println("Lista ordenada: " + pers);

        //Se usa Comparator para odenar por un campo especifico y no solo por String
        Collections.sort(pers, new OrdenarPersonaPorId());
        //System.out.println("Lista ordenadas por Id: " + pers);

        //Aprovechando la interface funcional Comparator se puede usar lambdas
        Collections.sort(pers, (p1,p2)->p1.getIdPersona() - p2.getIdPersona());
        System.out.println("Lista ordenadas por Id: " + pers);

        //Ejercicio
        //Crear una referencia de comparator
        //Ordenar por fecha de nacimiento
        Comparator<Persona> comp = (x,y) -> x.getFechaNacimiento().compareTo(y.getFechaNacimiento());

        Collections.sort(pers,comp);
        System.out.println("Lista ordenadas por fecha: " + pers);

    }
}