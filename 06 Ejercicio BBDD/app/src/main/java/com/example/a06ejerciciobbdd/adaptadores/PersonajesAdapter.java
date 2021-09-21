package com.example.a06ejerciciobbdd.adaptadores;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.bumptech.glide.Glide;
import com.example.a06ejerciciobbdd.model.Personaje;
import com.example.a06ejerciciobbdd.R;

import java.util.ArrayList;
import java.util.List;

public class PersonajesAdapter extends ArrayAdapter {
    private Context context = null;
    private List<Personaje> mPersonajesList = null;

    public PersonajesAdapter(@NonNull Context context, int resource) {
        super(context, resource);
        this.context = context;
        mPersonajesList = new ArrayList<>();
    }


    @Override
    public int getCount() {
        return mPersonajesList.size();
    }

    @Nullable
    @Override
    public Object getItem(int position) {
        return mPersonajesList.get(position);
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View vista = inflater.inflate(R.layout.personajes_adapter_layout, null);
        TextView tvNombrePersonaje = vista.findViewById(R.id.tvNombrePersonaje);
        ImageView ivImagenPersonaje = vista.findViewById(R.id.ivImagenPersonaje);

        tvNombrePersonaje.setText(mPersonajesList.get(position).getNombre());
        Glide.with(context).load(mPersonajesList.get(position).getUrl()).placeholder(R.drawable.w_a_t).into(ivImagenPersonaje);

        return vista;
    }

    public List<Personaje> getArrayPersonajes() {
        return mPersonajesList;
    }

    public void setArrayPersonajes(List<Personaje> arrayPersonajes) {
        mPersonajesList = arrayPersonajes;
        notifyDataSetChanged();
    }

}
