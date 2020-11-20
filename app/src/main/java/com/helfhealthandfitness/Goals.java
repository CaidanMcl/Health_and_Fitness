package com.helfhealthandfitness;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.content.FileProvider;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.io.File;
import java.io.IOException;

public class  Goals extends AppCompatActivity {
    FirebaseDatabase database;
    DatabaseReference myRef;
//Initialize Variables
     ImageView imageView;
     Button btnTakePic;

    private String Photo;

    String weightG;
    String CaloriesG;

    EditText Weight, Calories;
    Button btnSave;
    GoalsWorkerClass goalsWorkerClass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_goals);
        //Assigning Variables
        database = FirebaseDatabase.getInstance();



        //Variables for photo
        imageView = findViewById(R.id.IMG_pic);
        btnTakePic = findViewById(R.id.btnTakePic);

        //Variables for goals
        myRef = database.getReference("Goals");
        Weight = findViewById(R.id.et_WeightGoal);
        Calories = findViewById(R.id.et_CaloricCounter);

        btnSave = (Button) findViewById(R.id.btnSave);


        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                weightG = Weight.getText().toString().trim();
                CaloriesG = Calories.getText().toString().trim();

                goalsWorkerClass = new GoalsWorkerClass(weightG, CaloriesG);
                myRef.push().setValue(goalsWorkerClass)
                        .addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void aVoid) {
                                Toast.makeText(Goals.this, "Goals have been successfully saved!", Toast.LENGTH_SHORT).show();

                            }
                        }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(Goals.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });


            }

        });
        //requesting camera permission
        if (ContextCompat.checkSelfPermission(Goals.this,
                Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(Goals.this,
                    new String[]{
                            Manifest.permission.CAMERA
                    },
                    100);
        }
        btnTakePic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Opens Camera
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intent, 100);
            }
        });
    }
        @Override
        protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
            super.onActivityResult(requestCode, resultCode, data);
            if (requestCode == 100) {
                //Get capture
                Bitmap captureImage = (Bitmap) data.getExtras().get("data");
                //set captured pic to the image view
                imageView.setImageBitmap(captureImage);
            }
        }
}


        /*findViewById(R.id.btnTakePic).setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                String fileName = "OPSCPicsCapture";
                File storageDirectory = getExternalFilesDir(Environment.DIRECTORY_PICTURES);

                try {
                    File imageFile = File.createTempFile(fileName, ".jpg", storageDirectory);
                    Photo = imageFile.getAbsolutePath();

                    Uri imageURI = FileProvider.getUriForFile(Goals.this, "com.helfhealthandfitness.fileprovider", imageFile);

                    Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                    intent.putExtra(MediaStore.EXTRA_OUTPUT, imageURI);
                    startActivityForResult(intent, 1);

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });*/


   /* @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == 1 && resultCode == RESULT_OK)
        {
            Bitmap bitmap = BitmapFactory.decodeFile(Photo);

            ImageView imageview = findViewById(R.id.IMG_pic);
            imageview.setImageBitmap(bitmap);
        }
    }*/
