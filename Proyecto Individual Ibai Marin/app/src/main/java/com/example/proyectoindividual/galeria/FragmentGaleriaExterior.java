package com.example.proyectoindividual.galeria;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.proyectoindividual.GalleryDialogFragment;
import com.example.proyectoindividual.ImagenGaleria;
import com.example.proyectoindividual.R;
import com.example.proyectoindividual.galeria.adaptadores.GaleriaAdapter;

import java.util.ArrayList;


public class FragmentGaleriaExterior extends Fragment {
    private RecyclerView recyclerView;
    private Context context;
    private ArrayList<ImagenGaleria> arrayImagenes;
    private ImagenGaleria imagenGaleria;
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

        rellenarGaleriaExterior();

        View view = inflater.inflate(R.layout.fragment_galeria_exterior, container, false);
        // Add the following lines to create RecyclerView
        recyclerView = view.findViewById(R.id.rvExterior);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity().getApplicationContext(), 3));

        recyclerView.setAdapter(new GaleriaAdapter(arrayImagenes, context));

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }

    private void rellenarGaleriaExterior() {
        arrayImagenes = new ArrayList();

        arrayImagenes.add(new ImagenGaleria("https://almi.eus/wp-content/uploads/2016/09/01-Almi-1024x576.jpg", "Exterior 1"));
        arrayImagenes.add(new ImagenGaleria("https://almi.eus/wp-content/uploads/2019/11/IMG_20191125_084551.jpg", "Exterior 2"));
        arrayImagenes.add(new ImagenGaleria("https://static.pacelma.es/wp-content/uploads/2013/04/BIZ.002.001.png", "Exterior 3"));

    }
}