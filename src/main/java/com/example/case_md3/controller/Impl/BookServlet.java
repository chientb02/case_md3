package com.example.case_md3.controller.Impl;

import com.example.case_md3.controller.extendInterface.IBook;
import com.example.case_md3.model.Book;
import com.example.case_md3.service.Impl.BookService;
import com.example.case_md3.service.Impl.CategoryService;
import com.example.case_md3.service.Impl.LocationService;
import com.example.case_md3.service.Impl.PublisherServices;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "BookServlet", value = "/book")
public class BookServlet extends HttpServlet implements IBook {

    private BookService bookService;
    private CategoryService categoryService;
    private LocationService locationService;
    private PublisherServices publisherServices;

    public BookServlet() {
        bookService = new BookService();
        categoryService = new CategoryService();
        locationService =new LocationService();
        publisherServices = new PublisherServices();

    }

    @Override
    public void create(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    public void display(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Book> books = bookService.findAll();
        request.setAttribute("books", books);
        RequestDispatcher rq = request.getRequestDispatcher("/book/book.jsp");
        rq.forward(request, response);
    }

    public void delete (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    public void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    public void createPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    public void updatePost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {

            case "":
                display(request, response);
                break;
            case "create":
                create(request, response);
                break;
            case "delete":
                delete(request, response);
                break;
            case "update":
                update(request, response);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {

            case "createPost":
                createPost(request, response);
                break;
            case "updatePost":
                updatePost(request, response);
                break;
        }
    }

}