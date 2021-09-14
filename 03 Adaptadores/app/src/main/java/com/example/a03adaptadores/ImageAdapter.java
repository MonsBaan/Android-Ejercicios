package com.example.a03adaptadores;

import android.content.Context;
import android.content.res.TypedArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class ImageAdapter extends BaseAdapter {
    private Context context = null;
    private TypedArray imagenes = null;

    public ImageAdapter(Context context, TypedArray imagenes) {
        this.context = context;
        this.imagenes = imagenes;
    }

    @Override
    public int getCount() {
        return imagenes.length();
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
        View vistaImagen = inflater.inflate(R.layout.grid_layout, null);

        ImageView imagen = vistaImagen.findViewById(R.id.ivItemGrid);
        //imagen.setImageResource(imagenes.getResourceId(i, -1));

        Glide.with(context).load(this.imagenes.getResourceId(i, -1)).into(imagen);

        return vistaImagen;
    }
}
