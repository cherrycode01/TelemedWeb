package com.telemedweb.telemedweb;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Record {
    @Id
    @GeneratedValue
    private Long id;
    private Date date;
    private int systolic;
    private int diastolic;
    private int heartBeats;
    private String description;

    @ManyToOne
    @JoinColumn(name = "user_id")

    private User user;
    public Record () {
    }
    public Record (Date date, int systolic, int diastolic, int heartBeats, String description) {
        this.date = date;
        this.systolic = systolic;
        this.diastolic = diastolic;
        this.heartBeats = heartBeats;
        this.description = description;
    }
    public Date getDate () {
        return date;
    }

    public void setDate (Date date) {
        this.date = date;
    }

    public int getSystolic () {
        return systolic;
    }

    public void setSystolic (int systolic) {
        this.systolic = systolic;
    }

    public int getDiastolic () {
        return diastolic;
    }

    public void setDiastolic (int diastolic) {
        this.diastolic = diastolic;
    }

    public int getHeartBeats () {
        return heartBeats;
    }

    public void setHeartBeats (int heartBeats) {
        this.heartBeats = heartBeats;
    }

    public String getDescription () {
        return description;
    }

    public void setDescription (String description) {
        this.description = description;
    }

    public User getUser () {
        return user;
    }

    public void setUser (User user) {
        this.user = user;
    }

    public Long getId () {
        return id;
    }
}