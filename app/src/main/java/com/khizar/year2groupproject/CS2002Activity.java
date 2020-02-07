package com.khizar.year2groupproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

public class CS2002Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cs2002);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        TextView mDeadline = findViewById(R.id.deadlineTXT);
        TextView mDeadline2 = findViewById(R.id.deadline2TXT);
        TextView mType = findViewById(R.id.typeTXT);
        TextView mType2 = findViewById(R.id.type2TXT);
        TextView mWeight = findViewById(R.id.weightTXT);
        TextView mWeight2 = findViewById(R.id.weight2TXT);

        MySQLConnector sqlConnector = new MySQLConnector();
        ArrayList<String> assessmentInformation = sqlConnector.readAssessmentInformation();
        mType.setText(assessmentInformation.get(3));
        mDeadline.setText(assessmentInformation.get(4));
        mWeight.setText(assessmentInformation.get(5) + "%");
        mType2.setText(assessmentInformation.get(6));
        mDeadline2.setText(assessmentInformation.get(7));
        mWeight2.setText(assessmentInformation.get(8) + "%");

        TextView mCurrentTXT = findViewById(R.id.currentTXT);
        TextView mCurrent2TXT = findViewById(R.id.current2TXT);
        ArrayList<String> userGrade = sqlConnector.readUserGrade("CS2002");
        mCurrentTXT.setText(userGrade.get(0)+"%");
        mCurrent2TXT.setText(userGrade.get(1)+"%");

        TextView mOverallTXT = findViewById(R.id.overallTXT);

        double gradeOne = Integer.valueOf(userGrade.get(0));
        double weightOne = Integer.valueOf(assessmentInformation.get(5));
        double gradeTwo = Integer.valueOf(userGrade.get(1));
        double weightTwo = Integer.valueOf(assessmentInformation.get(8));

        double overall = ((gradeOne*weightOne) + (gradeTwo*weightTwo))/100;
        mOverallTXT.setText(overall+"%");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main_cs2002, menu);
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
        else if(id == R.id.action_one)
        {
            Intent intent = new Intent(this, CS2001Activity.class);
            startActivity(intent);
            finish();
        }
        else if(id == R.id.action_three)
        {
            Intent intent = new Intent(this, CS2003Activity.class);
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
        Intent intent = new Intent(getApplicationContext(), CS2002ToDoListActivity.class);
        startActivity(intent);
    }

    public void moduleInfoSelection(View view)
    {
        Intent intent = new Intent(getApplicationContext(), CS2002ModuleInfoActivity.class);
        startActivity(intent);
    }

    public void enterGradesSelection(View view)
    {
        Intent intent = new Intent(getApplicationContext(), CS2002GradesActivity.class);
        startActivity(intent);
    }
}
