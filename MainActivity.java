package com.vanibansal.stopwatch;

import android.os.Bundle;
import android.os.Handler;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    TextView tvTime;
    Button btnStart, btnStop, btnReset;
    Handler handler = new Handler();
    int seconds = 0;
    boolean isRunning = false;

    Runnable runnable = new Runnable() {
        @Override
        public void run() {
            seconds++;
            updateDisplay();
            handler.postDelayed(this, 1000);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvTime = findViewById(R.id.tvTime);
        btnStart = findViewById(R.id.btnStart);
        btnStop = findViewById(R.id.btnStop);
        btnReset = findViewById(R.id.btnReset);

        btnStart.setOnClickListener(v -> {
            if (!isRunning) {
                isRunning = true;
                handler.postDelayed(runnable, 1000);
                btnStart.setEnabled(false);
                btnStop.setEnabled(true);
            }
        });

        btnStop.setOnClickListener(v -> {
            if (isRunning) {
                isRunning = false;
                handler.removeCallbacks(runnable);
                btnStart.setEnabled(true);
                btnStop.setEnabled(false);
            }
        });

        btnReset.setOnClickListener(v -> {
            isRunning = false;
            handler.removeCallbacks(runnable);
            seconds = 0;
            updateDisplay();
            btnStart.setEnabled(true);
            btnStop.setEnabled(false);
        });
    }

    void updateDisplay() {
        int h = seconds / 3600;
        int m = (seconds % 3600) / 60;
        int s = seconds % 60;
        tvTime.setText(String.format("%02d:%02d:%02d", h, m, s));
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (isRunning) handler.removeCallbacks(runnable);
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (isRunning) handler.postDelayed(runnable, 1000);
    }
}