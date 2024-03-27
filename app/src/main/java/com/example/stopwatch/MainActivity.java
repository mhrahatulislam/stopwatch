package com.example.stopwatch;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Chronometer;

public class MainActivity extends AppCompatActivity {

    private AppCompatButton start_btn;
    private AppCompatButton push_btn;
    private AppCompatButton reset_btn;
    private Chronometer diply_time;
    private long stopTime=0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        start_btn=findViewById(R.id.start_button);
        push_btn=findViewById(R.id.push_button);
        diply_time=findViewById(R.id.chronometer_display);
        reset_btn=findViewById(R.id.rester_button);

        start_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                diply_time.setBase(SystemClock.elapsedRealtime()+stopTime);
                diply_time.start();
                start_btn.setVisibility(View.INVISIBLE);
                push_btn.setVisibility(View.VISIBLE);
            }
        });

        push_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stopTime=diply_time.getBase()-SystemClock.elapsedRealtime();
                diply_time.stop();
                start_btn.setVisibility(View.VISIBLE);
                push_btn.setVisibility(View.INVISIBLE);
            }
        });


        reset_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                diply_time.setBase(SystemClock.elapsedRealtime());
                stopTime=0;
                diply_time.stop();
                start_btn.setVisibility(View.VISIBLE);
                push_btn.setVisibility(View.INVISIBLE);
            }
        });

    }
}