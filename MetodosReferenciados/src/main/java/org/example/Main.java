package org.example;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        //Se requiere que sea mas legible la funcionalidad que realiza al ordenar
        List<Persona> listPer = Arrays.asList(
                new Persona("Juan",10,"asda@gmail.com"),
                new Persona("Juan2",20,"asda2@gmail.com"),
                new Persona("Juan3",22,"asda3@gmail.com"),
                new Persona("Juan4",30,"asda4@gmail.com"),
                new Persona("Juan5",32,"asda5@gmail.com"),
                new Persona("Juan6",35,"asda6@gmail.com"),
                new Persona("Juan7",17,"asda7@gmail.com"),
                new Persona("Juan8",13,"asda8@gmail.com"),
                new Persona("Juan9",10,"asda9@gmail.com"),
                new Persona("Juan00",20,"asda10@gmail.com"));

        System.out.println("Ordenando por Edad de forma mas entendible");
        //Collections.sort(listPer,(p1,p2)-> p1.getEdad().compareTo(p2.getEdad()));
        //Se esta usando un metodo referenciado "compararPorEdad"
        Collections.sort(listPer,(p1,p2)-> Persona.compararPorEdad(p1,p2));

        //El uso del metodo referencia es equivalente al anterior codigo.
        Collections.sort(listPer,Persona::compararPorEdad);
        listPer.forEach(p -> System.out.println(p));
    }
}