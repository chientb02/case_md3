package com.example.case_md3.model;

public class Roles {
    private int id;
    private String permission;

    public Roles(int id, String permission) {
        this.id = id;
        this.permission = permission;
    }

    public Roles(String permission) {
        this.permission = permission;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }
}
