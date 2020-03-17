package com.khizar.year2groupproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;


import android.os.Bundle;

import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;


public class RequestResourceActivity extends AppCompatActivity {

    String Module_Code;
    String Resource_Type;
    String Resource_Name;

    EditText ResourceName_EditText;

    Button requestresource_submit_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_request_resource);

        ResourceName_EditText = findViewById(R.id.resourcename_editext);
        requestresource_submit_button = findViewById(R.id.requestresource_submit_button);

        Toolbar toolbar = findViewById(R.id.toolbar4);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        final Spinner modulecode_spinner = findViewById(R.id.modulecode_spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.Resource_Module, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        modulecode_spinner.setAdapter(adapter);

        modulecode_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String modulecode_string = modulecode_spinner.getSelectedItem().toString();
                Module_Code = modulecode_string;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });final Spinner resourcetype_spinner = findViewById(R.id.resourcetype_spinner);
        ArrayAdapter<CharSequence> adapter_two = ArrayAdapter.createFromResource(this, R.array.Resource_Type, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        resourcetype_spinner.setAdapter(adapter_two);

        resourcetype_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String resourcetype_string = resourcetype_spinner.getSelectedItem().toString();
                Resource_Type = resourcetype_string;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        requestresource_submit_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Resource_Name = ResourceName_EditText.getText().toString();
                MySQLConnector SQLConnect = new MySQLConnector();
                SQLConnect.writeRequestResources(Module_Code, Resource_Type, Resource_Name);
            }
        });
    }


    public boolean onOptionsItemSelected (MenuItem item) {
        if(item.getItemId()==android.R.id.home) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}
