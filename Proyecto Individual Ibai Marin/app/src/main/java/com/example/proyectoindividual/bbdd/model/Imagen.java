package com.example.proyectoindividual.bbdd.model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Imagen {
    @PrimaryKey(autoGenerate = true)
    private int id;
    private String tituloImagen, urlImagen;
    private int tipoFoto; //0- Interior  1- Exterior

    public Imagen(String tituloImagen, String urlImagen, int tipoFoto) {
        this.tituloImagen = tituloImagen;
        this.urlImagen = urlImagen;
        this.tipoFoto = tipoFoto;
    }

    public int getTipoFoto() {
        return tipoFoto;
    }

    public void setTipoFoto(int tipoFoto) {
        this.tipoFoto = tipoFoto;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTituloImagen() {
        return tituloImagen;
    }

    public void setTituloImagen(String tituloImagen) {
        this.tituloImagen = tituloImagen;
    }

    public String getUrlImagen() {
        return urlImagen;
    }

    public void setUrlImagen(String urlImagen) {
        this.urlImagen = urlImagen;
    }
}
