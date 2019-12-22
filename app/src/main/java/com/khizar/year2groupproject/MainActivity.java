package com.khizar.year2groupproject;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import com.google.firebase.auth.FirebaseAuth;


public class MainActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void logout(View view)
    {
        FirebaseAuth.getInstance().signOut();
        Intent intent = new Intent(getApplicationContext(), Login.class);
        startActivity(intent);
        finish();
    }

    public void profileSelection(View view)
    {
        Intent intent = new Intent(getApplicationContext(), ProfileActivity.class);
        startActivity(intent);
    }

    public void moduleSelection(View view)
    {
        Intent intent = new Intent(getApplicationContext(), ModuleSelectionActivity.class);
        startActivity(intent);
    }

    public void timetableSelection(View view)
    {
        Intent intent = new Intent(getApplicationContext(), TimetableActivity.class);
        startActivity(intent);
    }

    public void chatSelection(View view)
    {
        Intent intent = new Intent(getApplicationContext(), ChatActivity.class);
        startActivity(intent);
    }

    public void resourceSelection(View view)
    {
        Intent intent = new Intent(getApplicationContext(), ResourceActivity.class);
        startActivity(intent);
    }

    public void gradeCalculatorSelection(View view)
    {
        Intent intent = new Intent(getApplicationContext(), GradeCalcActivity.class);
        startActivity(intent);
    }
}
