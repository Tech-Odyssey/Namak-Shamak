package com.example.namakshamak;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class detailed extends AppCompatActivity {
    ImageView mainimageview;
    TextView title,time,det;
    String data1,data2,data3;
    int images;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailed);
        mainimageview=findViewById(R.id.mainimage);
        title=findViewById(R.id.mainname);
        time=findViewById(R.id.main2);
        det=findViewById(R.id.main3);
        getdata();
        setdata();
    }
private void getdata(){
        if(getIntent().hasExtra("images")&& getIntent().hasExtra("data1")&&
                getIntent().hasExtra("data2") && getIntent().hasExtra("data3")){
            data1=getIntent().getStringExtra("data1");
            data2=getIntent().getStringExtra("data2");
            images=getIntent().getIntExtra("images", 1);
            data3=getIntent().getStringExtra("data3");
        }
        else {
            Toast.makeText(this, "NO Data", Toast.LENGTH_SHORT).show();
        }
}
private void setdata(){
title.setText(data1);
time.setText(data2);
mainimageview.setImageResource(images);
det.setText(data3);
}
}