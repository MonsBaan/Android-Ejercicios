package com.example.proyectoindividual.galeria.adaptadores;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.proyectoindividual.GalleryDialogFragment;
import com.example.proyectoindividual.R;
import com.example.proyectoindividual.bbdd.AppDatabase;
import com.example.proyectoindividual.bbdd.AppExecutors;
import com.example.proyectoindividual.bbdd.model.Imagen;

import java.util.ArrayList;
import java.util.List;

public class GaleriaAdapter extends RecyclerView.Adapter<GaleriaAdapter.ViewHolder> {

    //private ArrayList<ImagenGaleria> mDataset;
    private Context context;
    private GalleryDialogFragment dialog;
    private AppDatabase mDb;
    private List<Imagen> arrayImagen;


    /*public GaleriaAdapter(ArrayList<ImagenGaleria> myDataset, Context context) {
        this.mDataset = myDataset;
        this.context = context;
        arrayImagen = new ArrayList<>();
    }*/

    public GaleriaAdapter(Context context) {
        this.context = context;
        arrayImagen = new ArrayList<>();
        mDb = AppDatabase.getInstance(context);
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

        Glide.with(context)
                .load(arrayImagen.get(position).getUrlImagen())
                .into(holder.imageView);

        holder.imageView.setTag(arrayImagen.get(position).getUrlImagen());
        holder.textView.setText(arrayImagen.get(position).getTituloImagen());

        holder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog = new GalleryDialogFragment();

                Bundle bundle = new Bundle();
                bundle.putString("texto", arrayImagen.get(holder.getAdapterPosition()).getTituloImagen());
                bundle.putString("imagen", arrayImagen.get(holder.getAdapterPosition()).getUrlImagen());

                dialog.setArguments(bundle);

                dialog.show(((FragmentActivity) context).getSupportFragmentManager(), "GaleriaBig");
            }
        });

        final AlertDialog.Builder alerta = new AlertDialog.Builder(context);
        alerta.setTitle("Cuidado!!!");
        alerta.setMessage("¿Estas seguro que quieres borrar esta imagen?");
        holder.imageView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                final int idImagen = arrayImagen.get(holder.getAdapterPosition()).getId();
                
                alerta.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        
                    }
                });
                
                alerta.setPositiveButton("Eliminar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(context, "Imagen Borrada", Toast.LENGTH_SHORT).show();
                        eliminar(idImagen);
                    }
                });
                alerta.show();
                return false;
            }
        });
    }

    @Override
    public int getItemCount() {
        return arrayImagen.size();
    }

    private void eliminar(int id) {
        AppExecutors.getInstance().getDiskIP().execute(new Runnable() {
            @Override
            public void run() {
                Imagen imagen = mDb.imagenDao().loadImagenById(id);
                mDb.imagenDao().deleteImage(imagen);
            }
        });
    }



    public void setArrayImagen(List<Imagen> arrayImagen) {
        this.arrayImagen = arrayImagen;
        notifyDataSetChanged();
    }
}

