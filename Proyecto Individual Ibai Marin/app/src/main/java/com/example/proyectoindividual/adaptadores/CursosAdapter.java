package com.example.proyectoindividual.adaptadores;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.proyectoindividual.R;
import com.example.proyectoindividual.ui.inicio.InicioFragment;

import java.util.ArrayList;

public class CursosAdapter extends BaseAdapter {
    private ArrayList<String> arrayCursos;
    private Context context;

    public CursosAdapter(InicioFragment inicioFragment, ArrayList<String> arrayCursos) {
        this.context = inicioFragment.getContext();
        this.arrayCursos = arrayCursos;
    }

    @Override
    public int getCount() {
        return arrayCursos.size();
    }

    @Override
    public Object getItem(int i) {
        return arrayCursos.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View vista = inflater.inflate(R.layout.inicio_fragment_listview_layout, null);

        TextView tvCursos = vista.findViewById(R.id.tvCursos);
        tvCursos.setText(getItem(i).toString());

        return vista;
    }
}
