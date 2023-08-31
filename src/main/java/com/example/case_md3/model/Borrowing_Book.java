package com.example.case_md3.model;

import java.time.LocalDateTime;

public class Borrowing_Book {
    private int id;
    private Book book;
    private String status;
    private Borrowing_List borrowingList ;
    private LocalDateTime dateBorrowing ;

    public Borrowing_Book() {
    }

    public Borrowing_Book(int id, Book book, String status, Borrowing_List borrowingList, LocalDateTime dateBorrowing) {
        this.id = id;
        this.book = book;
        this.status = status;
        this.borrowingList = borrowingList;
        this.dateBorrowing = dateBorrowing;
    }

    public Borrowing_Book(Book book, String status, Borrowing_List borrowingList, LocalDateTime dateBorrowing) {
        this.book = book;
        this.status = status;
        this.borrowingList = borrowingList;
        this.dateBorrowing = dateBorrowing;
    }

    public Borrowing_List getBorrowingList() {
        return borrowingList;
    }

    public void setBorrowingList(Borrowing_List borrowingList) {
        this.borrowingList = borrowingList;
    }

    public LocalDateTime getDateBorrowing() {
        return dateBorrowing;
    }

    public void setDateBorrowing(LocalDateTime dateBorrowing) {
        this.dateBorrowing = dateBorrowing;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
