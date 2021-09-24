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
import android.widget.GridView;

import com.example.proyectoindividual.R;
import com.example.proyectoindividual.galeria.adaptadores.GaleriaAdapter;

import java.util.ArrayList;
import java.util.Collections;


public class FragmentGaleriaExterior extends Fragment {
    private RecyclerView recyclerView;
    private Context context;
    private ArrayList<Integer> arrayImagenes;

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

        rellenar();

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

    private void rellenar() {
        arrayImagenes.add(R.drawable.exterior_1);
        arrayImagenes.add(R.drawable.exterior_2);
        arrayImagenes.add(R.drawable.exterior_3);

    }
}