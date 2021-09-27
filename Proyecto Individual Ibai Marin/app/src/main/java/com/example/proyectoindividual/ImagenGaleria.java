package com.example.proyectoindividual;

public class ImagenGaleria {
    //IBAI: Bastante directo. Es una clase para guardar las imagenes de la galeria y luego meterlo en un arraylist

    private String urlImagen;
    private String textoGaleria;

    public ImagenGaleria(String urlImagen, String textoGaleria) {
        this.urlImagen = urlImagen;
        this.textoGaleria = textoGaleria;
    }

    public String getUrlImagen() {
        return urlImagen;
    }

    public void setUrlImagen(String urlImagen) {
        this.urlImagen = urlImagen;
    }

    public String getTextoGaleria() {
        return textoGaleria;
    }

    public void setTextoGaleria(String textoGaleria) {
        this.textoGaleria = textoGaleria;
    }
}
