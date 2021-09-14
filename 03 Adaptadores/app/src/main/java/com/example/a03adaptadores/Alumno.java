package com.example.a03adaptadores;



public class Alumno {
    private String[] alumnoSplit;

    public String getNombre(String alumno) {
        alumnoSplit = alumno.split(" ");

        return alumnoSplit[0];
    }

    public String getApellido(String alumno) {
        alumnoSplit = alumno.split(" ");

        return alumnoSplit[1];
    }

    private String[] split(String alumno) {
        alumnoSplit = alumno.split(" ");
        return alumnoSplit;

    }

}
