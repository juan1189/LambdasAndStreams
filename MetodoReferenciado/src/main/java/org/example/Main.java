package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;

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
        //Se esta usando un metodo estatico "compararPorEdad"
        Collections.sort(listPer,(p1,p2)-> Persona.compararPorEdad(p1,p2));

        //El metodo referenciado es equivalente al anterior codigo.
        //Se usa cuando los parametros en la entrada y en la funcion es igual
        //Metodo referenciado a un metodo estatico.
        Collections.sort(listPer,Persona::compararPorEdad);
        listPer.forEach(p -> System.out.println(p));

        //Metodo Referenciado a una instancia, se usa una clase con metodos comparadores
        System.out.println("Uso de Metodo Referenciado a una instancia");
        ProveedorComparaciones comparador = new ProveedorComparaciones();
        //Collections.sort(listPer, (per1, per2) -> comparador.compararPorNombre(per1,per2));
        Collections.sort(listPer, comparador::compararPorNombre);
        listPer.forEach(System.out::println);

        System.out.println("Uso de Metodo Referenciado a una instancia por tipo arbitrario");
        //Collections.sort(listPer, (per1, per2) -> per1.compararPorEdad2(per2));
        Collections.sort(listPer, Persona::compararPorEdad2);
        listPer.forEach(System.out::println);

        System.out.println("Uso de Metodo Referenciado a un constructor");
        List<String> numeros = Arrays.asList("10","10","15","15","25","30","40","6","30");
        //getResultados(numeros,(numeroString) -> new Integer(numeroString));
        getResultados(numeros,Integer::valueOf).forEach(Main::multiplicarPor10); //Integer::valueOf<>Integer::new

    }

    public static List<Integer> getResultados(List<String> datos, Function<String,Integer> func){
        List<Integer> result = new ArrayList<>();
        datos.forEach(strNum -> result.add(func.apply(strNum)));
        return result;
    }

    public static void multiplicarPor10(int numero){
        System.out.println("El nuevo valor de " + numero +" es: " + numero*10);
    }
}