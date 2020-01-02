package com.khizar.year2groupproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.app.DownloadManager;
import android.content.Context;
import android.net.Uri;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import static android.os.Environment.DIRECTORY_DOWNLOADS;

public class ResourceActivity extends AppCompatActivity {

    Button resourceButtonM1a;
    Button resourceButtonM1b;

    Button resourceButtonM2a;
    Button resourceButtonM2b;

    Button resourceButtonM3a;
    Button resourceButtonM3b;

    Button resourceButtonM4a;
    Button resourceButtonM4b;

    Button resourceButtonM5a;
    Button resourceButtonM5b;

    Button resourceButtonM6a;
    Button resourceButtonM6b;

    Button resourceButtonM7a;
    Button resourceButtonM7b;


    FirebaseStorage firebaseStorage;
    StorageReference storageReference;

    StorageReference ref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resource_cs);

        resourceButtonM1a = findViewById(R.id.resourceButtonM1a);
        resourceButtonM1b = findViewById(R.id.resourceButtonM1b);

        resourceButtonM2a = findViewById(R.id.resourceButtonM2a);
        resourceButtonM2b = findViewById(R.id.resourceButtonM2b);

        resourceButtonM3a = findViewById(R.id.resourceButtonM3a);
        resourceButtonM3b = findViewById(R.id.resourceButtonM3b);

        resourceButtonM4a = findViewById(R.id.resourceButtonM4a);
        resourceButtonM4b = findViewById(R.id.resourceButtonM4b);

        resourceButtonM5a = findViewById(R.id.resourceButtonM5a);
        resourceButtonM5b = findViewById(R.id.resourceButtonM5b);

        resourceButtonM6a = findViewById(R.id.resourceButtonM6a);
        resourceButtonM6b = findViewById(R.id.resourceButtonM6b);

        resourceButtonM7a = findViewById(R.id.resourceButtonM7a);
        resourceButtonM7b = findViewById(R.id.resourceButtonM7b);


        resourceButtonM1a.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                downloadM1a();
            }
        });resourceButtonM1b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                downloadM1b();
            }
        });resourceButtonM2a.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                downloadM2a();
            }
        });resourceButtonM2b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                downloadM2b();
            }
        });resourceButtonM3a.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                downloadM3a();
            }
        });resourceButtonM3b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                downloadM3b();
            }
        });resourceButtonM4a.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                downloadM4a();
            }
        });resourceButtonM4b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                downloadM4b();
            }
        });resourceButtonM5a.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                downloadM5a();
            }
        });resourceButtonM5b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                downloadM5b();
            }
        });


    }

    public void downloadM1a() {

        storageReference = firebaseStorage.getInstance().getReference();
        ref = storageReference.child("Resources/CS2001-The-4th-Paradigm.pdf");

        ref.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
            @Override
            public void onSuccess(Uri uri) {
                String url = uri.toString();
                fileDownloader(ResourceActivity.this, "CS2001-The-4th-Paradigm", ".pdf", DIRECTORY_DOWNLOADS, url);
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {

            }
        });


    }

    public void downloadM1b() {

        storageReference = firebaseStorage.getInstance().getReference();
        ref = storageReference.child("Resources/CS2001-UML-2-in-Action.pdf");

        ref.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
            @Override
            public void onSuccess(Uri uri) {
                String url = uri.toString();
                fileDownloader(ResourceActivity.this, "CS2001-UML-2-in-Action", ".pdf", DIRECTORY_DOWNLOADS, url);
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {

            }
        });


    }

    public void downloadM2a() {

        storageReference = firebaseStorage.getInstance().getReference();
        ref = storageReference.child("Resources/CS2002-Sommerville-Software-Engineering.pdf");

        ref.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
            @Override
            public void onSuccess(Uri uri) {
                String url = uri.toString();
                fileDownloader(ResourceActivity.this, "CS2002-Sommerville-Software-Engineering", ".pdf", DIRECTORY_DOWNLOADS, url);
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {

            }
        });


    }

    public void downloadM2b() {

        storageReference = firebaseStorage.getInstance().getReference();
        ref = storageReference.child("Resources/CS2002-Software-Engineering-Theory-and-Practice.pdf");

        ref.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
            @Override
            public void onSuccess(Uri uri) {
                String url = uri.toString();
                fileDownloader(ResourceActivity.this, "CS2002-Software-Engineering-Theory-and-Practice", ".pdf", DIRECTORY_DOWNLOADS, url);
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {

            }
        });


    }

    public void downloadM3a() {

        storageReference = firebaseStorage.getInstance().getReference();
        ref = storageReference.child("Resources/CS2003-Interaction-Design - Beyond-Human-Computer-Interaction.pdf");

        ref.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
            @Override
            public void onSuccess(Uri uri) {
                String url = uri.toString();
                fileDownloader(ResourceActivity.this, "CS2003-Interaction-Design - Beyond-Human-Computer-Interaction", ".pdf", DIRECTORY_DOWNLOADS, url);
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {

            }
        });


    }

    public void downloadM3b() {

        storageReference = firebaseStorage.getInstance().getReference();
        ref = storageReference.child("Resources/CS2003-The-Design-of-Everyday-Things.pdf");

        ref.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
            @Override
            public void onSuccess(Uri uri) {
                String url = uri.toString();
                fileDownloader(ResourceActivity.this, "CS2003-The-Design-of-Everyday-Things", ".pdf", DIRECTORY_DOWNLOADS, url);
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {

            }
        });


    }

    public void downloadM4a() {

        storageReference = firebaseStorage.getInstance().getReference();
        ref = storageReference.child("Resources/CS2004-Data-Structures-and-Algorithms-in-Java.pdf");

        ref.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
            @Override
            public void onSuccess(Uri uri) {
                String url = uri.toString();
                fileDownloader(ResourceActivity.this, "CS2004-Data-Structures-and-Algorithms-in-Java", ".pdf", DIRECTORY_DOWNLOADS, url);
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {

            }
        });


    }

    public void downloadM4b() {

        storageReference = firebaseStorage.getInstance().getReference();
        ref = storageReference.child("Resources/CS2004-How-to-Solve-it-Modern-Heuristics.pdf");

        ref.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
            @Override
            public void onSuccess(Uri uri) {
                String url = uri.toString();
                fileDownloader(ResourceActivity.this, "CS2004-How-to-Solve-it-Modern-Heuristics", ".pdf", DIRECTORY_DOWNLOADS, url);
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {

            }
        });


    }

    public void downloadM5a() {

        storageReference = firebaseStorage.getInstance().getReference();
        ref = storageReference.child("Resources/CS2005-Computer-Networking-A-Top-Down-Approach.pdf");

        ref.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
            @Override
            public void onSuccess(Uri uri) {
                String url = uri.toString();
                fileDownloader(ResourceActivity.this, "CS2005-Computer-Networking-A-Top-Down-Approach", ".pdf", DIRECTORY_DOWNLOADS, url);
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {

            }
        });


    }

    public void downloadM5b() {

        storageReference = firebaseStorage.getInstance().getReference();
        ref = storageReference.child("Resources/CS2005-Operating-System-Concepts.pdf");

        ref.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
            @Override
            public void onSuccess(Uri uri) {
                String url = uri.toString();
                fileDownloader(ResourceActivity.this, "CS2005-Operating-System-Concepts", ".pdf", DIRECTORY_DOWNLOADS, url);
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {

            }
        });


    }


    public void fileDownloader(Context context, String fileName, String fileExtension, String destinationDirectory, String url) {


        DownloadManager downloadmanager = (DownloadManager) context.
                getSystemService(Context.DOWNLOAD_SERVICE);
        Uri uri = Uri.parse(url);
        DownloadManager.Request request = new DownloadManager.Request(uri);

        request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
        request.setDestinationInExternalFilesDir(context, destinationDirectory, fileName + fileExtension);

        downloadmanager.enqueue(request);
    }

}

