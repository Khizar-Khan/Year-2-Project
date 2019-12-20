package com.khizar.year2groupproject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        if (id == R.id.action_one)
        {
            openCS2001Activity();
        }
        else if(id == R.id.action_two)
        {
            openCS2002Activity();
        }
        else if(id == R.id.action_three)
        {
            openCS2003Activity();
        }
        else if(id == R.id.action_four)
        {
            openCS2004Activity();
        }
        else if(id == R.id.action_five)
        {
            openCS2005Activity();
        }
        else if(id == R.id.action_six)
        {
            openCS2006Activity();
        }
        else if(id == R.id.action_seven)
        {
            openCS2007Activity();
        }

        return super.onOptionsItemSelected(item);
    }

    public void openCS2001Activity()
    {
        Intent intent = new Intent(this, CS2001Activity.class);
        startActivity(intent);
    }
    public void openCS2002Activity()
    {
        Intent intent = new Intent(this, CS2002Activity.class);
        startActivity(intent);
    }
    public void openCS2003Activity()
    {
        Intent intent = new Intent(this, CS2003Activity.class);
        startActivity(intent);
    }
    public void openCS2004Activity()
    {
        Intent intent = new Intent(this, CS2004Activity.class);
        startActivity(intent);
    }
    public void openCS2005Activity()
    {
        Intent intent = new Intent(this, CS2005Activity.class);
        startActivity(intent);
    }
    public void openCS2006Activity()
    {
        Intent intent = new Intent(this, CS2006Activity.class);
        startActivity(intent);
    }
    public void openCS2007Activity()
    {
        Intent intent = new Intent(this, CS2007Activity.class);
        startActivity(intent);
    }
}
