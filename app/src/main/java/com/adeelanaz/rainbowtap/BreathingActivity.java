package com.adeelanaz.rainbowtap;

import android.animation.ArgbEvaluator;
import android.animation.ValueAnimator;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class BreathingActivity extends AppCompatActivity {

    View breathingView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_breathing);
        TextView title = findViewById(R.id.featureTitle);
        title.setText("Breathing Exercise");

        breathingView = findViewById(R.id.breathingView);
        startBreathingAnimation();
    }

    private void startBreathingAnimation() {
        // Animate background color in and out
        int colorFrom = Utils.getRandomColor();
        int colorTo = Utils.getRandomColor();

        ValueAnimator colorAnimation = ValueAnimator.ofObject(new ArgbEvaluator(), colorFrom, colorTo);
        colorAnimation.setDuration(4000); // inhale/exhale duration
        colorAnimation.setRepeatCount(ValueAnimator.INFINITE);
        colorAnimation.setRepeatMode(ValueAnimator.REVERSE);

        colorAnimation.addUpdateListener(animator -> {
            if (breathingView != null) {
                breathingView.setBackgroundColor((int) animator.getAnimatedValue());
            }
        });

        colorAnimation.start();
    }
}