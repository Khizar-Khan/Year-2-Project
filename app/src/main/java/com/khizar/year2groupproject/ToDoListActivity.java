package com.khizar.year2groupproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class ToDoListActivity extends AppCompatActivity {
    ArrayList<String> cs2001ToDoList;
    ArrayList<String> cs2002ToDoList;
    ArrayList<String> cs2003ToDoList;
    ArrayList<String> cs2004ToDoList;
    ArrayList<String> cs2005ToDoList;
    ArrayAdapter<String> cs2001ArrayAdapter;
    ArrayAdapter<String> cs2002ArrayAdapter;
    ArrayAdapter<String> cs2003ArrayAdapter;
    ArrayAdapter<String> cs2004ArrayAdapter;
    ArrayAdapter<String> cs2005ArrayAdapter;
    ListView cs2001ListView;
    ListView cs2002ListView;
    ListView cs2003ListView;
    ListView cs2004ListView;
    ListView cs2005ListView;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_to_do_list);

        //CS2001 TO DO LIST//
        cs2001ToDoList = FileHelper.readData(this);
        cs2001ArrayAdapter = new ArrayAdapter<>(this, R.layout.list_view_layout, cs2001ToDoList);
        cs2001ListView = findViewById(R.id.cs2001ListView);
        cs2001ListView.setAdapter(cs2001ArrayAdapter);
        cs2001ListView.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l)
            {
                cs2001ToDoList.remove(i);
                cs2001ArrayAdapter.notifyDataSetChanged();
                FileHelper.writeData(cs2001ToDoList, ToDoListActivity.this);
            }
        });

        //CS2002 TO DO LIST//
        cs2002ToDoList = FileHelper1.readData(this);
        cs2002ArrayAdapter = new ArrayAdapter<>(this, R.layout.list_view_layout, cs2002ToDoList);
        cs2002ListView = findViewById(R.id.cs2002ListView);
        cs2002ListView.setAdapter(cs2002ArrayAdapter);
        cs2002ListView.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l)
            {
                cs2002ToDoList.remove(i);
                cs2002ArrayAdapter.notifyDataSetChanged();
                FileHelper1.writeData(cs2002ToDoList, ToDoListActivity.this);
            }
        });

        //CS2003 TO DO LIST//
        cs2003ToDoList = FileHelper2.readData(this);
        cs2003ArrayAdapter = new ArrayAdapter<>(this, R.layout.list_view_layout, cs2003ToDoList);
        cs2003ListView = findViewById(R.id.cs2003ListView);
        cs2003ListView.setAdapter(cs2003ArrayAdapter);
        cs2003ListView.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l)
            {
                cs2003ToDoList.remove(i);
                cs2003ArrayAdapter.notifyDataSetChanged();
                FileHelper2.writeData(cs2003ToDoList, ToDoListActivity.this);
            }
        });

        //CS2004 TO DO LIST//
        cs2004ToDoList = FileHelper3.readData(this);
        cs2004ArrayAdapter = new ArrayAdapter<>(this, R.layout.list_view_layout, cs2004ToDoList);
        cs2004ListView = findViewById(R.id.cs2004ListView);
        cs2004ListView.setAdapter(cs2004ArrayAdapter);
        cs2004ListView.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l)
            {
                cs2004ToDoList.remove(i);
                cs2004ArrayAdapter.notifyDataSetChanged();
                FileHelper3.writeData(cs2004ToDoList, ToDoListActivity.this);
            }
        });

        //CS2005 TO DO LIST//
        cs2005ToDoList = FileHelper4.readData(this);
        cs2005ArrayAdapter = new ArrayAdapter<>(this, R.layout.list_view_layout, cs2005ToDoList);
        cs2005ListView = findViewById(R.id.cs2005ListView);
        cs2005ListView.setAdapter(cs2005ArrayAdapter);
        cs2005ListView.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l)
            {
                cs2005ToDoList.remove(i);
                cs2005ArrayAdapter.notifyDataSetChanged();
                FileHelper4.writeData(cs2005ToDoList, ToDoListActivity.this);
            }
        });
    }
}
