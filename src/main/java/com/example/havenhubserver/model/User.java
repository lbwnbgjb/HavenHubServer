package com.example.havenhubserver.model;

public class User {
    private String username;
    private String realname;
    private String password;
    private String gender;

    public User() {
    }

    public User(String username, String realname, String password) {
        this.username = username;
        this.realname = realname;
        this.password = password;
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setGender(String gender){
        this.gender=gender;
    }

    public String getGender(){return gender;}

}