package org.example;

public class ProveedorComparaciones {

    public int compararPorNombre(Persona a, Persona b){
        return a.getNombre().compareTo(b.getNombre());
    }

    public int compararPorEdad(Persona a, Persona b){
        return a.getEdad().compareTo(b.getEdad());
    }
}
