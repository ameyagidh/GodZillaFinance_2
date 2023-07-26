package com.example.godzillafinance;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class FeatureActivity extends AppCompatActivity {

    Button CryptoFeature, GooglePayButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_features);

        CryptoFeature = findViewById(R.id.CryptoFeatureActivity);
        GooglePayButton = findViewById(R.id.GooglePayActivity);

        CryptoFeature.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent  = new Intent(getApplicationContext(), CryptoTrackerActivity.class);
                startActivity(intent);
            }
        });

        GooglePayButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent  = new Intent(getApplicationContext(), GooglePaymentActivity.class);
                startActivity(intent);
            }
        });
    }
}