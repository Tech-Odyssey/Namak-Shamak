package com.example.namakshamak;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Onboard extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_onboard);
    }

    public void gotologin(View view) {
        Intent i1= new Intent(Onboard.this,Login.class);
        startActivity(i1);
    }

    public void gotoregister(View view) {
        Intent i2= new Intent(Onboard.this,register.class);
        startActivity(i2);
    }
}