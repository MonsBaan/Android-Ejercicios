package com.example.a02ejerciciohilos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.TypedArray;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

public class HiloDam2 extends AppCompatActivity {
    private ProgressBar pbHilo = null;
    private ImageView ivhilo = null;
    private TextView tvHilo = null;
    private TypedArray caballos = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hilo_dam2);
        pbHilo = findViewById(R.id.pbHilo);
        ivhilo = findViewById(R.id.ivHilo);
        tvHilo = findViewById(R.id.tvHilo);
        caballos = getResources().obtainTypedArray(R.array.fotos);

        //ESTABLECEMOS LOS PARAMETROS DE LA BARRA
        pbHilo.setMax(100);
        pbHilo.setProgress(0);

        //INSTANCIAMOS EL NUEVO HILO
        //CaballoCorriendo hilo = new CaballoCorriendo(this);

        AsyntaskEjercicio hilo = new AsyntaskEjercicio(this);
        hilo.execute();

        //INSTANCIAMOS EL EXECUTOR
        //EjecutarHilo ejecutarHilo = new EjecutarHilo();

        //EJECUTAR HILO
        //ejecutarHilo.execute(hilo);

    }

    public ProgressBar getPbHilo() {
        return pbHilo;
    }

    public void setPbHilo(ProgressBar pbHilo) {
        this.pbHilo = pbHilo;
    }

    public ImageView getIvhilo() {
        return ivhilo;
    }

    public void setIvhilo(ImageView ivhilo) {
        this.ivhilo = ivhilo;
    }

    public TextView getTvHilo() {
        return tvHilo;
    }

    public void setTvHilo(TextView tvHilo) {
        this.tvHilo = tvHilo;
    }

    public TypedArray getCaballos() {
        return caballos;
    }

    public void setCaballos(TypedArray caballos) {
        this.caballos = caballos;
    }
}