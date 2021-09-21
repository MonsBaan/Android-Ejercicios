package com.example.a06ejerciciobbdd.model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Personaje {
    @PrimaryKey(autoGenerate = true)
    private int id;
    private String nombre, url;

    public Personaje(String nombre, String url) {
        this.nombre = nombre;
        this.url = url;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
