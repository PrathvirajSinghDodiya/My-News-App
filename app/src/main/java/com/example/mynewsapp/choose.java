package com.example.mynewsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.TextView;


public class choose extends AppCompatActivity {
    LinearLayout textViewE,textViewS,textViewH,textViewSp,textViewT,textViewB;
    Animation animation;
    LinearLayout linearLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose);
        textViewB = findViewById(R.id.linearBusiness);
        textViewH = findViewById(R.id.linearHealth);
        textViewSp = findViewById(R.id.linearSports);
        textViewS = findViewById(R.id.linearScience);
        textViewT = findViewById(R.id.linearTechnology);
        textViewE = findViewById(R.id.linearEntrtnmnt);
        linearLayout  = findViewById(R.id.linearCategory);
        Intent sendNum = new Intent(choose.this,MainActivity.class);
        animation = AnimationUtils.loadAnimation(this,R.anim.bottom_anim);
        linearLayout.setAnimation(animation);
        textViewE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendNum.putExtra("sendNum",1);
                startActivity(sendNum);

            }
        });
        textViewSp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendNum.putExtra("sendNum",2);
                startActivity(sendNum);
            }
        });
        textViewH.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendNum.putExtra("sendNum",3);
                startActivity(sendNum);
            }
        });
        textViewS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendNum.putExtra("sendNum",4);
                startActivity(sendNum);


            }
        });
        textViewT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendNum.putExtra("sendNum",5);
                startActivity(sendNum);
            }
        });
        textViewB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendNum.putExtra("sendNum",6);
                startActivity(sendNum);
            }
        });


    }
}