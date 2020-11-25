package com.helfhealthandfitness;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.content.Intent;

public class Home extends AppCompatActivity {

    Button Log,Goals, EditP;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        Log = findViewById(R.id.btnLog);
        Goals = findViewById(R.id.btnGoals);
        EditP = findViewById(R.id.btnEditP);

        Log = (Button) findViewById(R.id.btnLog);

        Log.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Home.this, UserProfile.class));
            }

        });

        Goals = (Button) findViewById(R.id.btnGoals);

        Goals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Home.this, Goals.class));
            }

        });


        EditP = (Button) findViewById(R.id.btnEditP);

        EditP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Home.this, UserProfileSettings.class));
            }

        });


    }
}