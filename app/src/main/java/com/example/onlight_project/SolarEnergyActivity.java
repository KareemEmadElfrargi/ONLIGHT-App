package com.example.onlight_project;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class SolarEnergyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_solar_energy);

        @SuppressLint({"MissingInflatedId", "LocalSuppress"})
        ImageView btn_back_monitor = findViewById(R.id.iv_exit_solar_activity);

        btn_back_monitor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(SolarEnergyActivity.this, DashboardActivity.class);
                startActivity(myIntent);
            }
        });
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent myIntent = new Intent(SolarEnergyActivity.this, DashboardActivity.class);
        startActivity(myIntent);    }
}