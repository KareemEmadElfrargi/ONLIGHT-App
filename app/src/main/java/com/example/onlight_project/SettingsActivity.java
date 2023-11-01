package com.example.onlight_project;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class SettingsActivity extends AppCompatActivity {
    TextView edit_profile_tv;
    TextView mode_profile_tv;
    TextView lan_profile_tv;
    TextView logout_profile_tv;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        toolbar = findViewById(R.id.toolbar);
        edit_profile_tv=findViewById(R.id.setting_editProfile_tv);
        mode_profile_tv=findViewById(R.id.setting_mode_tv);
        lan_profile_tv=findViewById(R.id.setting_language_tv);
        logout_profile_tv=findViewById(R.id.setting_logout_tv);

        setSupportActionBar(toolbar);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }


        edit_profile_tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(SettingsActivity.this,editProfileActivity.class);
                startActivity(intent);
            }
        });
        mode_profile_tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(SettingsActivity.this,modeActivity.class);
                startActivity(intent);
            }
        });
        lan_profile_tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(SettingsActivity.this,languageActivity.class);
                startActivity(intent);
            }
        });



        logout_profile_tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DialogFragment fragment=DialogFragment.newInstance("Delete","Are you sure to delete account ?");
                fragment.show(getSupportFragmentManager(),null);
            }
        });

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent myIntent = new Intent(SettingsActivity.this, DashboardActivity.class);
        startActivity(myIntent);
    }
}