package com.example.navigationdrawer;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Alumnado implements Serializable {
    private List<Alumno> alumnado = new ArrayList<>();

    public Alumnado() {
        rellenarAlumnos();
    }

    public Alumnado(List<Alumno> alumnado) {
        this.alumnado = alumnado;
    }

    public List<Alumno> getAlumnado() {
        return alumnado;
    }

    public void setAlumnado(List<Alumno> alumnado) {
        this.alumnado = alumnado;
    }

    public void rellenarAlumnos(){
        this.alumnado.add(new Alumno("Arnold", "Schwarzenagger", "Goikoetxea"));
        this.alumnado.add(new Alumno("Ibai", "Marin", "Muñoz"));
        this.alumnado.add(new Alumno("Aitor", "Sobera", "Sobera"));
        this.alumnado.add(new Alumno("Christian", "Rojas", "Blancas"));
    }
}
