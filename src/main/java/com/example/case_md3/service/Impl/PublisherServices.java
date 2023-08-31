package com.example.case_md3.service.Impl;

import com.example.case_md3.DAO.Impl.PublisherDAO;
import com.example.case_md3.controller.Impl.PublisherServlet;
import com.example.case_md3.model.Publisher;
import com.example.case_md3.service.IGenerateService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;

public class PublisherServices implements IGenerateService <Publisher> {
    private PublisherDAO publisherDAO;

    public PublisherServices() {
        publisherDAO = new PublisherDAO();
    }

    @Override
    public List<Publisher> findAll() {
        List<Publisher> publishers =publisherDAO.findAll();
        return publishers;
    }

    @Override
    public Publisher findOne(HttpServletRequest request) throws ServletException, IOException {
        return null;
    }

    @Override
    public void update(HttpServletRequest request) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        Publisher publisher = new Publisher(id,name);
        publisherDAO.update(publisher);
    }

    @Override
    public void create(HttpServletRequest request) throws ServletException, IOException {
        String name = request.getParameter("name");
        Publisher publisher = new Publisher(name);
        publisherDAO.create(publisher);
    }
}
