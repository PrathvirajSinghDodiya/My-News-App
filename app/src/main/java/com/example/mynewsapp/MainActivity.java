package com.example.mynewsapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
Animation animation;
    ArrayList<NEWS> obj ;
    //ArrayAdapter<String> arrayAdapter;
    //TextView textView;
//   ArrayList<NEWS> obj;

    //CustomAdapter c;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //getSupportActionBar().hide();
        obj = new ArrayList<>();
        animation = AnimationUtils.loadAnimation(this,R.anim.top_anim);
        recyclerView = findViewById(R.id.randi);
        recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
        //recyclerView.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));
        CustomAdapter c = new CustomAdapter(obj,this);
        recyclerView.setAdapter(c);
        recyclerView.setAnimation(animation);
        Intent getNum = getIntent();
        int num = getNum.getIntExtra("sendNum",0);
        String url;
        if(num==1){
            url = "https://saurav.tech/NewsAPI/top-headlines/category/entertainment/in.json";

        }
        else if(num==2) {
            url = "https://saurav.tech/NewsAPI/top-headlines/category/sports/in.json";
        }
        else if(num==3) {
            url = "https://saurav.tech/NewsAPI/top-headlines/category/health/in.json";
        }
        else if(num==4) {
            url = "https://saurav.tech/NewsAPI/top-headlines/category/science/in.json";
        }
        else if(num==5) {
            url = "https://saurav.tech/NewsAPI/top-headlines/category/technology/in.json";
        }
        else if(num==6) {
            url = "https://saurav.tech/NewsAPI/top-headlines/category/business/in.json";
        }
        else {
             url = "https://saurav.tech/NewsAPI/top-headlines/category/technology/in.json";
        }


        // String apikey = "5c8d6e4669a640a8a6cee9574b48a43a";
        //

        //
        //;
        //
        //
        //
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        //String url="https://newsapi.org/v2/top-headlines?sources=bbc-news&apiKey=5c8d6e4669a640a8a6cee9574b48a43a";
         //String url="https://newsdata.io/api/1/news?apikey=pub_12620d8d8f09db2aff2a4a2248ef0f4298f1&country=in";
        //String url = "https://newsapi.org/v2/everything?q=Apple&from=2021-10-09&sortBy=popularity&apiKey=5c8d6e4669a640a8a6cee9574b48a43a";
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest
                (Request.Method.GET,
                        url,
                        null,
                        new Response.Listener<JSONObject>() {

                            @Override
                            public void onResponse(JSONObject response) {
                                Toast.makeText(MainActivity.this, "start", Toast.LENGTH_SHORT).show();
                                try {


                                    String name = response.getString("articles");

                                    Log.i("king...............>",response.toString());

                                    JSONArray newsJsonArray = response.getJSONArray("articles");

                                    for (int i = 0; i < newsJsonArray.length(); i++) {
                                        JSONObject newsJsonObject = newsJsonArray.getJSONObject(i);
                                        String title = newsJsonObject.getString("title");

                                        String description = newsJsonObject.getString("description");
                                        String image = newsJsonObject.getString("urlToImage");
                                        String publish = newsJsonObject.getString("publishedAt");
                                        String content = newsJsonObject.getString("content");
                                        String url = newsJsonObject.getString("url");

                                        obj.add(new NEWS(title,description,image,publish,content,url));
                                    }
                                    c.notifyDataSetChanged();

                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }

                            }
                        },
                        new Response.ErrorListener() {

                            @Override
                            public void onErrorResponse(VolleyError error) {
                                Toast.makeText(MainActivity.this, "error"+ error.toString(), Toast.LENGTH_SHORT).show();
                            }
                        });
requestQueue.add(jsonObjectRequest);



    }


}
