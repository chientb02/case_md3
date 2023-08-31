package com.example.case_md3.service.Impl;

import com.example.case_md3.DAO.Impl.BorrowingListDAO;
import com.example.case_md3.model.Account;
import com.example.case_md3.model.Borrowing_List;
import com.example.case_md3.service.IGenerateService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

public class BorrowingListService  {
    private AccountService accountService ;
    private BorrowingListDAO borrowingListDAO;

    public BorrowingListService() {
        accountService = new AccountService();
        borrowingListDAO = new BorrowingListDAO();
    }

    public List<Borrowing_List> findAll() {
        return borrowingListDAO.findAll();
    }
    public Borrowing_List findOne(int id ) {
        return borrowingListDAO.findOne(id) ;
    }
    public Borrowing_List findByAccount(Account account ) {
        return borrowingListDAO.findByAccount(account) ;
    }
    public boolean checkAcc (Account account) {
        List<Borrowing_List> borrowingLists = findAll();
        boolean flag = true ;
        for (Borrowing_List b :
                borrowingLists) {
            if(account.getId() == b.getUser().getId()) {
                flag = false;
            }
        }
        return flag;
    }
    public void update(HttpServletRequest request) throws ServletException, IOException {

    }


    public void create(HttpServletRequest request) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Account account= accountService.findOne((Integer) session.getAttribute("idUser"));
        if (checkAcc(account)){
            Borrowing_List borrowingList = new Borrowing_List(account);
            borrowingListDAO.create(borrowingList);
        }
    }
}
