package com.example.a06dialogpersonalizado;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.speech.RecognitionService;
import android.speech.RecognizerIntent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;

public class VozActivity extends AppCompatActivity {
    private Button btnVoz, btnWeb;
    private EditText etTexto;
    public static final int VOZ = 1;
    public static final int WEB = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_voz);
        btnVoz = findViewById(R.id.btnVoz);
        btnWeb = findViewById(R.id.btnWeb);
        etTexto = findViewById(R.id.etTexto);

        btnVoz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
                intent.putExtra(RecognizerIntent.EXTRA_PROMPT, "GUACAMOLE");
                intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
                startActivityForResult(intent, VOZ);
            }
        });
        btnWeb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                realizarAcciones(etTexto.getText().toString());
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        ArrayList<String> arrayResultado = new ArrayList<>();
        if (requestCode == VOZ && resultCode == RESULT_OK && data != null) {
            arrayResultado = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);

            etTexto.setText(arrayResultado.get(0));

        }
    }

    private void realizarAcciones(String s) {
        try {
            String palabraBuscar = URLEncoder.encode(s, "UTF-8");
            Uri uri = Uri.parse("https://www.google.es/search?q=" + s);
            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
            startActivity(intent);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

    }
}