package com.example.cs17kkd.explorebrunel;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class social extends AppCompatActivity {

    public ActionBar actionBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_social);

        actionBar = getSupportActionBar();//calls actionnbar
        actionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#2196f3")));//Color of the action bar
        getSupportActionBar().setTitle("SOCIAL SPACES");
        String title = actionBar.getTitle().toString();

    }
}
