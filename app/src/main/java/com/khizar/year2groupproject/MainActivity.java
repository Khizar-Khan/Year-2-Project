package com.khizar.year2groupproject;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.work.Data;
import androidx.work.PeriodicWorkRequest;
import androidx.work.WorkInfo;
import androidx.work.WorkManager;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;
import android.widget.Toolbar;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.khizar.year2groupproject.workers.AssessmentDeadlineWorker;

import java.util.concurrent.TimeUnit;

import javax.annotation.Nullable;

public class MainActivity extends AppCompatActivity
{
    private PeriodicWorkRequest assessmentDeadlineWorkRequest;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final WorkManager mWorkManager = WorkManager.getInstance();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            assessmentDeadlineWorkRequest = new PeriodicWorkRequest.Builder(AssessmentDeadlineWorker.class, 15, TimeUnit.MINUTES)
                    .setInputData(
                            new Data.Builder()
                                .putInt(AssessmentDeadlineWorker.DAYS_TAG, 100)
                                .build()
                            )
                    .build();
        }

        mWorkManager.getWorkInfoByIdLiveData(assessmentDeadlineWorkRequest.getId()).observe(this, new Observer<WorkInfo>() {
            @Override
            public void onChanged(@Nullable WorkInfo workInfo) {
                if (workInfo != null) {
                    WorkInfo.State state = workInfo.getState();
                    if (state == WorkInfo.State.FAILED) {
                        Toast toast = Toast. makeText(getApplicationContext(), "Assessment Deadline Notification: " + state.toString(), Toast.LENGTH_SHORT);
                        toast.show();
                    }
                }
            }
        });

        //trigger manually on startup
        mWorkManager.enqueue(assessmentDeadlineWorkRequest);
    }

    public void logout(View view)
    {
        FirebaseAuth.getInstance().signOut();
        Intent intent = new Intent(getApplicationContext(), Login.class);
        startActivity(intent);
        finish();
    }

    public void profileSelection(View view)
    {
        Intent intent = new Intent(getApplicationContext(), ProfileActivity.class);
        startActivity(intent);
    }

    public void moduleSelection(View view)
    {
        Intent intent = new Intent(getApplicationContext(), ModuleSelectionActivity.class);
        startActivity(intent);
    }
    public void timetableSelection(View view)
    {
        Intent intent = new Intent(getApplicationContext(), activity_group_input.class);
        startActivity(intent);
    }

    public void industryPlacementsSelection(View view)
    {
        Intent intent = new Intent(getApplicationContext(), IndustryPlacementsActivity.class);
        startActivity(intent);
    }

    public void resourceSelection(View view)
    {
        Intent intent = new Intent(getApplicationContext(), ResourceActivity.class);
        startActivity(intent);
    }

    public void gradeCalculatorSelection(View view)
    {
        Intent intent = new Intent(getApplicationContext(), GradeCalcActivity.class);
        startActivity(intent);
    }
}