package com.example.a03adaptadores;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.GridView;

public class GridActivity extends AppCompatActivity {

    private GridView gvPaisajes = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid);

        gvPaisajes = findViewById(R.id.gvPaisajes);
        gvPaisajes.setAdapter(new ImageAdapter(getApplicationContext(), getResources().obtainTypedArray(R.array.paisajes)));
    }
}