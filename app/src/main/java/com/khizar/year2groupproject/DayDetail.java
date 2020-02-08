package com.khizar.year2groupproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.khizar.year2groupproject.Utils.LetterImageView;
import java.util.ArrayList;

import androidx.appcompat.widget.Toolbar;



public class DayDetail extends AppCompatActivity {

    private ListView listView;
    private Toolbar toolbar;
    public static String[] Monday;
    public static String[] Tuesday;
    public static String[] Wednesday;
    public static String[] Thursday;
    public static String[] Friday;
    public static String[] Time1;
    public static String[] Time2;
    public static String[] Time3;
    public static String[] Time4;
    public static String[] Time5;
    private String[] PreferredDay;
    private String[] PreferredTime;
    ArrayList<String> Mondays = new ArrayList<String>();
    ArrayList<String> Tuesdays = new ArrayList<String>();
    ArrayList<String> Wednesdays = new ArrayList<String>();
    ArrayList<String> Thursdays = new ArrayList<String>();
    ArrayList<String> Fridays = new ArrayList<String>();

    ArrayList<String> Times1 = new ArrayList<String>();
    ArrayList<String> Times2 = new ArrayList<String>();
    ArrayList<String> Times3 = new ArrayList<String>();
    ArrayList<String> Times4 = new ArrayList<String>();
    ArrayList<String> Times5 = new ArrayList<String>();






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_day_detail);

        setupUIViews();
        initToolbar();
        setupListView();
    }
    private void setupUIViews(){
        listView = (ListView)findViewById(R.id.lvDayDetail);
        toolbar = (Toolbar)findViewById(R.id.ToolbarDayDetail);
    }

    private void initToolbar(){
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(TimetableActivity.sharedPreferences.getString(TimetableActivity.SEL_DAY, null));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    private void setupListView(){

        Mondays = MySQLConnector.readTimetableDayData("Monday");
        Tuesdays = MySQLConnector.readTimetableDayData("Tuesday");
        Wednesdays = MySQLConnector.readTimetableDayData("Wednesday");
        Thursdays = MySQLConnector.readTimetableDayData("Thursday");
        Fridays = MySQLConnector.readTimetableDayData("Friday");

        Monday = Mondays.toArray(new String[Mondays.size()]);
        Tuesday = Tuesdays.toArray(new String[Tuesdays.size()]);
        Wednesday = Wednesdays.toArray(new String[Wednesdays.size()]);
        Thursday = Thursdays.toArray(new String[Thursdays.size()]);
        Friday = Fridays.toArray(new String[Fridays.size()]);

        Times1 = MySQLConnector.readTimetableTimeData("Monday");
        Times2 = MySQLConnector.readTimetableTimeData("Tuesday");
        Times3 = MySQLConnector.readTimetableTimeData("Wednesday");
        Times4 = MySQLConnector.readTimetableTimeData("Thursday");
        Times5 = MySQLConnector.readTimetableTimeData("Friday");

        Time1 = Times1.toArray(new String[Times1.size()]);
        Time2 = Times2.toArray(new String[Times2.size()]);
        Time3 = Times3.toArray(new String[Times3.size()]);
        Time4 = Times4.toArray(new String[Times4.size()]);
        Time5 = Times5.toArray(new String[Times5.size()]);

        String selected_day = TimetableActivity.sharedPreferences.getString(TimetableActivity.SEL_DAY, null);

        if(selected_day.equalsIgnoreCase("Monday")){
            PreferredDay = Monday;
            PreferredTime = Time1;
        }else if(selected_day.equalsIgnoreCase("Tuesday")){
            PreferredDay = Tuesday;
            PreferredTime = Time2;
        }else if(selected_day.equalsIgnoreCase("Wednesday")){
            PreferredDay = Wednesday;
            PreferredTime = Time3;
        }else if(selected_day.equalsIgnoreCase("Thursday")){
            PreferredDay = Thursday;
            PreferredTime = Time4;
        }else if(selected_day.equalsIgnoreCase("Friday")){
            PreferredDay = Friday;
            PreferredTime = Time5;
        }

        SimpleAdapter simpleAdapter = new SimpleAdapter(DayDetail.this, PreferredDay, PreferredTime);
        listView.setAdapter(simpleAdapter);
    }

    public class SimpleAdapter extends BaseAdapter {

        private Context mContext;
        private LayoutInflater layoutInflater;
        private TextView subject, time;
        private String[] subjectArray;
        private String[] timeArray;
        private LetterImageView letterImageView;

        TimetableActivity toolbarz = new TimetableActivity();

        public SimpleAdapter(Context context, String[] subjectArray, String[] timeArray){
            mContext = context;
            this.subjectArray = subjectArray;
            this.timeArray = timeArray;
            layoutInflater = LayoutInflater.from(context);
        }


        @Override
        public int getCount() {
            return subjectArray.length;
        }

        @Override
        public Object getItem(int position) {
            return subjectArray[position];
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if(convertView == null){
                convertView = layoutInflater.inflate(R.layout.day_detail_single_item, null);
            }

            subject = (TextView)convertView.findViewById(R.id.tvSubjectDayDetails);
            time = (TextView)convertView.findViewById(R.id.tvTimeDayDetail);
            letterImageView = (LetterImageView)convertView.findViewById(R.id.ivDayDetails);

            subject.setText(subjectArray[position]);
            time.setText(timeArray[position]);

            letterImageView.setOval(true);
            letterImageView.setLetter(subjectArray[position].charAt(0));

            return convertView;

        }
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId()){
            case android.R.id.home : {
                onBackPressed();
             }
        }
        return super.onOptionsItemSelected(item);
    }
}
