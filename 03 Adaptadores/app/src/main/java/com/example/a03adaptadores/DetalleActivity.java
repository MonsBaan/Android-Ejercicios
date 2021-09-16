package com.example.a03adaptadores;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.ViewCompat;

import android.content.res.TypedArray;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class DetalleActivity extends AppCompatActivity {
    public static final String VIEW_NAME_HEADER_IMAGE = "imagenCabecera";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle);

        TypedArray paisajes = getResources().obtainTypedArray(R.array.paisajes);
        int pos = getIntent().getIntExtra("idFoto", 0);

        /*TextView tvTitulo =  findViewById(R.id.tvDetalles);
        tvTitulo.setText((pos+""));*/
        ImageView ivDetalles = findViewById(R.id.ivDetalle);
        Glide.with(getApplicationContext()).load(paisajes.getResourceId(pos, -1)).into(ivDetalles);
        ViewCompat.setTransitionName(ivDetalles, VIEW_NAME_HEADER_IMAGE);
    }
}