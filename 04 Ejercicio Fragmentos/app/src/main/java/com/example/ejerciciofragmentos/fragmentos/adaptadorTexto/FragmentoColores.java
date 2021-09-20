package com.example.ejerciciofragmentos.fragmentos.adaptadorTexto;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.ejerciciofragmentos.ColoresAdapter;
import com.example.ejerciciofragmentos.ColoresLista;
import com.example.ejerciciofragmentos.R;
import com.example.ejerciciofragmentos.fragmentos.IControlFragmentos;

import java.util.ArrayList;


public class FragmentoColores extends Fragment {
    private ListView lvColores = null;
    private ArrayList<ColoresLista> arrayColores = null;
    private Context context;
    private IControlFragmentos controlFragmentos;


    public FragmentoColores() {
        super();
        arrayColores = new ArrayList<ColoresLista>();

    }

    //METODO PARA CONECTARNOS CON LA ACTIVIDAD PRINCIPAL
    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        this.context = context;
        controlFragmentos = (IControlFragmentos) context;


    }

    //CUANDO SE CREA EL FRAGMENTO(NO CUANDO SE MUESTRA)
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    //CUANDO SE CARGA LA VISTA(CUANDO SE EJECUTA EL INFLATER)
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_fragmento_colores, null);
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        rellenarColores();

        ColoresAdapter coloresAdapter = new ColoresAdapter(this.context, arrayColores);
        lvColores = view.findViewById(R.id.lvColores);
        lvColores.setAdapter(coloresAdapter);

        lvColores.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                controlFragmentos.cambiarColor(arrayColores.get(i).getColor());
            }
        });

    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    private void rellenarColores() {
        arrayColores.add(new ColoresLista("Rojo", Color.RED));
        arrayColores.add(new ColoresLista("Azul", Color.BLUE));
        arrayColores.add(new ColoresLista("Verde", Color.GREEN));
    }


}
