package com.example.onlight_project;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.content.Intent;
import android.provider.MediaStore;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.IOException;
import java.io.InputStream;
import de.hdodenhof.circleimageview.CircleImageView;

public class editProfileActivity extends AppCompatActivity {
    ImageView profile_img;
    Toolbar toolbar;

    private static final int REQUEST_IMAGE_PICK = 1;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);
        toolbar = findViewById(R.id.toolbar);
        profile_img = findViewById(R.id.imageViewPro);

        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        profile_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openGallery();
            }
        });
    }

    private void openGallery() {
        Intent galleryIntent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(galleryIntent, REQUEST_IMAGE_PICK);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUEST_IMAGE_PICK && resultCode == RESULT_OK) {
            if (data != null) {
                // حصول على URI للصورة المحددة
                android.net.Uri selectedImage = data.getData();

                try {
                    // فتح InputStream للصورة المحددة
                    InputStream inputStream = getContentResolver().openInputStream(selectedImage);

                    // تحويل InputStream إلى Bitmap
                    Bitmap bitmap = BitmapFactory.decodeStream(inputStream);

                    // عرض الصورة في ImageView
                    profile_img.setImageBitmap(bitmap);

                    // إغلاق InputStream بعد الانتهاء
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } else {
            Toast.makeText(this, "Image Cancelled!", Toast.LENGTH_SHORT).show();
        }
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
        Intent myIntent = new Intent(editProfileActivity.this, DashboardActivity.class);
        startActivity(myIntent);    }
}