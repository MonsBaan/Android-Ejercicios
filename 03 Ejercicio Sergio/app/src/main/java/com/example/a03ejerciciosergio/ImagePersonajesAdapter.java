package com.example.a03ejerciciosergio;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class ImagePersonajesAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<String> personajesAnime;
    private String[] personaje = null;
    private String nombrePersonaje = "";
    private String imagenPersonaje = "";

    public ImagePersonajesAdapter(Context context, ArrayList<String> personajesAnime) {
        this.context = context;
        this.personajesAnime = personajesAnime;
    }

    @Override
    public int getCount() {
        return personajesAnime.size();
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
        LayoutInflater inflater = LayoutInflater.from(this.context);
        View imagePersonajes = inflater.inflate(R.layout.activity_personajes_grid_layout, null);
        ImageView ivPersonajes = imagePersonajes.findViewById(R.id.ivPersonajes);

        personaje = personajesAnime.get(i).split(" ");
        nombrePersonaje = personaje[1];
        imagenPersonaje = personaje[2];



        Glide.with(context).load(imagenPersonaje).into(ivPersonajes);
        return imagePersonajes;

    }

    private String[] separarString(String textoOriginal, String filtro) {
        return textoOriginal.split(filtro);
    }

}
