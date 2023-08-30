package com.example.case_md3.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public interface IServlet  {
    void create(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
    void display(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException ;
    void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException ;
    void createPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException ;
    void updatePost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException ;
}
