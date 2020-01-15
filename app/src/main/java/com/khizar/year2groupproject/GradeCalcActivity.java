package com.khizar.year2groupproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.tabs.TabLayout;

import java.text.DecimalFormat;

public class GradeCalcActivity extends AppCompatActivity
{
    private TabLayout tabLayout;
    private AppBarLayout appBarLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grade_calc);
        tabLayout = findViewById(R.id.tablayout);
        appBarLayout = findViewById(R.id.appbar);
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
        EditText mCS2001GradeET = findViewById(R.id.cs2001GradeET);
        EditText mCS2002GradeET = findViewById(R.id.cs2002GradeET);
        EditText mCS2003GradeET = findViewById(R.id.cs2003GradeET);
        EditText mCS20046GradeET = findViewById(R.id.cs20046GradeET);
        EditText mCS20057GradeET = findViewById(R.id.cs20057GradeET);

        String cs2001Grade = mCS2001GradeET.getText().toString();
        String cs2002Grade = mCS2002GradeET.getText().toString();
        String cs2003Grade = mCS2003GradeET.getText().toString();
        String cs20046Grade = mCS20046GradeET.getText().toString();
        String cs20057Grade = mCS20057GradeET.getText().toString();

        double grade = gradeCalculateAlg(Double.valueOf(cs2001Grade), Double.valueOf(cs2002Grade), Double.valueOf(cs2003Grade), Double.valueOf(cs20046Grade), Double.valueOf(cs20057Grade));

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
    }

    public double gradeCalculateAlg(double cs2001Grade, double cs2002Grade, double cs2003Grade, double cs20046Grade, double cs20057Grade)
    {
        double grade = ((cs2001Grade*40) + (cs2002Grade*20) + (cs2003Grade*20) + (cs20046Grade*20) + (cs20057Grade*20)) / 120;
        return grade;
    }
}
