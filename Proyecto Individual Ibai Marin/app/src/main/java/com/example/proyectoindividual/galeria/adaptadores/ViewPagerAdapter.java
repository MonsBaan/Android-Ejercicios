package com.example.proyectoindividual.galeria.adaptadores;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.proyectoindividual.galeria.FragmentGaleriaExterior;
import com.example.proyectoindividual.galeria.FragmentGaleriaInterior;

public class ViewPagerAdapter extends FragmentStateAdapter {
    public ViewPagerAdapter(Fragment fragment) {
        super(fragment);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {

        if (position==0){
            return new FragmentGaleriaInterior();
        }else{
            return new FragmentGaleriaExterior();
        }
    }

    @Override
    public int getItemCount() {
        return 2;
    }
}

