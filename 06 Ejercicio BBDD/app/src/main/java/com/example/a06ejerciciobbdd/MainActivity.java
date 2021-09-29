package com.example.a06ejerciciobbdd;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.Toast;

import com.example.a06ejerciciobbdd.adaptadores.PersonajesAdapter;
import com.example.a06ejerciciobbdd.bbdd.AppDatabase;
import com.example.a06ejerciciobbdd.bbdd.AppExecutors;
import com.example.a06ejerciciobbdd.model.Personaje;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private Button btnAddPj = null;
    private GridView gvMain = null;

    private int identificador = -1;
    private Intent intent = null;
    private AppDatabase mDb = null;

    private PersonajesAdapter personajesAdapter = null;

    private GalleryDialogFragment dialog = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnAddPj = findViewById(R.id.btnAñadirPersonaje);
        gvMain = findViewById(R.id.gvMain);

        mDb = AppDatabase.getInstance(getApplicationContext());
        intent = getIntent();
        Toast.makeText(getApplicationContext(), "Base de Datos Lista", Toast.LENGTH_SHORT).show();

        personajesAdapter = new PersonajesAdapter(getApplicationContext(), 1);
        gvMain.setAdapter(personajesAdapter);

        btnAddPj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog = new GalleryDialogFragment();
                dialog.show(getSupportFragmentManager(), "Añadir");
            }
        });

        final AlertDialog.Builder alerta = new AlertDialog.Builder(this);

        gvMain.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                alerta.setTitle("Cuidado!!");
                alerta.setMessage("Quieres Borrar Este Personaje?");
                final int idEliminar = ((Personaje)personajesAdapter.getItem(i)).getId();
                alerta.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(getApplicationContext(), "Personaje no Eliminado", Toast.LENGTH_SHORT).show();
                    }
                });
                alerta.setPositiveButton("Si", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                      eliminar(idEliminar);
                    }
                });
                alerta.show();
                return false;
            }
        });
    }

    private void eliminar(int id) {
        AppExecutors.getInstance().getDiskIP().execute(new Runnable() {
            @Override
            public void run() {
                Personaje personaje = mDb.personajeDao().loadPersonajeById(id);
                mDb.personajeDao().deletePersonaje(personaje);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        consultar();
    }

    private void consultar() {
        mDb.personajeDao().loadAllPersonajes().observe(this, new Observer<List<Personaje>>() {
            @Override
            public void onChanged(List<Personaje> personajes) {
                personajesAdapter.setArrayPersonajes(personajes);
            }
        });
    }
}