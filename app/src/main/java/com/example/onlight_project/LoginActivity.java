package com.example.onlight_project;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import java.util.ArrayList;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        User adminOne = new User("Kareem Emad", "S-12038");
        User adminTwo = new User("Omar Magdy", "C-10038");
    }
}