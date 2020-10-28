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


public class UserProfileSettings extends AppCompatActivity {
    FirebaseDatabase database;
    DatabaseReference myRef;

    String usName;
    String usUsername;
    String usPassword;
    String usAge;
    String usEmail;

    EditText usPName, Username, Password, Age, Email;
    Button btnUpdate;
    WorkerUserSettings workerUserSettings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile_settings);

        database= FirebaseDatabase.getInstance();
        myRef = database.getReference("UserProfilesettings");

        usPName = findViewById(R.id.et_pName);
        Username = findViewById(R.id.et_pUserName);
        Password = findViewById(R.id.et_pPassword);
        Age = findViewById(R.id.et_Age);
        Email = findViewById(R.id.et_pEmail);
        btnUpdate = findViewById(R.id.btnUpdate);

        btnUpdate = (Button) findViewById(R.id.btnUpdate);

        btnUpdate.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                usName = usPName.getText().toString().trim();
                usUsername = Username.getText().toString().trim();
                usPassword = Password.getText().toString().trim();
                usAge = Age.getText().toString().trim();
                usEmail = Email.getText().toString().trim();

                workerUserSettings = new WorkerUserSettings(usName, usUsername, usPassword, usAge, usEmail);
                myRef.push().setValue(workerUserSettings).addOnSuccessListener(new OnSuccessListener<Void>()
                {
                    @Override
                    public void onSuccess(Void aVoid)
                    {
                        Toast.makeText(UserProfileSettings.this, "Updated user changes.", Toast.LENGTH_SHORT).show();

                        startActivity(new Intent(UserProfileSettings.this, Home.class));

                    }

                }).addOnFailureListener(new OnFailureListener()
                {
                    @Override
                    public void onFailure(@NonNull Exception e)
                    {
                        Toast.makeText(UserProfileSettings.this, "Information not completed", Toast.LENGTH_SHORT).show();

                    }
                });

            }
        });
    }
}