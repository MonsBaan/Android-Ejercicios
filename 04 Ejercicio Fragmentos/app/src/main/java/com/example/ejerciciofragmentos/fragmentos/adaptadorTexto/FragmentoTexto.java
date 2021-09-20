package com.example.ejerciciofragmentos.fragmentos.adaptadorTexto;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.ejerciciofragmentos.R;


public class FragmentoTexto extends Fragment {
    private Context context = null;
    private TextView tvCurso = null;

    public FragmentoTexto() {
        // Required empty public constructor
    }

    //METODO PARA RECIBIR PARAMETROS
    public static FragmentoTexto newInstance(Bundle bundle) {
        FragmentoTexto fragmentoTexto = new FragmentoTexto();
        if (bundle != null) {
            fragmentoTexto.setArguments(bundle);

        }
        return fragmentoTexto;
    }

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
        return inflater.inflate(R.layout.fragment_fragmento_texto, null);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        tvCurso = view.findViewById(R.id.tvCurso);

        if (getArguments() != null) {
            if (getArguments().containsKey("curso")) {
                tvCurso.setText(getArguments().getString("curso"));
            }
            if (getArguments().containsKey("color")) {
                tvCurso.setBackgroundColor(getArguments().getInt("color"));
            }

        }

    }

    @Override
    public void onDetach() {
        super.onDetach();
    }
}