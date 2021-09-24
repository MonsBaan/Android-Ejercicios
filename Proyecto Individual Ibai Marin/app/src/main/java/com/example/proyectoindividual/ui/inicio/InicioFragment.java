package com.example.proyectoindividual.ui.inicio;

import androidx.lifecycle.ViewModelProvider;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.transition.Transition;
import android.transition.TransitionInflater;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.proyectoindividual.R;
import com.example.proyectoindividual.adaptadores.CursosAdapter;

import java.util.ArrayList;

public class InicioFragment extends Fragment {

    private InicioViewModel mViewModel;
    private ArrayList<String> arrayCursos = new ArrayList<>();
    private Context context;

    public static InicioFragment newInstance() {
        return new InicioFragment();
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        this.context = context;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TransitionInflater inflater = TransitionInflater.from(context);
        setEnterTransition(inflater.inflateTransition(R.transition.slidedam));
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        return inflater.inflate(R.layout.inicio_fragment, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(InicioViewModel.class);
        // TODO: Use the ViewModel


        final ListView lvCursos = getView().findViewById(R.id.lvInicioCursos);
        rellenarDatos();

        CursosAdapter adapter = new CursosAdapter(this, arrayCursos);
        lvCursos.setAdapter(adapter);
    }

    private void rellenarDatos() {
        String[] stringArray = getResources().getStringArray(R.array.cursos);
        for (String curso :
                stringArray) {
            arrayCursos.add(curso);

        }
    }

}