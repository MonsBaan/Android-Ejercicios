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
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.TextView;

import com.example.proyectoindividual.GalleryDialogFragment;
import com.example.proyectoindividual.ImagenGaleria;
import com.example.proyectoindividual.R;
import com.example.proyectoindividual.galeria.adaptadores.GaleriaAdapter;

import java.util.ArrayList;
import java.util.Collections;


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
        arrayImagenes = new ArrayList();

        rellenar();

        View view = inflater.inflate(R.layout.fragment_galeria_exterior, container, false);
        // Add the following lines to create RecyclerView
        recyclerView = view.findViewById(R.id.rvExterior);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity().getApplicationContext(), 3));

        recyclerView.setAdapter(new GaleriaAdapter(arrayImagenes, context));

        recyclerView.addOnItemTouchListener(new RecyclerView.OnItemTouchListener() {
            @Override
            public boolean onInterceptTouchEvent(@NonNull RecyclerView rv, @NonNull MotionEvent e) {
                View child = rv.findChildViewUnder(e.getX(), e.getY());
                if (child != null) {

                    TextView texto = child.findViewById(R.id.tvGaleria);
                    String nombreImagen = texto.getText().toString();
                    nombreImagen = nombreImagen.replace(" ", "_").toLowerCase();
                    Bundle bundle = new Bundle();
                    int icon = context.getResources().getIdentifier(nombreImagen, "drawable", context.getPackageName());

                    bundle.putInt("imagen", icon);

                    bundle.putString("texto", (String) texto.getText());
                    dialog = new GalleryDialogFragment();
                    dialog.show(getChildFragmentManager(), "GaleriaBig");
                    dialog.setArguments(bundle);
                    return true;
                }
                return false;

            }

            @Override
            public void onTouchEvent(@NonNull RecyclerView rv, @NonNull MotionEvent e) {

            }

            @Override
            public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {

            }
        });
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }

    private void rellenar() {
        imagenGaleria = new ImagenGaleria(R.drawable.exterior_1, "Exterior 1");
        arrayImagenes.add(imagenGaleria);
        imagenGaleria = new ImagenGaleria(R.drawable.exterior_2, "Exterior 2");
        arrayImagenes.add(imagenGaleria);
        imagenGaleria = new ImagenGaleria(R.drawable.exterior_3, "Exterior 3");
        arrayImagenes.add(imagenGaleria);

    }
}