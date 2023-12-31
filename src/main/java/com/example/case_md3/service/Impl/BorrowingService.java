package com.example.case_md3.service.Impl;

import com.example.case_md3.DAO.Impl.BookDAO;
import com.example.case_md3.DAO.Impl.BorrowingBookDAO;
import com.example.case_md3.DAO.Impl.BorrowingListDAO;
import com.example.case_md3.model.Account;
import com.example.case_md3.model.Book;
import com.example.case_md3.model.Borrowing_Book;
import com.example.case_md3.model.Borrowing_List;
import com.example.case_md3.service.extendInterface.IBorrowingService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class BorrowingService implements IBorrowingService {
    private AccountService accountService;
    private BookService bookService;
    private BorrowingListService borrowingListService;
    private BorrowingBookDAO borrowingBookDAO;
    private BookDAO bookDAO ;

    public BorrowingService() {
        accountService = new AccountService();
        bookService = new BookService();
        borrowingListService = new BorrowingListService();
        borrowingBookDAO = new BorrowingBookDAO();
        bookDAO = new BookDAO();
    }

    @Override
    public List<Borrowing_Book> findAll() {
        return borrowingBookDAO.findAll();
    }

    @Override
    public Borrowing_Book findOne(HttpServletRequest request) throws ServletException, IOException {
        Borrowing_Book borrowingBook = null;
        return borrowingBook;
    }

    @Override
    public void update(HttpServletRequest request) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Borrowing_Book book = borrowingBookDAO.findOne(id);
        book.setStatus("đã trả");
        Book book1 = book.getBook();
        bookDAO.unborrowing(book1);
        borrowingBookDAO.update(book);
    }

    @Override
    public void create(HttpServletRequest request) throws ServletException, IOException {
        HttpSession session = request.getSession();
        int user = (int) session.getAttribute("idUser");
        borrowingListService.create(request);
        Book book = bookService.findOne(request);
        bookDAO.borrowing(book);
        Borrowing_Book borrowingBook = new Borrowing_Book(book, "Chưa trả", borrowingListService.findByAccount(accountService.findOne(user)), LocalDateTime.now());
        borrowingBookDAO.create(borrowingBook);
    }


    @Override
    public List<Borrowing_Book> findByUser(HttpServletRequest request) throws ServletException, IOException {
        HttpSession session = request.getSession();
        int user = (int) session.getAttribute("idUser");
        return borrowingBookDAO.findByUser((borrowingListService.findByAccount(accountService.findOne(user))));
    }

}
