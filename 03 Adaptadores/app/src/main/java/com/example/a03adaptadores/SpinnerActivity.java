package com.example.a03adaptadores;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;


public class SpinnerActivity extends AppCompatActivity {
    private Spinner sp = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner);

        sp = findViewById(R.id.spCursos);
        String[] datos = getResources().getStringArray(R.array.cursos);
        //ArrayAdapter <CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.cursos, android.R.layout.simple_spinner_dropdown_item);

        SpinnerDamAdapter adapter = new SpinnerDamAdapter(this, R.layout.spinner_per, datos);

        sp.setAdapter(adapter);
    }
}