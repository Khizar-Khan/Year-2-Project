package com.khizar.year2groupproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.tabs.TabLayout;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class GradeCalcActivity extends AppCompatActivity
{
    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grade_calc);
        tabLayout = findViewById(R.id.tablayout);
        viewPager = findViewById(R.id.viewpager);
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());

        adapter.addFragment(new Fragment1(),"Grade Calculator");
        adapter.addFragment(new Fragment2(),"Target Calculator");

        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
    }

    public void calculateGrade(View view)
    {
        DecimalFormat decimalFormat = new DecimalFormat("#.##");

        TextView mOverallGradePercTXT = findViewById(R.id.overallGradePercTXT);
        TextView mOverallGradeTXT = findViewById(R.id.overallGradeTXT);
        TextView mColonTXT = findViewById(R.id.colonTXT);
        EditText mCS2001GradeET = findViewById(R.id.cs2001GradeET);
        EditText mCS2002GradeET = findViewById(R.id.cs2002GradeET);
        EditText mCS2003GradeET = findViewById(R.id.cs2003GradeET);
        EditText mCS2004GradeET = findViewById(R.id.cs2004GradeET);
        EditText mCS2005GradeET = findViewById(R.id.cs2005GradeET);

        String cs2001Grade;
        String cs2002Grade;
        String cs2003Grade;
        String cs2004Grade;
        String cs2005Grade;

        double grade = 0.0;

        try
        {
            cs2001Grade = mCS2001GradeET.getText().toString();
            cs2002Grade = mCS2002GradeET.getText().toString();
            cs2003Grade = mCS2003GradeET.getText().toString();
            cs2004Grade = mCS2004GradeET.getText().toString();
            cs2005Grade = mCS2005GradeET.getText().toString();

            grade = gradeCalculateAlg(Double.valueOf(cs2001Grade), Double.valueOf(cs2002Grade), Double.valueOf(cs2003Grade), Double.valueOf(cs2004Grade), Double.valueOf(cs2005Grade));
        }
        catch(Exception e)
        {
            Toast.makeText(GradeCalcActivity.this, "ERROR", Toast.LENGTH_SHORT).show();
        }


        if(grade <= 29.49)
        {
            mOverallGradeTXT.setText("F");
        }
        else if (grade >= 29.50 && grade <= 32.49)
        {
            mOverallGradeTXT.setText("E-");
        }
        else if (grade >= 32.50 && grade <= 37.49)
        {
            mOverallGradeTXT.setText("E");
        }
        else if (grade >= 37.50 && grade <= 39.49)
        {
            mOverallGradeTXT.setText("E+");
        }
        else if (grade >= 39.50 && grade <= 42.49)
        {
            mOverallGradeTXT.setText("D-");
        }
        else if (grade >= 42.50 && grade <= 47.49)
        {
            mOverallGradeTXT.setText("D");
        }
        else if (grade >= 47.50 && grade <= 49.49)
        {
            mOverallGradeTXT.setText("D+");
        }
        else if (grade >= 49.50 && grade <= 52.49)
        {
            mOverallGradeTXT.setText("C-");
        }
        else if (grade >= 52.50 && grade <= 57.49)
        {
            mOverallGradeTXT.setText("C");
        }
        else if (grade >= 57.50 && grade <= 59.49)
        {
            mOverallGradeTXT.setText("C+");
        }
        else if (grade >= 59.50 && grade <= 62.49)
        {
            mOverallGradeTXT.setText("B-");
        }
        else if (grade >= 62.50 && grade <= 67.49)
        {
            mOverallGradeTXT.setText("B");
        }
        else if (grade >= 67.50 && grade <= 69.49)
        {
            mOverallGradeTXT.setText("B+");
        }
        else if (grade >= 69.50 && grade <= 72.49)
        {
            mOverallGradeTXT.setText("A-");
        }
        else if (grade >= 72.50 && grade <= 79.49)
        {
            mOverallGradeTXT.setText("A");
        }
        else if (grade >= 79.50 && grade <= 89.49)
        {
            mOverallGradeTXT.setText("A+");
        }
        else if (grade >= 89.50)
        {
            mOverallGradeTXT.setText("A*");
        }
        else
        {
            mOverallGradeTXT.setText("ERROR");
        }
        mOverallGradePercTXT.setText(decimalFormat.format(grade) + "% ");
        mOverallGradeTXT.setVisibility(View.VISIBLE);
        mOverallGradePercTXT.setVisibility(View.VISIBLE);
        mColonTXT.setVisibility(View.VISIBLE);
    }

    public void calculateTargetGrade(View view)
    {
        DecimalFormat decimalFormat = new DecimalFormat("#.##");

        TextView mGradeNeededTXT = findViewById(R.id.gradeNeededTXT);
        EditText mDesiredGradeET = findViewById(R.id.desiredGradeET);
        EditText mCurrentGradeET = findViewById(R.id.currentGradeET);
        EditText mWeightOfFinalET = findViewById(R.id.weightOfFinalET);

        String desiredGrade;
        String currentGrade;
        String weightOfFinal;

        double gradeNeeded = 0.0;

        try
        {
            desiredGrade = mDesiredGradeET.getText().toString();
            currentGrade = mCurrentGradeET.getText().toString();
            weightOfFinal = mWeightOfFinalET.getText().toString();

            gradeNeeded = targetGradeCalculateAlg(Double.valueOf(desiredGrade), Double.valueOf(currentGrade), Double.valueOf(weightOfFinal));
            mGradeNeededTXT.setText(decimalFormat.format(gradeNeeded) + "%");
        }
        catch(Exception e)
        {
            Toast.makeText(GradeCalcActivity.this, "ERROR", Toast.LENGTH_SHORT).show();
        }
    }

    public double gradeCalculateAlg(double cs2001Grade, double cs2002Grade, double cs2003Grade, double cs20046Grade, double cs20057Grade)
    {
        MySQLConnector sqlConnector = new MySQLConnector();

        ArrayList<String> moduleInformation = sqlConnector.readModuleInformation();

        double cs2001Credits = Integer.valueOf(moduleInformation.get(3));
        double cs2002Credits = Integer.valueOf(moduleInformation.get(8));
        double cs2003Credits = Integer.valueOf(moduleInformation.get(13));
        double cs2004Credits = Integer.valueOf(moduleInformation.get(18));
        double cs2005Credits = Integer.valueOf(moduleInformation.get(23));

        double grade = ((cs2001Grade*cs2001Credits) + (cs2002Grade*cs2002Credits) + (cs2003Grade*cs2003Credits) + (cs20046Grade*cs2004Credits) + (cs20057Grade*cs2005Credits)) / (cs2001Credits + cs2002Credits + cs2003Credits + cs2004Credits + cs2005Credits);
        return grade;
    }

    public double targetGradeCalculateAlg(double desiredGrade, double currentGrade, double weightOfFinal)
    {
        double weightOfCurrentGrade = 100 - weightOfFinal;
        double gradeNeeded = (desiredGrade*100/weightOfFinal - currentGrade*weightOfCurrentGrade/weightOfFinal);
        return gradeNeeded;
    }
}
