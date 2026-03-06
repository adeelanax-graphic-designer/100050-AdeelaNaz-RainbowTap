package com.adeelanaz.rainbowtap;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class ProfileActivity extends AppCompatActivity {

    TextView txtStreak, txtPoints, txtAchievements;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        txtStreak = findViewById(R.id.txtStreak);
        txtPoints = findViewById(R.id.txtPoints);
        txtAchievements = findViewById(R.id.txtAchievements);

        SharedPreferences prefs = getSharedPreferences("RainbowTapPrefs", MODE_PRIVATE);
        int streak = prefs.getInt("streak", 0);
        int points = prefs.getInt("points", 0);

        txtStreak.setText("Daily Streak: " + streak);
        txtPoints.setText("Points: " + points);
        txtAchievements.setText("Achievements:\n- First 100 taps\n- 7-day streak\n- Mood Master");
    }
}