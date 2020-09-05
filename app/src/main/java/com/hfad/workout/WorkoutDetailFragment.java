package com.hfad.workout;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class WorkoutDetailFragment extends Fragment {
    private long workoutId;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (savedInstanceState != null) {
            workoutId = savedInstanceState.getLong("workoutId");
        }
        return inflater.inflate(R.layout.fragment_workout_detail, container, false); // tell android which fragement to use
    }

    @Override
    public void onStart() {
        super.onStart();
        View view = (View) getView();
        if (view != null) {
            Workout workout = Workout.workouts[(int) workoutId];

            TextView name = (TextView) view.findViewById(R.id.textTitle);
            name.setText(workout.getName());

            TextView description = (TextView) view.findViewById(R.id.textDescription);
            description.setText(workout.getDescription());

        }
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putLong("workoutId", workoutId);
    }

    public void setWorkout(long id) {
        this.workoutId = id;
    }
}