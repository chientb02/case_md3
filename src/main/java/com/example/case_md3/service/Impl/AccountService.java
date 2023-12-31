package com.example.case_md3.service.Impl;
import com.example.case_md3.DAO.Impl.AccountDAO;
import com.example.case_md3.DAO.Impl.RoleDAO;
import com.example.case_md3.model.Account;
import com.example.case_md3.model.Roles;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.*;

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
    public Account findOneByAccount(String name) {
        return accountDAO.finOneByAccount(name);
    }

    public boolean update(HttpServletRequest request) throws ServletException, IOException {
        boolean check = false;
        String email = request.getParameter("email");
        String oldPass = request.getParameter("oldPass");
        String newPass = request.getParameter("newPass");
        String confirmPass = request.getParameter("confirmPass");
           Account account = findOneByAccount(email);
        if (account != null && newPass.equals(confirmPass) && checkRegex(email,newPass) ){
            if (!checkSameAccount(email) && account.getPassword().equals(oldPass)){
                account.setPassword(newPass);
                accountDAO.update(account);
                check = true;
            }

        }
        return check;
    }
    public boolean checkSameAccount(String email){
        boolean check = true;
        List<Account> accounts = findAll();
        for (Account acc : accounts) {
            if (acc.getEmail().equals(email)){
                check = false;
                break;
            }
        }
        return check;
    }
    public boolean create(HttpServletRequest request) throws ServletException, IOException {
        boolean check = false;
        String email = request.getParameter("email");
        String pass = request.getParameter("pass");
        Roles roles = roleDAO.findOne(2);
        if (checkRegex(email, pass) && checkSameAccount(email)){
            Account account = new Account(email, pass, roles);
            accountDAO.create(account);
            check = true;
        }
        return check;
    }

    public void delete(HttpServletRequest request) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        accountDAO.delete(id);
    }
    public boolean checkRegex(String name, String pass ){
        boolean checkAcc = false;
        try {
            String regexGmail = "^[a-zA-Z0-9._%+-]+@gmail\\.com$";
            String regexPass = "^[a-zA-Z0-9]{6}$";
            Pattern patternGmail = Pattern.compile(regexGmail);
            Pattern patternPass = Pattern.compile(regexPass);
            Matcher matcherGmail = patternGmail.matcher(name);
            Matcher matcherPass = patternPass.matcher(pass);
            if (matcherPass.matches() && matcherGmail.matches()) {
                checkAcc = true;
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        return checkAcc;
    }
    public List<Account> searchByName(String name){
        List<Account> accounts = findAll();
        List<Account> accountList = new ArrayList<>();
        for (Account acc : accounts) {
            if (acc.getEmail().toLowerCase().contains(name.toLowerCase())) {
                accountList.add(acc);
            }
        }
        return accountList;
    }
    public boolean adminUpdate(HttpServletRequest request, int id) throws ServletException, IOException {
        boolean check = false;
        int option = Integer.parseInt(request.getParameter("option"));
        String gmail = request.getParameter("email");
        String pass = request.getParameter("pass");
        if (checkRegex(gmail, pass)) {
            Roles roles = roleDAO.findOne(option);
            Account account = findOne(id);
            account.setEmail(gmail);
            account.setPassword(pass);
            account.setRoles(roles);
            accountDAO.updateAccAdmin(account);
            check = true;
        }
        return check;
    }
}
