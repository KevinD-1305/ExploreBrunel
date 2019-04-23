package com.example.cs17kkd.explorebrunel;

import android.annotation.SuppressLint;
import android.os.StrictMode;
import android.util.Log;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnectionClass {

    public static final String dburl = "jdbc:mysql://172.17.0.21:3306/exploreBrunelDB";
    public static final String user = "root";
    public static final String pswd = "123";

    @SuppressLint("NewApi")
    public Connection connections() {

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        java.sql.Connection connection = null;
        String ConnectionURL = null;
        try {
            Class.forName("net.sourceforge.jtds.jdbc.Driver");
//            ConnectionURL = "jdbc:jtds:sqlserver://" + IP + ";databasename" + DB + ";user=" + DBUsername + ";password=" + DBPassword + ";";
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
