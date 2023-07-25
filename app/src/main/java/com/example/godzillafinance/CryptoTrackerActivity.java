package com.example.godzillafinance;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.ProgressBar;

public class CryptoTrackerActivity extends AppCompatActivity {

    EditText searchBar;
    RecyclerView RecyclerView;
    ProgressBar ProgressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crypto_tracker);

        searchBar = findViewById(R.id.SearchCryptoTracker);
        RecyclerView = findViewById(R.id.recyclerViewCryptoTracker);
        ProgressBar = findViewById(R.id.ProgressBarCryptoTracker);

    }



}