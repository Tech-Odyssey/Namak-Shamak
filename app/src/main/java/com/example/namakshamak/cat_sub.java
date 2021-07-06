package com.example.namakshamak;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class cat_sub extends AppCompatActivity {
    RecyclerView recyclerView;
    String sn[],sr[];
    int images[]={R.drawable.subway,R.drawable.subway,R.drawable.subway,R.drawable.subway,
            R.drawable.subway,R.drawable.subway,R.drawable.subway,R.drawable.subway};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cat_sub);
        recyclerView= findViewById(R.id.recyclerView);
        sn=getResources().getStringArray(R.array.namsub);
        sr=getResources().getStringArray(R.array.recsub);

        Myadaptar myadaptar = new Myadaptar(this,sn,sr,images);
        recyclerView.setAdapter(myadaptar);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }
}