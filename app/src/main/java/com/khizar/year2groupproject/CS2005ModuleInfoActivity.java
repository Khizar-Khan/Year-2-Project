package com.khizar.year2groupproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;

public class CS2005ModuleInfoActivity extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cs2005_module_info);

        TextView mModuleCode = findViewById(R.id.moduleCodeTXT);
        TextView mModuleName = findViewById(R.id.moduleNameTXT);
        TextView mModuleLeader = findViewById(R.id.moduleLeaderTXT);
        TextView mModuleCredits = findViewById(R.id.moduleCreditsTXT);
        TextView mModuleAssessments = findViewById(R.id.moduleAssessmentsTXT);

        MySQLConnector sqlConnector = new MySQLConnector();
        ArrayList<String> moduleInformation = sqlConnector.readModuleInformation();

        mModuleCode.setText(moduleInformation.get(20));
        mModuleName.setText(moduleInformation.get(21));
        mModuleLeader.setText(moduleInformation.get(22));
        mModuleCredits.setText(moduleInformation.get(23));
        mModuleAssessments.setText(moduleInformation.get(24));
    }
}
