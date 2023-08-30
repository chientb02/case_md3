package com.example.case_md3.controller.Impl;

import com.example.case_md3.controller.extendInterface.ILocationServlet;
import com.example.case_md3.service.Impl.LocationService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "LocationServlet", value = "/location")
public class LocationServlet extends HttpServlet implements ILocationServlet {
    private LocationService locationService;

    public LocationServlet() {
        locationService = new LocationService();
    }

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
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/location/create.jsp");
        requestDispatcher.forward(request, response);
    }

    @Override
    public void display(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("locations", locationService.findAll());
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/location/display.jsp");
        requestDispatcher.forward(request, response);

    }

    @Override
    public void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
           request.setAttribute("location",locationService.findOne(request));
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("location/update.jsp");
        requestDispatcher.forward(request, response);

    }

    @Override
    public void createPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            locationService.create(request);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("location/create.jsp");
        requestDispatcher.forward(request, response);

    }

    @Override
    public void updatePost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        locationService.update(request);
        request.setAttribute("locations", locationService.findAll());
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/location/display.jsp");
        requestDispatcher.forward(request, response);
    }
}