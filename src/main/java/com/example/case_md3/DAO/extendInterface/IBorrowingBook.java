package com.example.case_md3.DAO.extendInterface;

import com.example.case_md3.DAO.IDAO;
import com.example.case_md3.model.Account;
import com.example.case_md3.model.Borrowing_Book;

import java.util.List;

public interface IBorrowingBook extends IDAO <Borrowing_Book> {
    List<Borrowing_Book> findByUser (Account account);
}
