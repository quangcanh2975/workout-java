package com.hfad.workout;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.os.Handler;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class Stopwatch extends Fragment implements View.OnClickListener {

    private int seconds = 0;
    private boolean isRunning = false;
    private boolean isStarted = false;

    public Stopwatch() {
        // Required empty public constructor
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button_start:
                onClickStart(view);
                break;

            case R.id.button_stop:
                onClickStop(view);
                break;
            case R.id.button_reset:
                onClickReset(view);
                break;
        }
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState != null) {
            seconds = savedInstanceState.getInt("seconds");
            isStarted = savedInstanceState.getBoolean("isStarted");
            isRunning = savedInstanceState.getBoolean("isRunning");
            if (isStarted) {
                isRunning = true;
            }
        }

    }


    public void onClickStart(View view) {
        isRunning = true;
    }

    public void onClickStop(View view) {
        isStarted = true;
        isRunning = false;
    }

    public void onClickReset(View view) {
        seconds = 0;
        isRunning = false;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View layout = inflater.inflate(R.layout.fragment_stopwatch, container, false);
        runTimer(layout);

        Button startButton = (Button) layout.findViewById(R.id.button_start);
        startButton.setOnClickListener(this);
        Button stopButton = (Button) layout.findViewById(R.id.button_stop);
        stopButton.setOnClickListener(this);
        Button resetButton = (Button) layout.findViewById(R.id.button_reset);
        resetButton.setOnClickListener(this);

        return layout;
    }

    private void runTimer(View view) {
        final TextView timeView = (TextView) view.findViewById(R.id.time_view);
        final Handler handler = new Handler();
        handler.post(new Runnable() {
            @Override
            public void run() {
                int hours = seconds / 3600;
                int minutes = (seconds % 3600) / 60;
                int secs = seconds % 60;
                String time = String.format("%d:%02d:%02d", hours, minutes, secs);
                timeView.setText(time);
                if (isRunning) {
                    seconds++;
                }
                handler.postDelayed(this, 1000);
            }
        });
    }

    @Override
    public void onPause() {
        super.onPause();
        isStarted = isRunning;
        isRunning = false;
    }

    @Override
    public void onResume() {
        super.onResume();
        if (isStarted) {
            isRunning = true;
        }
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("seconds", seconds);
        outState.putBoolean("isRunning", isRunning);
        outState.putBoolean("isStarted", isStarted);
    }
}