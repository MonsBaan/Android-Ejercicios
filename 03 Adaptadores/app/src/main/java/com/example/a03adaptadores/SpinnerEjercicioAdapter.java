package com.example.a03adaptadores;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class SpinnerEjercicioAdapter extends ArrayAdapter {
    private Context context;
    private String[] datos;
    private Alumno alumno;

    public SpinnerEjercicioAdapter(@NonNull Context context, int resource, @NonNull String[] datos) {
        super(context, resource, datos);
        this.datos = datos;
        this.context = context;
    }


    @Override
    public int getCount() {
        return datos.length - 1;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        return getCustomView(position, convertView, parent);
    }

    @Override
    public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        return getCustomView(position, convertView, parent);
    }

    public View getCustomView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = ((Activity) context).getLayoutInflater();
        View fila = inflater.inflate(R.layout.spinner_ejercicio1, parent, false);
        TextView textoFilaNombre = fila.findViewById(R.id.tvNombre);
        TextView textoFilaApellidos = fila.findViewById(R.id.tvApellidos);

        if (position == 0) {
            textoFilaNombre.setText("Escoge una Opcion:");
            textoFilaApellidos.setText("");
        } else {
            //textoFilaNombre.setText(alumno.getAlumno(datos, position -1));
            //textoFilaApellidos.setText(alumno.getApellido(datos, position -1));






            /*
            Metodo Toloko
            String alumno = "";
            String[] alumnoSplit = null;
            String nombre = "";
            String apellido = "";
            Boolean isSplit = false;

            alumno = datos[position - 1];

            alumnoSplit = alumno.split(" ");

            textoFilaNombre.setText(alumnoSplit[0]);
            textoFilaApellidos.setText(alumnoSplit[1]);*/
        }
        return fila;
    }
}
