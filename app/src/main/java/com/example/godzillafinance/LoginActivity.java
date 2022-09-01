package com.example.godzillafinance;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {

    private EditText email,password;
    private Button LoginButton;
    private TextView SignUpTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        email = findViewById(R.id.EmailId);
        password = findViewById(R.id.Password);
        LoginButton = findViewById(R.id.LoginButton);
        SignUpTextView = findViewById(R.id.SignUpTextView);

        LoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotoActivity_RegisterHere();
            }
        });
        SignUpTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotoActivity_RegisterHere();
            }
        });
    }
    public void gotoActivity_RegisterHere() {
        Intent i = new Intent(this,RegistrationActiivity.class);
        startActivity(i);
    }
}