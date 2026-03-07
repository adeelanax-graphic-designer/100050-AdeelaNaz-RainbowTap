package com.adeelanaz.rainbowtap;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class ProfileActivity extends AppCompatActivity {

    private TextView txtStreak, txtPoints, txtAchievements;
    private Button btnReset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        // Initialize Views
        txtStreak = findViewById(R.id.txtStreak);
        txtPoints = findViewById(R.id.txtPoints);
        txtAchievements = findViewById(R.id.txtAchievements);
        btnReset = findViewById(R.id.btnReset);

        loadProfileData();

        btnReset.setOnClickListener(v -> {
            resetProfileData();
            loadProfileData();
            Toast.makeText(this, "Progress Reset!", Toast.LENGTH_SHORT).show();
        });
    }

    private void loadProfileData() {
        SharedPreferences prefs = getSharedPreferences("RainbowTapPrefs", MODE_PRIVATE);
        int streak = prefs.getInt("streak", 0);
        int points = prefs.getInt("points", 0);

        txtStreak.setText("Daily Streak: " + streak + " Days");
        txtPoints.setText("Total Points: " + points);
    }

    private void resetProfileData() {
        SharedPreferences prefs = getSharedPreferences("RainbowTapPrefs", MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putInt("streak", 0);
        editor.putInt("points", 0);
        editor.apply();
    }
}
