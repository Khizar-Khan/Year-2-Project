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

public class CS2002Activity extends AppCompatActivity {

    private TextView txtTimerDay, txtTimerDay2, txtTimerHour, txtTimerHour2, txtTimerMinute, txtTimerMinute2, txtTimerSecond, txtTimerSecond2, assessment, assessment2, enoughtime, enoughtime2, counter, counter2;
    private TextView tvEvent, tvEvent2;
    private TextView Addhours, Addhours2, PlusCount, PlusCount2, MinusCount, MinusCount2;
    private Handler handler;
    private Runnable runnable;

    MySQLConnector2 sqlConnector2 = new MySQLConnector2();
    ArrayList<String> assignmentHours = sqlConnector2.AssignmentHours();
    ArrayList<String> readHours = sqlConnector2.ReadHours();
    public int currentCount = Integer.valueOf(readHours.get(1));
    public int currentCount2 = Integer.valueOf(readHours.get(2));
    public int sghours = Integer.valueOf(assignmentHours.get(1));
    public int sghours2 = Integer.valueOf(assignmentHours.get(2));

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
        assessment.setText(assessmentInformation.get(3));
        tvEvent = (TextView) findViewById(R.id.tvEvent);
        counter = (TextView) findViewById(R.id.Counter);
        counter.setText((readHours.get(4)));
        Addhours = (TextView) findViewById(R.id.Addhours);
        PlusCount = (TextView) findViewById(R.id.PlusCount);
        MinusCount = (TextView) findViewById(R.id.MinusCount);

        txtTimerDay2 = (TextView) findViewById(R.id.txtTimerDay2);
        txtTimerHour2 = (TextView) findViewById(R.id.txtTimerHour2);
        txtTimerMinute2 = (TextView) findViewById(R.id.txtTimerMinute2);
        txtTimerSecond2 = (TextView) findViewById(R.id.txtTimerSecond2);
        enoughtime2 = (TextView) findViewById(R.id.enoughtime2);
        assessment2 = (TextView) findViewById(R.id.Assessment_name2);
        assessment2.setText(assessmentInformation.get(6));
        tvEvent2 = (TextView) findViewById(R.id.tvEvent2);
        counter2 = (TextView) findViewById(R.id.Counter2);
        counter2.setText((readHours.get(5)));
        Addhours2 = (TextView) findViewById(R.id.Addhours2);
        PlusCount2 = (TextView) findViewById(R.id.PlusCount2);
        MinusCount2 = (TextView) findViewById(R.id.MinusCount2);
        countDownStart();

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
    public void PlusCounter(View view)
    {
        //int currentCount = 0;

        currentCount = currentCount + 1;
        String newcount = String.valueOf(currentCount);
        sqlConnector2.UpdateHours(2, currentCount);
        counter.setText(newcount);
    }
    public void MinusCounter (View view){

        //int currentCount = 0;
        currentCount = currentCount - 1;
        String newcount = String.valueOf(currentCount);
        sqlConnector2.UpdateHours(2,currentCount);
        counter.setText(newcount);
    }
    public void PlusCounter2(View view)
    {
        //int currentCount = 0;

        currentCount2 = currentCount2 + 1;
        String newcount = String.valueOf(currentCount2);
        sqlConnector2.UpdateHours(3, currentCount2);
        counter2.setText(newcount);
    }
    public void MinusCounter2 (View view){

        //int currentCount = 0;
        currentCount2 = currentCount2 - 1;
        String newcount = String.valueOf(currentCount2);
        sqlConnector2.UpdateHours(3,currentCount2);
        counter2.setText(newcount);
    }

    public void countDownStart() {
        handler = new Handler();
        runnable = new Runnable() {
            @Override
            public void run() {

                MySQLConnector sqlConnector = new MySQLConnector();
                ArrayList<String> assessmentInformation = sqlConnector.readAssessmentInformation();
                int displayCount = currentCount;
                int displayCount2 = currentCount2;
                int displayHours = sghours;
                int displayHours2 = sghours2;
                DateFormat dateFormat = new SimpleDateFormat(
                        "dd/MM/yyyy");

                String date = assessmentInformation.get(4);
                String date2 = assessmentInformation.get(7);

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
                try {

                    Date futureDate = dateFormat.parse(date2);
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
                        txtTimerDay2.setText("" + String.format("%02d", days));
                        txtTimerHour2.setText("" + String.format("%02d", hours));
                        txtTimerMinute2.setText(""
                                + String.format("%02d", minutes));
                        txtTimerSecond2.setText(""
                                + String.format("%02d", seconds));
                        if ((days * 2)< displayHours2-displayCount2){enoughtime.setBackgroundColor(Color.rgb(255,0,0));}
                        if (((days * 2)>= displayHours2-displayCount2)&&(days < displayHours2-displayCount2)){enoughtime.setBackgroundColor(Color.rgb(255,255,0));}
                        if (days >= displayHours2-displayCount2){enoughtime.setBackgroundColor(Color.rgb(0,255,0));}
                    } else {
                        tvEvent2.setVisibility(View.VISIBLE);
                        Addhours2.setVisibility(View.INVISIBLE);
                        counter2.setVisibility(View.INVISIBLE);
                        PlusCount2.setVisibility(View.INVISIBLE);
                        MinusCount2.setVisibility(View.INVISIBLE);
                        tvEvent2.setText("This assessment has ended!");
                        //textViewGone();
                        enoughtime2.setBackgroundColor(Color.rgb(255,0,0));
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }


            }

        };
        handler.postDelayed(runnable, 1 * 1000);
    }
}
