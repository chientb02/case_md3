package com.example.case_md3.service.extendInterface;

import com.example.case_md3.model.Borrowing_Book;
import com.example.case_md3.service.IGenerateService;

import javax.servlet.http.HttpSession;
import java.util.List;

public interface IBorrowingService extends IGenerateService <Borrowing_Book> {
    List<Borrowing_Book> findByUser (HttpSession session);
}
