package org.example;

public class Estudiante {

    private String identificacion;
    private int edad;
    private double estatura;
    private double promedio;

    public Estudiante(String identificacion, int edad, double estatura, double promedio) {
        this.identificacion = identificacion;
        this.edad = edad;
        this.estatura = estatura;
        this.promedio = promedio;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public double getEstatura() {
        return estatura;
    }

    public void setEstatura(double estatura) {
        this.estatura = estatura;
    }

    public double getPromedio() {
        return promedio;
    }

    public void setPromedio(double promedio) {
        this.promedio = promedio;
    }

    @Override
    public String toString() {
        return "Estudiante{" +
                "identificacion='" + identificacion + '\'' +
                ", edad=" + edad +
                ", estatura=" + estatura +
                ", promedio=" + promedio +
                '}';
    }
}
