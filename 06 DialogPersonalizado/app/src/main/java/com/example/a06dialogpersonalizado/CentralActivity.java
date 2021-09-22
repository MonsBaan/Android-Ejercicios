package com.example.a06dialogpersonalizado;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class CentralActivity extends AppCompatActivity {

    private Button btnSensores, btnVoz, btnCamara, btnVolley = null;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_central);
        btnSensores = findViewById(R.id.btnSensores);
        btnVoz = findViewById(R.id.btnSensorVoz);
        btnCamara = findViewById(R.id.btnCamara);
        btnVolley = findViewById(R.id.btnVolley);

        btnVoz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), VozActivity.class);
                startActivity(intent);
            }
        });
        btnSensores.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), SensoresActivity.class);
                startActivity(intent);
            }
        });

        btnCamara.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), CamaraActivity.class);
                startActivity(intent);
            }
        });

    }
}