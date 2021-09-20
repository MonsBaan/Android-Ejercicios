package com.example.a03adaptadores;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class CompaniasAdapter extends BaseAdapter {

    private Context context = null;
    ArrayList<CompaniaTelefonica> companiaTelefonicas = null;

    public CompaniasAdapter(Context context, ArrayList<CompaniaTelefonica> companiaTelefonicas) {
        this.context = context;
        this.companiaTelefonicas = companiaTelefonicas;
    }

    @Override
    public int getCount() {
        return companiaTelefonicas.size();
    }

    @Override
    public Object getItem(int i) {
        return companiaTelefonicas.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater inflater = ((Activity) context).getLayoutInflater();
        View fila = inflater.inflate(R.layout.compania_telefonica_list, null);

        CompaniaTelefonica compania = companiaTelefonicas.get(i);
        ImageView ivCompañia = fila.findViewById(R.id.ivCompaniaTelefonica);
        ivCompañia.setImageResource(compania.getLogo());

        TextView tvNombre = fila.findViewById(R.id.tvNombreCompania);
        tvNombre.setText(compania.getNombre());

        TextView tvPrecio = fila.findViewById(R.id.tvPrecioCompania);
        tvPrecio.setText(compania.getPrecio() + "");
        return fila;
    }
}
