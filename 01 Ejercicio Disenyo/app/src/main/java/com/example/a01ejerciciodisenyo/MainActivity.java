package com.example.a01ejerciciodisenyo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageButton btnNuevo = findViewById(R.id.imgBtnNuevo);

        //CREAR TOAST PERSONALIZADO
        final int duracion = Toast.LENGTH_SHORT;
        LayoutInflater inflater = getLayoutInflater();
        final View miToast = inflater.inflate(R.layout.toast_per, (ViewGroup) findViewById(R.id.layoutToast));
        final Toast toast = new Toast(getApplicationContext());

        //CAMBIAR TEXTO A TOAST PERSONALIZADO
        TextView textoToast = miToast.findViewById(R.id.tvToast);
        textoToast.setText("Albertxigo");

        //CAMBIAR IMAGEN A TOAST PERSONALIZADO
        ImageView fotoToast =miToast.findViewById(R.id.ivToast);
        fotoToast.setImageResource(R.drawable.ic_launcher_background);


        btnNuevo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*Toast Cutre
                Toast.makeText(getApplicationContext(), "Cagaste Guacho", Toast.LENGTH_LONG).show();*/

                //Toast Fancy
                toast.setView(miToast);
                toast.setGravity(Gravity.CENTER_VERTICAL, 0, 300);
                toast.setDuration(duracion);
                toast.show();
            }
        });
    }






    /* Toast OnClick activity_main.xml

    public void toastMsg(View view) {
        Toast toast = Toast.makeText(this, "Cagaste Guacho",Toast.LENGTH_LONG);
        toast.show();
    }*/
}