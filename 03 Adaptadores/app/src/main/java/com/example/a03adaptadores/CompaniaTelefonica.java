package com.example.a03adaptadores;

public class CompaniaTelefonica {
    private String nombre = "";
    private int logo = 0;
    private float precio = 0;

    public CompaniaTelefonica(String nombre, int logo, float precio) {
        this.nombre = nombre;
        this.logo = logo;
        this.precio = precio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getLogo() {
        return logo;
    }

    public void setLogo(int logo) {
        this.logo = logo;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }
}
