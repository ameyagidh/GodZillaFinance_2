package com.example.godzillafinance;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class FeatureActivity extends AppCompatActivity {

    Button CryptoFeature;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_features);

        CryptoFeature = findViewById(R.id.CryptoFeatureActivity);

        CryptoFeature.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent  = new Intent(getApplicationContext(), CryptoTrackerActivity.class);
                startActivity(intent);
            }
        });
    }
}