package com.example.godzillafinance;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;

public class ProfileActivity extends AppCompatActivity {

    private ImageView LogOut_Btn;
    private TextView FullName_Et;
    private TextView Age_Et;
    private TextView Email_Et;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        LogOut_Btn = findViewById(R.id.LogOut);
        mAuth = FirebaseAuth.getInstance();

        LogOut_Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseAuth.getInstance().signOut();
                gotoActivity_Logout();
            }
        });

    }
    public void gotoActivity_Logout(){
        Intent i = new Intent(ProfileActivity.this,LoginActivity.class);
        startActivity(i);

    }
}