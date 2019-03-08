package com.example.cs17kkd.explorebrunel;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatCallback;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.support.v4.app.Fragment;
import android.view.View;
import android.view.ViewGroup;

public class Categories extends AppCompatActivity {

    private ActionBar actionBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categories);
        actionBar=getSupportActionBar();//calls actionnbar
        actionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#1A92A7")));//Color of the action bar
        getSupportActionBar().setDisplayShowHomeEnabled(true);//calls action bar
        getSupportActionBar().setIcon(R.drawable.actionbar_categories);//shows the icon on action bar
    }

}
