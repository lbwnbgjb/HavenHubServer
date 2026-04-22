package com.example.havenhubserver.model;

public class StudentUpdateResponse {
    private boolean isSuccess;
    private String message;

    public StudentUpdateResponse() {
    }

    public boolean getSuccess() {
        return isSuccess;
    }

    public void setSuccess(boolean isSuccess) {
        this.isSuccess = isSuccess;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }


}
