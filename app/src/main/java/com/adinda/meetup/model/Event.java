package com.adinda.meetup.model;

public class Event {
    public String name;
    public String description;
    public String categories;
    public String date ;
    public String place ;
    public int photo;

    public Event(){

    }

    public Event(String name, String description, String categories, String date,String place, int photo ) {
        this.name = name;
        this.description = description;
        this.categories = categories;
        this.date = date;
        this.photo = photo;
        this.place = place;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategories() {
        return categories;
    }

    public void setCategories(String categories) {
        this.categories = categories;
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
