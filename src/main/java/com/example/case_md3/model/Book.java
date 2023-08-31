package com.example.case_md3.model;

public class Book {
    private int id;
    private Publisher publisher;
    private Category category;
    private Location location;
    private String name;
    private String image;
    private String description;
    private String status;

    public Book(int id, Publisher publisher, Category category, Location location, String name, String image, String description, String status) {
        this.id = id;
        this.publisher = publisher;
        this.category = category;
        this.location = location;
        this.name = name;
        this.image = image;
        this.description = description;
        this.status = status;
    }
    public Book(Publisher publisher, Category category, Location location, String name, String image, String description, String status) {
        this.publisher = publisher;
        this.category = category;
        this.location = location;
        this.name = name;
        this.image = image;
        this.description = description;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Publisher getPublisher() {
        return publisher;
    }

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
