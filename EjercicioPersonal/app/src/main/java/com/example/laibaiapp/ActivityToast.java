package com.example.laibaiapp;

import androidx.appcompat.app.AppCompatActivity;

import android.media.Image;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class ActivityToast extends AppCompatActivity {
    private Button btnToast, btnToastPer = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toast);

        //SE INSTANCIAN LOS BOTONES
        btnToast = findViewById(R.id.btnToastNormal);
        btnToastPer = findViewById(R.id.btnToastPer);

        //SE CREAN LOS EVENTOS DE LOS BOTONES
        btnToast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Hola, soy un Toast Normal", Toast.LENGTH_SHORT).show();
            }
        });


        btnToastPer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //PARA PERSONALIZAR UN TOAST SE NECESITA CREAR UN LAYOUTINFLATER
                LayoutInflater inflater = getLayoutInflater();
                View miToast = inflater.inflate(R.layout.toast_per, null);
                ImageView imagenToastPer = miToast.findViewById(R.id.ivToastPer);
                imagenToastPer.setImageResource(R.drawable.ic_launcher_foreground);

                Toast toast = new Toast(getApplicationContext());

                toast.setView(miToast);
                toast.show();


            }
        });
    }
}