package com.example.a01ejerciciodisenyo;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class ActivityFrame extends AppCompatActivity {
    private ImageView ivFrame = null;
    private Button btnPlay, btnStop, btnBack = null;
    private AnimationDrawable frame = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frame);
        ivFrame = findViewById(R.id.ivFrame);
        btnPlay = findViewById(R.id.btnPlay);
        btnStop = findViewById(R.id.btnStop);
        btnBack = findViewById(R.id.btnBack);

        ivFrame.setVisibility(ImageView.VISIBLE);
        ivFrame.setBackgroundResource(R.drawable.framebyframe);
        frame = (AnimationDrawable) ivFrame.getBackground();

        btnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!frame.isRunning()){
                    frame.start();
                }
            }
        });
        btnStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(frame.isRunning()){
                    frame.stop();
                }
            }
        });
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();

            }
        });
    }
}