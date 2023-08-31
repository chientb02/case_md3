package com.example.case_md3.controller.Impl;

import com.example.case_md3.controller.extendInterface.IBorrowingBookServlet;
import com.example.case_md3.service.Impl.BookService;
import com.example.case_md3.service.Impl.BorrowingService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "BorrowingBookServlet", value = "/borrowingBook")
public class BorrowingBookServlet extends HttpServlet implements IBorrowingBookServlet {
    private BorrowingService borrowingService = new BorrowingService() ;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                create(request, response);
                break;
            case "update":
                update(request, response);
                break;
            default:
                display(request, response);
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
            case "create":
                createPost(request, response);
                break;
            case "update":
                updatePost(request, response);
                break;
        }
    }

    @Override
    public void create(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        borrowingService.create(request);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/borrowing/book.jsp");
        requestDispatcher.forward(request,response);

    }

    @Override
    public void display(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("borrowing",borrowingService.findByUser(request));
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/borrowing/display.jsp");
        requestDispatcher.forward(request,response);
    }

    @Override
    public void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        borrowingService.update(request);
        display(request,response);
    }

    @Override
    public void createPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        borrowingService.create(request);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/borrowing/book.jsp");
        requestDispatcher.forward(request,response);
    }

    @Override
    public void updatePost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}