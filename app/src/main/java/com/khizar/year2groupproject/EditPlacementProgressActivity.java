package com.khizar.year2groupproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Spinner;
import android.widget.TextView;

public class EditPlacementProgressActivity extends AppCompatActivity {

    private int placementsNo;
    private int interviewsNo;
    private int jobOfferNo;

import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class EditPlacementProgressActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_placement_progress);

        final Spinner mySpinner = (Spinner) findViewById(R.id.spinner2);
        Spinner mySpinner = (Spinner) findViewById(R.id.spinner2);

        ArrayAdapter<String> myAdapter = new ArrayAdapter<String>(EditPlacementProgressActivity.this, android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.numbers));
        myAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mySpinner.setAdapter(myAdapter);
        String placementsString = mySpinner.getSelectedItem().toString();

        mySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                placementsNo = Integer.parseInt(mySpinner.getSelectedItem().toString());
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                placementsNo = Integer.parseInt(mySpinner.getSelectedItem().toString());
            }
        });


        final Spinner mySpinner2 = (Spinner) findViewById(R.id.spinner3);

        Spinner mySpinner2 = (Spinner) findViewById(R.id.spinner3);

        ArrayAdapter<String> myAdapter2 = new ArrayAdapter<String>(EditPlacementProgressActivity.this, android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.numbers));
        myAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mySpinner2.setAdapter(myAdapter2);

        mySpinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                interviewsNo = Integer.parseInt(mySpinner2.getSelectedItem().toString());
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                interviewsNo = Integer.parseInt(mySpinner2.getSelectedItem().toString());
            }
        });

        final Spinner mySpinner3 = (Spinner) findViewById(R.id.spinner4);
        Spinner mySpinner3 = (Spinner) findViewById(R.id.spinner4);

        ArrayAdapter<String> myAdapter3 = new ArrayAdapter<String>(EditPlacementProgressActivity.this, android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.numbers));
        myAdapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mySpinner3.setAdapter(myAdapter2);

        mySpinner3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                jobOfferNo = Integer.parseInt(mySpinner3.getSelectedItem().toString());
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                jobOfferNo = Integer.parseInt(mySpinner3.getSelectedItem().toString());
            }
        });
    }


    /*TextView emailSQL = findViewById(R.id.email);*/

    private int cvInt;
    private int coverLInt;


    public void CVCheck(View v){
        CheckBox checkBox = (CheckBox) v;
        if(checkBox.isChecked()){
            cvInt = 1;
        } else {
            cvInt = 0;
        }
    }

    public void coverLCheck(View v){
        CheckBox checkBox = (CheckBox) v;
        if(checkBox.isChecked()) {
            coverLInt = 1;
        } else {
            coverLInt = 0;
        }
    }

    public void buttonOnClick(View v) {
        Button button = (Button) v;
        MySQLConnector SQLConnect = new MySQLConnector();
        SQLConnect.industrySQLconnect(1,cvInt,coverLInt,placementsNo,interviewsNo, jobOfferNo);
    }

    }


}
