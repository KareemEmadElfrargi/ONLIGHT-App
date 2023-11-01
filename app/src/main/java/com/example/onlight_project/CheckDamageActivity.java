package com.example.onlight_project;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;

import com.airbnb.lottie.LottieAnimationView;
import com.airbnb.lottie.LottieDrawable;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Arrays;

public class CheckDamageActivity extends AppCompatActivity {
     TextView text_description_feature_2;
    private Button onANDOf_feature_btn_2;
    private LottieAnimationView animationView_check_damage,animationView_check_No_damage,animationView_check_damage_discinnect;
    private DatabaseReference myRef;
    private FirebaseDatabase database;
    @SuppressLint({"MissingInflatedId", "WrongViewCast"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_damage);

        animationView_check_damage = findViewById(R.id.animation_damage_exist);
        animationView_check_No_damage = findViewById(R.id.animation_damage_Not_exist);

        LottieAnimationView animation_disconnect = findViewById(R.id.animation_damage_disconnect);
        animation_disconnect.setRepeatCount(15000);
        animation_disconnect.setRepeatMode(LottieDrawable.RESTART);
        animation_disconnect.playAnimation();

        ImageView btn_back_damageChange = findViewById(R.id.iv_exit_check_damageChange_activity);
        btn_back_damageChange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(CheckDamageActivity.this, DashboardActivity.class);
                startActivity(myIntent);
            }
        });


        database  = FirebaseDatabase.getInstance();
        myRef = database.getReference();
        TextView textView = findViewById(R.id.checkDamage_txt_test);

        myRef.addValueEventListener(new ValueEventListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                try {
                    long area1  = (long) snapshot.child("Led1").getValue();
                    long area2  = (long) snapshot.child("Led2").getValue();
                    long area3  = (long) snapshot.child("Led3").getValue();
                    long area4  = (long) snapshot.child("Led4").getValue();

                    double power  =(double) snapshot.child("CurrentMeasure").getValue();
                    TextView check_text_status = findViewById(R.id.check_damage);
                    boolean flag = false;

                    if (area1==1&&area2==1&&area3==1&&area4==1){
                        flag=true;
                        textView.setText("Every lamps well ,Current is "+power);
                    }else {
                        flag =false;
                    }

                    if (power > 70.0 && flag){
                        textView.setText("Damage here");
                        textView.setVisibility(View.VISIBLE);
                        animationView_check_damage.setVisibility(View.VISIBLE);
                        animationView_check_No_damage.setVisibility(View.GONE);
                        animation_disconnect.setVisibility(View.GONE);
                    }
                    else{
                        textView.setText("Every lamps well ,Current is "+power);
                        animationView_check_No_damage.setVisibility(View.VISIBLE);
                        animation_disconnect.setVisibility(View.GONE);
                        animationView_check_damage.setVisibility(View.GONE);
                    }
                }catch (Exception exception){
                    System.out.println((exception.getStackTrace()));
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
        Intent myIntent = new Intent(CheckDamageActivity.this, DashboardActivity.class);
        startActivity(myIntent);    }
}