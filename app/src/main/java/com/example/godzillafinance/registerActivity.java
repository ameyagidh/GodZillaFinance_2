package com.example.godzillafinance;

import static android.content.ContentValues.TAG;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.Objects;

public class registerActivity extends AppCompatActivity {

    TextInputEditText editTextEmail;
    EditText editTextPassword;
    Button SignUpButton;
    ProgressBar progressBar;
    TextView textViewRegisterPage;

    private FirebaseAuth mAuth;

    @Override
    public void onStart() {
        super.onStart();

        FirebaseUser currentUser = mAuth.getCurrentUser();
        if(currentUser != null){
            Intent intent = new Intent(getApplicationContext(),MainActivity.class);
            startActivity(intent);
            finish();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        editTextEmail = findViewById(R.id.emailRegister);
        editTextPassword = findViewById(R.id.passwordRegister);
        SignUpButton = findViewById(R.id.buttonRegister);
        progressBar = findViewById(R.id.progressbarRegister);
        textViewRegisterPage = findViewById(R.id.LoginInNowRegister);

        mAuth = FirebaseAuth.getInstance();

        textViewRegisterPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),registerActivity.class);
                startActivity(intent);
                finish();
            }
        });

        SignUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                progressBar.setVisibility(View.VISIBLE);
                String email = Objects.requireNonNull(editTextEmail.getText()).toString();
                String password = Objects.requireNonNull(editTextPassword.getText()).toString();
                if(TextUtils.isEmpty(email)){
                    Toast.makeText(registerActivity.this,"Enter email",Toast.LENGTH_LONG).show();
                    return;
                }
                if(TextUtils.isEmpty(password)){
                    Toast.makeText(registerActivity.this,"Enter password",Toast.LENGTH_LONG).show();
                    return;
                }
                else{

                    mAuth.createUserWithEmailAndPassword(email, password)
                            .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    progressBar.setVisibility(View.GONE);
                                    if (task.isSuccessful()) {
                                        progressBar.setVisibility(View.GONE);
                                        Toast.makeText(registerActivity.this,"Registeration Successful!!! ",Toast.LENGTH_LONG).show();
                                        FirebaseUser user = mAuth.getCurrentUser();

                                         Intent intent = new Intent(getApplicationContext(),registerActivity.class);
                                        startActivity(intent);
                                        finish();

                                    } else {
                                      Toast.makeText(registerActivity.this, "Registration failed.",
                                                Toast.LENGTH_SHORT).show();
                                    }
                                }
                            });
                }
            }
        });

    }
}