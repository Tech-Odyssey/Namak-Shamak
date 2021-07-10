package com.example.namakshamak;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class cat_paneer extends AppCompatActivity {
    RecyclerView recyclerView;
    String pn[],pr[],brr[];
    int images[]={R.drawable.paneer,R.drawable.paneer,R.drawable.paneer,R.drawable.paneer,
            R.drawable.paneer};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cat_paneer);
        recyclerView= findViewById(R.id.recyclerView);
        pn=getResources().getStringArray(R.array.nampan);
        pr=getResources().getStringArray(R.array.recpan);
        brr=getResources().getStringArray(R.array.recpanrec);
        Myadaptar myadaptar = new Myadaptar(this,pn,pr,images,brr);
        recyclerView.setAdapter(myadaptar);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}