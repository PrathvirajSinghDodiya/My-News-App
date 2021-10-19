package com.example.mynewsapp;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.ViewHolder> {


    ArrayList<NEWS> arrayList;
    Context context;
    public CustomAdapter(ArrayList<NEWS> arrayList, Context context) {
        this.arrayList = arrayList;
        this.context = context;
    }
    @NonNull
    @Override
    public CustomAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.text_raw_item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomAdapter.ViewHolder holder, int position) {
        holder.title.setText(arrayList.get(position).getTitle());
        holder.despcription.setText(arrayList.get(position).getDesc());
        String imgurl = arrayList.get(position).getImg();
        Picasso.get().load(imgurl).into(holder.image);
        String str = arrayList.get(position).getPublish();
      holder.published.setText(str.substring(0,str.indexOf("T")));

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView title,despcription,published;
        private ImageView image;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            title = itemView.findViewById(R.id.textView);
            despcription = itemView.findViewById(R.id.descriptionNewOne);
            image = itemView.findViewById(R.id.imageViewNew);
            published = itemView.findViewById(R.id.datetime);
        }

        @Override
        public void onClick(View v) {
            int index = this.getAdapterPosition();
            Toast.makeText(context, "you Clicked on :-"+index, Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(context,MainActivity2.class);
            intent.putExtra("one",arrayList.get(index).getTitle());
            intent.putExtra("two",arrayList.get(index).getImg());
            intent.putExtra("three",arrayList.get(index).getContent());
            intent.putExtra("four",arrayList.get(index).getDesc());
            intent.putExtra("five",arrayList.get(index).getUrl());
            context.startActivity(intent);

        }
    }
}