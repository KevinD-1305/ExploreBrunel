package com.example.cs17kkd.explorebrunel;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

public class Settings extends AppCompatActivity {
    private Button button1;



    private ActionBar actionBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        actionBar=getSupportActionBar();
        actionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#ffd700")));
        getSupportActionBar().setDisplayShowHomeEnabled(true);//calls action bar
        getSupportActionBar().setIcon(R.drawable.settings);//shows the icon on action bar

       button1 = (Button) findViewById(R.id.button1);
       button1.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               openActivity2();
           }
       });
    }

    public void openActivity2() {
        Intent intent = new Intent(this,colours.class);
        startActivity(intent);
    }

}


