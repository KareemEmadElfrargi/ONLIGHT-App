package com.example.onlight_project;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.PorterDuff;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.TextAppearanceSpan;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;
import com.google.android.material.textfield.TextInputEditText;

public class DashboardActivity extends AppCompatActivity {
    TextView titleChangeLanguage , dash_solar_energyChangeLanguage , onOFFChangeLanguage , monitoringChangeLanguage
            , check_damageChangeLanguage , synchronizationChangeLanguage , settingSynchronization;
    ImageView monitorDir , settingDir , solarDir , onOFFDir , damageDir , synchronizationDir;
    CardView monitor_card,sync_card;
    // drawer
    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    private ActionBarDrawerToggle drawerToggle;
    private MenuItem item;
    private Toolbar mToolBar;
    private ActionBar mActionBar;
    String storeNameOfEmployee;

    // end drawer
    @SuppressLint({"MissingInflatedId", "WrongViewCast"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        // animation in background
        @SuppressLint({"MissingInflatedId", "LocalSuppress"})
        DrawerLayout drawerLayout = findViewById(R.id.drawable_layout);
        AnimationDrawable animationDrawable = (AnimationDrawable) drawerLayout.getBackground();
        animationDrawable.setEnterFadeDuration(2500);
        animationDrawable.setExitFadeDuration(5000);
        animationDrawable.start();

        // initialization variables . .
//        titleChangeLanguage = findViewById(R.id.dashboard_Activity_title);
        dash_solar_energyChangeLanguage =findViewById(R.id.dash_solar_energy);
        onOFFChangeLanguage = findViewById(R.id.dash_on_off_2);
        monitoringChangeLanguage = findViewById(R.id.dash_monitor_3);
        check_damageChangeLanguage = findViewById(R.id.dash_damage_4);
        synchronizationChangeLanguage = findViewById(R.id.dash_Synchronization_5);
//        settingSynchronization = findViewById(R.id.dash_setting_6);
        monitorDir = findViewById(R.id.dash_monitor_direction);
//        settingDir = findViewById(R.id.setting_icon_animation);
        solarDir = findViewById(R.id.setting_solar_animation);
        onOFFDir = findViewById(R.id.setting_on_animation);
        damageDir = findViewById(R.id.setting_damage_animation);
        synchronizationDir = findViewById(R.id.setting_Synchronization_animation);
        monitor_card = findViewById(R.id.dash_card_monitor);
//        ImageView drawer = findViewById(R.id.iv_nav_dashBoard_activity);
        // drawer
        mToolBar = findViewById(R.id.main_page_toolBar);
        setSupportActionBar(mToolBar);
        getSupportActionBar().setTitle("");
        drawerToggle = new ActionBarDrawerToggle(DashboardActivity.this,drawerLayout,R.string.drawer_open,R.string.drawer_close);

        Drawable drawable = ContextCompat.getDrawable(this, R.drawable.menu_drawer);
        drawable.setColorFilter(ContextCompat.getColor(this, R.color.basic_background_2level), PorterDuff.Mode.SRC_IN);
        // Set the tinted drawable as the drawer indicator
        drawerToggle.setHomeAsUpIndicator(drawable);

        drawerLayout.addDrawerListener(drawerToggle);
        drawerToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        navigationView = findViewById(R.id.navigation_view);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                userMenuSelector(item);
                return false;
            }
        });

        View headerView = navigationView.inflateHeaderView(R.layout.custom_header);
        TextView headerTextView = headerView.findViewById(R.id.header_text);

        String inputText_name = getIntent().getStringExtra("IT_name");
        if (inputText_name!= null){
            storeNameOfEmployee = inputText_name;
        }
        if (inputText_name==null){
            //TODO : handel Welcome back User . .
            headerTextView.setText("Welcome back, "+storeNameOfEmployee); // error
        }else{
            headerTextView.setText("Hello, "+inputText_name);

        }

        synchronizationDir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(DashboardActivity.this, SynchronizationActivity.class);
                startActivity(myIntent);
            }
        });

        monitor_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(DashboardActivity.this, MonitorActivity.class);
                startActivity(myIntent);
            }
        });

        damageDir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(DashboardActivity.this, CheckDamageActivity.class);
                startActivity(myIntent);
            }
        });

//        settingDir.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent myIntent = new Intent(DashboardActivity.this, SettingsActivity.class);
//                startActivity(myIntent);
//            }
//        });

        onOFFDir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(DashboardActivity.this, OnOffActivity.class);
                startActivity(myIntent);
            }
        });

        solarDir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(DashboardActivity.this, SolarEnergyActivity.class);
                startActivity(myIntent);
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (drawerToggle.onOptionsItemSelected(item)){
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void userMenuSelector(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.nav_settings:
                Intent intent = new Intent(DashboardActivity.this, SettingsActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
                finish();
                break;
            case R.id.nav_logOut:
                logout();
                Toast.makeText(this, "error here", Toast.LENGTH_SHORT).show();
                break;
        }
        drawerLayout.closeDrawer(GravityCompat.START);
    }
    private void logout() {
            SharedPreferences sharedPreferences = getSharedPreferences("loginPrefs", Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.clear();
            editor.apply();
            Intent intent = new Intent(DashboardActivity.this, IDLoginActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
            finish();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent myIntent = new Intent(DashboardActivity.this, DashboardActivity.class);
        startActivity(myIntent);
    }

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        getMenuInflater().inflate(R.menu.navigation_menu, menu);
//
//        for (int i = 0; i < menu.size(); i++) {
//            MenuItem menuItem = menu.getItem(i);
//            SpannableString spannable = new SpannableString(menuItem.getTitle());
//            spannable.setSpan(new TextAppearanceSpan(this, R.style.CustomMenuItemStyle), 0, spannable.length(), 0);
//            menuItem.setTitle(spannable);
//        }
//        return true;
//    }
}
