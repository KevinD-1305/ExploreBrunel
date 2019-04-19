package com.example.cs17kkd.explorebrunel;

import android.widget.SimpleAdapter;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GetData {

    Connection connect;
    String ConnectionResult;
    Boolean working=false;

    public List<Map<String,String>> getdata(){
        List<Map<String,String>> data =null;
        data= new ArrayList<Map<String,String>>();

        try{
            ConnectionHelper connectionHelper=new ConnectionHelper();
            connect=connectionHelper.connections();
            if(connect==null){
                ConnectionResult="Something went wrong!";
            }
            else{
                String query="select * from people;";
                Statement stmt=connect.createStatement();
                ResultSet rs=stmt.executeQuery(query);

                while (rs.next()){
                    Map<String,String> datanum=new HashMap<String, String>();
                    datanum.put("ID",rs.getString("PeopleID"));
                    datanum.put("First_Name",rs.getString("FirstName"));
                    datanum.put("Last_Name",rs.getString("LastName"));
                    data.add(datanum);

                }

                ConnectionResult="Successful";
                working=true;
                connect.close();
            }
        }catch (Exception ex){
            working=false;
            ConnectionResult=ex.getMessage();
        }
        return data;
    }
}
