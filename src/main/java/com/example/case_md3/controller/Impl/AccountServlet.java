package com.example.case_md3.controller.Impl;
import com.example.case_md3.model.Account;
import com.example.case_md3.service.Impl.AccountService;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;
@WebServlet(name = "AccountServlet", value = "/account")

public class AccountServlet extends HttpServlet{
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
            case "listAd":
                displayAcc(req, resp);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        switch (action) {
            case "create":
                createPost(req, resp);
                break;
            case "update":
                updatePost(req, resp);
                break;
            case "login":
                loginAcc(req, resp);
                break;
            case "search":
                searchByName(req, resp);
                break;
        }
    }

    public void create(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("/account/create.jsp");
    }

    public void display(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("/account/list.jsp");
    }

    public void displayAcc(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Account> acc = accountService.findAll();
        request.setAttribute("acc", acc);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/account/admin.jsp");
        requestDispatcher.forward(request, response);
    }

    public void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("/account/update.jsp");

    }

    public void createPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (accountService.create(request)){
            HttpSession session = request.getSession();
            session.setAttribute("messagers", "Thêm thành công");
            response.sendRedirect("/account/create.jsp");
        } else {
            HttpSession session = request.getSession();
            session.setAttribute("messagers", "nhập trùng hoặc sai thông tin gồi é");
            response.sendRedirect("/account/create.jsp");
        }
    }

    public void updatePost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (accountService.update(request)){
            HttpSession session = request.getSession();
            session.setAttribute("messages", "Sửa thành công");
            response.sendRedirect("/account/update.jsp");
        } else {
            HttpSession session = request.getSession();
            session.setAttribute("messages", "nhập trùng hoặc sai thông tin gồi é");
            response.sendRedirect("/account/update.jsp");
        }

    }
    public void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        accountService.delete(request);
        response.sendRedirect("/account");
    }
    public Account returnAcc(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        String name = request.getParameter("email");
        String pass = request.getParameter("pass");
        return new Account(name, pass);
    }

    public void loginAcc(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       Account returnAccount = returnAcc(request, response);
        if (accountService.checkRegex(returnAccount.getEmail(), returnAccount.getPassword())){
            Account account = accountService.findOneByAccount(returnAccount.getEmail());
            if(account != null){
                if (account.getRoles().getId() == 1){
                    //đây là acc admin nha, chuyển qua trang chủ admin nhé
                    response.sendRedirect(""); //=> đây là link nhé mng, link của admin
                } else if (account.getRoles().getId() == 2){
                    //đây là acc user nha, chuyển qua trang chủ user nhé
                    HttpSession session = request.getSession();
                    session.setAttribute("id", account.getId());
                    response.sendRedirect(""); //=> đây là link nhé mng, link của user
                }
            } else {
                HttpSession session = request.getSession();
                session.setAttribute("messager", "thông tin không đúng gồi é");
                response.sendRedirect("account/list.jsp");
            }
            }
    }
    public void searchByName(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        String name = request.getParameter("search");
        List<Account> accounts = accountService.searchByName(name);
        request.setAttribute("accounts", accounts);
        RequestDispatcher rq = request.getRequestDispatcher("account/admin.jsp");
        rq.forward(request, response);
    }
}
