package com.example.proyectoindividual.galeria.adaptadores;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.proyectoindividual.R;

import java.util.ArrayList;

public class GaleriaAdapter extends RecyclerView.Adapter<GaleriaAdapter.ViewHolder> {

    private ArrayList<Integer> mDataset;
    private Context context;

    public GaleriaAdapter(ArrayList<Integer> myDataset, Context context) {
        this.mDataset = myDataset;
        this.context=context;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView iv;
        public ViewHolder(View v) {
            super(v);
            iv = v.findViewById(R.id.ivGaleria);

            v.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    
                }
            });
        }
    }

    @NonNull
    @Override
    public GaleriaAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.galeria_list_item, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        Glide
                .with(this.context)
                .load(mDataset.get(position))
                .into(holder.iv);
    }

    @Override
    public int getItemCount() {
        return mDataset.size();
    }
}

