package com.example.mynewsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;

public class MainActivity2 extends AppCompatActivity {
    private TextView contentN,titleN,descriptionN;
    private ImageView backN;
    LinearLayout layout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        getSupportActionBar().hide();
        contentN = findViewById(R.id.contentNews);
        layout = findViewById(R.id.linearN);
        titleN = findViewById(R.id.titleNews);
        backN = findViewById(R.id.shareN);
        descriptionN = findViewById(R.id.descriptionNews);
        layout.setBackgroundResource(R.drawable.background_two);
        Intent intent  = getIntent();
        String TITLE = intent.getStringExtra("one");
        String IMAGE = intent.getStringExtra("two");
        String CONTENT = intent.getStringExtra("three");
        String DESCRIPTION = intent.getStringExtra("four");
        String URL = intent.getStringExtra("five");
        titleN.setText(TITLE);
        descriptionN.setText(DESCRIPTION);
        contentN.setText(CONTENT+"***************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************");
        Picasso.get().load(IMAGE).into(new Target(){

            @Override
            public void onBitmapLoaded(Bitmap bitmap, Picasso.LoadedFrom from) {
                layout.setBackground(new BitmapDrawable(getBaseContext().getResources(), bitmap));
            }

            @Override
            public void onBitmapFailed(Exception e, Drawable errorDrawable) {
                Log.d("TAG", "FAILED");

            }
            @Override
            public void onPrepareLoad(final Drawable placeHolderDrawable) {
                Log.d("TAG", "Prepare Load");
            }
        });
        backN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity2.this, "sending", Toast.LENGTH_SHORT).show();
                Intent sendIntent = new Intent();
                sendIntent.setAction(Intent.ACTION_SEND);
                sendIntent.putExtra(Intent.EXTRA_TEXT,URL);
                sendIntent.setType("text/plain");
                startActivity(sendIntent);
            }
        });

    }
}