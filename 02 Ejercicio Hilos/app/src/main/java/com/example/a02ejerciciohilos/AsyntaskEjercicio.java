package com.example.a02ejerciciohilos;

import android.os.AsyncTask;
import android.widget.Toast;

public class AsyntaskEjercicio extends AsyncTask<Void, Integer, Void> {
    private HiloDam2 hiloDam2 = null;

    public AsyntaskEjercicio(HiloDam2 hiloDam2) {
        this.hiloDam2 = hiloDam2;
    }

    @Override
    protected Void doInBackground(Void... voids) {
        int numFoto = 0;

        for (int i = 0; i <= 100; i++) {
            if (numFoto == 7) {
                numFoto = 0;
            } else {
                numFoto++;
            }
            publishProgress(numFoto, i);
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
        return null;
    }

    @Override
    protected void onPostExecute(Void unused) {
        super.onPostExecute(unused);
        Toast.makeText(hiloDam2, "Hilo Finalizado", Toast.LENGTH_SHORT).show();
        hiloDam2.finish();
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        super.onProgressUpdate(values);
        //AQUI MODIFICAMOS EL %
        hiloDam2.getTvHilo().setText(values[1] + "%");
        hiloDam2.getIvhilo().setImageResource(hiloDam2.getCaballos().getResourceId(values[0], -1));
        hiloDam2.getPbHilo().setProgress(values[1]);
        if (values[1] == 50){
            Toast.makeText(hiloDam2, "Hilo al 50%", Toast.LENGTH_SHORT).show();
        }
    }
}
