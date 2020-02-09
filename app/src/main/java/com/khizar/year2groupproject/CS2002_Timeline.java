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

    private TextView txtTimerDay, txtTimerDay2, txtTimerHour, txtTimerHour2, txtTimerMinute, txtTimerMinute2, txtTimerSecond, txtTimerSecond2, assessment, assessment2, enoughtime, enoughtime2;
    private TextView tvEvent, tvEvent2;
    private Handler handler;
    private Runnable runnable;

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

        txtTimerDay2 = (TextView) findViewById(R.id.txtTimerDay2);
        txtTimerHour2 = (TextView) findViewById(R.id.txtTimerHour2);
        txtTimerMinute2 = (TextView) findViewById(R.id.txtTimerMinute2);
        txtTimerSecond2 = (TextView) findViewById(R.id.txtTimerSecond2);
        enoughtime2 = (TextView) findViewById(R.id.enoughtime2);
        assessment2 = (TextView) findViewById(R.id.Assessment_name2);
        assessment2.setText(assessmentInformation.get(6));
        tvEvent2 = (TextView) findViewById(R.id.tvEvent2);
        countDownStart();
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
                    String sghour = "60";
                    int sghours = Integer.parseInt(sghour);
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
                        if ((days * 2)< sghours){enoughtime.setBackgroundColor(Color.rgb(255,0,0));}
                        if (((days * 2)>= sghours)&&(days < sghours)){enoughtime.setBackgroundColor(Color.rgb(255,255,0));}
                        if (days >= sghours){enoughtime.setBackgroundColor(Color.rgb(0,255,0));}
                    } else {
                        tvEvent.setVisibility(View.VISIBLE);
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
                    String sghour = "60";
                    int sghours = Integer.parseInt(sghour);
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
                        if ((days * 2)< sghours){enoughtime2.setBackgroundColor(Color.rgb(255,0,0));}
                        if (((days * 2)>= sghours)&&(days < sghours)){enoughtime2.setBackgroundColor(Color.rgb(255,255,0));}
                        if (days >= sghours){enoughtime2.setBackgroundColor(Color.rgb(0,255,0));}
                    } else {
                        tvEvent2.setVisibility(View.VISIBLE);
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