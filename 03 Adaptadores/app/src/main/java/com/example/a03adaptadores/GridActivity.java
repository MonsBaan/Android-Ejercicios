package com.example.a03adaptadores;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.app.ActivityOptionsCompat;
import androidx.core.util.Pair;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

public class GridActivity extends AppCompatActivity {

    private GridView gvPaisajes = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid);

        gvPaisajes = findViewById(R.id.gvPaisajes);
        gvPaisajes.setAdapter(new ImageAdapter(getApplicationContext(), getResources().obtainTypedArray(R.array.paisajes)));
        final GridActivity instance = this;

        gvPaisajes.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(instance, DetalleActivity.class);
                intent.putExtra("idFoto", i);
                ActivityOptionsCompat activityOptions = ActivityOptionsCompat.makeSceneTransitionAnimation(instance,
                        new Pair<>(view.findViewById(R.id.ivItemGrid), DetalleActivity.VIEW_NAME_HEADER_IMAGE));

                ActivityCompat.startActivity(instance, intent, activityOptions.toBundle());
            }
        });

    }
}