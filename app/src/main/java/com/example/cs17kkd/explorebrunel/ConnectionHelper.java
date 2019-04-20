package com.example.cs17kkd.explorebrunel;

import android.annotation.SuppressLint;
import android.os.StrictMode;
import android.test.suitebuilder.annotation.Suppress;
import android.util.Log;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionHelper {
    String IP, DB, DBUsername, DBPassword;

    @SuppressLint("NewApi")
    public Connection connections() {

        IP = "127.0.0.1";
        DB = "mytestdb";
        DBUsername = "root";
        DBPassword = "1234";

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
