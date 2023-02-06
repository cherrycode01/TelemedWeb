package com.telemedweb.telemedweb;

import java.util.Date;

public class Record {
    private int ordinalNumber;
    private Date date;
    private int systolic;
    private int diastolic;
    private int heartBeats;
    private String description;

    public Record(int ordinalNumber) {
        this.ordinalNumber = ordinalNumber;
    }

    public Record (int redniBroj, Date date, int sistolickiTlak, int dijastolickiTlak, int otkucaji, String opis) {
        this.ordinalNumber = redniBroj;
        this.date = date;
        this.systolic = sistolickiTlak;
        this.diastolic = dijastolickiTlak;
        this.heartBeats = otkucaji;
        this.description = opis;
    }

    public int getOrdinalNumber () {
        return ordinalNumber;
    }

    public void setOrdinalNumber (int ordinalNumber) {
        this.ordinalNumber = ordinalNumber;
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
}