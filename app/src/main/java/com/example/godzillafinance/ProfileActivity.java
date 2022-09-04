package com.example.godzillafinance;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class ProfileActivity extends AppCompatActivity {

    private ImageView LogOut_Btn;
    private TextView FullName_Et;
    private TextView Age_Et;
    private TextView Email_Et;
    private FirebaseAuth mAuth;

    private FirebaseUser user;
    private DatabaseReference reference;
    private String userId;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        FullName_Et = findViewById(R.id.FullName);
        Age_Et = findViewById(R.id.age);
        Email_Et = findViewById(R.id.EmailAddress);

        LogOut_Btn = findViewById(R.id.LogOut);
        mAuth = FirebaseAuth.getInstance();

        LogOut_Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseAuth.getInstance().signOut();
                gotoActivity_Logout();
            }
        });

        // Showing user information.
        user = FirebaseAuth.getInstance().getCurrentUser();
        reference = FirebaseDatabase.getInstance().getReference("Users");
        userId = user.getUid();

        reference.child(userId).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                UserCreated userProfile = snapshot.getValue(UserCreated.class);
                if(userProfile != null){
                    String FullName = userProfile.fullName;
                    String age = userProfile.age;
                    String email = userProfile.email;

                    // Setting the user information on the userprofile.
                    FullName_Et.setText(FullName);
                    Age_Et.setText(age);
                    Email_Et.setText(email);

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(ProfileActivity.this,"Unable to fetch User Data.",Toast.LENGTH_LONG).show();
            }
        });
    }
    public void gotoActivity_Logout(){
        Intent i = new Intent(ProfileActivity.this,LoginActivity.class);
        startActivity(i);

    }
}