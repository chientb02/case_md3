package com.example.case_md3.controller.Impl;
import com.example.case_md3.controller.extendInterface.IRoles;
import com.example.case_md3.model.Account;
import com.example.case_md3.model.Roles;
import com.example.case_md3.service.Impl.AccountService;
import com.example.case_md3.service.Impl.RolesService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "RolesServlet", value = "/roles")

public class RolesServlet extends HttpServlet implements IRoles {
    RolesService rolesService;
    @Override
    public void init() throws ServletException {
        rolesService = new RolesService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "":
                display(req, resp);
                break;
            case "create":
                create(req, resp);
                break;
            case "update":
                update(req, resp);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                createPost(req, resp);
                break;
            case "update":
                updatePost(req, resp);
                break;
        }
    }

    @Override
    public void create(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Roles> rolesList= rolesService.findAll();
        request.setAttribute("rolesList",rolesList);
        RequestDispatcher rq = request.getRequestDispatcher("roles/create.jsp");
        rq.forward(request, response);
    }

    @Override
    public void display(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Roles> rolesList= rolesService.findAll();
        request.setAttribute("rolesList",rolesList);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("roles/list.jsp");
        requestDispatcher.forward(request, response);
    }

    @Override
    public void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Roles roles = rolesService.findOne(id);
        request.setAttribute("roles", roles);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("roles/update.jsp");
        requestDispatcher.forward(request, response);
    }

    @Override
    public void createPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        rolesService.create(request);
        response.sendRedirect("/roles");
    }

    @Override
    public void updatePost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        rolesService.update(request);
        response.sendRedirect("/roles");
    }
}
