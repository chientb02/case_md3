package com.example.case_md3.service.Impl;

import com.example.case_md3.model.Borrowing_Book;
import com.example.case_md3.service.extendInterface.IBorrowingService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;

public class BorrowingService implements IBorrowingService {

    @Override
    public List<Borrowing_Book> findAll() {
        return null;
    }

    @Override
    public Borrowing_Book findOne(HttpServletRequest request) throws ServletException, IOException {
        return null;
    }

    @Override
    public void update(HttpServletRequest request) throws ServletException, IOException {

    }

    @Override
    public void create(HttpServletRequest request) throws ServletException, IOException {

    }
}
