package com.khizar.year2groupproject;

import android.os.StrictMode;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class MySQLConnector
{
    public static ArrayList<String> readModuleInformation()
    {
        enableStrictMode();

        ArrayList<String> modulesInformation = new ArrayList<>();

        try
        {
            //Register the JDBC driver for MySQL
            Class.forName("com.mysql.jdbc.Driver").newInstance();

            String url = "jdbc:mysql://172.31.82.82:3306/modules";
            Connection con = DriverManager.getConnection( url,"Khizar","Khizar");
            Statement select = con.createStatement();

            // Execute a quesry
            ResultSet rs = select.executeQuery("SELECT Module_Code, Module_Name, Module_Leader, Module_Credits, Module_Assessments FROM Modules_Information");

            while (rs.next())
            {
                modulesInformation.add(rs.getString(1));
                modulesInformation.add(rs.getString(2));
                modulesInformation.add(rs.getString(3));
                modulesInformation.add(Integer.toString(rs.getInt(4)));
                modulesInformation.add(Integer.toString(rs.getInt(5)));
            }
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        return modulesInformation;
    }

    public static ArrayList<String> readAssessmentInformation()
    {
        enableStrictMode();

        ArrayList<String> assessmentsInformation = new ArrayList<>();

        try
        {
            //Register the JDBC driver for MySQL
            Class.forName("com.mysql.jdbc.Driver").newInstance();

            String url = "jdbc:mysql://172.31.82.82:3306/modules";
            Connection con = DriverManager.getConnection( url,"Khizar","Khizar");
            Statement select = con.createStatement();

            ResultSet rs = select.executeQuery("SELECT Assessment_Type, Assessment_Deadline, Assessment_Weight FROM Assessments_Information");

            while (rs.next())
            {
                assessmentsInformation.add(rs.getString(1));
                assessmentsInformation.add(rs.getString(2));
                assessmentsInformation.add(Integer.toString(rs.getInt(3)));
            }
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
        return assessmentsInformation;
    }

    public static void enableStrictMode()
    {
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();

        StrictMode.setThreadPolicy(policy);
    }
}