package com.example.case_md3.DAO.extendInterface;

import com.example.case_md3.DAO.IDAO;
import com.example.case_md3.model.Account;
import com.example.case_md3.model.Borrowing_Book;
import com.example.case_md3.model.Borrowing_List;

import java.util.List;

public interface IBorrowingListDAO extends IDAO<Borrowing_List> {
    Borrowing_List findByAccount (Account account);
}
