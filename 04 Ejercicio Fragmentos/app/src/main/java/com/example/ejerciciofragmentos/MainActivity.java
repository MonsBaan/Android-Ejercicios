package com.example.ejerciciofragmentos;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.example.ejerciciofragmentos.fragmentos.adaptadorTexto.FragmentoColores;
import com.example.ejerciciofragmentos.fragmentos.adaptadorTexto.FragmentoTexto;
import com.example.ejerciciofragmentos.fragmentos.IControlFragmentos;

public class MainActivity extends AppCompatActivity implements IControlFragmentos {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //CARGAMOS LOS 3 FRAGMENTOS

        //Fragmento ListView Colores

        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.LLColores, new FragmentoColores()).commit();


        //Fragmento Texto
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.LLTexto, new FragmentoTexto()).commit();
        /*
        //Fragmento Spinner
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.LLSpinner, new FragmentoSpinner()).commit();
                */

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menuDam:
                cambiarTexto("DAM");
                return true;
            case R.id.menuAsir:
                cambiarTexto("ASIR");
                return true;
            case R.id.menuSmr:
                cambiarTexto("SMR");
                return true;
        }
        cambiarTexto(item.toString());
        return super.onOptionsItemSelected(item);
    }


    @Override
    public void cambiarColor(int color) {
        Bundle bundle = new Bundle();
        bundle.putInt("color", color);

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.LLTexto, FragmentoTexto.newInstance(bundle)).commit();
    }

    @Override
    public void cambiarTexto(String texto) {
        Bundle bundle = new Bundle();
        bundle.putString("curso", texto);

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.LLTexto, FragmentoTexto.newInstance(bundle)).commit();
    }
}