package com.khizar.year2groupproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class EditPlacementProgressActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_placement_progress);

        Spinner mySpinner = (Spinner) findViewById(R.id.spinner2);

        ArrayAdapter<String> myAdapter = new ArrayAdapter<String>(EditPlacementProgressActivity.this, android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.numbers));
        myAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mySpinner.setAdapter(myAdapter);

        Spinner mySpinner2 = (Spinner) findViewById(R.id.spinner3);

        ArrayAdapter<String> myAdapter2 = new ArrayAdapter<String>(EditPlacementProgressActivity.this, android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.numbers));
        myAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mySpinner2.setAdapter(myAdapter2);

        Spinner mySpinner3 = (Spinner) findViewById(R.id.spinner4);

        ArrayAdapter<String> myAdapter3 = new ArrayAdapter<String>(EditPlacementProgressActivity.this, android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.numbers));
        myAdapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mySpinner3.setAdapter(myAdapter2);
    }


}
