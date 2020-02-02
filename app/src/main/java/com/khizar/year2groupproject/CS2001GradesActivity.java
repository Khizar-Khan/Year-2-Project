package com.khizar.year2groupproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class CS2001GradesActivity extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cs2001_grades);
    }

    public void enterGradeOne(View view)
    {
        EditText mGradeOneET = findViewById(R.id.gradeOneET);

        int grade;
        try
        {
            grade = Integer.parseInt(mGradeOneET.getText().toString());
            mGradeOneET.setText("");
        }
        catch (Exception e)
        {
            grade = 0;
        }

        MySQLConnector sqlConnector = new MySQLConnector();
        sqlConnector.writeUserGrade("CS2001_GradeOne", grade);
    }
}
