package com.khizar.year2groupproject;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class ModuleSelectionActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_module_selection);
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

    public void cs2004Activity(View view)
    {
        Intent intent = new Intent(getApplicationContext(), CS2004Activity.class);
        startActivity(intent);
    }

    public void cs2005Activity(View view)
    {
        Intent intent = new Intent(getApplicationContext(), CS2005Activity.class);
        startActivity(intent);
    }

    public void toDoListSelection(View view)
    {
        Intent intent = new Intent(getApplicationContext(), ToDoListActivity.class);
        startActivity(intent);
    }

    public void reminderSelection(View view)
    {
        Intent intent = new Intent(getApplicationContext(), ReminderActivity.class);
        startActivity(intent);
    }
}
