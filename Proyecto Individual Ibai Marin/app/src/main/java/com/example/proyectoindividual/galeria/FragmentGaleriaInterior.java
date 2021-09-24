package com.example.proyectoindividual.galeria;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.proyectoindividual.R;
import com.example.proyectoindividual.galeria.adaptadores.GaleriaAdapter;

import java.util.ArrayList;
import java.util.Collections;

public class FragmentGaleriaInterior extends Fragment {
    private RecyclerView recyclerView;
    private Context context;
    private ArrayList<String> arrayImagenes;

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
        arrayImagenes = new ArrayList();

        //METER IMAGENES EN ARRAY














        rellenarDatos();
        View view = inflater.inflate(R.layout.fragment_galeria_interior, container, false);
        // Add the following lines to create RecyclerView
        recyclerView = view.findViewById(R.id.rvInterior);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity().getApplicationContext(), 3));

        recyclerView.setAdapter(new GaleriaAdapter(arrayImagenes,context));


        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }

    private void rellenarDatos() {
        String[] stringArray = getResources().getStringArray(R.array.almiInterior);
        Collections.addAll(arrayImagenes, stringArray);
    }

}