package com.example.cs17kkd.explorebrunel;

import android.annotation.SuppressLint;
//import android.app.Activity;
import android.os.StrictMode;
//import android.support.v7.app.AppCompatActivity;
//import android.test.suitebuilder.annotation.Suppress;
import android.util.Log;
//import android.widget.TextView;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
//import java.sql.Statement;
//import java.sql.ResultSet;
//import java.sql.ResultSetMetaData;

/*public class DatabaseConnectionClass extends AppCompatActivity{

//public static final String url = "jdbc:mysql://172.31.82.91:3306/exploreBrunelDB";
//public static final String username = "root";
//public static final String password = "123";

/*public void testDB(){

        TextView tv=(TextView)findViewById(R.id.textView);
        try{
        StrictMode.ThreadPolicy policy=new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection(url, username, password);

        String result = "Database connection success\n";
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery("select * from Academic");
        ResultSetMetaData rsmd = rs.getMetaData();

        while(rs.next()){
            result += rsmd.getColumnName(1) + ": " + rs.getString(1) + "\n";
            result += rsmd.getColumnName(2) + ": " + rs.getInt(2) + "\n";
            result += rsmd.getColumnName(3) + ": " + rs.getString(3) + "\n";
        }
        tv.setText(result);
            }
            catch(Exception e){
            e.printStackTrace();
            tv.setText(e.toString());
         }
       */
public class DatabaseConnectionClass {
   String IP, DB, DBUsername, DBPassword;

   @SuppressLint("NewApi")
   public Connection connections() {

       IP = "172.17.0.20 /134.83.251.152/172.31.82.91";
       DB = "exploreBrunelDB";
        DBUsername = "root";
       DBPassword = "123";

      StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
      StrictMode.setThreadPolicy(policy);
       java.sql.Connection connection = null;
       String ConnectionURL = null;
       try {
         Class.forName("net.sourceforge.jtds.jdbc.Driver");
           ConnectionURL = "jdbc:jtds:sqlserver://" + IP + ";databasename" + DB + ";user=" + DBUsername + ";password=" + DBPassword + ";";
          connection = DriverManager.getConnection(ConnectionURL);
        } catch (SQLException se) {
            Log.e("error from sql", se.getMessage());
       } catch (ClassNotFoundException e) {
            Log.e("Error from Class", e.getMessage());
       } catch (Exception ex) {
            Log.e("Error from Exception", ex.getMessage());
        }
       return connection;


    }
}
