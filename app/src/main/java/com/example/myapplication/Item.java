package com.example.myapplication;


public class Item {
    private String name;
    private int photo;
    private String company;

    private String pay;

    private String booking;

    private String location;

    public Item() {
    }
    public Item(String name, int photo, String company, String pay, String booking,String location) {
        this.name = name;
        this.photo = photo;
        this.company = company;
        this.pay = pay;
        this.booking = booking;
        this.location = location;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPhoto() {
        return photo;
    }

    public void setPhoto(int photo) {
        this.photo = photo;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getPay() {
        return pay;
    }

    public void setPay(String pay) {
        this.pay = pay;
    }

    public String getBooking() {
        return booking;
    }

    public void setBooking(String booking) {
        this.booking = booking;
    }



}
