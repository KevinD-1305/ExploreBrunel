package com.example.cs17kkd.explorebrunel;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

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

        final Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent Departments = new Intent(Categories.this, Buildings.class);
                startActivity(Departments);
            }
        });

        final Button button3 = findViewById(R.id.button3);
        button3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent social = new Intent(Categories.this, Social.class);
                startActivity(social);
            }
        });
        
        final Button button19 = findViewById(R.id.button19);
        button19.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Categories.this, Accommodations.class);
                startActivity(intent);
            }
        });


}
}
