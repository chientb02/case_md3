package com.example.case_md3.controller.Impl;

import com.example.case_md3.DAO.Impl.BookDAO;
import com.example.case_md3.controller.extendInterface.IBook;
import com.example.case_md3.model.Book;
import com.example.case_md3.model.Category;
import com.example.case_md3.model.Location;
import com.example.case_md3.model.Publisher;
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
    private BookDAO bookDAO;

    public BookServlet() {
        bookService = new BookService();
        categoryService = new CategoryService();
        locationService =new LocationService();
        publisherServices = new PublisherServices();
        bookDAO = new BookDAO();
    }

    @Override
    public void create(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Category> categories = categoryService.findAll();
        List<Publisher> publishers = publisherServices.findAll();
        List<Location> locations = locationService.findAll();
        request.setAttribute("categories",categories);
        request.setAttribute("publishers",publishers);
        request.setAttribute("locations",locations);
        RequestDispatcher rq = request.getRequestDispatcher("/book/create.jsp");
        rq.forward(request,response);
    }

    @Override
    public void display(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Book> books = bookService.findAll();
        HttpSession session = request.getSession();
        session.setAttribute("books", books);
        RequestDispatcher rq = request.getRequestDispatcher("home.jsp");
        rq.forward(request, response);
    }


    public void details(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Book book = bookService.findOne(request);
        HttpSession session = request.getSession();
        session.setAttribute("book", book);
        RequestDispatcher rq = request.getRequestDispatcher("/showBook/BookDetail.jsp");
        rq.forward(request, response);
    }

    public void delete (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        request.setAttribute("id", id);
        bookService.delete(id);
        List<Book> books = bookService.findAll();
        HttpSession session = request.getSession();
        session.setAttribute("books", books);
        RequestDispatcher rq = request.getRequestDispatcher("/book/book.jsp");
        rq.forward(request, response);
    }

    @Override
    public void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Book book = bookDAO.findOne(id);
        request.setAttribute("id",id);
        List<Publisher> publishers = publisherServices.findAll();
        List<Location> locations = locationService.findAll();
        List<Category> categories = categoryService.findAll();
        String name = book.getName();
        String image = book.getImage();
        String description = book.getDescription();
        String status = book.getStatus();
        request.setAttribute("name",name);
        request.setAttribute("image",image);
        request.setAttribute("description",description);
        request.setAttribute("status",status);
        request.setAttribute("publishers",publishers);
        request.setAttribute("locations",locations);
        request.setAttribute("categories",categories);
        RequestDispatcher rq = request.getRequestDispatcher("/book/update.jsp");
        rq.forward(request,response);
    }

    @Override
    public void createPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        bookService.create(request);

        List<Book> books = bookService.findAll();
        HttpSession session = request.getSession();
        session.setAttribute("books", books);
        RequestDispatcher rq = request.getRequestDispatcher("/book/book.jsp");
        rq.forward(request, response);
    }



    @Override
    public void updatePost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        bookService.update(request);
        List<Book> books = bookService.findAll();
        HttpSession session = request.getSession();
        session.setAttribute("books", books);
        RequestDispatcher rq = request.getRequestDispatcher("/book/book.jsp");
        rq.forward(request, response);
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
            case "details" :
                details(request,response);
                break;
            case "adminHome":
                disPlayAdmin(request,response);
                break;
        }
    }
    public void disPlayAdmin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Book> books = bookService.findAll();
        HttpSession session = request.getSession();
        session.setAttribute("books", books);
        RequestDispatcher rq = request.getRequestDispatcher("book/book.jsp");
        rq.forward(request, response);
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
