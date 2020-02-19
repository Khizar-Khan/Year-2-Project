package com.khizar.year2groupproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;

public class CS2003Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cs2003);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        TextView mDeadline = findViewById(R.id.deadlineTXT);
        TextView mType = findViewById(R.id.typeTXT);
        TextView mWeight = findViewById(R.id.weightTXT);

        MySQLConnector sqlConnector = new MySQLConnector();
        ArrayList<String> assessmentInformation = sqlConnector.readAssessmentInformation();

        mType.setText(assessmentInformation.get(9));
        mDeadline.setText(assessmentInformation.get(10));
        mWeight.setText(assessmentInformation.get(11) + "%");

        TextView mCurrentTXT = findViewById(R.id.currentTXT);
        ArrayList<String> userGrade = sqlConnector.readUserGrade("CS2003");
        mCurrentTXT.setText(userGrade.get(0)+"%");

        TextView mLabel = findViewById(R.id.mLabel);
        TextView dLabel = findViewById(R.id.dLabel);
        TextView eLabel = findViewById(R.id.eLabel);

        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MMMM/d/E", Locale.UK);
        String strDate = simpleDateFormat.format(calendar.getTime());

        String[] values = strDate.split("/",0);

        mLabel.setText(values[1]);
        dLabel.setText(values[2]);
        eLabel.setText(values[3]);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main_cs2003, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        if(id == R.id.home)
        {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
            finish();
        }
        else if(id == R.id.refresh)
        {
            finish();
            startActivity(getIntent());
        }
        else if(id == R.id.action_one)
        {
            Intent intent = new Intent(this, CS2001Activity.class);
            startActivity(intent);
            finish();
        }
        else if(id == R.id.action_two)
        {
            Intent intent = new Intent(this, CS2002Activity.class);
            startActivity(intent);
            finish();
        }
        else if(id == R.id.action_four)
        {
            Intent intent = new Intent(this, CS2004Activity.class);
            startActivity(intent);
            finish();
        }
        else if(id == R.id.action_five)
        {
            Intent intent = new Intent(this, CS2005Activity.class);
            startActivity(intent);
            finish();
        }

        return super.onOptionsItemSelected(item);
    }

    public void toDoListSelection(View view)
    {
        Intent intent = new Intent(getApplicationContext(), CS2003ToDoListActivity.class);
        startActivity(intent);
    }

    public void moduleInfoSelection(View view)
    {
        Intent intent = new Intent(getApplicationContext(), CS2003ModuleInfoActivity.class);
        startActivity(intent);
    }

    public void enterGradesSelection(View view)
    {
        Intent intent = new Intent(getApplicationContext(), CS2003GradesActivity.class);
        startActivity(intent);
    }
}
