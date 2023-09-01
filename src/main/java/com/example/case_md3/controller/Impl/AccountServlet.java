package com.example.case_md3.controller.Impl;
import com.example.case_md3.DAO.Impl.RoleDAO;
import com.example.case_md3.model.Account;
import com.example.case_md3.model.Roles;
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
    RoleDAO roleDAO;
    @Override
    public void init() throws ServletException {
        roleDAO = new RoleDAO();
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
// khi đăng nhập dc vào trang chủ acc min thì cho 1 đường
// dẫn link vào case này để thêm xóa xóa acc và quyền
                displayAcc(req, resp);
                break;
            case "adminEdit":
                adminEdit(req, resp);
                break;
            case "role":
                displayRole(req, resp);
                break;
            case "roleUpdate":
                roleGetUpdate(req, resp);
                break;
            case "roleCreate":
                roleCreate(req, resp);
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
            case "adminEdit":
                adminEditPost(req, resp);
                break;
            case "roleUpdate":
                roleUpdatePost(req, resp);
                break;
            case "roleCreate":
                roleCreatePost(req, resp);
                break;

        }
    }
    public void roleCreate(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        resp.sendRedirect("/account/roleCreate.jsp");
    }
    public void roleCreatePost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("role");
        Roles roles = new Roles(name);
        HttpSession session = req.getSession();
            roleDAO.create(roles);
            session.setAttribute("messagers", "Them thành công");
            resp.sendRedirect("/account/roleCreate.jsp");
    }
    public void roleUpdatePost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        int id = Integer.parseInt(req.getParameter("id"));
        String role = req.getParameter("role");
        Roles roles = roleDAO.findOne(id);
        HttpSession session = req.getSession();
            roles.setPermission(role);
            roles.setId(roles.getId());
            roleDAO.update(roles);
            session.setAttribute("message", "Sửa thành công");
            session.setAttribute("roles", roles);
            resp.sendRedirect("/account/roleEdit.jsp");
    }
    public void roleGetUpdate(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        int id = Integer.parseInt(req.getParameter("id"));
        Roles roles = roleDAO.findOne(id);
        HttpSession session = req.getSession();
        session.setAttribute("roles", roles);
        resp.sendRedirect("/account/roleEdit.jsp");
    }
    public void displayRole(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        List<Roles> roles = roleDAO.findAll();
        req.setAttribute("roles", roles);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/account/listRole.jsp");
        requestDispatcher.forward(req, resp);
    }
    public void adminEditPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        int id = Integer.parseInt(request.getParameter("id"));
        Account acc = accountService.findOne(id);
        List<Roles> roles = roleDAO.findAll();
        HttpSession session = request.getSession();
        if (accountService.adminUpdate(request, id)){
            session.setAttribute("acc", acc);
            session.setAttribute("roles", roles);
            session.setAttribute("message", "Sửa thành công");
            response.sendRedirect("/account/adminEdit.jsp");
        } else {
            session.setAttribute("acc", acc);
            session.setAttribute("roles", roles);
            session.setAttribute("message", "nhập trùng hoặc sai thông tin gồi é");
            response.sendRedirect("/account/adminEdit.jsp");
        }
    }
    public void adminEdit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Account acc = accountService.findOne(id);
        List<Roles> roles = roleDAO.findAll();
        request.setAttribute("id", id);
        request.setAttribute("acc", acc);
        request.setAttribute("roles", roles);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/account/adminEdit.jsp");
        requestDispatcher.forward(request, response);
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
        HttpSession session = request.getSession();
        if (accountService.update(request)){
            session.setAttribute("messages", "Sửa thành công");
            response.sendRedirect("/account/update.jsp");
        } else {
            session.setAttribute("messages", "nhập trùng hoặc sai thông tin gồi é");
            response.sendRedirect("/account/update.jsp");
        }

    }
    public void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        accountService.delete(request);
        displayAcc(request,response);
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
                    session.setAttribute("idUser", account.getId());
                    response.sendRedirect("/book"); //=> đây là link nhé mng, link của user
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
        RequestDispatcher rq = request.getRequestDispatcher("account/search.jsp");
        rq.forward(request, response);
    }
}
