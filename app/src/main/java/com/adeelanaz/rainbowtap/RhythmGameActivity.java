package com.adeelanaz.rainbowtap;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class RhythmGameActivity extends AppCompatActivity {

    private TextView txtScore, txtSpeed, txtStatus;
    private View tapArea;
    private int score = 0;
    private int delay = 1000; // Start with 1 second delay
    private final Handler handler = new Handler(Looper.getMainLooper());
    
    private final Runnable rhythmRunnable = new Runnable() {
        @Override
        public void run() {
            pulseColor();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rhythm_game);

        txtScore = findViewById(R.id.txtScore);
        txtSpeed = findViewById(R.id.txtSpeed);
        txtStatus = findViewById(R.id.txtStatus);
        tapArea = findViewById(R.id.tapArea);

        tapArea.setOnClickListener(v -> handleTap());

        // Start rhythm pulse
        startRhythm();
    }

    private void startRhythm() {
        handler.postDelayed(rhythmRunnable, delay);
    }

    private void pulseColor() {
        if (!isFinishing()) {
            tapArea.setBackgroundColor(Utils.getRandomColor());
            animatePulse();
            handler.postDelayed(rhythmRunnable, delay);
        }
    }

    private void handleTap() {
        score++;
        txtScore.setText("Score: " + score);
        
        // Make it harder every 5 points
        if (score % 5 == 0 && delay > 300) {
            delay -= 100;
            updateSpeedText();
        }
        
        tapArea.setBackgroundColor(Utils.getRandomColor());
        txtStatus.setText("GREAT!");
    }

    private void updateSpeedText() {
        String speedLevel;
        if (delay > 700) speedLevel = "Normal";
        else if (delay > 400) speedLevel = "Fast!";
        else speedLevel = "ULTRA FAST!!";
        
        txtSpeed.setText("Speed: " + speedLevel);
    }

    private void animatePulse() {
        ScaleAnimation scale = new ScaleAnimation(1.0f, 1.1f, 1.0f, 1.1f, 
                Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        scale.setDuration(150);
        scale.setRepeatMode(Animation.REVERSE);
        scale.setRepeatCount(1);
        tapArea.startAnimation(scale);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        handler.removeCallbacks(rhythmRunnable);
    }
}
