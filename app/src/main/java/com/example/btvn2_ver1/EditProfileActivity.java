package com.example.btvn2_ver1;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;

public class EditProfileActivity extends Activity {

    private TextView tvStudentId;
    private EditText etName, etDob, etAvatarUrl;
    private Button btnSave;

    private Student currentStudent;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);

        tvStudentId = findViewById(R.id.tv_student_id);
        etName = findViewById(R.id.et_name);
        etDob = findViewById(R.id.et_dob);
        etAvatarUrl = findViewById(R.id.et_avatar_url);
        btnSave = findViewById(R.id.btn_save);

        String studentId = getIntent().getStringExtra("studentId");
        currentStudent = StudentData.findStudentById(studentId);

        if (currentStudent != null) {
            tvStudentId.setText("Student ID: " + currentStudent.getStudentId());
            etName.setText(currentStudent.getName());
            etDob.setText(currentStudent.getDateOfBirth());
            etAvatarUrl.setText(currentStudent.getAvatarUrl());
        }

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (currentStudent != null) {
                    currentStudent.setName(etName.getText().toString());
                    currentStudent.setDateOfBirth(etDob.getText().toString());
                    currentStudent.setAvatarUrl(etAvatarUrl.getText().toString());
                }
                setResult(RESULT_OK);
                finish();
            }
        });
    }
}
