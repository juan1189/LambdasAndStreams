package org.lambda;

public class Cliente {

    String nombre;
    double monto_pedido;
    int nro_mesa;

    public Cliente(String nombre, double monto_pedido, int nro_mesa) {
        this.nombre = nombre;
        this.monto_pedido = monto_pedido;
        this.nro_mesa = nro_mesa;
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getMonto_pedido() {
        return monto_pedido;
    }

    public void setMonto_pedido(double monto_pedido) {
        this.monto_pedido = monto_pedido;
    }

    public int getNro_mesa() {
        return nro_mesa;
    }

    public void setNro_mesa(int nro_mesa) {
        this.nro_mesa = nro_mesa;
    }
}
