package com.example.a06dialogpersonalizado;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class CentralActivity extends AppCompatActivity {

    private Context context;
    private EditText etUser, etPass, etRePass = null;
    private Button btnRegistrar = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_central);
    }
}