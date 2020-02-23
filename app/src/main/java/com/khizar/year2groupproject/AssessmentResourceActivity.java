package com.khizar.year2groupproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AssessmentResourceActivity extends AppCompatActivity {

    Button second_mainmenuButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_assessment_resource);

        second_mainmenuButton = findViewById(R.id.second_mainmenuButton);

        second_mainmenuButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(AssessmentResourceActivity.this, MainActivity.class));

            }
        });
    }
}
