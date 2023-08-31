package com.example.case_md3.controller.Impl;
import com.example.case_md3.controller.extendInterface.IAccount;
import com.example.case_md3.model.Account;
import com.example.case_md3.service.Impl.AccountService;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
@WebServlet(name = "AccountServlet", value = "/account")

public class AccountServlet extends HttpServlet implements IAccount {
    AccountService accountService;
    @Override
    public void init() throws ServletException {
        accountService = new AccountService();
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
            case "delete":
                delete(req, resp);
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
        List<Account> accountList = accountService.findAll();
        request.setAttribute("accountList",accountList);
        RequestDispatcher rq = request.getRequestDispatcher("account/create.jsp");
        rq.forward(request, response);
    }

    @Override
    public void display(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Account> accountList = accountService.findAll();
        request.setAttribute("accountList",accountList);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("account/list.jsp");
        requestDispatcher.forward(request, response);
    }

    @Override
    public void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Account account = accountService.findOne(id);
        request.setAttribute("account", account);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("account/update.jsp");
        requestDispatcher.forward(request, response);
    }

    @Override
    public void createPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        accountService.create(request);
        response.sendRedirect("/account");
    }

    @Override
    public void updatePost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        accountService.update(request);
        response.sendRedirect("/account");
    }
    public void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        accountService.delete(request);
        response.sendRedirect("/account");
    }
}
