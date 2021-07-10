package com.example.namakshamak;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class cat_noodles extends AppCompatActivity {
     RecyclerView recyclerView;
     String nn[],sr[],brr[];
    int images1[]={R.drawable.noodles,R.drawable.noodles,R.drawable.noodles,R.drawable.noodles,R.drawable.noodles,R.drawable.noodles,R.drawable.noodles};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cat_noodles);
        recyclerView=findViewById(R.id.recyclerView1);
        nn=getResources().getStringArray(R.array.namnoodles);
        sr=getResources().getStringArray(R.array.recNoodles);
        brr=getResources().getStringArray(R.array.recNoodlesrec);
        Myadaptar myadaptar = new Myadaptar(this,nn,sr,images1,brr);
        recyclerView.setAdapter(myadaptar);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}