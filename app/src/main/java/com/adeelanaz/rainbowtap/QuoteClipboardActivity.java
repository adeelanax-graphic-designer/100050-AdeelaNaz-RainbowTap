package com.adeelanaz.rainbowtap;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class QuoteClipboardActivity extends AppCompatActivity {

    private EditText titleInput, quoteInput;
    private Button btnRed, btnBlue, btnGreen, btnSave;
    private TextView quoteTitle, quoteText;
    private LinearLayout quoteCard;

    private int selectedColor = Color.WHITE;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quote_clipboard);

        // Initialize Views
        titleInput = findViewById(R.id.titleInput);
        quoteInput = findViewById(R.id.quoteInput);
        btnRed = findViewById(R.id.btnRed);
        btnBlue = findViewById(R.id.btnBlue);
        btnGreen = findViewById(R.id.btnGreen);
        btnSave = findViewById(R.id.btnSaveQuote);
        quoteTitle = findViewById(R.id.quoteTitle);
        quoteText = findViewById(R.id.quoteText);
        quoteCard = findViewById(R.id.quoteCard);

        // Color Button Listeners
        btnRed.setOnClickListener(v -> {
            selectedColor = Color.parseColor("#FFCDD2"); // Light Red
            quoteCard.setBackgroundColor(selectedColor);
        });

        btnBlue.setOnClickListener(v -> {
            selectedColor = Color.parseColor("#BBDEFB"); // Light Blue
            quoteCard.setBackgroundColor(selectedColor);
        });

        btnGreen.setOnClickListener(v -> {
            selectedColor = Color.parseColor("#C8E6C9"); // Light Green
            quoteCard.setBackgroundColor(selectedColor);
        });

        // Save Button Listener
        btnSave.setOnClickListener(v -> {
            String title = titleInput.getText().toString().trim();
            String quote = quoteInput.getText().toString().trim();

            if (title.isEmpty() || quote.isEmpty()) {
                Toast.makeText(this, "Please enter both title and quote", Toast.LENGTH_SHORT).show();
                return;
            }

            quoteTitle.setText(title);
            quoteText.setText(quote);
            quoteCard.setBackgroundColor(selectedColor);
            
            Toast.makeText(this, "Quote Card Created!", Toast.LENGTH_SHORT).show();
        });
    }
}
