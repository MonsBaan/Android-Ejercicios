package com.example.a06dialogpersonalizado;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

public class ActivityRegister extends AppCompatActivity {
    private ListView lvUsers=null;
    private EditText btnUser, btnPass = null;
    private Button btnRegistrar = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
    }
}