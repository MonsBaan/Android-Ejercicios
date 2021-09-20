package com.example.navigationdrawer.ui.blanco;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class BlancoViewModel extends ViewModel {
    private MutableLiveData<String> mText;

    public BlancoViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Fragmento Blanco");
    }

    public LiveData<String> getmText() {
        return mText;
    }
}