package com.khizar.year2groupproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class CS2002GradesActivity extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cs2002_grades);
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
        sqlConnector.writeUserGrade("CS2002_GradeOne", grade);
        Toast.makeText(CS2002GradesActivity.this, "Submitted!", Toast.LENGTH_SHORT).show();
    }

    public void enterGradeTwo(View view)
    {
        EditText mGradeTwoET = findViewById(R.id.gradeTwoET);

        int grade;
        try
        {
            grade = Integer.parseInt(mGradeTwoET.getText().toString());
            mGradeTwoET.setText("");
        }
        catch (Exception e)
        {
            grade = 0;
        }

        MySQLConnector sqlConnector = new MySQLConnector();
        sqlConnector.writeUserGrade("CS2002_GradeTwo", grade);
        Toast.makeText(CS2002GradesActivity.this, "Submitted!", Toast.LENGTH_SHORT).show();
    }
}
