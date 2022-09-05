package com.example.godzillafinance;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class BudgetActivity extends AppCompatActivity {

    private FloatingActionButton fb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_budget);

        fb = findViewById(R.id.floatingActionButton);
        fb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotoActivity_insert();
            }
        });
    }
    public void gotoActivity_insert(){

    }
}