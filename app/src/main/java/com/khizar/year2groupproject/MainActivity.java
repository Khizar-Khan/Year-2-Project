package com.khizar.year2groupproject;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.provider.Settings;
import android.view.View;
import android.widget.Button;

import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import java.util.Scanner;
import javax.annotation.Nullable;

public class MainActivity extends AppCompatActivity
{
    static String userName = "#", uniqueID="#";

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FirebaseApp.initializeApp(this);
        checkandGetName();
        Button dF = findViewById(R.id.discussionBTN);
        Button rS = findViewById(R.id.resetBTN);
        dF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent newActivity = new Intent(MainActivity.this, DiscussionForum1.class);
                startActivity(newActivity);
            }
        });
        rS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showResetAlert();
            }
        });
    }

    public void showResetAlert(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Reset Discussion forum settings?");
        builder.setPositiveButton("RESET", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int id) {
                try {
                    FirebaseDatabase dReference = FirebaseDatabase.getInstance();
                    DatabaseReference aReference = dReference.getReference("ForumMessages");
                    DatabaseReference aReferenceUser = dReference.getReference("UserName");
                    aReference.removeValue();
                    aReferenceUser.removeValue();
                    userName="#";
                    uniqueID="UUID";
                    dialog.dismiss();
                }catch (Exception ignored){}
            }
        }).setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                dialog.dismiss();
            }
        });
        AlertDialog ad=builder.create();
        ad.show();
    }

    @SuppressLint("HardwareIds")
    public void checkandGetName()
    {
        uniqueID = Settings.Secure.getString(getContentResolver(),
                Settings.Secure.ANDROID_ID);
        FirebaseDatabase dReference = FirebaseDatabase.getInstance();
        DatabaseReference aReference = dReference.getReference("UserName").child(uniqueID);
        aReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String name = dataSnapshot.getValue()+"";
                if(!name.equals("null")){
                    userName = name;
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });
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