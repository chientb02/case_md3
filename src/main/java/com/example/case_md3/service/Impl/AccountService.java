package com.example.case_md3.service.Impl;
import com.example.case_md3.DAO.Impl.AccountDAO;
import com.example.case_md3.DAO.Impl.RoleDAO;
import com.example.case_md3.model.Account;
import com.example.case_md3.model.Roles;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;
public class AccountService {
    AccountDAO accountDAO;
    RoleDAO roleDAO;

    public AccountService() {
        roleDAO = new RoleDAO();
        accountDAO = new AccountDAO();
    }

    public List<Account> findAll() {
        return accountDAO.findAll();
    }

    public Account findOne(int id) {
        return accountDAO.findOne(id);
    }

    public void update(HttpServletRequest request) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String pass = request.getParameter("pass");
        Account account = findOne(id);
        account.setPassword(pass);
        accountDAO.update(account);
    }

    public void create(HttpServletRequest request) throws ServletException, IOException {
        int idPermission = Integer.parseInt(request.getParameter("idPermission"));
        String email = request.getParameter("email");
        String pass = request.getParameter("pass");
        Roles roles = roleDAO.findOne(idPermission);
        Account account = new Account(email, pass, roles);
        accountDAO.create(account);
    }

    public void delete(HttpServletRequest request) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        accountDAO.delete(id);
    }
}
