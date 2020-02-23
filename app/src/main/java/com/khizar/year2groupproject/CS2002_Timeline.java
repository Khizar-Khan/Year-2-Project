package com.khizar.year2groupproject;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import java.text.SimpleDateFormat;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import android.graphics.Color;

import android.os.Handler;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

public class CS2002_Timeline extends AppCompatActivity {

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
        setContentView(R.layout.activity_cs2002__timeline);

        MySQLConnector sqlConnector = new MySQLConnector();
        ArrayList<String> assessmentInformation = sqlConnector.readAssessmentInformation();
        //final Scanner scanner;
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

                handler.postDelayed(this, 1000);
                try {
                    DateFormat dateFormat = new SimpleDateFormat(
                            "dd/MM/yyyy");
                    MySQLConnector sqlConnector = new MySQLConnector();
                    ArrayList<String> assessmentInformation = sqlConnector.readAssessmentInformation();
                    String date = assessmentInformation.get(4);
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
                        if ((days * 2)< sghours-currentCount){enoughtime.setBackgroundColor(Color.rgb(255,0,0));}
                        if (((days * 2)>= sghours-currentCount)&&(days < sghours-currentCount)){enoughtime.setBackgroundColor(Color.rgb(255,255,0));}
                        if (days >= sghours-currentCount){enoughtime.setBackgroundColor(Color.rgb(0,255,0));}
                    } else {
                        tvEvent.setVisibility(View.VISIBLE);
                        Addhours.setVisibility(View.INVISIBLE);
                        counter.setVisibility(View.INVISIBLE);
                        PlusCount.setVisibility(View.INVISIBLE);
                        MinusCount.setVisibility(View.INVISIBLE);
                        tvEvent.setText("This assessment has ended!");
                        textViewGone();
                        enoughtime.setBackgroundColor(Color.rgb(255,0,0));
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }
                try {
                    DateFormat dateFormat = new SimpleDateFormat(
                            "dd/MM/yyyy");
                    MySQLConnector sqlConnector = new MySQLConnector();
                    ArrayList<String> assessmentInformation = sqlConnector.readAssessmentInformation();
                    String date = assessmentInformation.get(7);
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
                        txtTimerDay2.setText("" + String.format("%02d", days));
                        txtTimerHour2.setText("" + String.format("%02d", hours));
                        txtTimerMinute2.setText(""
                                + String.format("%02d", minutes));
                        txtTimerSecond2.setText(""
                                + String.format("%02d", seconds));
                        if ((days * 2)< sghours2-currentCount2){enoughtime.setBackgroundColor(Color.rgb(255,0,0));}
                        if (((days * 2)>= sghours2-currentCount2)&&(days < sghours2-currentCount2)){enoughtime.setBackgroundColor(Color.rgb(255,255,0));}
                        if (days >= sghours2-currentCount2){enoughtime.setBackgroundColor(Color.rgb(0,255,0));}
                    } else {
                        tvEvent2.setVisibility(View.VISIBLE);
                        Addhours2.setVisibility(View.INVISIBLE);
                        counter2.setVisibility(View.INVISIBLE);
                        PlusCount2.setVisibility(View.INVISIBLE);
                        MinusCount2.setVisibility(View.INVISIBLE);
                        tvEvent2.setText("This assessment has ended!");
                        textViewGone();
                        enoughtime2.setBackgroundColor(Color.rgb(255,0,0));
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }


            }

        };
        handler.postDelayed(runnable, 1 * 1000);
    }

    public void textViewGone() {
       /* findViewById(R.id.LinearLayout10).setVisibility(View.GONE);
        findViewById(R.id.LinearLayout11).setVisibility(View.GONE);
        findViewById(R.id.LinearLayout12).setVisibility(View.GONE);
        findViewById(R.id.LinearLayout13).setVisibility(View.GONE);
        findViewById(R.id.textView1).setVisibility(View.GONE);
        findViewById(R.id.textView2).setVisibility(View.GONE);*/
    }

}