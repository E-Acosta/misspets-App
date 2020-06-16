package com.everacosta.misspets.models;

import android.text.Editable;

public class LoginRequestData {
   public  String email;
    public  String password;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return "LoginRequestData{" +
                "email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LoginRequestData(String email, String password) {
        this.email = email;
        this.password = password;
    }
}
