package org.example;

public class Persona {
    private String nombre;
    private Integer edad;
    private String correo;

    public Persona(String nombre, Integer edad, String correo) {
        this.nombre = nombre;
        this.edad = edad;
        this.correo = correo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public static int compararPorEdad(Persona a, Persona b){
        return a.getEdad().compareTo(b.getEdad());
    }

    public int compararPorEdad2(Persona per){
        return this.getEdad().compareTo(per.getEdad());
    }
    @Override
    public String toString() {
        return "Persona{" +
                "nombre='" + nombre + '\'' +
                ", edad=" + edad +
                ", correo='" + correo + '\'' +
                '}';
    }
}
