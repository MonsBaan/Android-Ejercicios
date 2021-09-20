package com.example.ejerciciofragmentos;

import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;


public class ColoresLista {
    private String nombreColor = "";
    private int color = -1;

    public ColoresLista(String nombreColor, int color) {
        this.nombreColor = nombreColor;
        this.color = color;
    }

    public String getNombreColor() {
        return nombreColor;
    }

    public void setNombreColor(String nombreColor) {
        this.nombreColor = nombreColor;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }
}
