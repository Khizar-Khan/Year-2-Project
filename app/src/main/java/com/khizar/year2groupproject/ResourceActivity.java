package com.khizar.year2groupproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import android.app.DownloadManager;
import android.content.Context;
import android.net.Uri;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.util.ArrayList;

import static android.os.Environment.DIRECTORY_DOWNLOADS;

public class ResourceActivity extends AppCompatActivity {

    Button resourceButtonM1a;
    Button resourceButtonM1b;
    Button resourceButtonM1c;
    Button resourceButtonM1d;

    Button resourceButtonM2a;
    Button resourceButtonM2b;
    Button resourceButtonM2c;
    Button resourceButtonM2d;

    Button resourceButtonM3a;
    Button resourceButtonM3b;
    Button resourceButtonM3c;
    Button resourceButtonM3d;

    Button resourceButtonM4a;
    Button resourceButtonM4b;
    Button resourceButtonM4c;
    Button resourceButtonM4d;

    Button resourceButtonM5a;
    Button resourceButtonM5b;
    Button resourceButtonM5c;
    Button resourceButtonM5d;

    Button resourceButtonM6a;
    Button resourceButtonM6b;
    Button resourceButtonM6c;
    Button resourceButtonM6d;

    Button resourceButtonM7a;
    Button resourceButtonM7b;
    Button resourceButtonM7c;
    Button resourceButtonM7d;

    Button assessment_resourcesButton;
    Button mainmenuButton;
    Button gobackButton;


    FirebaseStorage firebaseStorage;
    StorageReference storageReference;
    StorageReference ref;

