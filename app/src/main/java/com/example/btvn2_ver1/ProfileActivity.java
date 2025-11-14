package com.example.btvn2_ver1;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;

import java.io.InputStream;
import java.net.URL;

public class ProfileActivity extends Activity {

    private static final int EDIT_REQUEST_CODE = 1;

    private ImageView ivAvatar;
    private TextView tvStudentId, tvName, tvDob;
    private Button btnEdit, btnLogout;

    private Student currentStudent;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        ivAvatar = findViewById(R.id.iv_avatar);
        tvStudentId = findViewById(R.id.tv_student_id);
        tvName = findViewById(R.id.tv_name);
        tvDob = findViewById(R.id.tv_dob);
        btnEdit = findViewById(R.id.btn_edit);
        btnLogout = findViewById(R.id.btn_logout);

        String studentId = getIntent().getStringExtra("studentId");
        currentStudent = StudentData.findStudentById(studentId);

        if (currentStudent != null) {
            displayStudentInfo();
        }

        btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ProfileActivity.this, EditProfileActivity.class);
                intent.putExtra("studentId", currentStudent.getStudentId());
                startActivityForResult(intent, EDIT_REQUEST_CODE);
            }
        });

        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void displayStudentInfo() {
        tvStudentId.setText(currentStudent.getStudentId());
        tvName.setText(currentStudent.getName());
        tvDob.setText(currentStudent.getDateOfBirth());
        new DownloadImageTask(ivAvatar).execute(currentStudent.getAvatarUrl());
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == EDIT_REQUEST_CODE && resultCode == RESULT_OK) {
            // Refetch student data as it might have been updated
            currentStudent = StudentData.findStudentById(currentStudent.getStudentId());
            if (currentStudent != null) {
                displayStudentInfo();
            }
        }
    }

    private static class DownloadImageTask extends AsyncTask<String, Void, Bitmap> {
        ImageView bmImage;

        public DownloadImageTask(ImageView bmImage) {
            this.bmImage = bmImage;
        }

        protected Bitmap doInBackground(String... urls) {
            String urldisplay = urls[0];
            Bitmap mIcon11 = null;
            try {
                InputStream in = new URL(urldisplay).openStream();
                mIcon11 = BitmapFactory.decodeStream(in);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return mIcon11;
        }

        protected void onPostExecute(Bitmap result) {
            bmImage.setImageBitmap(result);
        }
    }
}
