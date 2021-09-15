package com.example.a03ejerciciosergio;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private ListView lvMain = null;
    private String[] datos = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvMain = findViewById(R.id.lvMain);
        datos = getResources().getStringArray(R.array.animes);
        LvMainAdapter lvMainAdapter = new LvMainAdapter(this, R.layout.activity_main, datos);

        lvMain.setAdapter(lvMainAdapter);


        lvMain.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String[] animeNombreSplit = null;
                String animeNombreTrim = "";
                animeNombreSplit = separarString(adapterView.getItemAtPosition(i - 1).toString(), " ");
                for (int j = 0; j < animeNombreSplit[0].length(); j++) {
                    if (animeNombreSplit[0].charAt(j) != '_'){
                        animeNombreTrim += animeNombreSplit[0].charAt(j);
                    }
                }

                Bundle bundle = new Bundle();
                bundle.putString("anime", animeNombreTrim);
                Intent intent = new Intent(getApplicationContext(), PersonajesActivity.class);
                intent.putExtras(bundle);

                //ACTIVIDAD PERSONAJESACTIVITY
                startActivity(intent);
            }
        });
    }

    private String[] separarString(String textoOriginal, String filtro) {
        return textoOriginal.split(filtro);
    }


}