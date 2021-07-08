package com.example.namakshamak;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intentBackgroundService = new Intent(this, PushNotifications.class);
        startService(intentBackgroundService);
    }


    public void onboarding(View view) {
        Intent intent = new Intent(MainActivity.this,Onboard.class);
        startActivity(intent);
    }
}