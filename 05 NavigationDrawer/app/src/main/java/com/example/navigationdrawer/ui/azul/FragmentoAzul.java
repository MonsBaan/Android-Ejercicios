package com.example.navigationdrawer.ui.azul;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.navigationdrawer.Alumno;
import com.example.navigationdrawer.R;

public class FragmentoAzul extends Fragment {

    private FragmentoAzulViewModel mViewModel;

    public static FragmentoAzul newInstance() {
        return new FragmentoAzul();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragmento_azul_fragment, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(FragmentoAzulViewModel.class);
        // TODO: Use the ViewModel
        final TextView tvNombre = getView().findViewById(R.id.tvAzulNombre);
        final TextView tvApellido1 = getView().findViewById(R.id.tvAzulApellido1);
        final TextView tvApellido2 = getView().findViewById(R.id.tvAzulApellido2);
        if (getArguments() != null) {
            Alumno alumnoRecibido = (Alumno) getArguments().getSerializable("alumno");

            mViewModel.setAlumno(alumnoRecibido);
        }
        mViewModel.getAlumno().observe(getViewLifecycleOwner(), new Observer<Alumno>() {
            @Override
            public void onChanged(Alumno alumno) {
                if (alumno != null) {
                    tvNombre.setText(alumno.getNombre());
                    tvApellido1.setText(alumno.getApellido1());
                    tvApellido2.setText(alumno.getApellido2());
                }
            }
        });

    }

}