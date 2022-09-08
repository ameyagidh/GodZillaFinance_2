package com.example.godzillafinance;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class TodaySpendingActivity extends AppCompatActivity {

    private ProgressBar progressBar;
    private FloatingActionButton fb;
    private RecyclerView recyclerView3;
    private TextView TodaySpending_Tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_today_spending);

        progressBar = findViewById(R.id.progressBar2);
        fb = findViewById(R.id.floatingActionButton2);
        recyclerView3 = findViewById(R.id.RecyclerView3);

        fb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

    }
}