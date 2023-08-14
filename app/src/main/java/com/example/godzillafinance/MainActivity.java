package com.example.godzillafinance;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toolbar;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    FirebaseAuth auth;
    FirebaseUser user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DrawerLayout drawerLayout = findViewById(R.id.drawer_layout);
        drawerLayout.openDrawer(GravityCompat.START);

        auth = FirebaseAuth.getInstance();
        user = auth.getCurrentUser();


        if(user==null){
            Intent intent = new Intent(getApplicationContext(),loginActivity.class);
            startActivity(intent);
            finish();
        }
//        else{
//        }
    }

    public void displaySelectedListener(int itemId) {
        Fragment fragment = null;
        switch (itemId) {
            case R.id.profile:
                Intent profile_intent = new Intent(getApplicationContext(), Profile.class);
                startActivity(profile_intent);
                break;

            case R.id.dashboard:
//                fragment = new DashboardFragment();
                break;

            case R.id.income:
//                fragment = new IncomeFragment();
                break;

            case R.id.search_income:
//                Intent intent_inc = new Intent(getApplicationContext(), searchdata.class);
//                startActivity(intent_inc);
                break;

            case R.id.expense:
//                fragment = new ExpenseFragment();
                break;

            case R.id.search_expense:
//                Intent intent_exp = new Intent(getApplicationContext(), searchdata2.class);
//                startActivity(intent_exp);
                break;

            case R.id.income_tax_emi:
//                Intent intent3 = new Intent(getApplicationContext(), inc_emi.class);
//                startActivity(intent3);
                break;
            case R.id.feedback:
                Intent intent2=new Intent(getApplicationContext(),feedback.class);
                startActivity(intent2);
                break;

            case R.id.about:
                Intent intent4=new Intent(getApplicationContext(),about.class);
                startActivity(intent4);
                break;

            case R.id.logout:
                FirebaseAuth.getInstance().signOut();
                Intent intent5 = new Intent(getApplicationContext(),loginActivity.class);
                startActivity(intent5);
                break;

        }
    }
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        displaySelectedListener(item.getItemId());
        return true;
    }
}
