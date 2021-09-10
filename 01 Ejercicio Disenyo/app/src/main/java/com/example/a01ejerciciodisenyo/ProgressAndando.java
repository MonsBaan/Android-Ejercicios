package com.example.a01ejerciciodisenyo;

import android.util.Log;
import android.widget.Toast;

public class ProgressAndando implements Runnable {
    private AsyntaskDam2 miActividad = null;

    public ProgressAndando(AsyntaskDam2 asyntaskDam2) {
        miActividad = asyntaskDam2;
    }

    @Override
    public void run() {
        int numFoto = 0;

        miActividad.getTexto().setText("0%");
        for (int i = 0; i < 100; i++) {
            //miActividad.getTexto().setText(i + "%");

            try {
                Thread.sleep(100);
                miActividad.getBarra().setProgress(i);
                if (numFoto >= 3) {
                    numFoto = 0;
                } else {
                    numFoto++;
                }
                miActividad.getImagenCentral().setImageResource(miActividad.getImagenes().getResourceId(numFoto, -1));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        //AQUI LLEGARA CUANDO TERMINE EL BUCLE
        miActividad.finish();
    }
}
