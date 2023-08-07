package com.example.godzillafinance;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FeatureActivity extends AppCompatActivity {

    Button CryptoFeature, GooglePayButton, StockTracker;

    private BottomNavigationView bottomNavigationView;
    private FrameLayout frameLayout;
    private FirebaseAuth mAuth;

    ArrayList<HashMap<String,Object>> items;
    PackageManager pm ;
    List<PackageInfo> packs;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_features);

        CryptoFeature = findViewById(R.id.cryptoFeatureActivity);

        CryptoFeature.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent  = new Intent(getApplicationContext(), CryptoTrackerActivity.class);
                startActivity(intent);
            }
        });

    }
}