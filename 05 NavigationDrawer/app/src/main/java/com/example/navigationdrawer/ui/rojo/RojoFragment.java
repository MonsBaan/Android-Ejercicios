package com.example.navigationdrawer.ui.rojo;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.navigationdrawer.Alumnado;
import com.example.navigationdrawer.Alumno;
import com.example.navigationdrawer.MainActivity;
import com.example.navigationdrawer.R;
import com.example.navigationdrawer.adaptadores.AlumnadoAdapter;

public class RojoFragment extends Fragment {

    private RojoViewModel mViewModel;
    private Context context;

    public static RojoFragment newInstance() {
        return new RojoFragment();
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        this.context = context;
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.rojo_fragment, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(RojoViewModel.class);
        // TODO: Use the ViewModel
        final TextView tvRojo = getView().findViewById(R.id.tvRojo);
        final ListView lvRojo = getView().findViewById(R.id.lvRojoAlumnado);

        lvRojo.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                ((MainActivity) context).cambiarFragmento((Alumno) adapterView.getItemAtPosition(i));
            }
        });

        mViewModel.getAlumnado().observe(getViewLifecycleOwner(), new Observer<Alumnado>() {
            @Override
            public void onChanged(Alumnado alumnado) {
                lvRojo.setAdapter(new AlumnadoAdapter(getContext(), R.layout.alumno_item, alumnado));

            }
        });
    }

}