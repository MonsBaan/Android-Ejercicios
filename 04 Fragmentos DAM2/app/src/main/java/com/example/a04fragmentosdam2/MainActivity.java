package com.example.a04fragmentosdam2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.example.a04fragmentosdam2.fragmentos.FragmentoAbajo;
import com.example.a04fragmentosdam2.fragmentos.FragmentoArriba;
import com.example.a04fragmentosdam2.fragmentos.IControlFragmentos;

public class MainActivity extends AppCompatActivity implements IControlFragmentos {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //CARGAMOS LOS 2 FRAGMENTOS
        getSupportFragmentManager()
                .beginTransaction().add(R.id.contenedor1, new FragmentoArriba()).commit();


        Bundle bundle = new Bundle();
        bundle.putString("saludo", "Esto Funciona");

        getSupportFragmentManager()
                .beginTransaction().add(R.id.contenedor2, FragmentoAbajo.newInstance(bundle)).commit();
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
            case R.id.rojo:
                cambiarColor(Color.RED);
                return true;
            case R.id.verde:
                cambiarColor(Color.GREEN);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void cambiarColor(int color) {
        Bundle bundle = new Bundle();
        bundle.putInt("color", color);

        getSupportFragmentManager()
                .beginTransaction().replace(R.id.contenedor2, FragmentoAbajo.newInstance(bundle)).commit();
    }

    @Override
    public void cambiarTexto(String texto) {
        Bundle bundle = new Bundle();
        bundle.putString("texto", texto);

        getSupportFragmentManager()
                .beginTransaction().replace(R.id.contenedor2, FragmentoAbajo.newInstance(bundle)).commit();
    }
}