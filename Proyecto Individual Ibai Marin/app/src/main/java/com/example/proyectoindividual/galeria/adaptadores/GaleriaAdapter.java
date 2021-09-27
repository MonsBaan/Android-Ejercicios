package com.example.proyectoindividual.galeria.adaptadores;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.proyectoindividual.GalleryDialogFragment;
import com.example.proyectoindividual.ImagenGaleria;
import com.example.proyectoindividual.R;

import java.util.ArrayList;

public class GaleriaAdapter extends RecyclerView.Adapter<GaleriaAdapter.ViewHolder> {

    private ArrayList<ImagenGaleria> mDataset;
    private Context context;
    private GalleryDialogFragment dialog;


    public GaleriaAdapter(ArrayList<ImagenGaleria> myDataset, Context context) {
        this.mDataset = myDataset;
        this.context = context;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView imageView;
        public TextView textView;

        public ViewHolder(View v) {
            super(v);
            imageView = v.findViewById(R.id.ivGaleria);
            textView = v.findViewById(R.id.tvGaleria);
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

        Glide.with(this.context)
                .load(mDataset.get(position).getUrlImagen())
                .into(holder.imageView);

        holder.imageView.setTag(mDataset.get(position).getUrlImagen());
        holder.textView.setText(mDataset.get(position).getTextoGaleria());

        holder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog = new GalleryDialogFragment();

                Bundle bundle = new Bundle();
                bundle.putString("texto", mDataset.get(holder.getAdapterPosition()).getTextoGaleria());
                bundle.putString("imagen", mDataset.get(holder.getAdapterPosition()).getUrlImagen());

                dialog.setArguments(bundle);

                dialog.show(((FragmentActivity) context).getSupportFragmentManager(), "GaleriaBig");
            }
        });
    }

    @Override
    public int getItemCount() {
        return mDataset.size();
    }
}

