package com.farshadfard.helloworldsematec;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d("activityLog", "onCreate: Called");
    }

    @Override
    protected void onStart() {
        super.onStart();

        Log.d("activityLog", "onStart: Called");
    }

    @Override
    protected void onResume() {
        super.onResume();

        Log.d("activityLog", "onResume: Called");

    }

    @Override
    protected void onPause() {
        super.onPause();

        Log.d("activityLog", "onPause: Called");

    }

    @Override
    protected void onStop() {
        super.onStop();

        Log.d("activityLog", "onStop: Called");

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        Log.d("activityLog", "onDestroy: Called");

    }

    @Override
    protected void onRestart() {
        super.onRestart();

        Log.d("activityLog", "onRestart: Called");

    }
}
