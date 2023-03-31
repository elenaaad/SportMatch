package com.example.sportmatch;

public class User {
    public String username;
    public String password;
    public String birthDate;
    public String fullName;

    public User(){

    }

    public User(String username, String password, String birthDate, String fullName) {
        this.username = username;
        this.password = password;
        this.birthDate = birthDate;
        this.fullName = fullName;
    }
}
