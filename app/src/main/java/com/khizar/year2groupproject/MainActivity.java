package com.khizar.year2groupproject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    public void logout(View view)
    {
        FirebaseAuth.getInstance().signOut();
        Intent intent = new Intent(getApplicationContext(), Login.class);
        startActivity(intent);
        finish();
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
            Intent intent = new Intent(this, CS2001Activity.class);
            startActivity(intent);
        }
        else if(id == R.id.action_two)
        {
            Intent intent = new Intent(this, CS2002Activity.class);
            startActivity(intent);
        }
        else if(id == R.id.action_three)
        {
            Intent intent = new Intent(this, CS2003Activity.class);
            startActivity(intent);
        }
        else if(id == R.id.action_four)
        {
            Intent intent = new Intent(this, CS2004Activity.class);
            startActivity(intent);
        }
        else if(id == R.id.action_five)
        {
            Intent intent = new Intent(this, CS2005Activity.class);
            startActivity(intent);
        }
        else if(id == R.id.action_six)
        {
            Intent intent = new Intent(this, CS2006Activity.class);
            startActivity(intent);
        }
        else if(id == R.id.action_seven)
        {
            Intent intent = new Intent(this, CS2007Activity.class);
            startActivity(intent);
        }

        return super.onOptionsItemSelected(item);
    }
}
