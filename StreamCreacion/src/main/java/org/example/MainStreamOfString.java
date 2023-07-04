package org.example;

import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.stream.IntStream;

public class MainStreamOfString {
    public static void main(String[] args) {
        //CharSequence.chars: Retorna un Strem de numeros enteros
        Scanner sc = new Scanner(System.in);
        String entrada= sc.nextLine();

        //Convierte a char lo ingresado por el teclado
        IntStream streamChars = entrada.chars();
        //streamChars.forEach(System.out::println);

        //Quita los espacios en blanco y todos los digitos numericos
        streamChars.filter(n-> !Character.isDigit((char)n)
                            && !Character.isWhitespace((char)n))
                .forEach(n -> System.out.print((char)n));

        System.out.println("\nUso de SplitAsStream");
        String str = "HTML, CSS, Javascript, Java";
        Pattern.compile(", ")
                .splitAsStream(str)
                .forEach(System.out::println);
    }
}
