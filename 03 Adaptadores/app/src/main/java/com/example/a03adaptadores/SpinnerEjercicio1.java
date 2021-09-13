package com.example.a03adaptadores;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Spinner;

public class SpinnerEjercicio1 extends AppCompatActivity {
    private Spinner sp;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner_ejercicio1);

        sp = findViewById(R.id.spAlumnos);
        String [] datos = getResources().getStringArray(R.array.alumnos);

        SpinnerEjercicioAdapter adapter = new SpinnerEjercicioAdapter(this, R.layout.spinner_ejercicio1, datos);

        sp.setAdapter(adapter);
    }
}