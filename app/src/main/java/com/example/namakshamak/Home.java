package com.example.namakshamak;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Home extends AppCompatActivity {
    EditText searchtext;
    Button searchbt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        searchtext=findViewById(R.id.searchtext);

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
        Intent ipan= new Intent(Home.this,cat_paneer.class);
        startActivity(ipan);
    }

    public void gotosearch(View view) {
        String searchline = searchtext.getText().toString();
        if (searchline.isEmpty()) {
            Toast.makeText(Home.this, "Please Enter Something!", Toast.LENGTH_SHORT).show();
        } else {
            Intent isearch = new Intent();
            isearch.putExtra("searchline", searchline);
            startActivity(isearch);
        }
    }
}