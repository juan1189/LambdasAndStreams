package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.UnaryOperator;

public class Main {
    public static void main(String[] args) {

        //UnaryOperator: Hereda de la interface Function
        //Se envia un tipo de dato y devuelve el mismo tipo
        List<Integer> lista = Arrays.asList(10,20,30,40,50,60,70,80,90,100);

        List<Integer> listaAct = operadorUnary(num -> num * 2,lista);
        listaAct.forEach(x-> System.out.println(x));
    }

    public static List<Integer> operadorUnary(UnaryOperator<Integer> unary,
                                              List<Integer> list){
        List<Integer> listaNueva = new ArrayList<>();

        //forEach,
        //param1 -> se envia la interface Consumer para agregar a la lista nueva
        //UnaryOperador -> usa el metodo "apply" para ejecutar la operacion lambda
        list.forEach(num -> listaNueva.add(unary.apply(num)));

        return listaNueva;
    }
}