package com.hfad.workout;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class Stopwatch extends Fragment {

    private int seconds = 0;
    private boolean isRunning = false;
    private boolean isStarted = false;

    public Stopwatch() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public void start() {
        isRunning = true;
    }

    public void stop() {
        isRunning = false;
    }

    public void reset() {
        seconds = 0;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        TextView textView = (TextView) getView().findViewById(R.id.stopwatch_number);
        textView.getText();
        return inflater.inflate(R.layout.fragment_stopwatch, container, false);
    }
}