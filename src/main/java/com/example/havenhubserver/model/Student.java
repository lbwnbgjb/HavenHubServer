package com.example.havenhubserver.model;

public class Student {
    private String name;
    private String studentId;
    private String gender;



    public Student(String name, String studentId ,String gender) {
        this.name = name;
        this.studentId = studentId;
        this.gender= gender;

    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }
}

