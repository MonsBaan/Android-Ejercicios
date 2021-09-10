package com.example.a01ejerciciodisenyo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.TypedArray;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class AsyntaskDam2 extends AppCompatActivity {
    private TypedArray imagenes = null;
    private ProgressBar barra = null;
    private ImageView imagenCentral = null;
    private TextView texto = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle = getIntent().getExtras();
        if (!bundle.isEmpty()) {
            Toast.makeText(getApplicationContext(), bundle.getString("saludo"), Toast.LENGTH_SHORT).show();
        }


        setContentView(R.layout.activity_asyntask_dam2);

        barra = findViewById(R.id.pbAnimacion);
        imagenCentral = findViewById(R.id.ivAnimacion);
        texto = findViewById(R.id.tvAnimacion);

        //CARGAMOS EL ARRAY DE FOTOS
        imagenes = getResources().obtainTypedArray(R.array.niño);

        //INICIALIZAMOS LA BARRA
        barra.setMax(100);
        barra.setProgress(0);

        //GENERAR HILO
        ProgressAndando hilo = new ProgressAndando(this);

        //EJECUCION DEL HILO
        ThreadExecutor executor = new ThreadExecutor();

        executor.execute(hilo);
    }


    public TypedArray getImagenes() {
        return imagenes;
    }

    public void setImagenes(TypedArray imagenes) {
        this.imagenes = imagenes;
    }

    public ProgressBar getBarra() {
        return barra;
    }

    public void setBarra(ProgressBar barra) {
        this.barra = barra;
    }

    public ImageView getImagenCentral() {
        return imagenCentral;
    }

    public void setImagenCentral(ImageView imagenCentral) {
        this.imagenCentral = imagenCentral;
    }

    public TextView getTexto() {
        return texto;
    }

    public void setTexto(TextView texto) {
        this.texto = texto;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(getApplicationContext(), "CAGASTE", Toast.LENGTH_SHORT).show();
    }
}