package com.example.proyectoindividual.ui.galeria;

import android.os.Bundle;
import android.transition.TransitionInflater;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import com.example.proyectoindividual.R;
import com.example.proyectoindividual.galeria.adaptadores.ViewPagerAdapter;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class GaleriaFragment extends Fragment {

    private TabLayout tabGaleria = null;
    private ViewPager2 vpGaleria = null;

    public static GaleriaFragment newInstance() {
        return new GaleriaFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //IBAI: He tenido que meter estas dos lineas de codigo en todos los fragmentos del menu para animarlas
        TransitionInflater inflater = TransitionInflater.from(getContext());
        setEnterTransition(inflater.inflateTransition(R.transition.slidedam));

    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.galeria_fragment, container, false);
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        tabGaleria = view.findViewById(R.id.tabGaleria);
        vpGaleria = view.findViewById(R.id.vpGaleria);

        ViewPagerAdapter adapter = new ViewPagerAdapter(this);
        vpGaleria.setAdapter(adapter);

        String[] string = {"Interior", "Exterior"};

        //IBAI: Esto ayuda a la sincronizacion entre el ViewPager y el TabView (El ArrayString de encima me pareció tremendo big brain)
        new TabLayoutMediator(tabGaleria, vpGaleria,
                (tab, position) -> tab.setText(string[position])
        ).attach();
    }


}