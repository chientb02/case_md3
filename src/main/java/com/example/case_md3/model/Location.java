package com.example.case_md3.model;

public class Location {
    private int id;
    private String name;
    private String details ;

    public Location(String name, String details) {
        this.name = name;
        this.details = details;
    }

    public Location(int id, String name, String details) {
        this.id = id;
        this.name = name;
        this.details = details;
    }

    public Location() {
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
