package com.helfhealthandfitness;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Logger;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class BarChartActivity extends AppCompatActivity {
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference("GoalsWorkerClass");



    GoalsWorkerClass goalsWorkerClass;
    UserInfo userInfo;
    BarChart barChart;
    ArrayList<IBarDataSet> iBarDataSets = new ArrayList<>();
   ArrayList<BarData> data = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bar_chart);

        barChart = findViewById(R.id.chart);

        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                goalsWorkerClass = new GoalsWorkerClass();
                ArrayList Weight = new ArrayList();
                if(barChart.getData() != null &&
                barChart.getData().getDataSetCount()>0)
                for(DataSnapshot goalWorkerClassFromFirebase : snapshot.getChildren()){
                    GoalsWorkerClass goalsWorkerClass = goalWorkerClassFromFirebase.getValue(GoalsWorkerClass.class);
                    Weight.add(new BarEntry(Float.parseFloat(goalsWorkerClass.weightGoal), 0));
                    Weight.add(new BarEntry(Float.parseFloat(goalsWorkerClass.caloricGoal), 0));
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        ArrayList Weight = new ArrayList();
        goalsWorkerClass = new GoalsWorkerClass();
        String weight = goalsWorkerClass.weightGoal;
        String Calories = goalsWorkerClass.caloricGoal;


        Weight.add(new BarEntry(Float.parseFloat(weight), 0));
        Weight.add(new BarEntry(Float.parseFloat(Calories), 1));
        Weight.add(new BarEntry(1133f, 2));
        Weight.add(new BarEntry(1240f, 3));
        Weight.add(new BarEntry(1369f, 4));
        Weight.add(new BarEntry(1487f, 5));
        Weight.add(new BarEntry(1501f, 6));
        Weight.add(new BarEntry(1645f, 7));
        Weight.add(new BarEntry(1578f, 8));
        Weight.add(new BarEntry(1695f, 9));

        ArrayList year = new ArrayList();

        year.add("2008");
        year.add("2009");
        year.add("2010");
        year.add("2011");
        year.add("2012");
        year.add("2013");
        year.add("2014");
        year.add("2015");
        year.add("2016");
        year.add("2017");

        BarDataSet bardataset = new BarDataSet(Weight, "Weight Goal");
        barChart.animateY(5000);
        BarData data = new BarData((IBarDataSet) Weight, bardataset);
        bardataset.setColors(ColorTemplate.COLORFUL_COLORS);
        barChart.setData(data);
    }
}
