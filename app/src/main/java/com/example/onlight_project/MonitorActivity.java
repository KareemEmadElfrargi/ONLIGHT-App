package com.example.onlight_project;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ScrollView;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MonitorActivity extends AppCompatActivity {
    private DatabaseReference myRef;
    private FirebaseDatabase database;

    ImageView lamp_group_one_1,lamp_group_one_2,lamp_group_one_3,lamp_group_one_4,
    lamp_group_one_5,lamp_group_one_6,lamp_group_one_7,lamp_group_one_8,lamp_group_two_1,
    lamp_group_two_2,lamp_group_two_3,lamp_group_two_4,lamp_group_two_5,lamp_group_two_6,lamp_group_two_7
    ,lamp_group_two_8,lamp_group_three_1,lamp_group_three_2,lamp_group_three_3,lamp_group_three_4,
     lamp_group_three_5,lamp_group_three_6,lamp_group_three_7,lamp_group_three_8,lamp_group_four_1,
     lamp_group_four_2,lamp_group_four_3,lamp_group_four_4,lamp_group_four_5,lamp_group_four_6,
     lamp_group_four_7,lamp_group_four_8;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_monitor);

        ImageView btn_back_monitor = findViewById(R.id.iv_exit_monitor_activity);

        btn_back_monitor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(MonitorActivity.this, DashboardActivity.class);
                startActivity(myIntent);
            }
        });

        ScrollView myScrollView = findViewById(R.id.mainScroll);
        myScrollView.setVerticalScrollBarEnabled(false);
        myScrollView.setHorizontalScrollBarEnabled(false);


        database  = FirebaseDatabase.getInstance();
        myRef = database.getReference();

        // TODO : 4 Group with 4 sensor
