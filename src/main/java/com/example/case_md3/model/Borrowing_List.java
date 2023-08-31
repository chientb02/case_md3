package com.example.case_md3.model;

public class Borrowing_List {
    private int id;
    private Borrowing_Book borrowing_book;
    private Account user;

    public Borrowing_List(int id, Borrowing_Book borrowing_book, Account user) {
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

    public Account getUser() {
        return user;
    }

    public void setUser(Account user) {
        this.user = user;
    }
}
