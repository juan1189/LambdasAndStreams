package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiPredicate;

public class Main {
    public static void main(String[] args) {

        //BiPredicate: Ejemplo Basico
        BiPredicate<Integer,Integer> bp = (x,y) -> x < y;
        System.out.println(bp.test(5 , 6));

        //BiPredicate: Empleados mayores a 25 y departamento ventas o mayor a 25 y en mostrador
        List<Empleado> listaEmpleados = Arrays.asList(
                new Empleado("Juan",25,1500,"Cobranzas"),
                new Empleado("Ernesto",30,2500,"Ventas"),
                new Empleado("Javier",40,1800,"Mostrador"),
                new Empleado("Paola",18,1000,"Ventas"));

        //1era forma de resolver
        //List<Empleado> empFiltrados = evaluar(listaEmpleados,
        //      (edad,depart) -> (edad > 25 && (depart.equals("Ventas") || depart.equals("Mostrador"))));

        //2da forma con funcion "or"
        BiPredicate<Integer,String> primerCriterio = (edad,depart) -> edad > 25 && depart.equals("Ventas");
        BiPredicate<Integer,String> segundoCriterio = (edad,depart) -> edad > 25 && depart.equals("Mostrador");

        BiPredicate<Integer,String> criterioTotal = primerCriterio.or(segundoCriterio);
        List<Empleado> empFiltrados = evaluar(listaEmpleados,criterioTotal);

        for (Empleado e:empFiltrados) {
            System.out.println("Nombre: " + e.getNombre());
        }

    }

    public static List<Empleado> evaluar(List<Empleado> listEmp,
                                         BiPredicate<Integer,String> bp){
        List<Empleado> listaNueva = new ArrayList<>();

        for (Empleado emp: listEmp) {
            if(bp.test(emp.getEdad(), emp.getDepartamento())){
                listaNueva.add(emp);
            }
        }
        return listaNueva;
    }
}