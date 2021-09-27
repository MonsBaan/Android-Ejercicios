package com.example.proyectoindividual;

import android.widget.ImageView;
import android.widget.TextView;

public class ImagenGaleria {
    private int imagenGaleria;
    private String textoGaleria;

    public ImagenGaleria(int imagenGaleria, String textoGaleria) {
        this.imagenGaleria = imagenGaleria;
        this.textoGaleria = textoGaleria;
    }

    public int getImagenGaleria() {
        return imagenGaleria;
    }

    public void setImagenGaleria(int imagenGaleria) {
        this.imagenGaleria = imagenGaleria;
    }

    public String getTextoGaleria() {
        return textoGaleria;
    }

    public void setTextoGaleria(String textoGaleria) {
        this.textoGaleria = textoGaleria;
    }
}
