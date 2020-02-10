package com.khizar.year2groupproject;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;

import javax.annotation.Nullable;


public class MainActivity extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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
        FirebaseAuth fAuth = FirebaseAuth.getInstance();
        FirebaseFirestore fStore = FirebaseFirestore.getInstance();
        String userID = fAuth.getCurrentUser().getUid();

        DocumentReference documentReference = fStore.collection("users").document(userID);
        documentReference.addSnapshotListener(this, new EventListener<DocumentSnapshot>()
        {
            @Override
            public void onEvent(@Nullable DocumentSnapshot documentSnapshot, @Nullable FirebaseFirestoreException e)
            {
                String userCourse = documentSnapshot.getString("courseType");
                if(userCourse.matches("Computer Science"))
                {
                    Intent intent = new Intent(getApplicationContext(), ModuleSelectionActivity.class);
                    startActivity(intent);
                }
                else if(userCourse.matches("Business Computing"))
                {
                    Intent intent = new Intent(getApplicationContext(), ModuleSelectionBusinessComputingActivity.class);
                    startActivity(intent);
                }
                else
                {
                    Toast.makeText(getApplicationContext(),"FAILED",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public void timetableSelection(View view)
    {
        Intent intent = new Intent(getApplicationContext(), TimetableActivity.class);
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
