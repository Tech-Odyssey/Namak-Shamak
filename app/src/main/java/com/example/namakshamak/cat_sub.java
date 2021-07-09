package com.example.namakshamak;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class cat_sub extends AppCompatActivity {
    RecyclerView recyclerView;
    String sun[],sur[],brr[];
    int images[]={R.drawable.subway,R.drawable.subway,R.drawable.subway,R.drawable.subway,
            R.drawable.subway,R.drawable.subway,R.drawable.subway,R.drawable.subway};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cat_sub);
        recyclerView= findViewById(R.id.recyclerView);
        sun=getResources().getStringArray(R.array.namsub);
        sur=getResources().getStringArray(R.array.recsub);
        brr=getResources().getStringArray(R.array.recsubrec);
        Myadaptar myadaptar = new Myadaptar(this,sun,sur,images,brr);
        recyclerView.setAdapter(myadaptar);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }
}