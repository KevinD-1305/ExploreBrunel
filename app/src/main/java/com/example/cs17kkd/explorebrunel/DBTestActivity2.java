package com.example.cs17kkd.explorebrunel;

import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

//import com.mysql.jdbc.ResultSetMetaData;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

public class DBTestActivity2 extends AppCompatActivity {

    private static final String url = "jdbc:mysql://192.168.1.149:3306/mytestdb";
    private static final String user = "talhasabir";
    private static final String pswd = "1234";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dbtest2);
    }

    public void testDB(){
        TextView tv = (TextView)this.findViewById(R.id.textView2);
        try{

            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);

            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, user, pswd);

            String result = "Database connection success\n";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from people");
            ResultSetMetaData rsmd = rs.getMetaData();

            while(rs.next()){
                result += rsmd.getColumnName(1) + ": " + rs.getString(1) + "\n";
                result += rsmd.getColumnName(2) + ": " + rs.getString(2) + "\n";
                result += rsmd.getColumnName(3) + ": " + rs.getString(3) + "\n";
            }
            tv.setText(result);

        }
        catch (Exception e){
            e.printStackTrace();
            tv.setText(e.toString());
        }
    }
}
