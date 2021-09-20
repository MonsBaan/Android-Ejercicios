package com.example.navigationdrawer.ui.rojo;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.navigationdrawer.Alumnado;

public class RojoViewModel extends ViewModel {
    // TODO: Implement the ViewModel
    private MutableLiveData<Alumnado> alumnado;

    public RojoViewModel(){
        alumnado = new MutableLiveData<>();
        Alumnado alum = new Alumnado();
        alumnado.postValue(alum);
    }

    public MutableLiveData<Alumnado> getAlumnado() {
        return alumnado;
    }
}