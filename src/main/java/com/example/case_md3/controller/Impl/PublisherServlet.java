package com.example.case_md3.controller.Impl;

import com.example.case_md3.controller.extendInterface.IPublisher;
import com.example.case_md3.service.Impl.PublisherServices;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;



@WebServlet(name = "Publisher", value = "/Publisher")
public class Publisher extends HttpServlet  implements IPublisher {

    private PublisherServices publisherServices;

    @Override
    public void init() throws ServletException {
        publisherServices = new PublisherServices();
    }

    @Override
    public void create(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    public void display(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Publisher> publishers = publisherServices.findAll();
        request.setAttribute("publishers", publishers);
        RequestDispatcher rq = request.getRequestDispatcher("Publisher.jsp");
        rq.forward(request, response);
    }

    public void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

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

    }
}