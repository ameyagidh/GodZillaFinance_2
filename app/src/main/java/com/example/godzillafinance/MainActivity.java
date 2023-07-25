package com.example.godzillafinance;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {

    Button LogoutButton;
    Button ExploreButton;
    TextView welcomeText;
    FirebaseAuth auth;
    FirebaseUser user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LogoutButton = findViewById(R.id.signOutButtonMainActivity);
        ExploreButton = findViewById(R.id.ExploreMainActivity);
        auth = FirebaseAuth.getInstance();
        welcomeText = findViewById(R.id.WelcomeTextMain);
        user = auth.getCurrentUser();


        if(user==null){
            Intent intent = new Intent(getApplicationContext(),loginActivity.class);
            startActivity(intent);
            finish();
        }
        else{
            welcomeText.setText(user.getEmail());
        }
        LogoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseAuth.getInstance().signOut();
                Intent intent = new Intent(getApplicationContext(),loginActivity.class);
                startActivity(intent);
                finish();
            }
        });

        ExploreButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), FeatureActivity.class);
                startActivity(intent);
            }
        });

    }
}