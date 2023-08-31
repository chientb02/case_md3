package com.example.case_md3.service.Impl;

import com.example.case_md3.controller.Impl.PublisherServlet;
import com.example.case_md3.model.Book;
import com.example.case_md3.service.IGenerateService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;

public class BookService implements IGenerateService <Book> {
    @Override
    public List<Book> findAll() {
        return null;
    }

    @Override
    public Book findOne(HttpServletRequest request) throws ServletException, IOException {
        return null;
    }

    @Override
    public void update(HttpServletRequest request) throws ServletException, IOException {

    }

    @Override
    public void create(HttpServletRequest request) throws ServletException, IOException {

    }
}
