package com.example.a03adaptadores;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.Toast;

public class SpinnerEjercicio1 extends AppCompatActivity {
    private Spinner sp;
    private int ver = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner_ejercicio1);

        sp = findViewById(R.id.spAlumnos);
        String[] datos = getResources().getStringArray(R.array.alumnos);

        SpinnerEjercicioAdapter adapter = new SpinnerEjercicioAdapter(this, R.layout.spinner_ejercicio1, datos);

        sp.setAdapter(adapter);

        //EVENTO DE SELECCION DE VALOR DEL SPINNER
        sp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (ver == 1 && i>0){
                    Toast.makeText(adapterView.getContext(), adapterView.getItemAtPosition(i - 1).toString(), Toast.LENGTH_SHORT).show();
                }
                ver = 1;
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }
}