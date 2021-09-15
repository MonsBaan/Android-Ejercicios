package com.example.a03ejerciciosergio;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class LvMainAdapter extends BaseAdapter {
    private Context context;

    private ImageView ivAnime = null;
    private TextView tvAnime = null;
    private String[] animes = null;

    public LvMainAdapter(Context context, int activity_main_list_layout, String[] animes) {
        this.context = context;
        this.animes = animes;
    }

    @Override
    public int getCount() {
        return animes.length;
    }

    @Override
    public Object getItem(int i) {
        return animes[i];
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater inflater = ((Activity) context).getLayoutInflater();
        if (i == 0) {
            return inflater.inflate(R.layout.activity_main_cabecera, null);

        } else {
            View fila = inflater.inflate(R.layout.activity_main_list_layout, null);

            String[] anime = separarString(animes[i -1], " ");

            TextView tvAnime = fila.findViewById(R.id.tvAnime);


            String animeNombreOriginal = anime[0];
            String animeNombreFinal = "";

            int animeNombreSize = animeNombreOriginal.length();
            for (int j = 0; j < animeNombreSize; j++) {
                if (animeNombreOriginal.charAt(j) == '_'){
                    animeNombreFinal += " ";
                }else{
                    animeNombreFinal += animeNombreOriginal.charAt(j);
                }
            }
            tvAnime.setText(animeNombreFinal);

            ImageView ivAnime = fila.findViewById(R.id.ivAnime);

            Log.d("anime", anime.length + "");

            if (anime.length > 1) {
                Glide.with(context)
                        .load(anime[1])
                        .centerCrop()
                        .placeholder(R.drawable.ic_launcher_foreground)
                        .into(ivAnime);
            }

            return fila;
        }


    }
    private String[] separarString(String textoOriginal, String filtro) {
        return textoOriginal.split(filtro);
    }


}
