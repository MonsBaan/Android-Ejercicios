package com.example.navigationdrawer.ui.azul;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.navigationdrawer.Alumno;

public class FragmentoAzulViewModel extends ViewModel {
    // TODO: Implement the ViewModel
    private MutableLiveData<Alumno> alumno;

    public FragmentoAzulViewModel() {
        alumno = new MutableLiveData<>();
        alumno.postValue(new Alumno("probando", "algo", "distinto"));
    }

    public MutableLiveData<Alumno> getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = new MutableLiveData<>();
        this.alumno.postValue(alumno);
    }
}