package com.khizar.year2groupproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class CS2003Activity extends AppCompatActivity {

    private TextView txtTimerDay, txtTimerHour, txtTimerMinute, txtTimerSecond, assessment, enoughtime, counter;
    private TextView tvEvent;
    private TextView Addhours, PlusCount, MinusCount;
    private Handler handler;
    private Runnable runnable;

    MySQLConnector2 sqlConnector2 = new MySQLConnector2();
    ArrayList<String> assignmentHours = sqlConnector2.AssignmentHours();
    ArrayList<String> readHours = sqlConnector2.ReadHours();
    public int currentCount = Integer.valueOf(readHours.get(3));
    public int sghours = Integer.valueOf(assignmentHours.get(3));

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

        txtTimerDay = (TextView) findViewById(R.id.txtTimerDay);
        txtTimerHour = (TextView) findViewById(R.id.txtTimerHour);
        txtTimerMinute = (TextView) findViewById(R.id.txtTimerMinute);
        txtTimerSecond = (TextView) findViewById(R.id.txtTimerSecond);
        enoughtime = (TextView) findViewById(R.id.enoughtime);
        assessment = (TextView) findViewById(R.id.Assessment_name);
        assessment.setText(assessmentInformation.get(9));
        tvEvent = (TextView) findViewById(R.id.tvEvent);
        counter = (TextView) findViewById(R.id.Counter);
        counter.setText((readHours.get(3)));
        Addhours = (TextView) findViewById(R.id.Addhours);
        PlusCount = (TextView) findViewById(R.id.PlusCount);
        MinusCount = (TextView) findViewById(R.id.MinusCount);
        countDownStart();

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
    public void PlusCounter(View view)
    {
        //int currentCount = 0;

        currentCount = currentCount + 1;
        String newcount = String.valueOf(currentCount);
        sqlConnector2.UpdateHours(4, currentCount);
        counter.setText(newcount);
    }
    public void MinusCounter (View view){

        //int currentCount = 0;
        currentCount = currentCount - 1;
        String newcount = String.valueOf(currentCount);
        sqlConnector2.UpdateHours(4,currentCount);
        counter.setText(newcount);
    }

    public void countDownStart() {
        handler = new Handler();
        runnable = new Runnable() {
            @Override
            public void run() {

                MySQLConnector sqlConnector = new MySQLConnector();
                ArrayList<String> assessmentInformation = sqlConnector.readAssessmentInformation();
                int displayCount = currentCount;
                int displayHours = sghours;
                DateFormat dateFormat = new SimpleDateFormat(
                        "dd/MM/yyyy");

                String date = assessmentInformation.get(10);

                handler.postDelayed(this, 1000);
                try {
                    Date futureDate = dateFormat.parse(date);
                    Date currentDate = new Date();

                    if (!currentDate.after(futureDate)) {
                        long diff = futureDate.getTime()
                                - currentDate.getTime();
                        long days = diff / (24 * 60 * 60 * 1000);
                        diff -= days * (24 * 60 * 60 * 1000);
                        long hours = diff / (60 * 60 * 1000);
                        diff -= hours * (60 * 60 * 1000);
                        long minutes = diff / (60 * 1000);
                        diff -= minutes * (60 * 1000);
                        long seconds = diff / 1000;
                        txtTimerDay.setText("" + String.format("%02d", days));
                        txtTimerHour.setText("" + String.format("%02d", hours));
                        txtTimerMinute.setText(""
                                + String.format("%02d", minutes));
                        txtTimerSecond.setText(""
                                + String.format("%02d", seconds));
                        if ((days * 2)< displayHours-displayCount){enoughtime.setBackgroundColor(Color.rgb(255,0,0));}
                        if (((days * 2)>= displayHours-displayCount)&&(days < displayHours-displayCount)){enoughtime.setBackgroundColor(Color.rgb(255,255,0));}
                        if (days >= displayHours-displayCount){enoughtime.setBackgroundColor(Color.rgb(0,255,0));}
                    } else {
                        tvEvent.setVisibility(View.VISIBLE);
                        Addhours.setVisibility(View.GONE);
                        counter.setVisibility(View.GONE);
                        PlusCount.setVisibility(View.GONE);
                        MinusCount.setVisibility(View.GONE);
                        tvEvent.setText("This assessment has ended!");
                        //textViewGone();
                        enoughtime.setBackgroundColor(Color.rgb(255,0,0));
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
        handler.postDelayed(runnable, 1 * 1000);

    }
    protected void onStop() {
        super.onStop();
        handler.removeCallbacks(runnable);
    }

}
