package org.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class Main {
    public static void main(String[] args) {
        //Muestra como se implementa la funcion de forma anonima
        Function<Integer,String> convertidor = new Function<Integer, String>() {
            @Override
            public String apply(Integer integer) {
                return "";
            }
        };

        //Function: te permite pasar un tipo de objeto y retornar otro tipo.
        Function<Integer,String> convertidorLambda = x -> Integer.toString(x);

        System.out.println(convertidorLambda.apply(3).length());
        System.out.println(convertidorLambda.apply(30).length());

        //Function: Obtengo un dato en especifico de un objeto
        Cliente cliente = new Cliente("Juan",25.5,5);
        String nombreComensal = (String)getDatoCliente(cliente, x -> x.getNombre());
        int nroMesa = (int)getDatoCliente(cliente, x -> x.getNro_mesa());
        System.out.println(nombreComensal + " - " + nroMesa);

        //Function: Obtener una lista de datos especificos apartir de otra lista
        List<Cliente> listaCliente =
                Arrays.asList(new Cliente("Juan",10,5),
                        new Cliente("Juan2",20,6),
                        new Cliente("Juan3",30,1),
                        new Cliente("Juan4",40,2),
                        new Cliente("Juan5",50,3),
                        new Cliente("Juan6",60,4),
                        new Cliente("Juan7",70,8));

        List<Object> listaNombres = getDatosClientes(listaCliente,x -> x.getNombre());
        for (Object nombre:listaNombres) {
            System.out.println("Nombre es: " + nombre);
        }

    }

    public static Object getDatoCliente(Cliente cli, Function<Cliente,Object> func){
        return func.apply(cli);
    }

    public static List<Object> getDatosClientes(List<Cliente> listaCli, Function<Cliente,Object> func){
        List<Object> listaDatos = new ArrayList<>();
        for(Cliente cli :listaCli) {
            listaDatos.add(func.apply(cli));
        }
        return listaDatos;
    }
}