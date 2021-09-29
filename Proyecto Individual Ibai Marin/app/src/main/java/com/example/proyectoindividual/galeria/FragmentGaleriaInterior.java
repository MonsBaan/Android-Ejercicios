package com.example.proyectoindividual.galeria;

import android.content.Context;
import android.content.Intent;
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

import com.example.proyectoindividual.R;
import com.example.proyectoindividual.bbdd.AppDatabase;
import com.example.proyectoindividual.bbdd.AppExecutorsGallery;
import com.example.proyectoindividual.bbdd.model.Imagen;
import com.example.proyectoindividual.galeria.adaptadores.GaleriaAdapter;

import java.util.ArrayList;
import java.util.List;

public class FragmentGaleriaInterior extends Fragment {
    private RecyclerView imagenAdapter;
    private Context context;
    private ArrayList<Imagen> arrayImagenes;
    private AppDatabase mDb;
    private GaleriaAdapter adapter;

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
        Intent intent = getActivity().getIntent();

        arrayImagenes = new ArrayList();


        View view = inflater.inflate(R.layout.fragment_galeria_interior, container, false);
        // Add the following lines to create RecyclerView
        adapter = new GaleriaAdapter(context);
        imagenAdapter = view.findViewById(R.id.rvInterior);
        imagenAdapter.setHasFixedSize(true);
        imagenAdapter.setLayoutManager(new GridLayoutManager(context, 2));
        imagenAdapter.setAdapter(adapter);

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        imagenAdapter = view.findViewById(R.id.rvInterior);
        consultar();


        Button btnAñadir = view.findViewById(R.id.btnAñadirInterior);

        btnAñadir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String titulo = "Hola";
                String url = "https://almi.eus/wp-content/uploads/2021/02/IMG_20210127_161001-1170x780.jpg";

            }

        });

        btnAñadir.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                mDb = AppDatabase.getInstance(getContext());

                rellenarGaleriaInterior();
                AppExecutorsGallery.getInstance().getDiskIP().execute(new Runnable() {
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

    private void rellenarGaleriaInterior() {
        arrayImagenes = new ArrayList<>();
        arrayImagenes.add(new Imagen("Interior 1", "https://almi.eus/wp-content/uploads/2021/02/IMG_20210127_161001-1170x780.jpg", 0));
        arrayImagenes.add(new Imagen("Interior 2", "https://almi.eus/wp-content/uploads/2019/10/IMG20191016111605-1170x780.jpg", 0));
        arrayImagenes.add(new Imagen("Interior 3", "https://almi.eus/wp-content/uploads/2018/11/IMG-20181113-WA0005.jpg", 0));
        arrayImagenes.add(new Imagen("Interior 4", "https://almi.eus/wp-content/uploads/2018/11/IMG_20181112_094736-1170x780.jpg", 0));
        arrayImagenes.add(new Imagen("Interior 5", "https://almi.eus/wp-content/uploads/2017/03/20170224_080620-1170x780.jpg", 0));
        arrayImagenes.add(new Imagen("Interior 6", "https://almi.eus/wp-content/uploads/2016/12/Laguntzaile-Digitala1-1170x780.png", 0));
        arrayImagenes.add(new Imagen("Interior 7", "https://almi.eus/wp-content/uploads/2017/06/Espacio-Cargdioprotegido.png", 0));
        arrayImagenes.add(new Imagen("Interior 8", "https://almi.eus/wp-content/uploads/2016/09/02-Entrada-Almi-1024x576.jpg", 0));
        arrayImagenes.add(new Imagen("Interior 9", "https://almi.eus/wp-content/uploads/2016/09/03-Entrada-Almi-1024x576.jpg", 0));
        arrayImagenes.add(new Imagen("Interior 10", "https://almi.eus/wp-content/uploads/2016/09/04-Entrada-Almi-1024x576.jpg", 0));
        arrayImagenes.add(new Imagen("Interior 11", "https://almi.eus/wp-content/uploads/2016/09/06-Aula-Ordenadores-1024x576.jpg", 0));
        arrayImagenes.add(new Imagen("Interior 12", "https://almi.eus/wp-content/uploads/2016/09/07-Aula-de-ordenadores-1024x576.jpg", 0));

    }

    @Override
    public void onResume() {
        super.onResume();
        consultar();
    }

    private void consultar() {
        mDb.imagenDao().loadInteriorImages().observe(getViewLifecycleOwner(), new Observer<List<Imagen>>() {
            @Override
            public void onChanged(List<Imagen> imagens) {
                adapter.setArrayImagen(imagens);
            }
        });
    }


}

