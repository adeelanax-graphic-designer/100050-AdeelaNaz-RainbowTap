package com.adeelanaz.rainbowtap;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ColorMixerActivity extends AppCompatActivity {

    View colorView;
    SeekBar seekRed, seekGreen, seekBlue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_color_mixer);
        TextView title = findViewById(R.id.featureTitle);
        title.setText("Background Color Changer");

        colorView = findViewById(R.id.colorView);
        seekRed = findViewById(R.id.seekRed);
        seekGreen = findViewById(R.id.seekGreen);
        seekBlue = findViewById(R.id.seekBlue);

        SeekBar.OnSeekBarChangeListener listener = new SeekBar.OnSeekBarChangeListener() {
            @Override public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) { updateColor(); }
            @Override public void onStartTrackingTouch(SeekBar seekBar) {}
            @Override public void onStopTrackingTouch(SeekBar seekBar) {}
        };

        seekRed.setOnSeekBarChangeListener(listener);
        seekGreen.setOnSeekBarChangeListener(listener);
        seekBlue.setOnSeekBarChangeListener(listener);

        // Set initial mood color
        String mood = getIntent().getStringExtra("mood");
        if(mood != null){
            switch(mood){
                case "Relax": colorView.setBackgroundColor(Color.BLUE); break;
                case "Focus": colorView.setBackgroundColor(Color.GREEN); break;
                case "Happy": colorView.setBackgroundColor(Color.YELLOW); break;
            }
        }
    }

    private void updateColor(){
        int r = seekRed.getProgress();
        int g = seekGreen.getProgress();
        int b = seekBlue.getProgress();
        colorView.setBackgroundColor(Color.rgb(r,g,b));
    }
}