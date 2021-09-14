package com.example.a03adaptadores;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class ListActivity extends AppCompatActivity {
    private ArrayList<CompaniaTelefonica> companias = new ArrayList<>();
    private ListView listaCompanias;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        rellenarCompanias();
        CompaniasAdapter adapter = new CompaniasAdapter(this, companias);
        listaCompanias = findViewById(R.id.lvTelefonicas);
        listaCompanias.setAdapter(adapter);
    }

    private void rellenarCompanias(){
        companias.add(new CompaniaTelefonica("Movistar", R.drawable.a1, 86));
        companias.add(new CompaniaTelefonica("Euskaltel", R.drawable.a2, 14));
        companias.add(new CompaniaTelefonica("Vodafone", R.drawable.andando1, 53));
        companias.add(new CompaniaTelefonica("Yoigo", R.drawable.ic_launcher_background, 65));
    }
}