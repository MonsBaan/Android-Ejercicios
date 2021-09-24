package com.example.proyectoindividual.galeria;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.proyectoindividual.R;

// Instances of this class are fragments representing a single
// object in our collection.
public class ViewPagerFragments extends Fragment {
    public static final String ARG_OBJECT = "object";

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        if (getArguments().getInt(ARG_OBJECT)==1){
            return inflater.inflate(R.layout.fragment_galeria_interior, container, false);
        }else{
            return inflater.inflate(R.layout.fragment_galeria_exterior, container, false);

        }
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        Bundle args = getArguments();


    }
}
