package com.example.a02ejerciciohilos;

import android.content.res.TypedArray;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

public class CaballoCorriendo implements Runnable {
    private HiloDam2 hiloDam2 = null;

    public CaballoCorriendo(HiloDam2 hiloDam2) {
        this.hiloDam2 = hiloDam2;
    }

    @Override
    public void run() {
        int numFoto = 0;
        ProgressBar pbHilo = hiloDam2.getPbHilo();
        ImageView ivHilo = hiloDam2.getIvhilo();
        TextView tvHilo = hiloDam2.getTvHilo();
        TypedArray caballos = hiloDam2.getCaballos();
        tvHilo.setText("0%");
        pbHilo.setProgress(50);

        for (int i = 0; i <= 100; i++) {
            if (numFoto == 7) {
                numFoto = 0;
            } else {
                numFoto++;
            }
            ivHilo.setImageResource(caballos.getResourceId(numFoto ,-1));
            tvHilo.setText(i+"%");
            pbHilo.setProgress(i);



        }
    }
}
