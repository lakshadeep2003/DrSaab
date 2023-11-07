package com.example.myapplication;

public class HelperClass {
    String username, phone,date;
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public HelperClass(String username, String phone) {

        this.username = username;
        this.phone = phone;
        this.date = date;
    }

    public HelperClass() {
    }
}

