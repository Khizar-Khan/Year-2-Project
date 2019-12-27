package com.khizar.year2groupproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class ModuleSelectionBusinessComputingActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_module_selection_business_computing);
    }

    public void cs2001Activity(View view)
    {
        Intent intent = new Intent(getApplicationContext(), CS2001Activity.class);
        startActivity(intent);
    }

    public void cs2002Activity(View view)
    {
        Intent intent = new Intent(getApplicationContext(), CS2002Activity.class);
        startActivity(intent);
    }

    public void cs2003Activity(View view)
    {
        Intent intent = new Intent(getApplicationContext(), CS2003Activity.class);
        startActivity(intent);
    }

    public void cs2006Activity(View view)
    {
        Intent intent = new Intent(getApplicationContext(), CS2006Activity.class);
        startActivity(intent);
    }

    public void cs2007Activity(View view)
    {
        Intent intent = new Intent(getApplicationContext(), CS2007Activity.class);
        startActivity(intent);
    }
}
