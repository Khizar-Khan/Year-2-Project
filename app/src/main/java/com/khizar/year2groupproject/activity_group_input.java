package com.khizar.year2groupproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class activity_group_input extends AppCompatActivity {

    public static int GroupNumber;


    EditText GroupNumberInput;

    Button goButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_group_input);

        GroupNumberInput = (EditText) findViewById(R.id.groupNumberInput);

        goButton = (Button) findViewById(R.id.btnGo);
        goButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GroupNumber = Integer.valueOf(GroupNumberInput.getText().toString());
                if (GroupNumber >= 1 && GroupNumber <= 44){
                    Intent intent = new Intent(getApplicationContext(), TimetableActivity.class);
                    startActivity(intent);
                }
                else {
                    showToast("Please Enter a Valid Group Number");
                }
            }
        });

    }

    private void showToast(String text) {
        Toast.makeText(activity_group_input.this, text, Toast.LENGTH_SHORT).show();
    }
}
