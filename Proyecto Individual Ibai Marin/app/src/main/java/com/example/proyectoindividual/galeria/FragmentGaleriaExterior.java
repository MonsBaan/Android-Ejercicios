package com.example.proyectoindividual.galeria;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.proyectoindividual.GalleryDialogFragment;
import com.example.proyectoindividual.R;
import com.example.proyectoindividual.bbdd.AppDatabase;
import com.example.proyectoindividual.bbdd.AppExecutors;
import com.example.proyectoindividual.bbdd.model.Imagen;
import com.example.proyectoindividual.galeria.adaptadores.GaleriaAdapter;

import java.util.ArrayList;
import java.util.List;


public class FragmentGaleriaExterior extends Fragment {
    private RecyclerView imagenAdapter;
    private Context context;
    private ArrayList<Imagen> arrayImagenes;
    private AppDatabase mDb;
    private GaleriaAdapter adapter;


    private GalleryDialogFragment dialog;


    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        this.context = context;

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mDb = AppDatabase.getInstance(context);

        View view = inflater.inflate(R.layout.fragment_galeria_exterior, container, false);
        // Add the following lines to create RecyclerView
        adapter = new GaleriaAdapter(context);

        imagenAdapter = view.findViewById(R.id.rvExterior);
        imagenAdapter.setHasFixedSize(true);
        imagenAdapter.setLayoutManager(new GridLayoutManager(getActivity().getApplicationContext(), 2));
        imagenAdapter.setAdapter(adapter);


        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        imagenAdapter = view.findViewById(R.id.rvExterior);
        consultar();

        Button btnAñadir = view.findViewById(R.id.btnAñadirExterior);
        btnAñadir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        btnAñadir.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                mDb = AppDatabase.getInstance(getContext());

                rellenarGaleriaExterior();
                AppExecutors.getInstance().getDiskIP().execute(new Runnable() {
                    @Override
                    public void run() {
                        //Imagen imagen = new Imagen(titulo, url, 0);
                        for (Imagen imagen :
                                arrayImagenes) {
                            mDb.imagenDao().insertNewImage(imagen);

                        }

                    }
                });
                return false;
            }
        });
    }

    private void rellenarGaleriaExterior() {
        arrayImagenes = new ArrayList();

        arrayImagenes.add(new Imagen("Exterior 1", "https://almi.eus/wp-content/uploads/2016/09/01-Almi-1024x576.jpg", 1));
        arrayImagenes.add(new Imagen("Exterior 2", "https://almi.eus/wp-content/uploads/2019/11/IMG_20191125_084551.jpg", 1));
        arrayImagenes.add(new Imagen("Exterior 3", "https://static.pacelma.es/wp-content/uploads/2013/04/BIZ.002.001.png", 1));
    }

    @Override
    public void onResume() {
        super.onResume();
        consultar();
    }

    public void consultar() {
        mDb.imagenDao().loadExteriorImages().observe(getViewLifecycleOwner(), new Observer<List<Imagen>>() {
            @Override
            public void onChanged(List<Imagen> imagens) {
                adapter.setArrayImagen(imagens);
            }
        });
    }
}