    private WebView web_view;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resource_cs);

        resourceButtonM1a = findViewById(R.id.resourceButtonM1a);
        resourceButtonM1b = findViewById(R.id.resourceButtonM1b);
        resourceButtonM1c = findViewById(R.id.resourceButtonM1c);
        resourceButtonM1d = findViewById(R.id.resourceButtonM1d);

        resourceButtonM2a = findViewById(R.id.resourceButtonM2a);
        resourceButtonM2b = findViewById(R.id.resourceButtonM2b);
        resourceButtonM2c = findViewById(R.id.resourceButtonM2c);
        resourceButtonM2d = findViewById(R.id.resourceButtonM2d);

        resourceButtonM3a = findViewById(R.id.resourceButtonM3a);
        resourceButtonM3b = findViewById(R.id.resourceButtonM3b);
        resourceButtonM3c = findViewById(R.id.resourceButtonM3c);
        resourceButtonM3d = findViewById(R.id.resourceButtonM3d);

        resourceButtonM4a = findViewById(R.id.resourceButtonM4a);
        resourceButtonM4b = findViewById(R.id.resourceButtonM4b);
        resourceButtonM4c = findViewById(R.id.resourceButtonM4c);
        resourceButtonM4d = findViewById(R.id.resourceButtonM4d);

        resourceButtonM5a = findViewById(R.id.resourceButtonM5a);
        resourceButtonM5b = findViewById(R.id.resourceButtonM5b);
        resourceButtonM5c = findViewById(R.id.resourceButtonM5c);
        resourceButtonM5d = findViewById(R.id.resourceButtonM5d);

        resourceButtonM6a = findViewById(R.id.resourceButtonM6a);
        resourceButtonM6b = findViewById(R.id.resourceButtonM6b);
        resourceButtonM6c = findViewById(R.id.resourceButtonM6c);
        resourceButtonM6d = findViewById(R.id.resourceButtonM6d);

        resourceButtonM7a = findViewById(R.id.resourceButtonM7a);
        resourceButtonM7b = findViewById(R.id.resourceButtonM7b);
        resourceButtonM7c = findViewById(R.id.resourceButtonM7c);
        resourceButtonM7d = findViewById(R.id.resourceButtonM7d);

        assessment_resourcesButton = findViewById(R.id.assessment_resourcesButton);
        mainmenuButton = findViewById(R.id.mainmenuButton);
        gobackButton = findViewById(R.id.gobackButton);

        TextView textView_m1 = findViewById(R.id.textView_Resources_M1);
        TextView textView_m2 = findViewById(R.id.textView_Resources_M2);
        TextView textView_m3 = findViewById(R.id.textView_Resources_M3);
        TextView textView_m4 = findViewById(R.id.textView_Resources_M4);
        TextView textView_m5 = findViewById(R.id.textView_Resources_M5);

        MySQLConnector sqlConnector = new MySQLConnector();
        final ArrayList<String> ResourcesData = sqlConnector.readResourcesData();

        textView_m1.setText(ResourcesData.get(0));
        textView_m2.setText(ResourcesData.get(6));
        textView_m3.setText(ResourcesData.get(12));
        textView_m4.setText(ResourcesData.get(18));
        textView_m5.setText(ResourcesData.get(24));

        resourceButtonM1c.setText(ResourcesData.get(1));
        resourceButtonM1d.setText(ResourcesData.get(4));
        resourceButtonM2c.setText(ResourcesData.get(7));
        resourceButtonM2d.setText(ResourcesData.get(10));
        resourceButtonM3c.setText(ResourcesData.get(13));
        resourceButtonM3d.setText(ResourcesData.get(16));
        resourceButtonM4c.setText(ResourcesData.get(19));
        resourceButtonM4d.setText(ResourcesData.get(22));
        resourceButtonM5c.setText(ResourcesData.get(25));
        resourceButtonM5d.setText(ResourcesData.get(28));


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


        web_view = findViewById(R.id.webView);
        web_view.getSettings().setJavaScriptEnabled(true);
        web_view.setWebViewClient(new WebViewClient());
        web_view.setVisibility(View.GONE);
        gobackButton.setVisibility(View.GONE);


        resourceButtonM1c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String resource_web = (ResourcesData.get(2));
                web_view.loadUrl(resource_web);
                web_view.setVisibility(View.VISIBLE);
                assessment_resourcesButton.setVisibility(View.GONE);
                gobackButton.setVisibility(View.VISIBLE);
                Toast.makeText(ResourceActivity.this, "Website Successfully Loading", Toast.LENGTH_SHORT).show();
            }
        });resourceButtonM1d.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String resource_web = (ResourcesData.get(5));
                web_view.loadUrl(resource_web);
                web_view.setVisibility(View.VISIBLE);
                assessment_resourcesButton.setVisibility(View.GONE);
                gobackButton.setVisibility(View.VISIBLE);
                Toast.makeText(ResourceActivity.this, "Website Successfully Loading", Toast.LENGTH_SHORT).show();
            }
        });resourceButtonM2c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String resource_web = (ResourcesData.get(8));
                web_view.loadUrl(resource_web);
                web_view.setVisibility(View.VISIBLE);
                assessment_resourcesButton.setVisibility(View.GONE);
                gobackButton.setVisibility(View.VISIBLE);
                Toast.makeText(ResourceActivity.this, "Website Successfully Loading", Toast.LENGTH_SHORT).show();
            }
        });resourceButtonM2d.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String resource_web = (ResourcesData.get(11));
                web_view.loadUrl(resource_web);
                web_view.setVisibility(View.VISIBLE);
                assessment_resourcesButton.setVisibility(View.GONE);
                gobackButton.setVisibility(View.VISIBLE);
                Toast.makeText(ResourceActivity.this, "Website Successfully Loading", Toast.LENGTH_SHORT).show();
            }
        });resourceButtonM3c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String resource_web = (ResourcesData.get(14));
                web_view.loadUrl(resource_web);
                web_view.setVisibility(View.VISIBLE);
                assessment_resourcesButton.setVisibility(View.GONE);
                gobackButton.setVisibility(View.VISIBLE);
                Toast.makeText(ResourceActivity.this, "Website Successfully Loading", Toast.LENGTH_SHORT).show();
            }
        });resourceButtonM3d.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String resource_web = (ResourcesData.get(17));
                web_view.loadUrl(resource_web);
                web_view.setVisibility(View.VISIBLE);
                assessment_resourcesButton.setVisibility(View.GONE);
                gobackButton.setVisibility(View.VISIBLE);
                Toast.makeText(ResourceActivity.this, "Website Successfully Loading", Toast.LENGTH_SHORT).show();
            }
        });resourceButtonM4c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String resource_web = (ResourcesData.get(20));
                web_view.loadUrl(resource_web);
                web_view.setVisibility(View.VISIBLE);
                assessment_resourcesButton.setVisibility(View.GONE);
                gobackButton.setVisibility(View.VISIBLE);
                Toast.makeText(ResourceActivity.this, "Website Successfully Loading", Toast.LENGTH_SHORT).show();
            }
        });resourceButtonM4d.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String resource_web = (ResourcesData.get(23));
                web_view.loadUrl(resource_web);
                web_view.setVisibility(View.VISIBLE);
                assessment_resourcesButton.setVisibility(View.GONE);
                gobackButton.setVisibility(View.VISIBLE);
                Toast.makeText(ResourceActivity.this, "Website Successfully Loading", Toast.LENGTH_SHORT).show();
            }
        });resourceButtonM5c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String resource_web = (ResourcesData.get(26));
                web_view.loadUrl(resource_web);
                web_view.setVisibility(View.VISIBLE);
                assessment_resourcesButton.setVisibility(View.GONE);
                gobackButton.setVisibility(View.VISIBLE);
                Toast.makeText(ResourceActivity.this, "Website Successfully Loading", Toast.LENGTH_SHORT).show();
            }
        });resourceButtonM5d.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String resource_web = (ResourcesData.get(29));
                web_view.loadUrl(resource_web);
                web_view.setVisibility(View.VISIBLE);
                assessment_resourcesButton.setVisibility(View.GONE);
                gobackButton.setVisibility(View.VISIBLE);
                Toast.makeText(ResourceActivity.this, "Website Successfully Loading", Toast.LENGTH_SHORT).show();
            }


        });gobackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                web_view.setVisibility(View.GONE);
                gobackButton.setVisibility(View.GONE);
                assessment_resourcesButton.setVisibility(View.VISIBLE);

            }
        });mainmenuButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ResourceActivity.this, MainActivity.class));

            }
        });assessment_resourcesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ResourceActivity.this, AssessmentResourceActivity.class));

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
                Toast.makeText(ResourceActivity.this, "File Successfully Downloading", Toast.LENGTH_SHORT).show();

            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(ResourceActivity.this, "An error occurred during the File Download", Toast.LENGTH_SHORT).show();
                Toast.makeText(ResourceActivity.this, "Please try again", Toast.LENGTH_SHORT).show();

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
                Toast.makeText(ResourceActivity.this, "File Successfully Downloading", Toast.LENGTH_SHORT).show();

            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(ResourceActivity.this, "An error occurred during the File Download", Toast.LENGTH_SHORT).show();
                Toast.makeText(ResourceActivity.this, "Please try again", Toast.LENGTH_SHORT).show();

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
                Toast.makeText(ResourceActivity.this, "File Successfully Downloading", Toast.LENGTH_SHORT).show();

            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(ResourceActivity.this, "An error occurred during the File Download", Toast.LENGTH_SHORT).show();
                Toast.makeText(ResourceActivity.this, "Please try again", Toast.LENGTH_SHORT).show();

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
                Toast.makeText(ResourceActivity.this, "File Successfully Downloading", Toast.LENGTH_SHORT).show();

            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(ResourceActivity.this, "An error occurred during the File Download", Toast.LENGTH_SHORT).show();
                Toast.makeText(ResourceActivity.this, "Please try again", Toast.LENGTH_SHORT).show();

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
                Toast.makeText(ResourceActivity.this, "File Successfully Downloading", Toast.LENGTH_SHORT).show();
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(ResourceActivity.this, "An error occurred during the File Download", Toast.LENGTH_SHORT).show();
                Toast.makeText(ResourceActivity.this, "Please try again", Toast.LENGTH_SHORT).show();

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
                Toast.makeText(ResourceActivity.this, "File Successfully Downloading", Toast.LENGTH_SHORT).show();
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(ResourceActivity.this, "An error occurred during the File Download", Toast.LENGTH_SHORT).show();
                Toast.makeText(ResourceActivity.this, "Please try again", Toast.LENGTH_SHORT).show();

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
                Toast.makeText(ResourceActivity.this, "File Successfully Downloading", Toast.LENGTH_SHORT).show();
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(ResourceActivity.this, "An error occurred during the File Download", Toast.LENGTH_SHORT).show();
                Toast.makeText(ResourceActivity.this, "Please try again", Toast.LENGTH_SHORT).show();

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
                Toast.makeText(ResourceActivity.this, "File Successfully Downloading", Toast.LENGTH_SHORT).show();
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(ResourceActivity.this, "An error occurred during the File Download", Toast.LENGTH_SHORT).show();
                Toast.makeText(ResourceActivity.this, "Please try again", Toast.LENGTH_SHORT).show();

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
                Toast.makeText(ResourceActivity.this, "File Successfully Downloading", Toast.LENGTH_SHORT).show();
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(ResourceActivity.this, "An error occurred during the File Download", Toast.LENGTH_SHORT).show();
                Toast.makeText(ResourceActivity.this, "Please try again", Toast.LENGTH_SHORT).show();

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
                Toast.makeText(ResourceActivity.this, "File Successfully Downloading", Toast.LENGTH_SHORT).show();
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(ResourceActivity.this, "An error occurred during the File Download", Toast.LENGTH_SHORT).show();
                Toast.makeText(ResourceActivity.this, "Please try again", Toast.LENGTH_SHORT).show();

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

