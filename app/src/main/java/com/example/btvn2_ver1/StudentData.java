package com.example.btvn2_ver1;

import java.util.ArrayList;
import java.util.List;

public class StudentData {

    private static final List<Student> students = new ArrayList<>();

    static {
        students.add(new Student("22520001", "123", "Nguyen Van A", "01/01/2003", "https://static.vecteezy.com/system/resources/thumbnails/009/292/244/small/default-avatar-icon-of-social-media-user-vector.jpg"));
        students.add(new Student("22520002", "123", "Tran Thi B", "02/02/2003", "https://static.vecteezy.com/system/resources/thumbnails/009/292/244/small/default-avatar-icon-of-social-media-user-vector.jpg"));
        students.add(new Student("22520003", "123", "Le Van C", "03/03/2003", "https://static.vecteezy.com/system/resources/thumbnails/009/292/244/small/default-avatar-icon-of-social-media-user-vector.jpg"));
        students.add(new Student("22520004", "123", "Pham Thi D", "04/04/2003", "https://static.vecteezy.com/system/resources/thumbnails/009/292/244/small/default-avatar-icon-of-social-media-user-vector.jpg"));
    }

    public static List<Student> getStudents() {
        return students;
    }

    public static Student findStudentById(String studentId) {
        for (Student student : students) {
            if (student.getStudentId().equals(studentId)) {
                return student;
            }
        }
        return null;
    }
}
