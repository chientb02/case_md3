package com.example.case_md3.controller.Impl;

import com.example.case_md3.DAO.Impl.BookDAO;
import com.example.case_md3.controller.IServlet;
import com.example.case_md3.model.Book;
import com.example.case_md3.model.Category;
import com.example.case_md3.service.Impl.BookService;
import com.example.case_md3.service.Impl.CategoryService;
import com.example.case_md3.service.Impl.LocationService;
import com.example.case_md3.service.Impl.PublisherServices;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "showBookServlet", value = "/showBookServlet")
public class showBookServlet extends HttpServlet{
    private BookService bookService;
    private CategoryService categoryService;
    private LocationService locationService;
    private PublisherServices publisherServices;
    private BookDAO bookDAO;

    public showBookServlet() {
        bookService = new BookService();
        categoryService = new CategoryService();
        locationService =new LocationService();
        publisherServices = new PublisherServices();
        bookDAO = new BookDAO();
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {

            case "":
              showBook(request, response);
                break;
            case "goBack":
                goBack(request, response);
                break;
            case "showBookDetail":
                showBookDetail(request,response);
                break;

        }
    }

    public void showBook (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Category> categories = categoryService.findAll();
        request.setAttribute("categories", categories);
        List<Book> books = bookService.findAll();
        request.setAttribute("books", books);
        RequestDispatcher rq = request.getRequestDispatcher("/showBook/showBook.jsp");
        rq.forward(request, response);
    }

    public void goBack (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Category> categories = categoryService.findAll();
        request.setAttribute("categories", categories);
        List<Book> books = bookService.findAll();
        request.setAttribute("books", books);
        RequestDispatcher rq = request.getRequestDispatcher("/showBook/showBook.jsp");
        rq.forward(request, response);
    }
    public void showBookDetail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Book book = bookDAO.findOne(id);
        request.setAttribute("book",book);
        RequestDispatcher rq = request.getRequestDispatcher("/showBook/BookDetail.jsp");
        rq.forward(request,response);
    }

    public void search(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("search");
        List<Book> books = bookDAO.search(name);
<<<<<<< HEAD
        request.setAttribute("bookSearch", books);
        RequestDispatcher rq = request.getRequestDispatcher("/showBook/search.jsp");
        rq.forward(request,response);
=======
        int number = books.size();

            if (number != 0) {
                request.setAttribute("books", books);
                RequestDispatcher rq = request.getRequestDispatcher("/showBook/search.jsp");
                rq.forward(request, response);
            } else{
                response.sendRedirect("/home.jsp");
            }
>>>>>>> khanh
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {

            case "":
                search(request, response);
                break;
            case "search":
                search(request, response);
                break;
        }
    }
}