package com.example.cs17kkd.explorebrunel;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.util.List;
import java.util.Map;

public class DBTestActivity extends AppCompatActivity {

    Button get_btn;
    ListView LVData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dbtest);

        LVData=(ListView)findViewById(R.id.LV_Data);
        get_btn=(Button)findViewById(R.id.getdata_btn);

        get_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                List<Map<String,String>> MyDataList=null;
                GetData myData = new GetData();
                MyDataList=myData.getdata();


            }
        });
    }
}