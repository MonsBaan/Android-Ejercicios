package com.example.a01ejerciciodisenyo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.TypedArray;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

public class CaballoPantalla extends AppCompatActivity {
    private TypedArray frames = null;
    private TextView porcentaje = null;
    private ImageView imgCaballo = null;
    private ProgressBar barra = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_caballo_pantalla);

        porcentaje = findViewById(R.id.tvCaballo);
        imgCaballo = findViewById(R.id.ivCaballo);
        barra = findViewById(R.id.pbCaballo);

        //INICIALIZACION DE BARRA
        barra.setMax(100);
        barra.setProgress(0);

        //INICIALIZACION DE FRAMES
        frames = getResources().obtainTypedArray(R.array.caballo);
        Log.d("Frames", frames.length()+"");

        //GENERAR HILO

        AnimacionCaballo animCaballo = new AnimacionCaballo(this);

        //EJECUTAR HILO
        ThreadExecutor executor = new ThreadExecutor();
        executor.execute(animCaballo);
    }


    public TypedArray getFrames() {
        return frames;
    }

    public void setFrames(TypedArray frames) {
        this.frames = frames;
    }

    public TextView getPorcentaje() {
        return porcentaje;
    }

    public void setPorcentaje(TextView porcentaje) {
        this.porcentaje = porcentaje;
    }

    public ImageView getImgCaballo() {
        return imgCaballo;
    }

    public void setImgCaballo(ImageView imgCaballo) {
        this.imgCaballo = imgCaballo;
    }

    public ProgressBar getBarra() {
        return barra;
    }

    public void setBarra(ProgressBar barra) {
        this.barra = barra;
    }
}