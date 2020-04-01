package com.khizar.year2groupproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Typeface;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.InputType;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import static com.khizar.year2groupproject.MainActivity.uniqueID;
import static com.khizar.year2groupproject.MainActivity.userName;

public class DiscussionForum1 extends AppCompatActivity {
    static ArrayList<String> arrayList;
    MyAsyncTasks myAsyncTasks;
    static ProgressDialog progressDialog;
    CompleteListAdapter mListAdapter;
    ListView mlistview;
    EditText e11, e1;
    String newMessage="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_discussion_forum1);
        arrayList = new ArrayList<>();
        loadMessagesinArrayList();
        mlistview = findViewById(R.id.listvieww);
        mListAdapter = new CompleteListAdapter(DiscussionForum1.this, arrayList);
        mlistview.setAdapter(mListAdapter);
        mListAdapter.notifyDataSetChanged();
        e11 = findViewById(R.id.editText3);
        if(userName.equals("#"))
            checkgetandStoreUserName();
        Button sendMessage = findViewById(R.id.button2);
        sendMessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!e11.getText().toString().equals("")) {
                    if(!userName.equals("#")) {
                        String mess = e11.getText().toString() + "";
                        e11.setText("");
                        mess = mess + "≬"+userName+"≬";
                        newMessage = "*B*" + mess;
                        arrayList.add("*B*" + mess + "");
                        mListAdapter.notifyDataSetChanged();
                        myAsyncTasks = new MyAsyncTasks();
                        myAsyncTasks.execute();
                    }
                    else
                        checkgetandStoreUserName();
                }
            }
        });
    }

    void loadMessagesinArrayList(){
        FirebaseDatabase dReference = FirebaseDatabase.getInstance();
        DatabaseReference aReference = dReference.getReference("ForumMessages");
        aReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                arrayList.clear();
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    String toWrite = snapshot.getValue()+"";
                    arrayList.add(toWrite);
                    mListAdapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });

    }

    void checkgetandStoreUserName(){
        FirebaseDatabase dReference = FirebaseDatabase.getInstance();
        DatabaseReference aReference = dReference.getReference("UserName").child(uniqueID);
        aReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String name = dataSnapshot.getValue()+"";
                if(!name.equals("null"))
                    userName = name;
                else
                    showDialog();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });
    }

    void showDialog(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Please Enter your Name");
        e1=new EditText(this);
        e1.setHint("Name");
        e1.setInputType(InputType.TYPE_CLASS_TEXT);
        builder.setView(e1);
        builder.setPositiveButton("PROCEED", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int id) {
                try {
                    String namee = e1.getText().toString();
                    userName = namee;
                    FirebaseDatabase dReference = FirebaseDatabase.getInstance();
                    DatabaseReference aReference = dReference.getReference("UserName").child(uniqueID);
                    aReference.setValue(namee);
                    dialog.dismiss();
                }catch (Exception ignored){}
            }
        }).setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                dialog.dismiss();
            }
        });
        AlertDialog ad=builder.create();
        ad.show();
    }

    @SuppressLint("StaticFieldLeak")
    public class MyAsyncTasks extends AsyncTask<String, String, String> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            DiscussionForum1.progressDialog = new ProgressDialog(DiscussionForum1.this);
            DiscussionForum1.progressDialog.setMessage("Sending Message to Forum...");
            DiscussionForum1.progressDialog.show();
        }
        @Override
        protected String doInBackground(String... params) {
            FirebaseDatabase dReference = FirebaseDatabase.getInstance();
            DatabaseReference aReference = dReference.getReference("ForumMessages");
            aReference.push().setValue(newMessage);
            return "";
        }
        @Override
        protected void onPostExecute(String s) {
            try {
                DiscussionForum1.progressDialog.dismiss();
                DiscussionForum1.progressDialog.cancel();
            }catch (Exception ignored){}
        }
    }

    public class CompleteListAdapter extends BaseAdapter {
        Activity mContext;
        List<String> mList;
        LayoutInflater mLayoutInflater;
        CompleteListAdapter(Activity context, List<String> list) {
            mContext = context;
            mList = list;
            mLayoutInflater = (LayoutInflater) mContext
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }

        @Override
        public int getCount() {
            return mList.size();
        }

        @Override
        public Object getItem(int pos) {
            return mList.get(pos);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @SuppressLint({"InflateParams", "SetTextI18n"})
        @Override
        public View getView(final int position, View convertView, ViewGroup parent) {
            View v = convertView;
            CompleteListViewHolder viewHolder;
            if (convertView == null) {
                LayoutInflater li = (LayoutInflater) mContext
                        .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                v = li.inflate(R.layout.customlayoutt, null);
                viewHolder = new CompleteListViewHolder(v);
                v.setTag(viewHolder);
            } else
                viewHolder = (CompleteListViewHolder) v.getTag();

            String name="#";
            String texttoWritee=mList.get(position).substring(3)+"";
            try{
                name = texttoWritee.substring(texttoWritee.indexOf("≬") + 1, texttoWritee.length()-1);
                texttoWritee=texttoWritee.substring(0, texttoWritee.indexOf("≬"));
            }catch (Exception ignored){}
            String type = mList.get(position) + "";
            type=type.trim();
            type = type.substring(0, 3);
            if (type.equals("*S*")) {
                viewHolder.mTVName.setVisibility(View.VISIBLE);
                viewHolder.mTVName.setText(name);
                viewHolder.mTVName1.setVisibility(View.GONE);
                viewHolder.mTVItem.setVisibility(View.VISIBLE);
                viewHolder.mTVItem1.setVisibility(View.GONE);
                viewHolder.mTVItem.setTypeface(null, Typeface.NORMAL);
                viewHolder.mTVItem.setText(texttoWritee);
            }
            else
            {
                if(name.equals(userName)){
                    viewHolder.mTVItem1.setVisibility(View.VISIBLE);
                    viewHolder.mTVItem.setVisibility(View.GONE);
                    viewHolder.mTVName.setVisibility(View.GONE);
                    viewHolder.mTVName1.setVisibility(View.VISIBLE);
                    viewHolder.mTVName1.setText("You");
                    viewHolder.mTVItem1.setTypeface(null, Typeface.NORMAL);
                    viewHolder.mTVItem1.setText(texttoWritee);
                }
                else{
                    viewHolder.mTVName.setVisibility(View.VISIBLE);
                    viewHolder.mTVName.setText(name);
                    viewHolder.mTVName1.setVisibility(View.GONE);
                    viewHolder.mTVItem.setVisibility(View.VISIBLE);
                    viewHolder.mTVItem1.setVisibility(View.GONE);
                    viewHolder.mTVItem.setTypeface(null, Typeface.NORMAL);
                    viewHolder.mTVItem.setText(texttoWritee);
                }
            }
            return v;
        }
    }

    class CompleteListViewHolder {
        TextView mTVItem, mTVName, mTVItem1, mTVName1;
        CompleteListViewHolder(View base) {
            mTVItem = base.findViewById(R.id.textView5);
            mTVName = base.findViewById(R.id.textViewName);
            mTVItem.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    copyTextToClipboard(mTVItem);
                    return false;
                }
            });
            mTVItem1 = base.findViewById(R.id.textView8);
            mTVName1 = base.findViewById(R.id.textViewNameMy);
            mTVItem1.setOnLongClickListener(new View.OnLongClickListener() {

                @Override
                public boolean onLongClick(View v) {
                    copyTextToClipboard(mTVItem1);
                    return false;
                }
            });
        }
    }

    public void copyTextToClipboard(TextView txtView){
        int sdk = android.os.Build.VERSION.SDK_INT;
        if(sdk < android.os.Build.VERSION_CODES.HONEYCOMB) {
            android.text.ClipboardManager clipboard = (android.text.ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
            clipboard.setText(txtView.getText().toString());
            Toast.makeText(this, "Text Copied", Toast.LENGTH_SHORT).show();
        } else {
            android.content.ClipboardManager clipboard = (android.content.ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
            android.content.ClipData clip = android.content.ClipData.newPlainText("text label",txtView.getText().toString());
            clipboard.setPrimaryClip(clip);
            Toast.makeText(this, "Text Copied", Toast.LENGTH_SHORT).show();
        }
    }
}


