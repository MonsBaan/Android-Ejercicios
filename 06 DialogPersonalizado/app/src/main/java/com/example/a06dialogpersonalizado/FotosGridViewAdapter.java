package com.example.a06dialogpersonalizado;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class FotosGridViewAdapter extends BaseAdapter {
    private CamaraActivity activity;

    public FotosGridViewAdapter(CamaraActivity activity) {
        this.activity = activity;
    }

    @Override
    public int getCount() {
        return activity.getImagenesList().size();
    }

    @Override
    public Object getItem(int i) {
        return activity.getImagenesList().get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        Log.d("ibai", getCount()+"");
        LayoutInflater inflater = activity.getLayoutInflater();
        View fila = inflater.inflate(R.layout.item_grid_view, viewGroup, false);
        ImageView imagen = fila.findViewById(R.id.ivItemImagen);
        Glide.with(activity).load(activity.getImagenesList().get(i)).into(imagen);
        return fila;
    }
}
