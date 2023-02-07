package com.telemedweb.telemedweb;

public class Patient {

    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String password;
    private String mbo;
    private String email;


    public Patient(String firstName, String lastName, String phoneNumber, String password, String mbo, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.password = password;
        this.mbo = mbo;
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMbo() {
        return mbo;
    }

    public void setMbo(String mbo) {
        this.mbo = mbo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}