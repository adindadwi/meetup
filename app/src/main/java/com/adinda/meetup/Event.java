package com.adinda.meetup;

public class Event {
    private String name;
    private String date ;
    private String place ;
    private int photo;


    public Event(String name, String date,String place, int photo ) {
        this.name = name;
        this.date = date;
        this.photo = photo;
        this.place=place;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public int getPhoto() {
        return photo;
    }

    public void setPhoto(int photo) {
        this.photo = photo;
    }
}
