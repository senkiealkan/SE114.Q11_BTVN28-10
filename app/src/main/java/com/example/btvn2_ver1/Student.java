package com.example.btvn2_ver1;

public class Student {
    private String studentId;
    private String password;
    private String name;
    private String dateOfBirth;
    private String avatarUrl;

    public Student(String studentId, String password, String name, String dateOfBirth, String avatarUrl) {
        this.studentId = studentId;
        this.password = password;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.avatarUrl = avatarUrl;
    }

    public String getStudentId() {
        return studentId;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }
}
