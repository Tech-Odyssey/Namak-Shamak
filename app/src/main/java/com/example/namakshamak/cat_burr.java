package com.example.namakshamak;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class cat_burr extends AppCompatActivity {
    RecyclerView recyclerView;
    String bn[],br[];
    int images[]= {R.drawable.burger,R.drawable.burger,R.drawable.burger,R.drawable.burger,R.drawable.burger,R.drawable.burger,R.drawable.burger};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cat_burr);

        recyclerView= findViewById(R.id.recyclerView);

        bn=getResources().getStringArray(R.array.namburger);
        br=getResources().getStringArray(R.array.recburger);
        Myadaptar myadaptar = new Myadaptar(this,bn,br,images);

        recyclerView.setAdapter(myadaptar);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}