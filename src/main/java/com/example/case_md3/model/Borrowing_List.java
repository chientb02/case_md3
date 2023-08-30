package com.example.case_md3.model;

public class Borrowing_List {
    private int id;
    private Borrowing_Book borrowing_book;
    private User user;

    public Borrowing_List(int id, Borrowing_Book borrowing_book, User user) {
        this.id = id;
        this.borrowing_book = borrowing_book;
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Borrowing_Book getBorrowing_book() {
        return borrowing_book;
    }

    public void setBorrowing_book(Borrowing_Book borrowing_book) {
        this.borrowing_book = borrowing_book;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
