package com.example.a02ejerciciohilos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button btnPrincipal = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnPrincipal = findViewById(R.id.btnPrincipal);
        btnPrincipal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //getApplicationContext es un "this"
                Intent intent = new Intent(getApplicationContext(), HiloDam2.class);
                startActivity(intent);
            }
        });
    }
}