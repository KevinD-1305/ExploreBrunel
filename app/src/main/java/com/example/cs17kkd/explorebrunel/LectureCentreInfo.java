package com.example.cs17kkd.explorebrunel;

import android.os.StrictMode;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

import static com.example.cs17kkd.explorebrunel.DatabaseConnectionClass.dburl;
import static com.example.cs17kkd.explorebrunel.DatabaseConnectionClass.pswd;
import static com.example.cs17kkd.explorebrunel.DatabaseConnectionClass.user;


public class LectureCentreInfo extends AppCompatActivity {

    private ActionBar actionBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lecture_centre_info);
        actionBar=getSupportActionBar();//calls actionnbar
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        testDB();
    }

    public void testDB(){
        TextView tv = (TextView)this.findViewById(R.id.lc_description);
        try{

            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);

            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(dburl, user, pswd);

            String result = new String();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from Academic where BuildingID=10");
            ResultSetMetaData rsmd = rs.getMetaData();

            while(rs.next()){
                result += rs.getString(3) + "\n";
            }
            tv.setText(result);

        }
        catch (Exception e){
            e.printStackTrace();
            tv.setText(e.toString());
        }
    }
}
