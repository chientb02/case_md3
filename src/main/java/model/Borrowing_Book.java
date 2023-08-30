package model;

public class Borrowing_Book {
    private int id;
    private Book book;
    private String status;

    public Borrowing_Book(int id, Book book, String status) {
        this.id = id;
        this.book = book;
        this.status = status;
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
