package com.example.a03ejerciciosergio;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.TypedArray;
import android.os.Bundle;
import android.util.Log;
import android.widget.GridView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class PersonajesActivity extends AppCompatActivity {
    private GridView gvPersonajes = null;
    private String nombreAnime = "";
    private Bundle datos = null;
    private String[] personajesArray = null;
    private ArrayList<String> personajesAnimeSel = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personajes);

        personajesAnimeSel = new ArrayList<String>();

        personajesArray = getResources().getStringArray(R.array.personajes);
        gvPersonajes = findViewById(R.id.gvPersonajes);

        datos = getIntent().getExtras();
        nombreAnime = datos.getString("anime");

        for (String personaje : personajesArray) {
            String[] personajeSplit = personaje.split(" ");

            if (personajeSplit[0].equals(nombreAnime)) {
                personajesAnimeSel.add(personaje);

            }
        }

        gvPersonajes.setAdapter(new ImagePersonajesAdapter(getApplicationContext(), personajesAnimeSel));
    }

    private String[] separarString(String textoOriginal, String filtro) {
        return textoOriginal.split(filtro);
    }
}