package com.helfhealthandfitness;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class RegisterUser extends AppCompatActivity {

    FirebaseDatabase database = FirebaseDatabase.getInstance();
   // DatabaseReference Ref = database.getReference("Register");
    private FirebaseAuth mAuth;

    EditText name,regUserName1,regPassword,regEmail,age,gender;
    Button RegisterUser1;
    String regName;
    String regUsername;
    String rPassword;
    String rEmail;
    String rAge;
    String rGender;
    Register register;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_user);

        name = findViewById(R.id.et_RName);
        regUserName1 = findViewById(R.id.et_UsName);
        regPassword = findViewById(R.id.et_Rpassword);
        regEmail = findViewById(R.id.et_email);
        age = findViewById(R.id.et_Rage);
        gender = findViewById(R.id.et_RGender);
        RegisterUser1 = findViewById(R.id.btnRegU);

        mAuth = FirebaseAuth.getInstance();

        RegisterUser1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String[] permissions = {Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.CAMERA};
                rEmail = regEmail.getText().toString().trim();
                rPassword = regPassword.getText().toString().trim();

                mAuth.createUserWithEmailAndPassword(rEmail, rPassword)
                        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                Toast.makeText(RegisterUser.this, "Successfully registered and new user created " + mAuth.getCurrentUser(), Toast.LENGTH_SHORT).show();
                            }
                        }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(RegisterUser.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });

                startActivity(new Intent(RegisterUser.this, MainActivity.class));

            }
        });
    }}


               /* regName = name.getText().toString().trim();
                regUsername = regUserName1.getText().toString().trim();
                rPassword = regPassword.getText().toString().trim();
                rAge = age.getText().toString().trim();
                rGender = gender.getText().toString().trim();

                register = new Register(regName,regUsername,rPassword,rEmail,rAge,rGender);
                Ref.push().setValue(register)
                        .addOnSuccessListener(new OnSuccessListener<Void>(){
                            @Override
                            public void onSuccess(Void aVoid)
                            {
                                Toast.makeText(RegisterUser.this, "Registration is successfully completed", Toast.LENGTH_SHORT).show();

                            }
                        })
                        .addOnFailureListener(new OnFailureListener()
                        {
                            @Override
                            public void onFailure(@NonNull Exception e)
                            {

                                Toast.makeText(RegisterUser.this, "Missing information from required fields", Toast.LENGTH_SHORT).show();
                            }
                        });
            }
        });
        RegisterUser1 = (Button) findViewById(R.id.btnRegU);
        RegisterUser1.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v){
                Intent i = new Intent(RegisterUser.this, MainActivity.class);
                startActivity(i);
                //startActivity(RegisterUser.this,MainActivity.class);
                //startActivity(new Intent());
            }
        });

    }*/
