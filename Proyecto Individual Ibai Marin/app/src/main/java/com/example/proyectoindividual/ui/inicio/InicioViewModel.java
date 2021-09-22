package com.example.proyectoindividual.ui.inicio;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class InicioViewModel extends ViewModel {
    // TODO: Implement the ViewModel
    private MutableLiveData<String> cursos;

    public InicioViewModel(){
        cursos = new MutableLiveData<>();
    }
}