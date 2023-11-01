package com.example.onlight_project;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.airbnb.lottie.LottieAnimationView;
import com.airbnb.lottie.LottieDrawable;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


public class SynchronizationActivity extends AppCompatActivity {
    private TextView text_description_feature;
    private Switch onANDOf_feature_switch;
    private LottieAnimationView animationView_sync_one,animationView_sync_wait;
    private DatabaseReference myRef;
    private FirebaseDatabase database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_synchronization);

        ImageView btn_back_synchronization = findViewById(R.id.iv_exit_synchronization_activity);

        ScrollView myScrollView2 = findViewById(R.id.mainScroll2);
        myScrollView2.setVerticalScrollBarEnabled(false);
        myScrollView2.setHorizontalScrollBarEnabled(false);



        btn_back_synchronization.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(SynchronizationActivity.this, DashboardActivity.class);
                startActivity(myIntent);
            }
        });

        @SuppressLint({"MissingInflatedId", "LocalSuppress"})
        ImageView HomeOne_iv = findViewById(R.id.home_One_IV);
        @SuppressLint({"MissingInflatedId", "LocalSuppress"})
        ImageView HomeTwo_iv = findViewById(R.id.home_Two_IV);
        @SuppressLint({"MissingInflatedId", "LocalSuppress"})
        TextView ownerHouseOne = findViewById(R.id.ownerHouseOne);
        @SuppressLint({"MissingInflatedId", "LocalSuppress"})
        TextView ownerHouseTwo = findViewById(R.id.ownerHouseTwo);

        TextView description_home_one = findViewById(R.id.descriptionHouseOne);
        TextView description_home_two = findViewById(R.id.descriptionHouseTwo);

        RelativeLayout relativeLayout = findViewById(R.id.house_one);
        RelativeLayout relativeLayout2 = findViewById(R.id.house_two);

        LottieAnimationView animation_monitoring = findViewById(R.id.animation_monitor);
        animation_monitoring.setAnimation(R.raw.monitoring_house);
        animation_monitoring.setRepeatCount(1500);
        animation_monitoring.setRepeatMode(LottieDrawable.RESTART);
        animation_monitoring.playAnimation();

        database  = FirebaseDatabase.getInstance();
        myRef = database.getReference();
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                long homeOne  = (long) snapshot.child("Home1").getValue();
                long homeTwo  = (long) snapshot.child("Home2").getValue();
                Typeface typeface = ResourcesCompat.getFont(SynchronizationActivity.this, R.font.janna);
                if (homeOne==1){
                    animation_monitoring.cancelAnimation();
                    HomeOne_iv.setImageDrawable(getResources().getDrawable(R.drawable.home_li));
                    ownerHouseOne.setTextColor(Color.BLACK);
                    ownerHouseOne.setTypeface(typeface);
                    description_home_one.setText(R.string.dark_mode);
                    ownerHouseOne.setTypeface(null, Typeface.BOLD);
                    relativeLayout.setBackgroundResource(R.drawable.round_background_homes);
                }else {
                    HomeOne_iv.setImageDrawable(getResources().getDrawable(R.drawable.home_of));
                    ownerHouseOne.setTextColor(Color.BLACK);
                    description_home_one.setText(R.string.dark_mode);
                    ownerHouseOne.setTypeface(null, Typeface.NORMAL);
                    description_home_one.setTypeface(null,Typeface.ITALIC);
                    relativeLayout.setBackgroundColor(getResources().getColor(R.color.white));
                    animation_monitoring.playAnimation();
                    relativeLayout.setBackgroundResource(R.drawable.round_background_homes_basic);

                }
                if (homeTwo==1) {
                    animation_monitoring.cancelAnimation();
                    HomeTwo_iv.setImageDrawable(getResources().getDrawable(R.drawable.home_li));
                    description_home_two.setText(R.string.light_mode);
                    ownerHouseTwo.setTypeface(null, Typeface.BOLD);
                    ownerHouseTwo.setTextColor(Color.BLACK);
                    relativeLayout2.setBackgroundResource(R.drawable.round_background_homes);
                }else {
                    HomeTwo_iv.setImageDrawable(getResources().getDrawable(R.drawable.home_of));
                    ownerHouseTwo.setTextColor(Color.BLACK);
                    description_home_two.setText(R.string.dark_mode);
                    ownerHouseTwo.setTypeface(null, Typeface.NORMAL);
                    relativeLayout2.setBackgroundResource(R.drawable.round_background_homes_basic);
                    animation_monitoring.playAnimation();
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent myIntent = new Intent(SynchronizationActivity.this, DashboardActivity.class);
        startActivity(myIntent);
    }
}