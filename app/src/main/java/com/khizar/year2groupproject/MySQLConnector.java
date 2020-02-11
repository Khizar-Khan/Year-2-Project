package com.khizar.year2groupproject;

import android.os.StrictMode;

import com.google.firebase.auth.FirebaseAuth;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class MySQLConnector
{
    FirebaseAuth fAuth =  FirebaseAuth.getInstance();
    String userID = fAuth.getCurrentUser().getUid();

    public MySQLConnector()
    {
        enableStrictMode();

        try
        {
            Statement stmt;

            //Register the JDBC driver for MySQL
            Class.forName("com.mysql.jdbc.Driver").newInstance();

            String url = "jdbc:mysql://172.31.82.82:3306/users";
            Connection con = DriverManager.getConnection( url,"Khizar","Khizar");

            //Get a Statement object
            stmt = con.createStatement();

            //Insert user id
            stmt.executeUpdate("INSERT INTO User_Grades(User_ID) SELECT "+"'"+userID+"' FROM DUAL "+"WHERE NOT EXISTS(SELECT User_ID FROM User_Grades WHERE User_ID="+"'"+userID+"')");
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
    }

    public ArrayList<String> readModuleInformation()
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

    public ArrayList<String> readAssessmentInformation()
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

    public void writeUserGrade(String module_GradeNum, int grade)
    {
        enableStrictMode();

        try
        {
            Statement stmt;

            //Register the JDBC driver for MySQL
            Class.forName("com.mysql.jdbc.Driver").newInstance();

            String url = "jdbc:mysql://172.31.82.82:3306/users";
            Connection con = DriverManager.getConnection( url,"Khizar","Khizar");

            //Get a Statement object
            stmt = con.createStatement();

            // Insert a row
            stmt.executeUpdate("UPDATE User_Grades SET "+module_GradeNum+"="+grade+" WHERE User_ID="+"'"+userID+"'");
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
    }

    public ArrayList<String> readUserGrade(String moduleCode)
    {
        enableStrictMode();

        ArrayList<String> userGrades = new ArrayList<>();

        try
        {
            //Register the JDBC driver for MySQL
            Class.forName("com.mysql.jdbc.Driver").newInstance();

            String url = "jdbc:mysql://172.31.82.82:3306/users";
            Connection con = DriverManager.getConnection( url,"Khizar","Khizar");
            Statement select = con.createStatement();

            ResultSet rs;
            if(moduleCode=="CS2001" || moduleCode=="CS2003")
            {
                rs = select.executeQuery("SELECT "+moduleCode+"_GradeOne FROM User_Grades WHERE User_ID="+"'"+userID+"'");
                while (rs.next())
                {
                    userGrades.add(Integer.toString(rs.getInt(1)));
                }
            }
            else
            {
                rs = select.executeQuery("SELECT "+moduleCode+"_GradeOne, "+moduleCode+"_GradeTwo FROM User_Grades WHERE User_ID="+"'"+userID+"'");
                while (rs.next())
                {
                    userGrades.add(Integer.toString(rs.getInt(1)));
                    userGrades.add(Integer.toString(rs.getInt(2)));
                }
            }
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
        return userGrades;
    }

    public static ArrayList<String> readTimetableDayData(String Day)
    {
        enableStrictMode();

        ArrayList<String> DayDataInformation = new ArrayList<>();

        try
        {
            //Register the JDBC driver for MySQL
            Class.forName("com.mysql.jdbc.Driver").newInstance();

            String url = "jdbc:mysql://172.31.82.82:3306/TimetableData";
            Connection con = DriverManager.getConnection( url,"Augustas","Augustas");
            Statement select = con.createStatement();

            ResultSet resultset;
            if(Day=="Monday")
            {
                resultset = select.executeQuery("SELECT ModuleName FROM Modules WHERE Day LIKE '%Monday%'");
                while (resultset.next())
                {
                    DayDataInformation.add(resultset.getString(1));
                }
            }
            else if(Day == "Tuesday")
            {
                resultset = select.executeQuery("SELECT ModuleName FROM Modules WHERE Day LIKE '%Tuesday%'");
                while (resultset.next())
                {
                    DayDataInformation.add(resultset.getString(1));
                }
            }
            else if(Day == "Wednesday")
            {
                resultset = select.executeQuery("SELECT ModuleName FROM Modules WHERE Day LIKE '%Wednesday%'");
                while (resultset.next())
                {
                    DayDataInformation.add(resultset.getString(1));
                }
            }
            else if(Day == "Thursday")
            {
                resultset = select.executeQuery("SELECT ModuleName FROM Modules WHERE Day LIKE '%Thursday%'");
                while (resultset.next())
                {
                    DayDataInformation.add(resultset.getString(1));
                }
            }
            else if(Day == "Friday")
            {
                resultset = select.executeQuery("SELECT ModuleName FROM Modules WHERE Day LIKE '%Friday%'");
                while (resultset.next())
                {
                    DayDataInformation.add(resultset.getString(1));
                }
            }
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
        return DayDataInformation;
    }

    public static ArrayList<String> readTimetableTimeData(String Day)
    {
        enableStrictMode();

        ArrayList<String> TimeInformation = new ArrayList<>();

        try
        {
            //Register the JDBC driver for MySQL
            Class.forName("com.mysql.jdbc.Driver").newInstance();

            String url = "jdbc:mysql://172.31.82.82:3306/TimetableData";
            Connection con = DriverManager.getConnection( url,"Augustas","Augustas");
            Statement select = con.createStatement();

            ResultSet resultset;
            if(Day=="Monday")
            {
                resultset = select.executeQuery("SELECT DATE_FORMAT(StartTime, '%k:%i') , DATE_FORMAT(EndTime, '%k:%i') FROM Modules WHERE Day LIKE '%Monday%'");
                while (resultset.next())
                {
                    TimeInformation.add(resultset.getString(1) + " - " + resultset.getString(2));

                }
            }
            else if(Day == "Tuesday")
            {
                resultset = select.executeQuery("SELECT DATE_FORMAT(StartTime, '%k:%i') , DATE_FORMAT(EndTime, '%k:%i') FROM Modules WHERE Day LIKE '%Tuesday%'");
                while (resultset.next())
                {
                    TimeInformation.add(resultset.getString(1) + " - " + resultset.getString(2));
                }
            }
            else if(Day == "Wednesday")
            {
                resultset = select.executeQuery("SELECT DATE_FORMAT(StartTime, '%k:%i') , DATE_FORMAT(EndTime, '%k:%i') FROM Modules WHERE Day LIKE '%Wednesday%'");
                while (resultset.next())
                {
                    TimeInformation.add(resultset.getString(1) + " - " + resultset.getString(2));
                }
            }
            else if(Day == "Thursday")
            {
                resultset = select.executeQuery("SELECT DATE_FORMAT(StartTime, '%k:%i') , DATE_FORMAT(EndTime, '%k:%i') FROM Modules WHERE Day LIKE '%Thursday%'");
                while (resultset.next())
                {
                    TimeInformation.add(resultset.getString(1) + " - " + resultset.getString(2));
                }
            }
            else if(Day == "Friday")
            {
                resultset = select.executeQuery("SELECT DATE_FORMAT(StartTime, '%k:%i') , DATE_FORMAT(EndTime, '%k:%i') FROM Modules WHERE Day LIKE '%Friday%'");
                while (resultset.next())
                {
                    TimeInformation.add(resultset.getString(1) + " - " + resultset.getString(2));
                }
            }
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
        return TimeInformation;
    }

    public ArrayList<String> readResourcesData()
    {
        enableStrictMode();

        ArrayList<String> ResourcesData = new ArrayList<>();

        try
        {
            //Register the JDBC driver for MySQL
            Class.forName("com.mysql.jdbc.Driver").newInstance();

            String url = "jdbc:mysql://172.31.82.82:3306/ResourcesData";
            Connection con = DriverManager.getConnection( url,"Vignesh","Vignesh");
            Statement select = con.createStatement();

            // Execute a quesry
            ResultSet rs = select.executeQuery("SELECT Module_Code, Resource_Name, Resource_URL FROM WebsiteResources");

            while (rs.next())
            {
                ResourcesData.add(rs.getString(1));
                ResourcesData.add(rs.getString(2));
                ResourcesData.add(rs.getString(3));
            }
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        return ResourcesData;
    }

    public static void enableStrictMode()
    {
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();

        StrictMode.setThreadPolicy(policy);
    }
}