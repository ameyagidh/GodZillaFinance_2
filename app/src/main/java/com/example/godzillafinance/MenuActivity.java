package com.example.godzillafinance;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MenuActivity extends AppCompatActivity {

    private CardView budgetCardView;
    private CardView todayCardView;
    private CardView weeklyCardView;
    private CardView MonthlyCardView;
    private CardView HistoryCardView;
    private CardView AnalyticsCardView;
    private CardView Learning;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        budgetCardView = (CardView) findViewById(R.id.budgetCardView);
        todayCardView = (CardView) findViewById(R.id.todayCardView);
        weeklyCardView = (CardView) findViewById(R.id.WeekCardView);
        MonthlyCardView = (CardView) findViewById(R.id.MonthlyCardView);
        HistoryCardView = (CardView) findViewById(R.id.HistoryCardView);
        AnalyticsCardView = (CardView) findViewById(R.id.AnalyticsCardView);

        budgetCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotoActivity1();
            }
        });
        todayCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotoActivity2();
            }
        });
        weeklyCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {gotoActivity3();}
        });
        MonthlyCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {gotoActivity4();}
        });
        HistoryCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {gotoActivity5();}
        });
        AnalyticsCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {gotoActivity6();}
        });
    }
    public void gotoActivity1(){
        Intent i = new Intent(this,BudgetActivity.class);
        startActivity(i);
    }
    public void gotoActivity2(){
        Intent i = new Intent(this,TodaySpendingActivity.class);
        startActivity(i);
    }
    public void gotoActivity3(){
        Intent i = new Intent(this,WeeklySpending.class);
        startActivity(i);
    }
    public void gotoActivity4(){
        Intent i = new Intent(this,MonthlyActivity.class);
        startActivity(i);
    }
    public void gotoActivity5(){
        Intent i = new Intent(this,HistoryActivity.class);
        startActivity(i);
    }
    public void gotoActivity6(){
        Intent i = new Intent(this,AnalyticsActivity.class);
        startActivity(i);
    }
}