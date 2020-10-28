package com.helfhealthandfitness;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.FileProvider;

import android.content.Intent;
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

public class Goals extends AppCompatActivity {
    FirebaseDatabase database;
    DatabaseReference myRef;

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
        database = FirebaseDatabase.getInstance();

        myRef = database.getReference("Goals");
        Weight = findViewById(R.id.et_WeightGoal);
        Calories = findViewById(R.id.et_CaloricCounter);

        btnSave = (Button) findViewById(R.id.btnSave);

        btnSave.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                weightG = Weight.getText().toString().trim();
                CaloriesG = Calories.getText().toString().trim();

                goalsWorkerClass = new GoalsWorkerClass(weightG, CaloriesG);
                myRef.push().setValue(goalsWorkerClass)
                        .addOnSuccessListener(new OnSuccessListener<Void>()
                        {
                            @Override
                            public void onSuccess(Void aVoid)
                            {
                                Toast.makeText(Goals.this, "Goals have been successfully saved!", Toast.LENGTH_SHORT).show();

                            }
                        }).addOnFailureListener(new OnFailureListener()
                {
                    @Override
                    public void onFailure(@NonNull Exception e)
                    {
                        Toast.makeText(Goals.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });


            }
        });
        findViewById(R.id.btnTakePic).setOnClickListener(new View.OnClickListener()
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
        });
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == 1 && resultCode == RESULT_OK)
        {
            Bitmap bitmap = BitmapFactory.decodeFile(Photo);

            ImageView imageview = findViewById(R.id.IMG_pic);
            imageview.setImageBitmap(bitmap);
        }
    }
}