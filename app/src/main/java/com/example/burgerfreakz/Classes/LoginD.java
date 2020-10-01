package com.example.burgerfreakz.Classes;

public class LoginD {
    private int id;
    private  String username,password;

    public LoginD() {
    }

    public LoginD(int id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }

    public LoginD(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
}
