package org.example;

import java.util.function.BinaryOperator;

public class Main {
    public static void main(String[] args) {

        //BinaryOperator.apply(Object,Object)
        //Hereda de la interface BiFunction<T,T,T>
        //Metodos estaticos: maxBy y minBy
        BinaryOperator<Integer> bOper = (n1, n2) -> n1 * n2;
        System.out.println(bOper.apply(2,10));

        //Uso del metodo minBy: Verifica quien es el menor
        BinaryOperator<Integer> menor = BinaryOperator.minBy((Integer t1, Integer t2)-> t1.compareTo(t2));
        System.out.println(menor.apply(12,24));

        //Uso del metodo minBy: Verifica quien es el menor
        BinaryOperator<Integer> mayor = BinaryOperator.maxBy((Integer t1, Integer t2)-> t1.compareTo(t2));
        System.out.println(mayor.apply(12,27));
    }
}