//        FirebaseApp.getInstance().getOptions().getProjectId();
        // Group one about 4*2 lamps ( 8 ) in one sensor .
        lamp_group_one_1 = findViewById(R.id.group_one_lamp_one);
        lamp_group_one_2 = findViewById(R.id.group_one_lamp_two);
        lamp_group_one_3 = findViewById(R.id.group_one_lamp_three);
        lamp_group_one_4 = findViewById(R.id.group_one_lamp_four);
        lamp_group_one_5 = findViewById(R.id.group_one_lamp_five);
        lamp_group_one_6 = findViewById(R.id.group_one_lamp_six);
        lamp_group_one_7 = findViewById(R.id.group_one_lamp_seven);
        lamp_group_one_8 = findViewById(R.id.group_one_lamp_eight);

        // Group two about 4*2 lamps ( 8 ) in one sensor .
        lamp_group_two_1 = findViewById(R.id.group_two_lamp_one);
        lamp_group_two_2 = findViewById(R.id.group_two_lamp_two);
        lamp_group_two_3 = findViewById(R.id.group_two_lamp_three);
        lamp_group_two_4 = findViewById(R.id.group_two_lamp_four);
        lamp_group_two_5 = findViewById(R.id.group_two_lamp_five);
        lamp_group_two_6 = findViewById(R.id.group_two_lamp_six);
        lamp_group_two_7 = findViewById(R.id.group_two_lamp_seven);
        lamp_group_two_8 = findViewById(R.id.group_two_lamp_eight);

        // Group three about 4*2 lamps ( 8 ) in one sensor .
        lamp_group_three_1 = findViewById(R.id.group_three_lamp_one);
        lamp_group_three_2 = findViewById(R.id.group_three_lamp_two);
        lamp_group_three_3 = findViewById(R.id.group_three_lamp_three);
        lamp_group_three_4 = findViewById(R.id.group_three_lamp_four);
        lamp_group_three_5 = findViewById(R.id.group_three_lamp_five);
        lamp_group_three_6 = findViewById(R.id.group_three_lamp_six);
        lamp_group_three_7 = findViewById(R.id.group_three_lamp_seven);
        lamp_group_three_8 = findViewById(R.id.group_three_lamp_eight);

        // Group four about 4*2 lamps ( 8 ) in one sensor .
        lamp_group_four_1 = findViewById(R.id.group_four_lamp_one);
        lamp_group_four_2 = findViewById(R.id.group_four_lamp_two);
        lamp_group_four_3 = findViewById(R.id.group_four_lamp_three);
        lamp_group_four_4 = findViewById(R.id.group_four_lamp_four);
        lamp_group_four_5 = findViewById(R.id.group_four_lamp_five);
        lamp_group_four_6 = findViewById(R.id.group_four_lamp_six);
        lamp_group_four_7 = findViewById(R.id.group_four_lamp_seven);
        lamp_group_four_8 = findViewById(R.id.group_four_lamp_eight);


        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                try {
                    long area1  = (long) snapshot.child("Led1").getValue();
                    long area2  = (long) snapshot.child("Led2").getValue();
                    long area3  = (long) snapshot.child("Led3").getValue();
                    long area4  = (long) snapshot.child("Led4").getValue();
                if (area1==1){
                    lamp_group_one_1.setImageDrawable(getResources().getDrawable(R.drawable.on_light_right));
                    lamp_group_one_3.setImageDrawable(getResources().getDrawable(R.drawable.on_light_right));
                    lamp_group_one_5.setImageDrawable(getResources().getDrawable(R.drawable.on_light_right));
                    lamp_group_one_7.setImageDrawable(getResources().getDrawable(R.drawable.on_light_right));
                    lamp_group_one_2.setImageDrawable(getResources().getDrawable(R.drawable.on_light_right));
                    lamp_group_one_2.setRotationY(180);
                    lamp_group_one_4.setImageDrawable(getResources().getDrawable(R.drawable.on_light_right));
                    lamp_group_one_4.setRotationY(180);
                    lamp_group_one_6.setImageDrawable(getResources().getDrawable(R.drawable.on_light_right));
                    lamp_group_one_6.setRotationY(180);
                    lamp_group_one_8.setImageDrawable(getResources().getDrawable(R.drawable.on_light_right));
                    lamp_group_one_8.setRotationY(180);
                }else {
                    lamp_group_one_1.setImageDrawable(getResources().getDrawable(R.drawable.off_light_right));
                    lamp_group_one_3.setImageDrawable(getResources().getDrawable(R.drawable.off_light_right));
                    lamp_group_one_5.setImageDrawable(getResources().getDrawable(R.drawable.off_light_right));
                    lamp_group_one_7.setImageDrawable(getResources().getDrawable(R.drawable.off_light_right));
                    lamp_group_one_2.setImageDrawable(getResources().getDrawable(R.drawable.off_light_right));
                    lamp_group_one_2.setRotationY(180);
                    lamp_group_one_4.setImageDrawable(getResources().getDrawable(R.drawable.off_light_right));
                    lamp_group_one_4.setRotationY(180);
                    lamp_group_one_6.setImageDrawable(getResources().getDrawable(R.drawable.off_light_right));
                    lamp_group_one_6.setRotationY(180);
                    lamp_group_one_8.setImageDrawable(getResources().getDrawable(R.drawable.off_light_right));
                    lamp_group_one_8.setRotationY(180);
                }
                if (area2==1){
                    lamp_group_two_1.setImageDrawable(getResources().getDrawable(R.drawable.on_light_right));
                    lamp_group_two_3.setImageDrawable(getResources().getDrawable(R.drawable.on_light_right));
                    lamp_group_two_5.setImageDrawable(getResources().getDrawable(R.drawable.on_light_right));
                    lamp_group_two_7.setImageDrawable(getResources().getDrawable(R.drawable.on_light_right));
                    lamp_group_two_2.setImageDrawable(getResources().getDrawable(R.drawable.on_light_right));
                    lamp_group_two_2.setRotationY(180);
                    lamp_group_two_4.setImageDrawable(getResources().getDrawable(R.drawable.on_light_right));
                    lamp_group_two_4.setRotationY(180);
                    lamp_group_two_6.setImageDrawable(getResources().getDrawable(R.drawable.on_light_right));
                    lamp_group_two_6.setRotationY(180);
                    lamp_group_two_8.setImageDrawable(getResources().getDrawable(R.drawable.on_light_right));
                    lamp_group_two_8.setRotationY(180);
                }else {
                    lamp_group_two_1.setImageDrawable(getResources().getDrawable(R.drawable.off_light_right));
                    lamp_group_two_3.setImageDrawable(getResources().getDrawable(R.drawable.off_light_right));
                    lamp_group_two_5.setImageDrawable(getResources().getDrawable(R.drawable.off_light_right));
                    lamp_group_two_7.setImageDrawable(getResources().getDrawable(R.drawable.off_light_right));
                    lamp_group_two_2.setImageDrawable(getResources().getDrawable(R.drawable.off_light_right));
                    lamp_group_two_2.setRotationY(180);
                    lamp_group_two_4.setImageDrawable(getResources().getDrawable(R.drawable.off_light_right));
                    lamp_group_two_4.setRotationY(180);
                    lamp_group_two_6.setImageDrawable(getResources().getDrawable(R.drawable.off_light_right));
                    lamp_group_two_6.setRotationY(180);
                    lamp_group_two_8.setImageDrawable(getResources().getDrawable(R.drawable.off_light_right));
                    lamp_group_two_8.setRotationY(180);
                }
                if (area3==1){
                    lamp_group_three_1.setImageDrawable(getResources().getDrawable(R.drawable.on_light_right));
                    lamp_group_three_3.setImageDrawable(getResources().getDrawable(R.drawable.on_light_right));
                    lamp_group_three_5.setImageDrawable(getResources().getDrawable(R.drawable.on_light_right));
                    lamp_group_three_7.setImageDrawable(getResources().getDrawable(R.drawable.on_light_right));
                    lamp_group_three_2.setImageDrawable(getResources().getDrawable(R.drawable.on_light_right));
                    lamp_group_three_2.setRotationY(180);
                    lamp_group_three_4.setImageDrawable(getResources().getDrawable(R.drawable.on_light_right));
                    lamp_group_three_4.setRotationY(180);
                    lamp_group_three_6.setImageDrawable(getResources().getDrawable(R.drawable.on_light_right));
                    lamp_group_three_6.setRotationY(180);
                    lamp_group_three_8.setImageDrawable(getResources().getDrawable(R.drawable.on_light_right));
                    lamp_group_three_8.setRotationY(180);
                }else {
                    lamp_group_three_1.setImageDrawable(getResources().getDrawable(R.drawable.off_light_right));
                    lamp_group_three_3.setImageDrawable(getResources().getDrawable(R.drawable.off_light_right));
                    lamp_group_three_5.setImageDrawable(getResources().getDrawable(R.drawable.off_light_right));
                    lamp_group_three_7.setImageDrawable(getResources().getDrawable(R.drawable.off_light_right));
                    lamp_group_three_2.setImageDrawable(getResources().getDrawable(R.drawable.off_light_right));
                    lamp_group_three_2.setRotationY(180);
                    lamp_group_three_4.setImageDrawable(getResources().getDrawable(R.drawable.off_light_right));
                    lamp_group_three_4.setRotationY(180);
                    lamp_group_three_6.setImageDrawable(getResources().getDrawable(R.drawable.off_light_right));
                    lamp_group_three_6.setRotationY(180);
                    lamp_group_three_8.setImageDrawable(getResources().getDrawable(R.drawable.off_light_right));
                    lamp_group_three_8.setRotationY(180);
                }
                if (area4==1){
                    lamp_group_four_1.setImageDrawable(getResources().getDrawable(R.drawable.on_light_right));
                    lamp_group_four_3.setImageDrawable(getResources().getDrawable(R.drawable.on_light_right));
                    lamp_group_four_5.setImageDrawable(getResources().getDrawable(R.drawable.on_light_right));
                    lamp_group_four_7.setImageDrawable(getResources().getDrawable(R.drawable.on_light_right));
                    lamp_group_four_2.setImageDrawable(getResources().getDrawable(R.drawable.on_light_right));
                    lamp_group_four_2.setRotationY(180);
                    lamp_group_four_4.setImageDrawable(getResources().getDrawable(R.drawable.on_light_right));
                    lamp_group_four_4.setRotationY(180);
                    lamp_group_four_6.setImageDrawable(getResources().getDrawable(R.drawable.on_light_right));
                    lamp_group_four_6.setRotationY(180);
                    lamp_group_four_8.setImageDrawable(getResources().getDrawable(R.drawable.on_light_right));
                    lamp_group_four_8.setRotationY(180);
                }else {
                    lamp_group_four_1.setImageDrawable(getResources().getDrawable(R.drawable.off_light_right));
                    lamp_group_four_3.setImageDrawable(getResources().getDrawable(R.drawable.off_light_right));
                    lamp_group_four_5.setImageDrawable(getResources().getDrawable(R.drawable.off_light_right));
                    lamp_group_four_7.setImageDrawable(getResources().getDrawable(R.drawable.off_light_right));
                    lamp_group_four_2.setImageDrawable(getResources().getDrawable(R.drawable.off_light_right));
                    lamp_group_four_2.setRotationY(180);
                    lamp_group_four_4.setImageDrawable(getResources().getDrawable(R.drawable.off_light_right));
                    lamp_group_four_4.setRotationY(180);
                    lamp_group_four_6.setImageDrawable(getResources().getDrawable(R.drawable.off_light_right));
                    lamp_group_four_6.setRotationY(180);
                    lamp_group_four_8.setImageDrawable(getResources().getDrawable(R.drawable.off_light_right));
                    lamp_group_four_8.setRotationY(180);
                }
            }catch (NullPointerException exception){
                    System.out.println(exception.getStackTrace());
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
        Intent myIntent = new Intent(MonitorActivity.this, DashboardActivity.class);
        startActivity(myIntent);    }
}