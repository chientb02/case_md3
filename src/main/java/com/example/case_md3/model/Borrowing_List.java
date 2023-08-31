package com.example.case_md3.model;

public class Borrowing_List {
    private int id;
    private Account user;

    public Borrowing_List(int id, Account user) {
        this.id = id;
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Account getUser() {
        return user;
    }

    public void setUser(Account user) {
        this.user = user;
    }
}
