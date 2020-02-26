package com.khizar.year2groupproject;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Switch;
import android.widget.Toast;

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

    Switch cs2001Switch;
    Switch cs2002Switch;
    Switch cs2003Switch;
    Switch cs2004Switch;
    Switch cs2005Switch;
    boolean cs2001SwitchCheck;
    boolean cs2002SwitchCheck;
    boolean cs2003SwitchCheck;
    boolean cs2004SwitchCheck;
    boolean cs2005SwitchCheck;

    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_to_do_list);

        editText = findViewById(R.id.taskET);

        //CS2001 TO DO LIST//
        cs2001Switch = findViewById(R.id.CS2001SWITCH);
        cs2001Switch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b)
            {
                cs2001SwitchCheck = b;
            }
        });

        cs2001ToDoList = FileHelper.readData(this);
        cs2001ArrayAdapter = new ArrayAdapter<>(this, R.layout.list_view_layout, cs2001ToDoList);
        cs2001ListView = findViewById(R.id.cs2001ListView);
        cs2001ListView.setAdapter(cs2001ArrayAdapter);
        cs2001ListView.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l)
            {
                final int index = i;

                AlertDialog.Builder aBuilder = new AlertDialog.Builder(ToDoListActivity.this);
                aBuilder.setMessage("Are you sure?").setCancelable(false).setPositiveButton("Yes", new DialogInterface.OnClickListener()
                {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i)
                    {
                        cs2001ToDoList.remove(index);
                        cs2001ArrayAdapter.notifyDataSetChanged();
                        FileHelper.writeData(cs2001ToDoList, ToDoListActivity.this);
                    }
                }).setNegativeButton("No", new DialogInterface.OnClickListener()
                {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i)
                    {
                        dialogInterface.cancel();
                    }
                });
                AlertDialog alert = aBuilder.create();
                alert.setTitle("Delete Task");
                alert.show();
            }
        });

        //CS2002 TO DO LIST//
        cs2002Switch = findViewById(R.id.CS2002SWITCH);
        cs2002Switch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b)
            {
                cs2002SwitchCheck = b;
            }
        });

        cs2002ToDoList = FileHelper1.readData(this);
        cs2002ArrayAdapter = new ArrayAdapter<>(this, R.layout.list_view_layout, cs2002ToDoList);
        cs2002ListView = findViewById(R.id.cs2002ListView);
        cs2002ListView.setAdapter(cs2002ArrayAdapter);
        cs2002ListView.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l)
            {
                final int index = i;

                AlertDialog.Builder aBuilder = new AlertDialog.Builder(ToDoListActivity.this);
                aBuilder.setMessage("Are you sure?").setCancelable(false).setPositiveButton("Yes", new DialogInterface.OnClickListener()
                {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i)
                    {
                        cs2002ToDoList.remove(index);
                        cs2002ArrayAdapter.notifyDataSetChanged();
                        FileHelper1.writeData(cs2002ToDoList, ToDoListActivity.this);
                    }
                }).setNegativeButton("No", new DialogInterface.OnClickListener()
                {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i)
                    {
                        dialogInterface.cancel();
                    }
                });
                AlertDialog alert = aBuilder.create();
                alert.setTitle("Delete Task");
                alert.show();
            }
        });

        //CS2003 TO DO LIST//
        cs2003Switch = findViewById(R.id.CS2003SWITCH);
        cs2003Switch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b)
            {
                cs2003SwitchCheck = b;
            }
        });

        cs2003ToDoList = FileHelper2.readData(this);
        cs2003ArrayAdapter = new ArrayAdapter<>(this, R.layout.list_view_layout, cs2003ToDoList);
        cs2003ListView = findViewById(R.id.cs2003ListView);
        cs2003ListView.setAdapter(cs2003ArrayAdapter);
        cs2003ListView.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l)
            {
                final int index = i;

                AlertDialog.Builder aBuilder = new AlertDialog.Builder(ToDoListActivity.this);
                aBuilder.setMessage("Are you sure?").setCancelable(false).setPositiveButton("Yes", new DialogInterface.OnClickListener()
                {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i)
                    {
                        cs2003ToDoList.remove(index);
                        cs2003ArrayAdapter.notifyDataSetChanged();
                        FileHelper2.writeData(cs2003ToDoList, ToDoListActivity.this);
                    }
                }).setNegativeButton("No", new DialogInterface.OnClickListener()
                {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i)
                    {
                        dialogInterface.cancel();
                    }
                });
                AlertDialog alert = aBuilder.create();
                alert.setTitle("Delete Task");
                alert.show();
            }
        });

        //CS2004 TO DO LIST//
        cs2004Switch = findViewById(R.id.CS2004SWITCH);
        cs2004Switch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b)
            {
                cs2004SwitchCheck = b;
            }
        });

        cs2004ToDoList = FileHelper3.readData(this);
        cs2004ArrayAdapter = new ArrayAdapter<>(this, R.layout.list_view_layout, cs2004ToDoList);
        cs2004ListView = findViewById(R.id.cs2004ListView);
        cs2004ListView.setAdapter(cs2004ArrayAdapter);
        cs2004ListView.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l)
            {
                final int index = i;

                AlertDialog.Builder aBuilder = new AlertDialog.Builder(ToDoListActivity.this);
                aBuilder.setMessage("Are you sure?").setCancelable(false).setPositiveButton("Yes", new DialogInterface.OnClickListener()
                {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i)
                    {
                        cs2004ToDoList.remove(index);
                        cs2004ArrayAdapter.notifyDataSetChanged();
                        FileHelper3.writeData(cs2004ToDoList, ToDoListActivity.this);
                    }
                }).setNegativeButton("No", new DialogInterface.OnClickListener()
                {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i)
                    {
                        dialogInterface.cancel();
                    }
                });
                AlertDialog alert = aBuilder.create();
                alert.setTitle("Delete Task");
                alert.show();
            }
        });

        //CS2005 TO DO LIST//
        cs2005Switch = findViewById(R.id.CS2005SWITCH);
        cs2005Switch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b)
            {
                cs2005SwitchCheck = b;
            }
        });

        cs2005ToDoList = FileHelper4.readData(this);
        cs2005ArrayAdapter = new ArrayAdapter<>(this, R.layout.list_view_layout, cs2005ToDoList);
        cs2005ListView = findViewById(R.id.cs2005ListView);
        cs2005ListView.setAdapter(cs2005ArrayAdapter);
        cs2005ListView.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l)
            {
                final int index = i;

                AlertDialog.Builder aBuilder = new AlertDialog.Builder(ToDoListActivity.this);
                aBuilder.setMessage("Are you sure?").setCancelable(false).setPositiveButton("Yes", new DialogInterface.OnClickListener()
                {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i)
                    {
                        cs2005ToDoList.remove(index);
                        cs2005ArrayAdapter.notifyDataSetChanged();
                        FileHelper4.writeData(cs2005ToDoList, ToDoListActivity.this);
                    }
                }).setNegativeButton("No", new DialogInterface.OnClickListener()
                {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i)
                    {
                        dialogInterface.cancel();
                    }
                });
                AlertDialog alert = aBuilder.create();
                alert.setTitle("Delete Task");
                alert.show();
            }
        });
    }

    public void addItemBTN(View view)
    {
        String taskEntered = editText.getText().toString();
        if(taskEntered.isEmpty())
        {
            Toast.makeText(ToDoListActivity.this, "Please enter a task", Toast.LENGTH_SHORT).show();
        }
        else
        {
            if(cs2001SwitchCheck == true)
            {
                cs2001ArrayAdapter.add(taskEntered);
                editText.setText("");
                FileHelper.writeData(cs2001ToDoList, this);
            }
            if(cs2002SwitchCheck == true)
            {
                cs2002ArrayAdapter.add(taskEntered);
                editText.setText("");
                FileHelper1.writeData(cs2002ToDoList, this);
            }
            if(cs2003SwitchCheck == true)
            {
                cs2003ArrayAdapter.add(taskEntered);
                editText.setText("");
                FileHelper2.writeData(cs2003ToDoList, this);
            }
            if(cs2004SwitchCheck == true)
            {
                cs2004ArrayAdapter.add(taskEntered);
                editText.setText("");
                FileHelper3.writeData(cs2004ToDoList, this);
            }
            if(cs2005SwitchCheck == true)
            {
                cs2005ArrayAdapter.add(taskEntered);
                editText.setText("");
                FileHelper4.writeData(cs2005ToDoList, this);
            }
            if(cs2001SwitchCheck == false && cs2002SwitchCheck == false && cs2003SwitchCheck == false && cs2004SwitchCheck == false && cs2005SwitchCheck == false)
            {
                Toast.makeText(ToDoListActivity.this, "Please select a module", Toast.LENGTH_SHORT).show();
            }
            else
            {
                Toast.makeText(ToDoListActivity.this, "Task Added!", Toast.LENGTH_SHORT).show();
            }
        }
    }
}
