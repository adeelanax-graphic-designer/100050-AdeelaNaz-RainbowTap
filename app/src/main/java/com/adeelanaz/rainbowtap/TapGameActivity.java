package com.adeelanaz.rainbowtap;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class TapGameActivity extends AppCompatActivity {

    private int score = 0;
    private boolean gameActive = false;
    private TextView txtScore, txtTimer;
    private FrameLayout tapArea;
    private Button btnStart;
    private CountDownTimer timer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tap_game);

        txtScore = findViewById(R.id.txtScore);
        txtTimer = findViewById(R.id.txtTimer);
        tapArea = findViewById(R.id.tapArea);
        btnStart = findViewById(R.id.btnStart);

        tapArea.setOnClickListener(v -> {
            if (gameActive) {
                score++;
                txtScore.setText("Taps: " + score);
                tapArea.setBackgroundColor(Utils.getRandomColor());
            }
        });

        btnStart.setOnClickListener(v -> startGame());
    }

    private void startGame() {
        score = 0;
        gameActive = true;
        txtScore.setText("Taps: 0");
        btnStart.setVisibility(View.GONE);

        timer = new CountDownTimer(10000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                txtTimer.setText("Time: " + (millisUntilFinished / 1000) + "s");
            }

            @Override
            public void onFinish() {
                gameActive = false;
                txtTimer.setText("Time: 0s");
                btnStart.setVisibility(View.VISIBLE);
                btnStart.setText("TRY AGAIN");
                showResult();
            }
        }.start();
    }

    private void showResult() {
        String rank;
        if (score > 60) rank = "LEGENDARY!";
        else if (score > 40) rank = "PRO!";
        else if (score > 20) rank = "BEGINNER";
        else rank = "KEEP TRYING!";

        Toast.makeText(this, "Game Over!\nScore: " + score + "\nRank: " + rank, Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (timer != null) timer.cancel();
    }
}
