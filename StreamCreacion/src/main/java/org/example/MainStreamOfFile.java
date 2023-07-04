package org.example;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class MainStreamOfFile {

    public static void main(String[] args) {

//        ClassLoader classLoader = MainStreamOfFile.class.getClassLoader();
//        String urlFile = classLoader.getResource("Parrafo.txt").getPath();

       Path path = Paths.get("./StreamCreacion/src/main/resources/Parrafo.txt");

        try {
            Stream<String> lineas = Files.lines(path);

            lineas.forEach(linea -> {
                System.out.println("Linea...");
                System.out.println(linea);
            });

        }catch (IOException e){
            e.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }

        Path dir = Paths.get("./StreamCreacion");
        System.out.printf("%nEl arbol de archivos para: %s es %n ", dir.toAbsolutePath());

        try {
            Stream<Path> paths = Files.walk(dir);
            paths.forEach(System.out::println);
        }catch (IOException e){
            e.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
