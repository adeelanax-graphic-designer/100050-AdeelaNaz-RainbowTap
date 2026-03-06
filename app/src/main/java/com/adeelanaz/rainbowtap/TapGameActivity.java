package com.adeelanaz.rainbowtap;

import android.os.Bundle;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class TapGameActivity extends AppCompatActivity {

    int score = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tap_game);
        TextView title = findViewById(R.id.featureTitle);
        title.setText("Tap Speed Game");



        TextView txtScore = findViewById(R.id.txtScore);
        FrameLayout tapArea = findViewById(R.id.tapArea);

        tapArea.setOnClickListener(v -> {
            score++;
            txtScore.setText("Score: " + score);
            tapArea.setBackgroundColor(Utils.getRandomColor());
        });
    }
}