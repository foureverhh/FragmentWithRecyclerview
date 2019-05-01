package com.nackademin.foureverhh.recyclerviewwithtableviewonfragment;

public class Contact {


    private String name;
    private String phoneNumber;
    private int photo;

    public Contact() {
    }

    public Contact(String name, String phoneNumber,int photo) {
        this.photo = photo;
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public int getPhoto() {
        return photo;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoto(int photo) {
        this.photo = photo;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
