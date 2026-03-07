package com.adeelanaz.rainbowtap;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button btnTapGame = findViewById(R.id.btnTapGame);

        Button btnColorMixer = findViewById(R.id.btnColorMixer);
        Button btnRhythmGame = findViewById(R.id.btnRhythmGame);
        Button btnProfile = findViewById(R.id.btnProfile);
        Button btnQuotes = findViewById(R.id.btnQuotes);
        Button btnQuoteClipboard = findViewById(R.id.btnQuoteClipboard);

        btnQuoteClipboard.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, QuoteClipboardActivity.class);
            startActivity(intent);
        });

        btnQuotes.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, QuotesActivity.class);
            startActivity(intent);
        });

        btnTapGame.setOnClickListener(v -> startActivity(new Intent(this, TapGameActivity.class)));

        btnColorMixer.setOnClickListener(v -> startActivity(new Intent(this, ColorMixerActivity.class)));
        btnRhythmGame.setOnClickListener(v -> startActivity(new Intent(this, RhythmGameActivity.class)));
        btnProfile.setOnClickListener(v -> startActivity(new Intent(this, ProfileActivity.class)));
    }
}