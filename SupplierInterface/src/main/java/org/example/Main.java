package org.example;

import java.util.function.Supplier;

public class Main {
    public static void main(String[] args) {

        //Supplier.get: Es lo contrario de Consumer, este provee objetos o variables
        //no tiene metodos Default,
        //el unico metodo abstracto que maneja es "get" no tiene parametros
        Supplier<String> s = () -> "Hola";
        System.out.println(s.get());
    }
}