package com.khizar.year2groupproject.workers;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.os.Build;
import androidx.annotation.NonNull;
import androidx.core.app.NotificationCompat;
import androidx.work.Data;
import androidx.work.Worker;
import androidx.work.WorkerParameters;

import com.khizar.year2groupproject.MySQLConnector;
import com.khizar.year2groupproject.R;
import com.khizar.year2groupproject.Utils.DateUtil;
import com.khizar.year2groupproject.models.Assessment;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;

public class AssessmentDeadlineWorker extends Worker {
    public static final String DAYS_TAG = "days";
    private static final String WORK_RESULT = "work_result";
    public AssessmentDeadlineWorker(@NonNull Context context, @NonNull WorkerParameters workerParams) {
        super(context, workerParams);
    }

    @NonNull
    @Override
    public Result doWork() {
        Data taskData = getInputData();
        // use 1 week as default amount of days
        int days = taskData.getInt(DAYS_TAG, 7);
        MySQLConnector sqlConnector = new MySQLConnector();
        Date currentDate = new Date();
        Date startDate = currentDate;
        Date endDate = DateUtil.AddDays(currentDate, days);

        ArrayList<Assessment> assessments = Assessment.GetBetween(sqlConnector, startDate, endDate);
        if (!assessments.isEmpty())
            showNotification(assessments);

        Data outputData = new Data.Builder().putString(WORK_RESULT, "Jobs Finished").build();
        return Result.success(outputData);
    }
    private void showNotification(ArrayList<Assessment> assessments) {
        NotificationManager manager = (NotificationManager) getApplicationContext().getSystemService(Context.NOTIFICATION_SERVICE);
        String channelId = "task_channel";
        String channelName = "task_name";
        String contentText = "";
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel channel = new
                    NotificationChannel(channelId, channelName, NotificationManager.IMPORTANCE_DEFAULT);
            manager.createNotificationChannel(channel);
        }

        for(int i = 0; i < assessments.size(); i++)
        {
            Assessment assessment = assessments.get(i);
            contentText += assessment.getType() + " Due on " + assessment.getDeadline();
        }

        NotificationCompat.Builder builder = new NotificationCompat.Builder(getApplicationContext(), channelId)
                .setContentTitle("Assessment Deadline")
                .setContentText(contentText)
                .setSmallIcon(R.mipmap.ic_launcher);
        manager.notify(1, builder.build());
    }
}