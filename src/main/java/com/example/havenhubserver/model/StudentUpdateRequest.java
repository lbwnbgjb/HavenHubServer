package com.example.havenhubserver.model;

public class StudentUpdateRequest {
    private String studentId;
    private String oldPassword;
    private String newPassword;
    private String newName;

    public StudentUpdateRequest() {
    }

    //    public StudentUpdateRequest(String studentId, String oldPassword, String newPassword, String newName) {
//        this.studentId = studentId;
//        this.oldPassword = oldPassword;
//        this.newPassword = newPassword;
//        //this.newName=newName;
//    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getOldPassword() {
        return oldPassword;
    }

    public void setOldPassword(String oldPassword) {
        this.oldPassword = oldPassword;
    }

    public String getNewName() {
        return newName;
    }

    public void setNewName(String newName) {
        this.newName = newName;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }
}