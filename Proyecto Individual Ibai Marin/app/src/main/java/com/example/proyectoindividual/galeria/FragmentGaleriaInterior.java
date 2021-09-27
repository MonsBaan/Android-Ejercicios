package com.example.proyectoindividual.galeria;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.proyectoindividual.ImagenGaleria;
import com.example.proyectoindividual.R;
import com.example.proyectoindividual.galeria.adaptadores.GaleriaAdapter;

import java.util.ArrayList;

public class FragmentGaleriaInterior extends Fragment {
    private RecyclerView recyclerView;
    private Context context;
    private ArrayList<ImagenGaleria> arrayImagenes;
    private ImagenGaleria imagenGaleria;

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
        rellenarGaleriaInterior();

        //METER IMAGENES EN ARRAY

        View view = inflater.inflate(R.layout.fragment_galeria_interior, container, false);
        // Add the following lines to create RecyclerView
        recyclerView = view.findViewById(R.id.rvInterior);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(context, 2));
        recyclerView.setAdapter(new GaleriaAdapter(arrayImagenes, context));

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = view.findViewById(R.id.rvInterior);


    }

    private void rellenarGaleriaInterior() {
        arrayImagenes = new ArrayList();

        arrayImagenes.add(new ImagenGaleria("https://almi.eus/wp-content/uploads/2021/02/IMG_20210127_161001-1170x780.jpg", "Interior 1"));
        arrayImagenes.add(new ImagenGaleria("https://almi.eus/wp-content/uploads/2019/10/IMG20191016111605-1170x780.jpg", "Interior 2"));
        arrayImagenes.add(new ImagenGaleria("https://almi.eus/wp-content/uploads/2018/11/IMG-20181113-WA0005.jpg", "Interior 3"));
        arrayImagenes.add(new ImagenGaleria("https://almi.eus/wp-content/uploads/2018/11/IMG_20181112_094736-1170x780.jpg", "Interior 4"));
        arrayImagenes.add(new ImagenGaleria("https://almi.eus/wp-content/uploads/2017/03/20170224_080620-1170x780.jpg", "Interior 5"));
        arrayImagenes.add(new ImagenGaleria("https://almi.eus/wp-content/uploads/2016/12/Laguntzaile-Digitala1-1170x780.png", "Interior 6"));
        arrayImagenes.add(new ImagenGaleria("https://almi.eus/wp-content/uploads/2017/06/Espacio-Cargdioprotegido.png", "Interior 7"));
        arrayImagenes.add(new ImagenGaleria("https://almi.eus/wp-content/uploads/2016/09/02-Entrada-Almi-1024x576.jpg", "Interior 8"));
        arrayImagenes.add(new ImagenGaleria("https://almi.eus/wp-content/uploads/2016/09/03-Entrada-Almi-1024x576.jpg", "Interior 9"));
        arrayImagenes.add(new ImagenGaleria("https://almi.eus/wp-content/uploads/2016/09/04-Entrada-Almi-1024x576.jpg", "Interior 10"));
        arrayImagenes.add(new ImagenGaleria("https://almi.eus/wp-content/uploads/2016/09/06-Aula-Ordenadores-1024x576.jpg", "Interior 11"));
        arrayImagenes.add(new ImagenGaleria("https://almi.eus/wp-content/uploads/2016/09/07-Aula-de-ordenadores-1024x576.jpg", "Interior 12"));

    }


}

