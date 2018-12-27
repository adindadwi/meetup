package com.adinda.meetup.model;

import java.security.Identity;

public class Group {
    public String gName;
    public String gDescription;
    public String gCategories;
    public String gMembers ;
    public String gEvents ;

    public Group(){

    }

    public Group(String name, String description, String categories, String members,String events) {
        this.gName = name;
        this.gDescription = description;
        this.gCategories = categories;
        this.gMembers = members;
        this.gEvents = events;
    }

    public String getName() {
        return gName;
    }

    public void setName(String name) {
        this.gName = name;
    }

    public String getDescription() {
        return gDescription;
    }

    public void setDescription(String description) {
        this.gDescription = description;
    }

    public String getCategories() {
        return gCategories;
    }

    public void setCategories(String categories) {
        this.gCategories = categories;
    }

    public String getMembers() {

        return gMembers;
    }

    public void setMembers(String members)
    {
        this.gMembers = members;
    }

    public String getEvents() {

        return gEvents;
    }

    public void setEvents(String events) {
        this.gEvents = events;
    }

//    public Identity getId() {
//
//
//    }
}

