package com.example.cs17kkd.explorebrunel;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Buildings extends AppCompatActivity {

    public ActionBar actionBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buildings);
        actionBar=getSupportActionBar();//calls actionnbar
        actionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#1A92A7")));//Color of the action bar
        getSupportActionBar().setDisplayShowHomeEnabled(true);//calls action bar
        getSupportActionBar().setIcon(R.drawable.departments);//shows the icon on action bar

        }
    }


