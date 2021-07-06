package com.example.namakshamak;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

public class Myadaptar extends RecyclerView.Adapter<Myadaptar.Myviewholder> {

    String data1[], data2[];
    int images[];
    Context context;

    public Myadaptar(Context ct, String bn[], String br[], int img[]){
    context=ct;
    data1=bn;
    data2=br;
    images=img;
    }

    @NonNull

    @Override
    public Myviewholder onCreateViewHolder(@NonNull  ViewGroup parent, int viewType) {
        LayoutInflater inflater= LayoutInflater.from(context);
        View view= inflater.inflate(R.layout.myrow,parent,false);

        return new Myviewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull  Myadaptar.Myviewholder holder, int position) {
        holder.text1.setText(data1[position]);
        holder.text2.setText(data2[position]);
        holder.myimageview.setImageResource(images[position]);

        holder.mainlayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent12= new Intent(context,detailed.class);
                intent12.putExtra("data1",data1[position]);
                intent12.putExtra("data2",data2[position]);
                intent12.putExtra("images",images[position]);
                context.startActivity(intent12);
            }
        });
    }

    @Override
    public int getItemCount() {
        return data1.length;
    }

    public class Myviewholder extends  RecyclerView.ViewHolder{

         TextView text1,text2 ;
         ImageView myimageview;
         ConstraintLayout mainlayout;
        public Myviewholder(@NonNull  View itemView) {
            super(itemView);
            text1=itemView.findViewById(R.id.itemname);
            text2=itemView.findViewById(R.id.item12);
            myimageview=itemView.findViewById(R.id.myimageview);
            mainlayout=itemView.findViewById(R.id.mainlayout);
        }
    }
}
