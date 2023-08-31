package com.example.case_md3.controller.Impl;

import com.example.case_md3.DAO.Impl.PublisherDAO;
import com.example.case_md3.controller.extendInterface.IPublisher;
import com.example.case_md3.model.Publisher;
import com.example.case_md3.service.Impl.PublisherServices;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;



@WebServlet(name = "PublisherServlet", value = "/Publisher")
public class PublisherServlet extends HttpServlet  implements IPublisher {

    private PublisherServices publisherServices;
    private PublisherDAO publisherDAO;

    @Override
    public void init() throws ServletException {
        publisherServices = new PublisherServices();
        publisherDAO = new PublisherDAO();
    }

    @Override
    public void create(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("/publisher/create.jsp");
    }

    @Override
    public void display(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Publisher> publishers = publisherServices.findAll();
        request.setAttribute("publishers", publishers);
        RequestDispatcher rq = request.getRequestDispatcher("/publisher/Publisher.jsp");
        rq.forward(request, response);
    }

    public void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    public void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      int id = Integer.parseInt(request.getParameter("id"));
      request.setAttribute("id",id);
      Publisher publisher = publisherDAO.findOne(id);
      request.setAttribute("publisher",publisher);
        RequestDispatcher rq = request.getRequestDispatcher("/publisher/update.jsp");
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
    @Override
    public void createPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        publisherServices.create(request);
        List<Publisher> publishers = publisherServices.findAll();
        request.setAttribute("publishers", publishers);
        RequestDispatcher rq = request.getRequestDispatcher("/publisher/Publisher.jsp");
        rq.forward(request, response);
    }
    @Override
    public void updatePost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        publisherServices.update(request);
        display(request, response);
    }
}