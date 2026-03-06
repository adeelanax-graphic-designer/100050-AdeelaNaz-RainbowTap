package com.adeelanaz.rainbowtap;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class RhythmGameActivity extends AppCompatActivity {

    TextView txtScore;
    View tapArea;
    int score = 0;
    Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rhythm_game);

        txtScore = findViewById(R.id.txtScore);
        tapArea = findViewById(R.id.tapArea);

        tapArea.setOnClickListener(this::onClick);

        // Automatic rhythm pulse
        handler.postDelayed(this::pulseColor, 1000);
    }

    private void pulseColor(){
        tapArea.setBackgroundColor(Utils.getRandomColor());
        handler.postDelayed(this::pulseColor, 1000);
    }

    private void onClick(View v) {
        score++;
        txtScore.setText(getString(R.string.score) + score);
        tapArea.setBackgroundColor(Utils.getRandomColor());
    }
}