package com.example.case_md3.DAO.Impl;

import com.example.case_md3.DAO.IDAO;
import com.example.case_md3.model.Book;
import com.example.case_md3.model.Category;
import com.example.case_md3.model.Location;
import com.example.case_md3.model.Publisher;
import com.example.case_md3.service.MyConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookDAO implements IDAO<Book> {
    private Connection connection;
    private CategoryDAO categoryDAO;
    private LocationDAO locationDAO;
    private PublisherDAO publisherDAO;



    private String list = "select  * from book;";
    private String findOne = "select  * from book where id=?; ";
    private String create = "insert into book (idPublisher, idCategory, idLocation, condision, status) values (?,?,?,?,?);";
    private  String update= "update book set (idPublisher = ?,idCategory =?,idLocation=?,condision=?,status=? ) where id=?;";
    private String delete = "delete from book where id = ?;";

    public BookDAO() {
        connection = new MyConnection().getConnection();
        categoryDAO = new CategoryDAO();
        locationDAO = new LocationDAO();
        publisherDAO = new PublisherDAO();
    }
    @Override
    public List<Book> findAll() {
        List<Book> books = new ArrayList<>();
        try (PreparedStatement preparedStatement = connection.prepareStatement(list);){
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int id = Integer.parseInt(resultSet.getString("id"));
                int idPublisher = Integer.parseInt(resultSet.getString("idPublisher"));
                int idCategory = Integer.parseInt(resultSet.getString("idCategory"));
                int idLocation = Integer.parseInt(resultSet.getString("idLocation"));
                String name = resultSet.getString("name");
                String img = resultSet.getString("img");
                String description = resultSet.getString("description");
                String status = resultSet.getString("status");
                Publisher publisher = publisherDAO.findOne(idPublisher);
                Category category = categoryDAO.findOne(idCategory);
                Location location = locationDAO.findOne(idLocation);

                Book book = new Book(id,publisher,category,location,name,img,description,status);
                books.add(book);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return books;
    }

    @Override
    public Book findOne(int id) {
        Book book= null;
        try (PreparedStatement preparedStatement = connection.prepareStatement(findOne)) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int idBook = Integer.parseInt(resultSet.getString("id"));
                int idPublisher = Integer.parseInt(resultSet.getString("idPublisher"));
                int idCategory = Integer.parseInt(resultSet.getString("idCategory"));
                int idLocation = Integer.parseInt(resultSet.getString("idLocation"));
                String name = resultSet.getString("name");
                String img = resultSet.getString("img");
                String description = resultSet.getString("description");
                String status = resultSet.getString("status");
                Publisher publisher = publisherDAO.findOne(idPublisher);
                Category category = categoryDAO.findOne(idCategory);
                Location location = locationDAO.findOne(idLocation);
                book = new Book(idBook,publisher,category,location,name,img,description,status);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return book;
    }
    @Override
    public void update(Book book) {

    }

    @Override
    public void create(Book book) {

    }

    @Override
    public void delete(int id) {
        try (PreparedStatement preparedStatement = connection.prepareStatement(delete)) {
            preparedStatement.setInt(1,id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
