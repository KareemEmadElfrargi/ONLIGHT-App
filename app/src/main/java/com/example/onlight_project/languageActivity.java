package com.example.onlight_project;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.appcompat.widget.Toolbar;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import java.util.Locale;
public class languageActivity extends AppCompatActivity {
    RadioGroup language_radioGroup;
    RadioButton radioButton_english;
    RadioButton radioButton_arabic;
    Toolbar toolbar;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_language);
//        toolbar = findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);

//        ActionBar actionBar = getSupportActionBar();
//        if (actionBar != null) {
//            actionBar.setDisplayHomeAsUpEnabled(true);
//        }

        ImageView btn_back_lang = findViewById(R.id.iv_langauge_activity);
        btn_back_lang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(languageActivity.this, DashboardActivity.class);
                startActivity(myIntent);
            }
        });
        radioButton_arabic = findViewById(R.id.radioButton_arabic);
        radioButton_english = findViewById(R.id.radioButton_english);
        language_radioGroup = findViewById(R.id.language_radioGroup);


        language_radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.radioButton_english:
                        setLocale("en");
                        break;
                    case R.id.radioButton_arabic:
                        setLocale("ar");
                        break;
                }
            }
        });
    }
    private void setLocale(String languageCode) {
        Locale locale = new Locale(languageCode);
        Locale.setDefault(locale);
        Configuration config = new Configuration();
        config.locale = locale;
        getResources().updateConfiguration(config, getResources().getDisplayMetrics());
        Intent intent = getIntent();
        finish();
        startActivity(intent);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            Intent intent = new Intent(this, SettingsActivity.class);
            intent.putExtra("selected_language", getCurrentLanguage()); // افترض أن الدالة getCurrentLanguage() تُرجع اللغة المحددة
            startActivity(intent);
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    private String getCurrentLanguage() {
        Configuration config = getResources().getConfiguration();
        return config.locale.getLanguage();
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent myIntent = new Intent(languageActivity.this, DashboardActivity.class);
        startActivity(myIntent);    }
}
