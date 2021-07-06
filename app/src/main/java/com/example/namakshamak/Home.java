package com.example.namakshamak;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Home extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
    }

    public void gotocatbur(View view) {
        Intent iburr= new Intent(Home.this,cat_burr.class);
        startActivity(iburr);
    }

    public void gotocatnoodle(View view) {
        Intent inoo= new Intent(Home.this,cat_noodles.class);
        startActivity(inoo);
    }

    public void gotosalad(View view) {
        Intent isala = new Intent(Home.this,cat_salaa.class);
        startActivity(isala);
    }

    public void gotosub(View view) {
        Intent isub = new Intent(Home.this,cat_sub.class);
        startActivity(isub);
    }

    public void gotopan(View view) {
    }
}