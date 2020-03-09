package com.khizar.year2groupproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class IndustryPlacementsActivity extends AppCompatActivity {

    FirebaseAuth fAuth =  FirebaseAuth.getInstance();
    String userID = fAuth.getCurrentUser().getUid();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_industry_placements);

        defineButtons();

    }

    public void defineButtons() {
        findViewById(R.id.button).setOnClickListener(buttonClickListener);
        findViewById(R.id.button2).setOnClickListener(buttonClickListener);
        findViewById(R.id.button3).setOnClickListener(buttonClickListener);
        findViewById(R.id.button5).setOnClickListener(buttonClickListener);
    }

    private String email;
    private int CVCOMP;
    private int COVERLCOMP;
    private int NoOfPlacements;
    private int InterviewsPending;
    private int JobOffers;
    private String CVCOMPYN;
    private String COVERLCOMPYN;

    private View.OnClickListener buttonClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()) {

                case R.id.button:
                    Intent viewPlacements = new Intent(IndustryPlacementsActivity.this, ChatActivity.class);
                    startActivity(viewPlacements);
                    break;
                case R.id.button2:
                    Intent bookAppointments = new Intent(IndustryPlacementsActivity.this, BookAppointment.class);
                    startActivity(bookAppointments);
                    break;
                case R.id.button3:
                    Intent editPlacements = new Intent(IndustryPlacementsActivity.this, EditPlacementProgressActivity.class);
                    startActivity(editPlacements);
                    /*MySQLConnector SQLConnect = new MySQLConnector();
                    SQLConnect.industrySQLconnect();*/
                    break;
                case R.id.button5:

                    enableStrictMode();

                    try {
                        Statement stmt;
                        ResultSet rs;

                        //Register the JDBC driver for MySQL

                        Class.forName("com.mysql.jdbc.Driver");

                        String url = "jdbc:mysql://172.31.82.82:3306/UserPlacementStatistics";

                        Connection con = DriverManager.getConnection( url,"Mznk","Mznk");
                        Statement select = con.createStatement();

                        // Execute a query

                        rs = select.executeQuery("SELECT email, CVComp, CoverLComp, NoOfPlacements, InterviewsPending, JobOffers FROM PlacementProgress WHERE email = '"+userID+"'");

                        System.out.println("Some results:");
                        while (rs.next()) { // process results one row at a time
                            String email = rs.getString("email");
                            CVCOMP = rs.getInt(2);
                            COVERLCOMP = rs.getInt(3);
                            NoOfPlacements = rs.getInt(4);
                            InterviewsPending = rs.getInt(5);
                            JobOffers = rs.getInt(6);

                            if (CVCOMP ==1){
                                CVCOMPYN = "Yes";
                            } else{
                                CVCOMPYN = "No";
                            }

                            if (COVERLCOMP ==1) {
                                COVERLCOMPYN = "Yes";
                            } else {
                                COVERLCOMPYN = "No";
                            }


                            TextView CVText = (TextView) findViewById(R.id.textView42);
                            CVText.setText(CVCOMPYN);

                            TextView CvrLtrText = (TextView) findViewById(R.id.textView45);
                            CvrLtrText.setText(COVERLCOMPYN);

                            TextView NoAppsText = (TextView) findViewById(R.id.textView49);
                            NoAppsText.setText(Integer.toString(NoOfPlacements));

                            TextView NoIntevsText = (TextView) findViewById(R.id.textView53);
                            NoIntevsText.setText(Integer.toString(InterviewsPending));

                            TextView JobOffersText = (TextView) findViewById(R.id.textView56);
                            JobOffersText.setText(Integer.toString(JobOffers));
                        }
                    }
                    catch (Exception e) {
                        System.out.println(e);

            }

        }
    }




        /*public void cvTxtBox(View v){
        TextView t = (TextView) findViewById(R.id.textView42);
        t.setText(CVCOMP);*/
    };

    public static void enableStrictMode()
    {
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();

        StrictMode.setThreadPolicy(policy);
    }

}





    /*private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_industry_placements);

        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openChatActivity();
            }
        });
    }

    public void openChatActivity() {
        Intent intent = new Intent(this, ChatActivity.class);
        startActivity(intent);
    }

    private Button button2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_industry_placements);

        button2 = (Button) findViewById(R.id.button2);
        button.setOnClickListener
        */