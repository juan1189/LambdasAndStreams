package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;

public class Main {
    public static void main(String[] args) {

        //BiFunction: Ejemplo Basico
        BiFunction<String,String,String> bi = (x,y) -> x + y;
        System.out.println(bi.apply("Hola","mundo"));

        //BiFunction: Pasar a funcion implementacion lambda
        String result = calc((x,y)-> ": " + (x*y),2,3);
        System.out.println(result);

        //BiFunction: Retorna la lista de salarios con un incremento a partir de la lista
        //de empleados
        List<Empleado> listaCliente =
                Arrays.asList(new Empleado("Juan",10),
                        new Empleado("Juan2",20),
                        new Empleado("Juan3",30),
                        new Empleado("Juan4",40),
                        new Empleado("Juan5",50),
                        new Empleado("Juan6",60),
                        new Empleado("Juan7",70));
        List<Double> listaSalario = calc((x,y)-> x * (1+y),listaCliente,0.6);
        for (Double nuevoSalario:listaSalario) {
            System.out.println("Salario es: " + nuevoSalario);
        }
    }

    public static String calc(BiFunction<Integer,Integer,String> bi,Integer i1,Integer i2){
        return bi.apply(i1,i2);
    }

    public static List<Double> calc(BiFunction<Double,Double,Double> bi,
                                    List<Empleado> listEmp, Double increm){

        List<Double> salarios = new ArrayList<>();

        for (Empleado emp : listEmp) {
            salarios.add(bi.apply(emp.getSalario(), increm));
        }

        return salarios;
    }
}