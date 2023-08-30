package com.example.case_md3.DAO;

import java.util.List;

public interface IDAO <E> {
    List<E> findAll () ;
    E findOne (int id) ;
    void update (E e) ;
    void create (E e) ;
    void delete (int id) ;
}