package com.khizar.year2groupproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class Register extends AppCompatActivity
{
    public static final String TAG = "TAG";
    EditText mFullName, mEmail, mPassword;
    Button mRegisterBtn;
    TextView mLoginBtn;
    FirebaseAuth fAuth;
    ProgressBar progressBar;
    FirebaseFirestore fStore;
    String userID;
    Spinner courseSpinner;
    String courseOptionSelected;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        mFullName = findViewById(R.id.fullName);
        mEmail = findViewById(R.id.email);
        mPassword = findViewById(R.id.password);
        mRegisterBtn = findViewById(R.id.registerButton);
        mLoginBtn = findViewById(R.id.loginText);
        courseSpinner = findViewById(R.id.spinner);

        fAuth = FirebaseAuth.getInstance();
        fStore = FirebaseFirestore.getInstance();
        progressBar = findViewById(R.id.progressBar);

        if(fAuth.getCurrentUser() != null)
        {
            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(intent);
            finish();
        }

        ArrayAdapter adapter = ArrayAdapter.createFromResource(this, R.array.courses, R.layout.colour_spinner);
        adapter.setDropDownViewResource(R.layout.spinner_dropdown);
        courseSpinner.setAdapter(adapter);
        courseSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l)
            {
                courseOptionSelected = courseSpinner.getItemAtPosition(i).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView)
            {

            }
        });

        mRegisterBtn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                final String email = mEmail.getText().toString();
                String password = mPassword.getText().toString();
                final String fullName = mFullName.getText().toString();

                if(TextUtils.isEmpty(email))
                {
                    mEmail.setError("Email is required!");
                    return;
                }
                if(TextUtils.isEmpty(password))
                {
                    mPassword.setError("Password is required!");
                    return;
                }

                if(password.length() < 6)
                {
                    mPassword.setError("Password must be 6 or more characters!");
                    return;
                }
                progressBar.setVisibility(View.VISIBLE);

                //Register user to firebase//
                fAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>()
                {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task)
                    {
                        if(task.isSuccessful())
                        {
                            Toast.makeText(Register.this, "User Created.", Toast.LENGTH_SHORT).show();
                            userID = fAuth.getCurrentUser().getUid();
                            DocumentReference documentReference = fStore.collection("users").document(userID);
                            Map<String,Object> user = new HashMap<>();
                            user.put("fullName", fullName);
                            user.put("email", email);
                            user.put("courseType", courseOptionSelected);
                            documentReference.set(user).addOnSuccessListener(new OnSuccessListener<Void>()
                            {
                                @Override
                                public void onSuccess(Void aVoid)
                                {
                                    Log.d(TAG,"onSuccess: user Profile is created for "+ userID);
                                }
                            });
                            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                            startActivity(intent);
                        }
                        else
                        {
                            Toast.makeText(Register.this, "ERROR" + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                            progressBar.setVisibility(View.GONE);
                        }
                    }
                });
            }
        });
        mLoginBtn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(getApplicationContext(), Login.class);
                startActivity(intent);
            }
        });
    }
}
