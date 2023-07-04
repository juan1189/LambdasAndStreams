package org.example;

import java.util.Date;

public class Persona implements Comparable<Persona>{
    private int idPersona;
    private String nombre;
    private Date fechaNacimiento;

    public Persona(){}
    public Persona(int idPersona, String nombre){
        this.idPersona = idPersona;
        this.nombre = nombre;
    }
    public Persona(int idPersona, String nombre, Date fechaNacimiento) {
        this.idPersona = idPersona;
        this.nombre = nombre;
        this.fechaNacimiento = fechaNacimiento;
    }

    public int getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(int idPersona) {
        this.idPersona = idPersona;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    @Override
    public int compareTo(Persona p) {
        int result = this.nombre.compareTo(p.nombre);
        return result;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "idPersona=" + idPersona +
                ", nombre='" + nombre + '\'' +
                ", fechaNacimiento=" + fechaNacimiento +
                '}';
    }
}
