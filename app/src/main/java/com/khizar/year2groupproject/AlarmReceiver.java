package com.khizar.year2groupproject;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;

public class AlarmReceiver extends BroadcastReceiver
{
    @Override
    public void onReceive(Context context, Intent intent)
    {
        //get id and message from intent//
        int notificationId = intent.getIntExtra("notificationId", 0);
        String message = intent.getStringExtra("todo");

        //When notification is tapped, call ReminderActivity//
        Intent reminderIntent = new Intent(context, ReminderActivity.class);
        PendingIntent contextIntent = PendingIntent.getActivity(context, 0, reminderIntent, 0);

        NotificationManager myNotificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);


        //Prepare notification//
        Notification.Builder builder = new Notification.Builder(context);
        builder.setSmallIcon(android.R.drawable.ic_dialog_info)
                .setContentTitle("Reminder Alert")
                .setContentText(message)
                .setWhen(System.currentTimeMillis())
                .setAutoCancel(true)
                .setContentIntent(contextIntent)
                .setPriority(Notification.PRIORITY_MAX)
                .setDefaults(Notification.DEFAULT_ALL);


        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O)
        {
            String channelId = "TaskReminder";
            NotificationChannel channel = new NotificationChannel(channelId, "Reminder", NotificationManager.IMPORTANCE_HIGH);
            myNotificationManager.createNotificationChannel(channel);
            builder.setChannelId(channelId);
        }

        //Notify//
        myNotificationManager.notify(notificationId, builder.build());
    }
}
