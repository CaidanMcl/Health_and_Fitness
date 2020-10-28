package com.helfhealthandfitness;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class UserProfile extends AppCompatActivity {
    FirebaseDatabase database;
    DatabaseReference myRef;

    String usWeight;
    String usHeight;
    String monDay;
    String tuesDay;
    String wednesDay;
    String thursDay;
    String friDay;
    String saturDay;
    String sunDay;

    EditText weight, height, monday, tuesday, wednesday, thursday, friday, saturday,  sunday;
    Button btnSave;
    UserInfo userInfo;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);
        database = FirebaseDatabase.getInstance();
        myRef = database.getReference("UserProfile");


        weight = findViewById(R.id.et_Weight);
        height = findViewById(R.id.et_Height);
        monday = findViewById(R.id.et_Monday);
        tuesday = findViewById(R.id.et_Tuesday);
        wednesday = findViewById(R.id.et_Wednesday);
        thursday = findViewById(R.id.et_Thursday);
        friday = findViewById(R.id.et_Friday);
        saturday = findViewById(R.id.et_Saturday);
        sunday = findViewById(R.id.et_Sunday);
        btnSave = findViewById(R.id.btnSave);


        btnSave.setOnClickListener(new View.OnClickListener()
        {  @Override
            public void onClick(View view) {
            usWeight = weight.getText().toString().trim();
            usHeight = height.getText().toString().trim();
            monDay = monday.getText().toString().trim();
            tuesDay = tuesday.getText().toString().trim();
            wednesDay = wednesday.getText().toString().trim();
            thursDay = thursday.getText().toString().trim();
            friDay = friday.getText().toString().trim();
            saturDay = saturday.getText().toString().trim();
            sunDay = sunday.getText().toString().trim();

            userInfo = new UserInfo(usWeight, usHeight, monDay, tuesDay, wednesDay, thursDay, friDay, saturDay, sunDay);
            myRef.push().setValue(userInfo)
                    .addOnSuccessListener(new OnSuccessListener<Void>() {

                        @Override
                        public void onSuccess(Void aVoid) {
                            Toast.makeText(UserProfile.this, "Successfully logged daily weight ", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(UserProfile.this, Home.class));

                        }
                    })
                    .addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Toast.makeText(UserProfile.this, "Missing values User profile", Toast.LENGTH_SHORT).show();
                        }


                    });

            btnSave = (Button) findViewById(R.id.btnSave);
            btnSave.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i = new Intent(UserProfile.this, MainActivity.class);
                    startActivity(i);
                    //startActivity(new : UserProfile.this,MainActivity.class);
                    // startActivity(new Intent());

                }


            });
        }


        });


    }
}