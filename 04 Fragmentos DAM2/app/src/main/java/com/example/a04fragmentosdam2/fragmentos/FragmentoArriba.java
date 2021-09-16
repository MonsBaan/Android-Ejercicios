package com.example.a04fragmentosdam2.fragmentos;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.a04fragmentosdam2.R;

import java.util.zip.Inflater;

public class FragmentoArriba extends Fragment {
    private Button btnEnviar = null;
    private EditText etTexto = null;
    private IControlFragmentos controlFragmentos = null;

    public FragmentoArriba() {
        super();


    }

    //METODO PARA CONECTARNOS CON LA ACTIVIDAD PRINCIPAL
    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        controlFragmentos = (IControlFragmentos) context;
    }

    //CUANDO SE CREA EL FRAGMENTO (NO CUANDO SE MUESTRA)
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    //CUANDO CARGAMOS LA VISTA (CUANDO SE EJECUTA EL INFLATER)
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_fragmento_arriba, null);
    }

    //CUANDO YA SE HA CARGADO LA VISTA
    //AQUI INSTANCIAMOS LOS ELEMENTOS
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        btnEnviar = view.findViewById(R.id.btnEnviar);
        etTexto = view.findViewById(R.id.etTexto);

        btnEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                controlFragmentos.cambiarTexto(etTexto.getText().toString());
            }
        });
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }


}