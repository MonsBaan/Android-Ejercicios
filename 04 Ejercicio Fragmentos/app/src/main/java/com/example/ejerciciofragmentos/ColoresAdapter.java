package com.example.ejerciciofragmentos;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import androidx.constraintlayout.widget.ConstraintLayout;

import java.util.ArrayList;

public class ColoresAdapter extends BaseAdapter {
    private Context context = null;
    private ArrayList<ColoresLista> arrayColores = null;

    public ColoresAdapter(Context context, ArrayList<ColoresLista> arrayColores) {
        this.context = context;
        this.arrayColores = arrayColores;
    }

    @Override
    public int getCount() {
        return arrayColores.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ColoresLista color = arrayColores.get(i);

        LayoutInflater inflater = LayoutInflater.from(this.context);
        View fila = inflater.inflate(R.layout.colores, null);


        TextView tvColor = fila.findViewById(R.id.tvColor);
        tvColor.setText(color.getNombreColor());

        return fila;
    }
}
