package com.telemedweb.telemedweb;

import jakarta.persistence.*;

@Entity(name = "APP_USER")
public class User {
    @Id
    @GeneratedValue()

    Long id;
    int type = 0; // 0 - employee, 1 - supervisor
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String mbo;
    private String email;
    private String password;

    public User () {

    }

    public User (String email, String password) {
        this.email = email;
        this.password = password;

    }

    public User (String firstName, String lastName, String phoneNumber, String email, String password, String mbo) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.password = password;
        this.mbo = mbo;
        this.email = email;

    }

    public int getType () {
        return type;
    }

    public void setType (int type) {
        this.type = type;
    }

    public String getFirstName () {
        return firstName;
    }

    public void setFirstName (String firstName) {
        this.firstName = firstName;
    }

    public String getLastName () {
        return lastName;
    }

    public void setLastName (String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber () {
        return phoneNumber;
    }

    public void setPhoneNumber (String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getMbo () {
        return mbo;
    }

    public void setMbo (String mbo) {
        this.mbo = mbo;
    }

    public String getEmail () {
        return email;
    }

    public void setEmail (String email) {
        this.email = email;
    }

    public String getPassword () {
        return password;
    }

    public void setPassword (String password) {
        this.password = password;
    }

    public Long getId () {
        return id;
    }
}