package com.example.actividad18;

// se instancia las variables
public class Producto {
    private String nombreProducto;
    private int precioProducto;



    public Producto(String nombreProducto, int precioProducto) {
        this.nombreProducto = nombreProducto;
        this.precioProducto = precioProducto;

    }
    //contructor por defecto
    public Producto() {
    }

    public static void add(Producto producto) {
    }


    @Override
    public String toString() {
        return "Producto{" +
                "nombreProducto='" + nombreProducto + '\'' +
                ", precioProducto=" + precioProducto +
                '}';
    }

    //getts and setters

    public String getnombreProducto() {
        return nombreProducto;
    }

    public void setnombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public int getPrecioProducto() {
        return precioProducto;
    }

    public void setPrecioProducto(int precioProducto) {
        this.precioProducto = precioProducto;
    }

    public int getPrecioInt ( int precio) {
        return precioProducto;
    }

    public void getnombreProducto(String toString) {
    }
}







