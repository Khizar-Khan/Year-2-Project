package com.khizar.year2groupproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;

import java.text.DecimalFormat;
import java.util.ArrayList;

import javax.annotation.Nullable;

public class ProfileActivity extends AppCompatActivity
{
    TextView fullName, email, courseType;
    FirebaseAuth fAuth;
    FirebaseFirestore fStore;
    String userID;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        fullName = findViewById(R.id.profileName);
        email = findViewById(R.id.profileEmail);
        courseType = findViewById(R.id.profileCourseType);

        fAuth = FirebaseAuth.getInstance();
        fStore = FirebaseFirestore.getInstance();

        userID = fAuth.getCurrentUser().getUid();

        DocumentReference documentReference = fStore.collection("users").document(userID);
        documentReference.addSnapshotListener(this, new EventListener<DocumentSnapshot>()
        {
            @Override
            public void onEvent(@Nullable DocumentSnapshot documentSnapshot, @Nullable FirebaseFirestoreException e)
            {
                fullName.setText(documentSnapshot.getString("fullName"));
                email.setText(documentSnapshot.getString("email"));
                courseType.setText(documentSnapshot.getString("courseType"));
            }
        });

        MySQLConnector sqlConnector = new MySQLConnector();

        ArrayList<String> moduleInformation = sqlConnector.readModuleInformation();
        ArrayList<String> userGrade1 = sqlConnector.readUserGrade("CS2001");
        ArrayList<String> userGrade2 = sqlConnector.readUserGrade("CS2002");
        ArrayList<String> userGrade3 = sqlConnector.readUserGrade("CS2003");
        ArrayList<String> userGrade4 = sqlConnector.readUserGrade("CS2004");
        ArrayList<String> userGrade5 = sqlConnector.readUserGrade("CS2005");

        double cs2001GradeOne = Integer.valueOf(userGrade1.get(0));
        double cs2002GradeOne = Integer.valueOf(userGrade2.get(0));
        double cs2002GradeTwo = Integer.valueOf(userGrade2.get(1));
        double cs2003GradeOne = Integer.valueOf(userGrade3.get(0));
        double cs2004GradeOne = Integer.valueOf(userGrade4.get(0));
        double cs2004GradeTwo = Integer.valueOf(userGrade4.get(1));
        double cs2005GradeOne = Integer.valueOf(userGrade5.get(0));
        double cs2005GradeTwo = Integer.valueOf(userGrade5.get(1));

        double cs2002Overall = ((cs2002GradeOne*50) + (cs2002GradeTwo*50))/100;
        double cs2004Overall = ((cs2004GradeOne*60) + (cs2004GradeTwo*40))/100;
        double cs2005Overall = ((cs2005GradeOne*25) + (cs2005GradeTwo*75))/100;

        double cs2001Credits = Integer.valueOf(moduleInformation.get(3));
        double cs2002Credits = Integer.valueOf(moduleInformation.get(8));
        double cs2003Credits = Integer.valueOf(moduleInformation.get(13));
        double cs2004Credits = Integer.valueOf(moduleInformation.get(18));
        double cs2005Credits = Integer.valueOf(moduleInformation.get(23));

        double yearOverall = ((cs2001GradeOne*cs2001Credits) + (cs2002Overall*cs2002Credits) + (cs2003GradeOne*cs2003Credits) + (cs2004Overall*cs2004Credits) + (cs2005Overall*cs2005Credits))/120;
        TextView mCurrentGradeTXT = findViewById(R.id.currentGradeTXT);
        if(yearOverall <= 29.49)
        {
            mCurrentGradeTXT.setText("F");
        }
        else if (yearOverall >= 29.50 && yearOverall <= 32.49)
        {
            mCurrentGradeTXT.setText("E-");
        }
        else if (yearOverall >= 32.50 && yearOverall <= 37.49)
        {
            mCurrentGradeTXT.setText("E");
        }
        else if (yearOverall >= 37.50 && yearOverall <= 39.49)
        {
            mCurrentGradeTXT.setText("E+");
        }
        else if (yearOverall >= 39.50 && yearOverall <= 42.49)
        {
            mCurrentGradeTXT.setText("D-");
        }
        else if (yearOverall >= 42.50 && yearOverall <= 47.49)
        {
            mCurrentGradeTXT.setText("D");
        }
        else if (yearOverall >= 47.50 && yearOverall <= 49.49)
        {
            mCurrentGradeTXT.setText("D+");
        }
        else if (yearOverall >= 49.50 && yearOverall <= 52.49)
        {
            mCurrentGradeTXT.setText("C-");
        }
        else if (yearOverall >= 52.50 && yearOverall <= 57.49)
        {
            mCurrentGradeTXT.setText("C");
        }
        else if (yearOverall >= 57.50 && yearOverall <= 59.49)
        {
            mCurrentGradeTXT.setText("C+");
        }
        else if (yearOverall >= 59.50 && yearOverall <= 62.49)
        {
            mCurrentGradeTXT.setText("B-");
        }
        else if (yearOverall >= 62.50 && yearOverall <= 67.49)
        {
            mCurrentGradeTXT.setText("B");
        }
        else if (yearOverall >= 67.50 && yearOverall <= 69.49)
        {
            mCurrentGradeTXT.setText("B+");
        }
        else if (yearOverall >= 69.50 && yearOverall <= 72.49)
        {
            mCurrentGradeTXT.setText("A-");
        }
        else if (yearOverall >= 72.50 && yearOverall <= 79.49)
        {
            mCurrentGradeTXT.setText("A");
        }
        else if (yearOverall >= 79.50 && yearOverall <= 89.49)
        {
            mCurrentGradeTXT.setText("A+");
        }
        else if (yearOverall >= 89.50)
        {
            mCurrentGradeTXT.setText("A*");
        }
        else
        {
            mCurrentGradeTXT.setText("ERROR");
        }

        TextView mCurrentPecTXT = findViewById(R.id.currentPercTXT);
        DecimalFormat decimalFormat = new DecimalFormat("#.##");

        mCurrentPecTXT.setText(decimalFormat.format(yearOverall) + "%");
    }
}
