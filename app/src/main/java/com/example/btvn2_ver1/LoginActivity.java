package com.example.btvn2_ver1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class LoginActivity extends Activity {

    private EditText etStudentId;
    private EditText etPassword;
    private Button btnLogin;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etStudentId = findViewById(R.id.et_student_id);
        etPassword = findViewById(R.id.et_password);
        btnLogin = findViewById(R.id.btn_login);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String studentId = etStudentId.getText().toString();
                String password = etPassword.getText().toString();

                Student student = checkLogin(studentId, password);

                if (student != null) {
                    Intent intent = new Intent(LoginActivity.this, ProfileActivity.class);
                    intent.putExtra("studentId", studentId);
                    startActivity(intent);
                } else {
                    Toast.makeText(LoginActivity.this, "Invalid credentials", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private Student checkLogin(String studentId, String password) {
        for (Student student : StudentData.getStudents()) {
            if (student.getStudentId().equals(studentId) && student.getPassword().equals(password)) {
                return student;
            }
        }
        return null;
    }
}
