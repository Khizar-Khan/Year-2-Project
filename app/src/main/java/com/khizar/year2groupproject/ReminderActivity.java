package com.khizar.year2groupproject;

import androidx.appcompat.app.AppCompatActivity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;

public class ReminderActivity extends AppCompatActivity
{
    private int notificationId = 1;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reminder);
    }

    public void anyBTN(View view)
    {
        EditText editText = findViewById(R.id.editText);
        TimePicker timePicker = findViewById(R.id.timePicker);
        DatePicker datePicker = findViewById(R.id.datePicker);

        //Set notificationId and text//
        Intent intent = new Intent(this, AlarmReceiver.class);
        intent.putExtra("notificationId", notificationId);
        intent.putExtra("todo", editText.getText().toString());

        //getBroadcast(context, requestCode, intent, flags)//
        PendingIntent alarmIntent = PendingIntent.getBroadcast(this, 0, intent, PendingIntent.FLAG_CANCEL_CURRENT);

        AlarmManager alarm = (AlarmManager) getSystemService(ALARM_SERVICE);

        switch (view.getId())
        {
            case R.id.setBTN:
                try
                {
                    int hour = timePicker.getCurrentHour();
                    int minute = timePicker.getCurrentMinute();
                    int year = datePicker.getYear();
                    int month = datePicker.getMonth();
                    int day = datePicker.getDayOfMonth();

                    //Create time//
                    Calendar startTime = Calendar.getInstance();
                    startTime.set(Calendar.HOUR_OF_DAY, hour);
                    startTime.set(Calendar.MINUTE, minute);
                    startTime.set(Calendar.SECOND, 0);
                    startTime.set(Calendar.YEAR, year);
                    startTime.set(Calendar.MONTH, month);
                    startTime.set(Calendar.DAY_OF_MONTH, day);
                    long alarmStartTime = startTime.getTimeInMillis();

                    //Set alarm//
                    //set(type, milliseconds, intent)
                    alarm.set(AlarmManager.RTC_WAKEUP,alarmStartTime,alarmIntent);

                    editText.setText("");
                    Toast.makeText(this, "Reminder Set", Toast.LENGTH_SHORT).show();

                    Intent intentBack = new Intent(getApplicationContext(), ModuleSelectionActivity.class);
                    startActivity(intentBack);

                }catch (Exception e)
                {
                    Toast.makeText(this, "Fail", Toast.LENGTH_SHORT).show();
                }
                break;

            case R.id.cancelBTN:
                alarm.cancel(alarmIntent);
                Toast.makeText(this, "Canceled", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
