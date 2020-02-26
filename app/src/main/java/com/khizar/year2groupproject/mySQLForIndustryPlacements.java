package com.khizar.year2groupproject;

import android.os.StrictMode;

import com.google.firebase.auth.FirebaseAuth;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class mySQLForIndustryPlacements
{


    FirebaseAuth fAuth =  FirebaseAuth.getInstance();
    String userID = fAuth.getCurrentUser().getUid();

    public void mySQLForIndustryPlacements()
    {

        try
        {
            Statement stmt;

            //Register the JDBC driver for MySQL
            Class.forName("com.mysql.jdbc.Driver").newInstance();

            String url = "jdbc:mysql://172.31.82.82:3306/UserPlacementStatistics";
            Connection con = DriverManager.getConnection( url,"Mznk","Mznk");

            //Get a Statement object
            stmt = con.createStatement();

            //Insert user id
            stmt.executeUpdate("INSERT INTO PlacementProgress(id, email, CVComp, CoverLComp, NoOfPlacements, InterviewsPending, JobOffers) VALUES(1,'MYAYERZ',1,1,4,2,0)");
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
    }
}