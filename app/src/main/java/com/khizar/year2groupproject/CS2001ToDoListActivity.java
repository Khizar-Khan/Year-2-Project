package com.khizar.year2groupproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class CS2001ToDoListActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    ArrayList<String> toDoList;
    ArrayAdapter<String> arrayAdapter;
    ListView listView;
    EditText editText;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cs2001_to_do_list);

        toDoList = FileHelper.readData(this);
        arrayAdapter = new ArrayAdapter<>(this, R.layout.list_view_layout, toDoList);
        listView = findViewById(R.id.listView);
        listView.setAdapter(arrayAdapter);
        listView.setOnItemClickListener(this);

        editText = findViewById(R.id.taskET);
    }

    public void addItemBTN(View view)
    {
        String taskEntered = editText.getText().toString();
        if(taskEntered.isEmpty())
        {
            Toast.makeText(CS2001ToDoListActivity.this, "Please enter a task", Toast.LENGTH_SHORT).show();
        }
        else
        {
            arrayAdapter.add(taskEntered);
            editText.setText("");
            FileHelper.writeData(toDoList, this);
        }
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l)
    {
        toDoList.remove(i);
        arrayAdapter.notifyDataSetChanged();
        FileHelper.writeData(toDoList, this);
    }
}
