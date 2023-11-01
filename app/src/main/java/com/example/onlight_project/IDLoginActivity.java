package com.example.onlight_project;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class IDLoginActivity extends AppCompatActivity {
    RelativeLayout activityXML;
    Button goToControlBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_idlogin);
        checkLoginStatus();

        activityXML = findViewById(R.id.loginManagerXML);
        AnimationDrawable animationDrawable = (AnimationDrawable) activityXML.getBackground();
        animationDrawable.setEnterFadeDuration(2500);
        animationDrawable.setExitFadeDuration(5000);
        animationDrawable.start();

        TextInputEditText user_name = findViewById(R.id.loginActivity_et_id_user);
        TextInputEditText identifier_card = findViewById(R.id.loginActivity_et_name_user);



        goToControlBtn = findViewById(R.id.loginManagerActivity_next_btn);
        goToControlBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userName = user_name.getText().toString();
                String identifierCard = identifier_card.getText().toString();
                login(userName,identifierCard);
            }
        });
    }



    private void login(String userName, String identifierCard) {
        if (userName.isEmpty() || identifierCard.isEmpty()) {
            Toast.makeText(getApplicationContext(), "Please enter username and password", Toast.LENGTH_SHORT).show();
        } else if (isValidAdminCredentials(userName, identifierCard)) {
            Toast.makeText(getApplicationContext(), "Welcome Eng. "+userName.trim(), Toast.LENGTH_SHORT).show();
            saveLoginStatus();
            Intent myIntent = new Intent(IDLoginActivity.this, DashboardActivity.class);
            if (userName.equals(null)){
                myIntent.putExtra("IT_name","Employee");
                startActivity(myIntent);
                finish();
            }else{
                myIntent.putExtra("IT_name",userName.trim());
                startActivity(myIntent);
                finish();
            }
        } else {
            Toast.makeText(getApplicationContext(), "Invalid username or password", Toast.LENGTH_SHORT).show();
        }
    }

    private void saveLoginStatus() {
        SharedPreferences sharedPreferences = getSharedPreferences("LoginPrefs",MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean("isLoggedIn",true);
        editor.apply();
    }
    @SuppressLint("ResourceType")
    private void checkLoginStatus() {
        SharedPreferences sharedPreferences = getSharedPreferences("LoginPrefs",MODE_PRIVATE);
        boolean isLoggedIn = sharedPreferences.getBoolean("isLoggedIn",false);
        if (isLoggedIn){
            Intent myIntent = new Intent(IDLoginActivity.this, DashboardActivity.class);
            startActivity(myIntent);
            finish();
        }else {
            setContentView(R.layout.activity_idlogin);
        }

    }
    private boolean isValidAdminCredentials(String userName, String identifierCard) {
        Map<String, String> adminCredentials = new HashMap<>();
        adminCredentials.put("Kareem Emad", "K-1010");
        adminCredentials.put("Omar magdy", "A-1412");
        adminCredentials.put("Farah Gado", "F-1010");
        adminCredentials.put("Muhamed Hamza", "M-1401");
        return adminCredentials.containsKey(userName) && adminCredentials.get(userName).equals(identifierCard);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent myIntent = new Intent(IDLoginActivity.this, DashboardActivity.class);
        startActivity(myIntent);    }
}