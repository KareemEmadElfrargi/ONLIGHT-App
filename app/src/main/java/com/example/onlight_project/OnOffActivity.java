package com.example.onlight_project;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;

import com.airbnb.lottie.LottieAnimationView;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class OnOffActivity extends AppCompatActivity {
    private LottieAnimationView animationView_OnOff_one,animationView_OnOff_wait;
    private TextView text_description_feature_4;
    private Switch onANDOf_feature_switch_on;
    private DatabaseReference myRef;
    private FirebaseDatabase database;


    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_on_off);

        ImageView btn_back_on_off = findViewById(R.id.iv_exit_on_off_activity);
        btn_back_on_off.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(OnOffActivity.this, DashboardActivity.class);
                startActivity(myIntent);
            }
        });

        text_description_feature_4 = findViewById(R.id.OnOff_title_tv);
        onANDOf_feature_switch_on = (Switch)findViewById(R.id.OnOff_onAndOF_switch);
        animationView_OnOff_one = findViewById(R.id.animation_on_off_one_i);
        animationView_OnOff_wait = findViewById(R.id.animation_on_off_two_wait);
        database  = FirebaseDatabase.getInstance();
        myRef = database.getReference();

        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                onANDOf_feature_switch_on.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @SuppressLint("SetTextI18n")
                    @Override
                    public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                        if(isChecked){
                            text_description_feature_4.setVisibility(View.GONE);
                            animationView_OnOff_one.setVisibility(View.VISIBLE);
                            animationView_OnOff_wait.setVisibility(View.GONE);
                            onANDOf_feature_switch_on.setText(R.string.on);
                            myRef.child("Home1").setValue(1);
                            myRef.child("Home2").setValue(1);
                        }else{
                            //CHANGE
                            text_description_feature_4.setVisibility(View.VISIBLE);
                            animationView_OnOff_one.setVisibility(View.GONE);
                            animationView_OnOff_wait.setVisibility(View.VISIBLE);
                            onANDOf_feature_switch_on.setText(R.string.off);
                            myRef.child("Home1").setValue(0);
                            myRef.child("Home2").setValue(0);
                        }
                    }
                });
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent myIntent = new Intent(OnOffActivity.this, DashboardActivity.class);
        startActivity(myIntent);
    }
}