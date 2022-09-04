package com.example.godzillafinance;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;

public class RegistrationActivity extends AppCompatActivity {

    private EditText FullName_Et;
    private EditText Password_Et;
    private EditText Email_Et;
    private EditText Age_Et;
    private Button SignUp_btn;
    private TextView LoginBack_btn;
    private ProgressBar ProgressBar;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        FullName_Et = findViewById(R.id.FullName);
        Password_Et = findViewById(R.id.password);
        Email_Et = findViewById(R.id.Email);
        Age_Et = findViewById(R.id.Age);
        SignUp_btn = findViewById(R.id.SignUp);
        LoginBack_btn = findViewById(R.id.LoginBack);
        ProgressBar = findViewById(R.id.ProgressBar);
        mAuth = FirebaseAuth.getInstance();

        LoginBack_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotToActivity_LoginHere();
            }
        });

        SignUp_btn.setOnClickListener(new View.OnClickListener() {
            // getting the string values from the edit text.
            @Override
            public void onClick(View view) {
                String FullName_val =  FullName_Et.getText().toString().trim();
                String Password_val =  Password_Et.getText().toString().trim();
                String Email_val =  Email_Et.getText().toString().trim();
                String Age_val =  Age_Et.getText().toString().trim();

                if(FullName_val.isEmpty()){
                    FullName_Et.setError("Full Name cannot be empty.");
                    FullName_Et.requestFocus();
                    return;
                }

                if(Age_val.isEmpty()){
                    Age_Et.setError("Age cannot be empty.");
                    Age_Et.requestFocus();
                    return;
                }

                if(Email_val.isEmpty()){
                    Email_Et.setError("Email cannot be empty.");
                    Email_Et.requestFocus();
                    return;
                }
                if(!Patterns.EMAIL_ADDRESS.matcher(Email_val).matches()){
                    Email_Et.setError("Email not in proper format.");
                    Email_Et.requestFocus();
                    return;
                }

                if(Password_val.isEmpty()){
                    Password_Et.setError("Password cannot be empty.");
                    Password_Et.requestFocus();
                    return;
                }
                if(Password_val.length() < 6){
                    Password_Et.setError("Length of the password cannot be less than 6.");
                    Password_Et.requestFocus();
                    return;
                }

            }
        });
    }
    public void gotToActivity_LoginHere(){
        // Already a user.
        Intent i = new Intent(RegistrationActivity.this,LoginActivity.class);
        startActivity(i);
    }
}