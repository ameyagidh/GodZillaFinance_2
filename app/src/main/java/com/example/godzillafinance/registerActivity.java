package com.example.godzillafinance;

import static android.content.ContentValues.TAG;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
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

    TextInputEditText editTextEmail,editTextPassword;
    Button SignUpButton;
    ProgressBar progressBar;
    TextView textViewRegisterPage;

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        editTextEmail = findViewById(R.id.emailRegister);
        editTextEmail = findViewById(R.id.passwordRegister);
        SignUpButton = findViewById(R.id.buttonRegister);
        progressBar = findViewById(R.id.progressbarRegister);
        textViewRegisterPage = findViewById(R.id.LoginInNowRegister);

        mAuth = FirebaseAuth.getInstance();

        textViewRegisterPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

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
                                    if (task.isSuccessful()) {
                                        progressBar.setVisibility(View.GONE);
                                        Toast.makeText(registerActivity.this,"Registeration Successful!!! ",Toast.LENGTH_LONG).show();
                                        FirebaseUser user = mAuth.getCurrentUser();

                                    } else {
                                      Toast.makeText(registerActivity.this, "Authentication failed.",
                                                Toast.LENGTH_SHORT).show();

                                    }
                                }
                            });

                }
            }
        });

    }
}