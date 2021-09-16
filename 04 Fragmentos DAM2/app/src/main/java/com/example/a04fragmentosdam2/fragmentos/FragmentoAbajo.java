package com.example.a04fragmentosdam2.fragmentos;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.a04fragmentosdam2.R;

public class FragmentoAbajo extends Fragment {
    private TextView tvAbajo = null;

    public FragmentoAbajo() {
        super();


    }

    //METODO PARA RECIBIR PARAMETROS
    public static FragmentoAbajo newInstance(Bundle bundle) {
        FragmentoAbajo fragmentoAbajo = new FragmentoAbajo();
        if (bundle != null) {
            fragmentoAbajo.setArguments(bundle);
        }
        return fragmentoAbajo;
    }


    //METODO PARA CONECTARNOS CON LA ACTIVIDAD PRINCIPAL
    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
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
        return inflater.inflate(R.layout.fragment_fragmento_abajo, null);
    }

    //CUANDO YA SE HA CARGADO LA VISTA
    //AQUI INSTANCIAMOS LOS ELEMENTOS
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        tvAbajo = view.findViewById(R.id.tvAbajo);
        if (getArguments().containsKey("saludo")) {
            tvAbajo.setText(getArguments().getString("saludo"));
        }
        if (getArguments().containsKey("color")) {
            tvAbajo.setTextColor(getArguments().getInt("color"));
        }
        if (getArguments().containsKey("texto")) {
            tvAbajo.setText(getArguments().getString("texto"));
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }


}