package org.example;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.function.BiConsumer;

public class Main {
    public static void main(String[] args) {

        //BiConsumer: Permite 2 entradas
        BiConsumer<Double,Double> biConsumer =
                (n1,n2) -> {
                System.out.println(n1*n2);
                };
        biConsumer.accept(2.0,4.0);

        Map<String,String> map = new HashMap<String,String>();
        String[][] arreglo = {{"Juan","PER"},{"Javier","IND"},{"Paola","KOR"},{"Rene","COL"}};

        for (int i = 0; i < arreglo.length; i++) {
            map.put(arreglo[i][0],arreglo[i][1]);
        }

        System.out.println("Usando la forma tradicional de imprimir clave y valor de un mapa");

        Iterator<Map.Entry<String,String>> iter = map.entrySet().iterator();
        if(iter != null){
            while (iter.hasNext()){
                Map.Entry<String,String> entry = iter.next();
                System.out.println("Clave: " + entry.getKey() + "\t" + " Valor: " + entry.getValue());
            }
        }
        //BiConsumer: foreach es una funcion default, dentro de esta se invoca al metodo accept de la funcion BiConsumer
        System.out.println("Usando BiConsumer y expresion lambda");
        map.forEach((key,value) -> {System.out.println("Clave: " + key+ "\t" + " Valor: " + value);});

    }
}