package com.example.a01ejerciciodisenyo;

import android.util.Log;
import android.widget.Toast;

public class AnimacionCaballo implements Runnable{
    private CaballoPantalla parent;
    public AnimacionCaballo(CaballoPantalla caballoPantalla) {
        parent = caballoPantalla;
    }
    @Override
    public void run() {
        int frame = 0;
        parent.getPorcentaje().setText("0%");
        for(int i=0; i <= 100; i++){
            try {
                Thread.sleep(100);
                parent.getBarra().setProgress(i);
                if (frame > 8){
                    frame = 0;
                }else{
                    frame++;
                }
                //parent.getImgCaballo().setImageResource(parent.getFrames().getResourceId(frame, -1));

                parent.getImgCaballo().setImageResource(parent.getFrames().getResourceId(frame, -1));
                parent.getPorcentaje().setText(i+"%");



            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
