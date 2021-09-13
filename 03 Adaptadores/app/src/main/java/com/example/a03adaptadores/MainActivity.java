package com.example.a03adaptadores;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.time.Instant;

public class MainActivity extends AppCompatActivity {
    private Button btnListView, btnSpinner, btnGridView, btnSpinnerEjercicio = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnListView = findViewById(R.id.btnListView);
        btnSpinner = findViewById(R.id.btnSpinner);
        btnGridView = findViewById(R.id.btnGridView);
        btnSpinnerEjercicio = findViewById(R.id.btnSpinnerEjercicio);


        btnListView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "ListView", Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(getApplicationContext(), ListActivity.class);
                startActivity(intent);
            }
        });

        btnSpinner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Spinner", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getApplicationContext(), SpinnerActivity.class);
                startActivity(intent);
            }
        });

        btnGridView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "GridView", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getApplicationContext(), GridActivity.class);
                startActivity(intent);
            }
        });

        btnSpinnerEjercicio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Ejercicio Spinner 1", Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(getApplicationContext(), SpinnerEjercicio1.class);
                startActivity(intent);
            }
        });
    }
}