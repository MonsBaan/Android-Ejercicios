package com.example.a01ejerciciodisenyo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageButton button = (ImageButton)findViewById(R.id.imgBtnCalendario);
        button.setOnClickListener(this::onClick);
    }


    public void onClick(View v){
        Toast.makeText(this, "Cagaste Guacho",Toast.LENGTH_LONG).show();
    }




    /* Toast OnClick activity_main.xml

    public void toastMsg(View view) {
        Toast toast = Toast.makeText(this, "Cagaste Guacho",Toast.LENGTH_LONG);
        toast.show();
    }*/
}