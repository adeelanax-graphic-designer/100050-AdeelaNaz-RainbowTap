package com.adeelanaz.rainbowtap;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class QuotesActivity extends AppCompatActivity {

    TextView quoteText;
    Button btnGenerate, btnShare;

    String[] quotes = {
            "Believe in yourself and all that you are.",
            "Success comes from hard work.",
            "Every day is a second chance.",
            "Dream big and dare to fail.",
            "Stay positive and keep going.",
            "Great things take time.",
            "Never stop learning.",
            "Your only limit is your mind."
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quotes);

        quoteText = findViewById(R.id.quoteText);
        btnGenerate = findViewById(R.id.btnGenerate);
        btnShare = findViewById(R.id.btnShare);

        btnGenerate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Random random = new Random();
                int index = random.nextInt(quotes.length);
                quoteText.setText(quotes[index]);
            }
        });

        btnShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent shareIntent = new Intent(Intent.ACTION_SEND);
                shareIntent.setType("text/plain");
                shareIntent.putExtra(Intent.EXTRA_TEXT, quoteText.getText().toString());
                startActivity(Intent.createChooser(shareIntent, "Share Quote"));
            }
        });

    }
}