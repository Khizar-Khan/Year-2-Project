package com.khizar.year2groupproject;

import android.os.StrictMode;

import com.google.firebase.auth.FirebaseAuth;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class MySQLConnector2 {
    FirebaseAuth fAuth =  FirebaseAuth.getInstance();
    String userID = fAuth.getCurrentUser().getUid();
    public MySQLConnector2()
    {
        enableStrictMode();

        try
        {
            Statement stmt;

            //Register the JDBC driver for MySQL
            Class.forName("com.mysql.jdbc.Driver").newInstance();

            String url = "jdbc:mysql://172.31.82.82:3306/StudyHours";
            Connection con = DriverManager.getConnection( url,"Paarth","Paarth");

            //Get a Statement object
            stmt = con.createStatement();

            //Insert user id
            stmt.executeUpdate("INSERT INTO PersonalHours(Student) VALUES "+"('"+userID+"')"/*+"WHERE NOT EXISTS(SELECT Student FROM PersonalHours WHERE Student="+"'"+userID+"')"*/);
            stmt.executeUpdate("UPDATE PersonalHours SET Assignment1=0 WHERE (Student="+"'"+userID+"' AND Assignment1 IS null)");
            stmt.executeUpdate("UPDATE PersonalHours SET Assignment2=0 WHERE (Student="+"'"+userID+"' AND Assignment2 IS null)");
            stmt.executeUpdate("UPDATE PersonalHours SET Assignment3=0 WHERE (Student="+"'"+userID+"' AND Assignment3 IS null)");
            stmt.executeUpdate("UPDATE PersonalHours SET Assignment4=0 WHERE (Student="+"'"+userID+"' AND Assignment4 IS null)");
            stmt.executeUpdate("UPDATE PersonalHours SET Assignment5=0 WHERE (Student="+"'"+userID+"' AND Assignment5 IS null)");
            stmt.executeUpdate("UPDATE PersonalHours SET Assignment6=0 WHERE (Student="+"'"+userID+"' AND Assignment6 IS null)");
            stmt.executeUpdate("UPDATE PersonalHours SET Assignment7=0 WHERE (Student="+"'"+userID+"' AND Assignment7 IS null)");
            stmt.executeUpdate("UPDATE PersonalHours SET Assignment8=0 WHERE (Student="+"'"+userID+"' AND Assignment8 IS null)");

        }
        catch (Exception e)
        {
            System.out.println(e);
        }
    }
    public ArrayList<String> AssignmentHours()
    {
        enableStrictMode();

        ArrayList<String> assignmentHours = new ArrayList<>();

        try
        {
            //Register the JDBC driver for MySQL
            Class.forName("com.mysql.jdbc.Driver").newInstance();

            String url = "jdbc:mysql://172.31.82.82:3306/StudyHours";
            Connection con = DriverManager.getConnection( url,"Paarth","Paarth");
            Statement select = con.createStatement();

            ResultSet rs = select.executeQuery("SELECT idAssignment, Recommended FROM AssignmentHours");

            while (rs.next())
            {

                assignmentHours.add(rs.getString(2));

            }
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
        return assignmentHours;
    }
    public ArrayList<String> ReadHours()
    {
        enableStrictMode();

        ArrayList<String> readHours = new ArrayList<>();

        try
        {
            //Register the JDBC driver for MySQL
            Class.forName("com.mysql.jdbc.Driver").newInstance();

            String url = "jdbc:mysql://172.31.82.82:3306/StudyHours";
            Connection con = DriverManager.getConnection( url,"Paarth","Paarth");
            Statement select = con.createStatement();

            ResultSet rs = select.executeQuery("SELECT Assignment1,Assignment2,Assignment3,Assignment4,Assignment5,Assignment6,Assignment7,Assignment8 FROM PersonalHours WHERE Student="+"'"+userID+"'");

            while (rs.next())
            {
                readHours.add(rs.getString(1));
                readHours.add(rs.getString(2));
                readHours.add(rs.getString(3));
                readHours.add(rs.getString(4));
                readHours.add(rs.getString(5));
                readHours.add(rs.getString(6));
                readHours.add(rs.getString(7));
                readHours.add(rs.getString(8));

            }
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
        return readHours;
    }

    public void UpdateHours(int assignment, int hours)
    {
        enableStrictMode();

        try
        {
            Statement stmt;

            //Register the JDBC driver for MySQL
            Class.forName("com.mysql.jdbc.Driver").newInstance();

            String url = "jdbc:mysql://172.31.82.82:3306/StudyHours";
            Connection con = DriverManager.getConnection( url,"Paarth","Paarth");

            //Get a Statement object
            stmt = con.createStatement();

            // Insert a row
            stmt.executeUpdate("UPDATE PersonalHours SET Assignment"+assignment+"="+hours+" WHERE Student="+"'"+userID+"'");
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
    }
    public static void enableStrictMode()
    {
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();

        StrictMode.setThreadPolicy(policy);
    }
}
