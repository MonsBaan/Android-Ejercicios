package com.example.laibaiapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class MainActivity extends AppCompatActivity {
    private Button btn1, btn2, btn3, btn4, btn5, btn6 = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //SE INICIALIZAN LOS BOTONES
        btn1 = findViewById(R.id.btnMainToast);
        btn2 = findViewById(R.id.btnMainFrameByFrame);
        btn3 = findViewById(R.id.btnMainHilo);
        btn4 = findViewById(R.id.btnMainAdaptadores);
        btn5 = findViewById(R.id.btnMainEjercicioAnimes);
        btn6 = findViewById(R.id.btnMainAnimacionesAndroid);


        //SE CREAN LOS EVENTOS DE LOS BOTONES
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //SE CREA UN INTENT PARA INICIAR LA NUEVA ACTIVIDAD
                Intent intent = new Intent(getApplicationContext(), ActivityToast.class);
                startActivity(intent);

            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //SE CREA UN INTENT PARA INICIAR LA NUEVA ACTIVIDAD
                Intent intent =  new Intent(getApplicationContext(), ActivityFrameByFrame.class);
                startActivity(intent);
            }
        });
    }
}