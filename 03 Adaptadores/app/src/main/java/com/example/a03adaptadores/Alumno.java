package com.example.a03adaptadores;

import android.util.Log;

public class Alumno {
    private String alumno = "";
    private String nombre = null;
    private String apellido = null;
    private int pos = 0;
    private String[] datos = null;
    private String[] alumnoSplit;

    public void getAlumno(String[] datos) {
        Log.d("datos", datos[0]);
    }


    /*public String getNombre(String[] datos, int pos) {
        alumnoSplit = getAlumno(datos, pos);
        return alumnoSplit[0];
    }

    public String getApellido(String[] datos, int pos) {
        alumnoSplit = datos[pos].split(" ");
        return alumnoSplit[1];
    }*/

}
