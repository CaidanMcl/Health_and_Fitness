package com.helfhealthandfitness;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class  MainActivity extends AppCompatActivity {
    // Write a message to the database
    FirebaseDatabase database = FirebaseDatabase.getInstance();
   // DatabaseReference myRef = database.getReference("Login");

    private FirebaseAuth mAuth;

    String emailE;
    String passwordE;

    EditText email, password;
    Button btnLogin, btnRegs;
    TextView errorMessage;
    helfClass helfClass;


    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        email = findViewById(R.id.et_Email);
        password = findViewById(R.id.et_password);
        btnLogin = findViewById(R.id.btnLogin);
        btnRegs = findViewById(R.id.btnReg);

        // Initialize Firebase Auth
        mAuth = FirebaseAuth.getInstance();

        btnRegs = (Button) findViewById(R.id.btnReg);

        btnRegs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)  {
                Log.d("TAG", "in main: ");

                startActivity(new Intent(MainActivity.this, RegisterUser.class));


            }
        });
        btnLogin = (Button) findViewById(R.id.btnLogin);

        btnLogin.setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View v) {
                emailE = email.getText().toString().trim();
                passwordE = password.getText().toString().trim();
                mAuth.signInWithEmailAndPassword(emailE, passwordE).addOnCompleteListener(new OnCompleteListener<AuthResult>()
                {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task)
                    {
                        if (task.isSuccessful())
                        {
                            Toast.makeText(MainActivity.this, "User " + mAuth.getCurrentUser().getEmail()+ " is logged in", Toast.LENGTH_SHORT).show();

                            startActivity(new Intent(MainActivity.this, Home.class));
                        }


                    }
                }).addOnFailureListener(new OnFailureListener()
                {
                    @Override
                    public void onFailure(@NonNull Exception e)
                    {
                        Toast.makeText(MainActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();

                    }
                });
            }
        });
    }
}