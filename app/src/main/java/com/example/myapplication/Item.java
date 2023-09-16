package com.example.myapplication;


public class Item {
    private String name;
    private int photo;
    private String company;

    private String pay;

    private String booking;

    public Item() {
        //Might Need Empty constructor, might not!
    }
    public Item(String name, int photo, String company, String pay, String booking) {
        this.name = name;
        this.photo = photo;
        this.company = company;
        this.pay = pay;
        this.booking = booking;
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
