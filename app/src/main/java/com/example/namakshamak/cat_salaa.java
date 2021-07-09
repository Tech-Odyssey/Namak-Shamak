package com.example.namakshamak;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class cat_salaa extends AppCompatActivity {
    RecyclerView recyclerView;
    String sn[],sr[],brr[];
    int images[]={R.drawable.salad,R.drawable.salad,R.drawable.salad,R.drawable.salad,R.drawable.salad,
            R.drawable.salad,R.drawable.salad,R.drawable.salad};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cat_salaa);
        recyclerView= findViewById(R.id.recyclerView);
        sn=getResources().getStringArray(R.array.namsala);
        sr=getResources().getStringArray(R.array.recsala);
        brr=getResources().getStringArray(R.array.recsalarec);
        Myadaptar myadaptar = new Myadaptar(this,sn,sr,images,brr);
        recyclerView.setAdapter(myadaptar);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}