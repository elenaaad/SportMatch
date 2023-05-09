package com.example.sportmatch;

public class User {
    private String username;
    private String password;
    private String birthDate;
    private String fullName;

    public User(){

    }

    public User(String username, String password, String birthDate, String fullName) {
        this.username = username;
        this.password = password;
        this.birthDate = birthDate;
        this.fullName = fullName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }


}
