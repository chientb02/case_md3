package com.example.case_md3.service.Impl;

import com.example.case_md3.DAO.Impl.BookDAO;
import com.example.case_md3.DAO.Impl.CategoryDAO;
import com.example.case_md3.DAO.Impl.LocationDAO;
import com.example.case_md3.DAO.Impl.PublisherDAO;
import com.example.case_md3.controller.Impl.PublisherServlet;
import com.example.case_md3.model.Book;
import com.example.case_md3.model.Category;
import com.example.case_md3.model.Location;
import com.example.case_md3.model.Publisher;
import com.example.case_md3.service.IGenerateService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;

public class BookService implements IGenerateService <Book> {
    private BookDAO bookDAO;
    private LocationDAO locationDAO;
    private CategoryDAO categoryDAO;
    private PublisherDAO publisherDAO;

    public BookService() {
        bookDAO = new BookDAO();
        locationDAO = new LocationDAO();
        categoryDAO = new CategoryDAO();
        publisherDAO = new PublisherDAO();

    }

    @Override
    public List<Book> findAll() {
        List<Book> books = bookDAO.findAll();
        return books;
    }
    public void delete(int id){
        Book book = bookDAO.findOne(id);
        if(book!=null){
            bookDAO.delete(id);
        }
    }
    @Override
    public Book findOne(HttpServletRequest request) throws ServletException, IOException {
        return null;
    }

    @Override
    public void update(HttpServletRequest request) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        request.setAttribute("id",id);
        int idPublisher = Integer.parseInt(request.getParameter("idPublisher"));
        Publisher publisher = publisherDAO.findOne(idPublisher);
        int idCategory = Integer.parseInt(request.getParameter("idCategory"));
        Category category = categoryDAO.findOne(idCategory);
        int idLocation = Integer.parseInt(request.getParameter("idLocation"));
        Location location = locationDAO.findOne(idLocation);
        String name = request.getParameter("name");
        String image = request.getParameter("image");
        String description = request.getParameter("description");
        String status = request.getParameter("status");
        Book book = new Book(id,publisher,category,location,name,image,description,status);
        bookDAO.update(book);
    }

    @Override
    public void create(HttpServletRequest request) throws ServletException, IOException {
        int idPublisher = Integer.parseInt(request.getParameter("idPublisher"));
        Publisher publisher = publisherDAO.findOne(idPublisher);
        int idCategory = Integer.parseInt(request.getParameter("idCategory"));
        Category category = categoryDAO.findOne(idCategory);
        int idLocation = Integer.parseInt(request.getParameter("idLocation"));
        Location location = locationDAO.findOne(idLocation);
        String name = request.getParameter("name");
        String image = request.getParameter("image");
        String description = request.getParameter("description");
        String status = request.getParameter("status");
        Book book = new Book(publisher,category,location,name,image,description,status);
        bookDAO.create(book);
    }
}
