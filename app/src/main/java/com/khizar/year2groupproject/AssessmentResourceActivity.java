package com.khizar.year2groupproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DownloadManager;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import static android.os.Environment.DIRECTORY_DOWNLOADS;

public class AssessmentResourceActivity extends AppCompatActivity {

    Button assessment_resourceButtonM1a;
    Button assessment_resourceButtonM1b;
    Button assessment_resourceButtonM1c;

    Button assessment_resourceButtonM2a;
    Button assessment_resourceButtonM2b;
    Button assessment_resourceButtonM2c;

    Button assessment_resourceButtonM3a;
    Button assessment_resourceButtonM3b;
    Button assessment_resourceButtonM3c;

    Button assessment_resourceButtonM4a;
    Button assessment_resourceButtonM4b;
    Button assessment_resourceButtonM4c;

    Button assessment_resourceButtonM5a;
    Button assessment_resourceButtonM5b;
    Button assessment_resourceButtonM5c;


    Button second_mainmenuButton;
    Button second_gobackButton;

    FirebaseStorage firebaseStorage;
    StorageReference storageReference;
    StorageReference ref;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_assessment_resource);

        assessment_resourceButtonM1a = findViewById(R.id.assessment_resourceButtonM1a);
        assessment_resourceButtonM1b = findViewById(R.id.assessment_resourceButtonM1b);
        assessment_resourceButtonM1c = findViewById(R.id.assessment_resourceButtonM1c);

        assessment_resourceButtonM2a = findViewById(R.id.assessment_resourceButtonM2a);
        assessment_resourceButtonM2b = findViewById(R.id.assessment_resourceButtonM2b);
        assessment_resourceButtonM2c = findViewById(R.id.assessment_resourceButtonM2c);

        assessment_resourceButtonM3a = findViewById(R.id.assessment_resourceButtonM3a);
        assessment_resourceButtonM3b = findViewById(R.id.assessment_resourceButtonM3b);
        assessment_resourceButtonM3c = findViewById(R.id.assessment_resourceButtonM3c);

        assessment_resourceButtonM4a = findViewById(R.id.assessment_resourceButtonM4a);
        assessment_resourceButtonM4b = findViewById(R.id.assessment_resourceButtonM4b);
        assessment_resourceButtonM4c = findViewById(R.id.assessment_resourceButtonM4c);

        assessment_resourceButtonM5a = findViewById(R.id.assessment_resourceButtonM5a);
        assessment_resourceButtonM5b = findViewById(R.id.assessment_resourceButtonM5b);
        assessment_resourceButtonM5c = findViewById(R.id.assessment_resourceButtonM5c);


        second_mainmenuButton = findViewById(R.id.second_mainmenuButton);
        second_gobackButton = findViewById(R.id.second_gobackButton);

        assessment_resourceButtonM1a.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                downloadassessmentM1a();
            }
        });assessment_resourceButtonM1b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                downloadassessmentM1b();
            }
        });assessment_resourceButtonM1c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                downloadassessmentM1c();
            }
        });assessment_resourceButtonM2a.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                downloadassessmentM2a();
            }
        });assessment_resourceButtonM2b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                downloadassessmentM2b();
            }
        });assessment_resourceButtonM2c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                downloadassessmentM2c();
            }
        });assessment_resourceButtonM3a.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                downloadassessmentM3a();
            }
        });assessment_resourceButtonM3b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                downloadassessmentM3b();
            }
        });assessment_resourceButtonM3c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                downloadassessmentM3c();
            }
        });assessment_resourceButtonM4a.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                downloadassessmentM4a();
            }
        });assessment_resourceButtonM4b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                downloadassessmentM4b();
            }
        });assessment_resourceButtonM4c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                downloadassessmentM4c();
            }
        });assessment_resourceButtonM5a.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                downloadassessmentM5a();
            }
        });assessment_resourceButtonM5b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                downloadassessmentM5b();
            }
        });assessment_resourceButtonM5c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                downloadassessmentM5c();
            }
        });second_mainmenuButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(AssessmentResourceActivity.this, MainActivity.class));

            }
        });second_gobackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(AssessmentResourceActivity.this, ResourceActivity.class));

            }
        });
    }

    public void downloadassessmentM1a() {

        storageReference = firebaseStorage.getInstance().getReference();
        ref = storageReference.child("Resources/CS2001-Coursework-Notes.pdf");

        ref.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
            @Override
            public void onSuccess(Uri uri) {
                String url = uri.toString();
                fileDownloader(AssessmentResourceActivity.this, "CS2001-Coursework-Notes", ".pdf", DIRECTORY_DOWNLOADS, url);
                Toast.makeText(AssessmentResourceActivity.this, "File Successfully Downloading", Toast.LENGTH_SHORT).show();

            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(AssessmentResourceActivity.this, "An error occurred during the File Download", Toast.LENGTH_SHORT).show();
                Toast.makeText(AssessmentResourceActivity.this, "Please try again", Toast.LENGTH_SHORT).show();

            }
        });


    }

    public void downloadassessmentM1b() {

        storageReference = firebaseStorage.getInstance().getReference();
        ref = storageReference.child("Resources/CS2001-Assessment-Template.pdf");

        ref.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
            @Override
            public void onSuccess(Uri uri) {
                String url = uri.toString();
                fileDownloader(AssessmentResourceActivity.this, "CS2001-Assessment-Template", ".pdf", DIRECTORY_DOWNLOADS, url);
                Toast.makeText(AssessmentResourceActivity.this, "File Successfully Downloading", Toast.LENGTH_SHORT).show();

            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(AssessmentResourceActivity.this, "An error occurred during the File Download", Toast.LENGTH_SHORT).show();
                Toast.makeText(AssessmentResourceActivity.this, "Please try again", Toast.LENGTH_SHORT).show();

            }
        });


    }

    public void downloadassessmentM1c() {

        storageReference = firebaseStorage.getInstance().getReference();
        ref = storageReference.child("Resources/CS2001-Assessment-Brief.pdf");

        ref.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
            @Override
            public void onSuccess(Uri uri) {
                String url = uri.toString();
                fileDownloader(AssessmentResourceActivity.this, "CS2001-Assessment-Brief", ".pdf", DIRECTORY_DOWNLOADS, url);
                Toast.makeText(AssessmentResourceActivity.this, "File Successfully Downloading", Toast.LENGTH_SHORT).show();

            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(AssessmentResourceActivity.this, "An error occurred during the File Download", Toast.LENGTH_SHORT).show();
                Toast.makeText(AssessmentResourceActivity.this, "Please try again", Toast.LENGTH_SHORT).show();

            }
        });


    }

    public void downloadassessmentM2a() {

        storageReference = firebaseStorage.getInstance().getReference();
        ref = storageReference.child("Resources/CS2002-Assessment-Material.pdf");

        ref.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
            @Override
            public void onSuccess(Uri uri) {
                String url = uri.toString();
                fileDownloader(AssessmentResourceActivity.this, "CS2002-Assessment-Material", ".pdf", DIRECTORY_DOWNLOADS, url);
                Toast.makeText(AssessmentResourceActivity.this, "File Successfully Downloading", Toast.LENGTH_SHORT).show();

            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(AssessmentResourceActivity.this, "An error occurred during the File Download", Toast.LENGTH_SHORT).show();
                Toast.makeText(AssessmentResourceActivity.this, "Please try again", Toast.LENGTH_SHORT).show();

            }
        });


    }

    public void downloadassessmentM2b() {

        storageReference = firebaseStorage.getInstance().getReference();
        ref = storageReference.child("Resources/CS2002-Assessment-Material2.pdf");

        ref.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
            @Override
            public void onSuccess(Uri uri) {
                String url = uri.toString();
                fileDownloader(AssessmentResourceActivity.this, "CS2002-Assessment-Material2", ".pdf", DIRECTORY_DOWNLOADS, url);
                Toast.makeText(AssessmentResourceActivity.this, "File Successfully Downloading", Toast.LENGTH_SHORT).show();
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(AssessmentResourceActivity.this, "An error occurred during the File Download", Toast.LENGTH_SHORT).show();
                Toast.makeText(AssessmentResourceActivity.this, "Please try again", Toast.LENGTH_SHORT).show();

            }
        });


    }

    public void downloadassessmentM2c() {

        storageReference = firebaseStorage.getInstance().getReference();
        ref = storageReference.child("Resources/CS2002-Assessment-Brief.pdf");

        ref.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
            @Override
            public void onSuccess(Uri uri) {
                String url = uri.toString();
                fileDownloader(AssessmentResourceActivity.this, "CS2002-Assessment-Brief", ".pdf", DIRECTORY_DOWNLOADS, url);
                Toast.makeText(AssessmentResourceActivity.this, "File Successfully Downloading", Toast.LENGTH_SHORT).show();
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(AssessmentResourceActivity.this, "An error occurred during the File Download", Toast.LENGTH_SHORT).show();
                Toast.makeText(AssessmentResourceActivity.this, "Please try again", Toast.LENGTH_SHORT).show();

            }
        });


    }

    public void downloadassessmentM3a() {

        storageReference = firebaseStorage.getInstance().getReference();
        ref = storageReference.child("Resources/CS2003-Assessment1-Template.pdf");

        ref.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
            @Override
            public void onSuccess(Uri uri) {
                String url = uri.toString();
                fileDownloader(AssessmentResourceActivity.this, "CS2003-Assessment1-Template", ".pdf", DIRECTORY_DOWNLOADS, url);
                Toast.makeText(AssessmentResourceActivity.this, "File Successfully Downloading", Toast.LENGTH_SHORT).show();
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(AssessmentResourceActivity.this, "An error occurred during the File Download", Toast.LENGTH_SHORT).show();
                Toast.makeText(AssessmentResourceActivity.this, "Please try again", Toast.LENGTH_SHORT).show();

            }
        });


    }

    public void downloadassessmentM3b() {

        storageReference = firebaseStorage.getInstance().getReference();
        ref = storageReference.child("Resources/CS2003-Assessment2-Template.pdf");

        ref.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
            @Override
            public void onSuccess(Uri uri) {
                String url = uri.toString();
                fileDownloader(AssessmentResourceActivity.this, "CS2003-Assessment2-Template", ".pdf", DIRECTORY_DOWNLOADS, url);
                Toast.makeText(AssessmentResourceActivity.this, "File Successfully Downloading", Toast.LENGTH_SHORT).show();
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(AssessmentResourceActivity.this, "An error occurred during the File Download", Toast.LENGTH_SHORT).show();
                Toast.makeText(AssessmentResourceActivity.this, "Please try again", Toast.LENGTH_SHORT).show();

            }
        });


    }

    public void downloadassessmentM3c() {

        storageReference = firebaseStorage.getInstance().getReference();
        ref = storageReference.child("Resources/CS2003-Assessment-Brief.pdf");

        ref.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
            @Override
            public void onSuccess(Uri uri) {
                String url = uri.toString();
                fileDownloader(AssessmentResourceActivity.this, "CS2003-Assessment-Brief", ".pdf", DIRECTORY_DOWNLOADS, url);
                Toast.makeText(AssessmentResourceActivity.this, "File Successfully Downloading", Toast.LENGTH_SHORT).show();
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(AssessmentResourceActivity.this, "An error occurred during the File Download", Toast.LENGTH_SHORT).show();
                Toast.makeText(AssessmentResourceActivity.this, "Please try again", Toast.LENGTH_SHORT).show();

            }
        });


    }

    public void downloadassessmentM4a() {

        storageReference = firebaseStorage.getInstance().getReference();
        ref = storageReference.child("Resources/CS2004-Assessment-Task2-Brief.pdf");

        ref.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
            @Override
            public void onSuccess(Uri uri) {
                String url = uri.toString();
                fileDownloader(AssessmentResourceActivity.this, "CS2004-Assessment-Task2-Brief", ".pdf", DIRECTORY_DOWNLOADS, url);
                Toast.makeText(AssessmentResourceActivity.this, "File Successfully Downloading", Toast.LENGTH_SHORT).show();
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(AssessmentResourceActivity.this, "An error occurred during the File Download", Toast.LENGTH_SHORT).show();
                Toast.makeText(AssessmentResourceActivity.this, "Please try again", Toast.LENGTH_SHORT).show();

            }
        });


    }


    public void downloadassessmentM4b() {

        storageReference = firebaseStorage.getInstance().getReference();
        ref = storageReference.child("Resources/CS2004-Assessment-Maths.pdf");

        ref.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
            @Override
            public void onSuccess(Uri uri) {
                String url = uri.toString();
                fileDownloader(AssessmentResourceActivity.this, "CS2004-Assessment-Maths", ".pdf", DIRECTORY_DOWNLOADS, url);
                Toast.makeText(AssessmentResourceActivity.this, "File Successfully Downloading", Toast.LENGTH_SHORT).show();
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(AssessmentResourceActivity.this, "An error occurred during the File Download", Toast.LENGTH_SHORT).show();
                Toast.makeText(AssessmentResourceActivity.this, "Please try again", Toast.LENGTH_SHORT).show();

            }
        });


    }

    public void downloadassessmentM4c() {

        storageReference = firebaseStorage.getInstance().getReference();
        ref = storageReference.child("Resources/CS2004-Assessment-Brief.pdf");

        ref.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
            @Override
            public void onSuccess(Uri uri) {
                String url = uri.toString();
                fileDownloader(AssessmentResourceActivity.this, "CS2004-Assessment-Brief", ".pdf", DIRECTORY_DOWNLOADS, url);
                Toast.makeText(AssessmentResourceActivity.this, "File Successfully Downloading", Toast.LENGTH_SHORT).show();
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(AssessmentResourceActivity.this, "An error occurred during the File Download", Toast.LENGTH_SHORT).show();
                Toast.makeText(AssessmentResourceActivity.this, "Please try again", Toast.LENGTH_SHORT).show();

            }
        });


    }

    public void downloadassessmentM5a() {

        storageReference = firebaseStorage.getInstance().getReference();
        ref = storageReference.child("Resources/CS2005-Assessment-Tutorial-Intro.pdf");

        ref.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
            @Override
            public void onSuccess(Uri uri) {
                String url = uri.toString();
                fileDownloader(AssessmentResourceActivity.this, "CS2005-Assessment-Tutorial-Intro", ".pdf", DIRECTORY_DOWNLOADS, url);
                Toast.makeText(AssessmentResourceActivity.this, "File Successfully Downloading", Toast.LENGTH_SHORT).show();
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(AssessmentResourceActivity.this, "An error occurred during the File Download", Toast.LENGTH_SHORT).show();
                Toast.makeText(AssessmentResourceActivity.this, "Please try again", Toast.LENGTH_SHORT).show();

            }
        });


    }

    public void downloadassessmentM5b() {

        storageReference = firebaseStorage.getInstance().getReference();
        ref = storageReference.child("Resources/CS2005-Assessment-Template.pdf");

        ref.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
            @Override
            public void onSuccess(Uri uri) {
                String url = uri.toString();
                fileDownloader(AssessmentResourceActivity.this, "CS2005-Assessment-Template", ".pdf", DIRECTORY_DOWNLOADS, url);
                Toast.makeText(AssessmentResourceActivity.this, "File Successfully Downloading", Toast.LENGTH_SHORT).show();
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(AssessmentResourceActivity.this, "An error occurred during the File Download", Toast.LENGTH_SHORT).show();
                Toast.makeText(AssessmentResourceActivity.this, "Please try again", Toast.LENGTH_SHORT).show();

            }
        });


    }

    public void downloadassessmentM5c() {

        storageReference = firebaseStorage.getInstance().getReference();
        ref = storageReference.child("Resources/CS2005-Assessment-Brief.pdf");

        ref.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
            @Override
            public void onSuccess(Uri uri) {
                String url = uri.toString();
                fileDownloader(AssessmentResourceActivity.this, "CS2005-Assessment-Brief", ".pdf", DIRECTORY_DOWNLOADS, url);
                Toast.makeText(AssessmentResourceActivity.this, "File Successfully Downloading", Toast.LENGTH_SHORT).show();
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(AssessmentResourceActivity.this, "An error occurred during the File Download", Toast.LENGTH_SHORT).show();
                Toast.makeText(AssessmentResourceActivity.this, "Please try again", Toast.LENGTH_SHORT).show();

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
