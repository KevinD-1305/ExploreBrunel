package com.example.cs17kkd.explorebrunel;

import android.content.Intent;
import android.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.Locale;

public class Template extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_template);

        Button but = (Button) findViewById(R.id.button);
        but.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent Categories = new Intent(Template.this, com.example.cs17kkd.explorebrunel.Categories.class);
                startActivity(Categories);

            }
        });
        Button but2 = (Button) findViewById(R.id.button2);
        but2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent Favourites = new Intent(Template.this, com.example.cs17kkd.explorebrunel.Favourites.class);
                startActivity(Favourites);

            }
        });
        Button but3 = (Button) findViewById(R.id.button3);
        but3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent Settings = new Intent(Template.this, com.example.cs17kkd.explorebrunel.Settings.class);
                startActivity(Settings);
            }
        });
        Button but4 = (Button) findViewById(R.id.button4);
        but4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent MainActivity = new Intent(Template.this, com.example.cs17kkd.explorebrunel.MainActivity.class);
                startActivity(MainActivity);
            }
        });

    }
}
