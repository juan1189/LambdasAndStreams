package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {

        //Predicate.Test: ejemplo basico de funcion Test
        Predicate<Integer> predicate = valor -> valor > 0;
        System.out.println(predicate.test(12));

        //Predicate.Test: obtener una lista de empleado segun una condicion
        List<Empleado> listaEmpleados = Arrays.asList(
                new Empleado("Juan",25,1500,"Cobranzas"),
                new Empleado("Ernesto",30,2500,"Ventas"),
                new Empleado("Javier",40,1800,"Mostrador"),
                new Empleado("Paola",28,1000,"Ventas"));

        List<Empleado> listTest = evaluar(listaEmpleados,x -> x.getSalario() > 1500);
        for (Empleado e:listTest) {
            System.out.println("Salario es: " + e.getSalario());
        }

        //Predicate.Test: obtener una lista de empleado que inician con "J"
        List<Empleado> listTest2 = evaluar(listaEmpleados,x -> x.getNombre().startsWith("J"));
        for (Empleado e:listTest2) {
            System.out.println("Nombre es: " + e.getNombre());
        }

        //Predicate.Negate.Test: evaluar a los empleados volteando la condicion
        List<Empleado> listTest4 = evaluarAlContrario(listaEmpleados,x -> x.getSalario() > 1500);
        for (Empleado e:listTest4) {
            System.out.println("Salario es: " + e.getSalario());
        }

        //Predicate.Test + BiFunctional:
        //Filtrar por edad y obtener lista de empleados con aumento salarial
        List<Empleado> listTest3 = incrementoSalarios(listaEmpleados,
                (x,y)-> x * (1 + y), x -> x.getEdad()>= 40,0.5);
        for (Empleado e:listTest3) {
            System.out.println("Nombre con aumento: " + e.getNombre() + " y aumento: " + e.getSalario());
        }
    }

    public static List<Empleado> evaluar(List<Empleado> listEmp, Predicate<Empleado> pre){
        List<Empleado> listaNueva = new ArrayList<>();

        for (Empleado emp :listEmp) {
            if(pre.test(emp))
            listaNueva.add(emp);
        }

        return listaNueva;
    }

    public static List<Empleado> evaluarAlContrario(List<Empleado> listEmp, Predicate<Empleado> pre){
        List<Empleado> listaNueva = new ArrayList<>();

        for (Empleado emp :listEmp) {
            if(pre.negate().test(emp))
                listaNueva.add(emp);
        }

        return listaNueva;
    }

    public static List<Empleado>  incrementoSalarios(List<Empleado> listEmp,
                                           BiFunction<Double,Double,Double> bi,
                                           Predicate<Empleado> pre, Double inc){

        List<Empleado> listNueva = new ArrayList<>();

        for (Empleado emp: listEmp) {
            if(pre.test(emp)){
                double nuevoSalario = bi.apply(emp.getSalario(),inc);
                emp.setSalario(nuevoSalario);
                listNueva.add(emp);
            }
        }
        return listNueva;
    }
}