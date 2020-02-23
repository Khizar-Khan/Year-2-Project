package com.khizar.year2groupproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class IndustryPlacementsActivity extends AppCompatActivity {

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
    }

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
            }
        }
    };
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