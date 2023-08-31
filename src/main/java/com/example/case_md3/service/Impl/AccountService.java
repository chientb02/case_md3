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
    public Account findOneByAccount(String name, String pass) {
        return accountDAO.finOneByAccount(name, pass);
    }

    public boolean update(HttpServletRequest request) throws ServletException, IOException {
        boolean check = false;
        String email = request.getParameter("email");
        String oldPass = request.getParameter("oldPass");
        String newPass = request.getParameter("newPass");
        String confirmPass = request.getParameter("confirmPass");
        Account account = findOneByAccount(email,oldPass);
        if (account != null && newPass.equals(confirmPass) && checkRegex(email,newPass) && checkSameAccount(email, newPass)){
            account.setPassword(newPass);
            accountDAO.update(account);
            check = true;
        }
        return check;
    }
    public boolean checkSameAccount(String email, String pass){
        boolean check = true;
        List<Account> accounts = findAll();
        for (Account acc : accounts) {
            if (acc.getEmail().equals(email) || acc.getPassword().equals(pass)){
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
        if (checkRegex(email, pass) && checkSameAccount(email, pass)){
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
//    public void checkAccount(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
//        String name = request.getParameter("email");
//        String pass = request.getParameter("pass");
//        if (checkRegex(name, pass)){
//            Account account = accountDAO.finOneByAccount(name, pass);
//            if (account.getRoles().getId() == 1){
//                //đây là acc admin nha, chuyển qua trang chủ accmin nhé
//                response.sendRedirect(""); //=> đây là link nhé mng, link của admin
//            } else if (checkRegex(name, pass))
//
//        }
//    }
}
