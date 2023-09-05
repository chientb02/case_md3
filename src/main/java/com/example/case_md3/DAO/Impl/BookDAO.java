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
    private String create = "insert into book (idPublisher, idCategory, idLocation, name, img, description, status) values (?,?,?,?,?,?,?);";
    private  String update= "update book set idPublisher = ?,idCategory =?,idLocation=?,name=?,img=?,description=?,status=?  where id=?;";
    private String delete = "delete from book where id = ?;";
    private  String search = "select * from book where name LIKE ?;";
    private String borrowing = "update book set description = 'đã có người mượn' where id = ? " ;
    private String unBorrowing = "update book set description = 'còn' where id = ? " ;

    public BookDAO() {
        connection = new MyConnection().getConnection();
        categoryDAO = new CategoryDAO();
        locationDAO = new LocationDAO();
        publisherDAO = new PublisherDAO();
    }
    public void borrowing (Book book) {
        try (PreparedStatement preparedStatement = connection.prepareStatement(borrowing)) {
            preparedStatement.setInt(1, book.getId());
            preparedStatement.executeUpdate();
        }catch (Exception e ) {
            e.printStackTrace();
        }
    }
    public void unborrowing (Book book) {
        try (PreparedStatement preparedStatement = connection.prepareStatement(unBorrowing)) {
            preparedStatement.setInt(1, book.getId());
            preparedStatement.executeUpdate();
        }catch (Exception e ) {
            e.printStackTrace();
        }
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

         public List<Book> search(String name){
        List<Book> books = new ArrayList<>();
        try (PreparedStatement preparedStatement = connection.prepareStatement(search)) {
            preparedStatement.setString(1, "%" + name + "%");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int idBook = Integer.parseInt(resultSet.getString("id"));
                int idPublisher = Integer.parseInt(resultSet.getString("idPublisher"));
                int idCategory = Integer.parseInt(resultSet.getString("idCategory"));
                int idLocation = Integer.parseInt(resultSet.getString("idLocation"));
                String name1 = resultSet.getString("name");
                String img = resultSet.getString("img");
                String description = resultSet.getString("description");
                String status = resultSet.getString("status");
                Publisher publisher = publisherDAO.findOne(idPublisher);
                Category category = categoryDAO.findOne(idCategory);
                Location location = locationDAO.findOne(idLocation);
                Book book = new Book(idBook,publisher,category,location,name1,img,description,status);
                books.add(book);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return books;
    }
    @Override
    public void update(Book book) {
        try (PreparedStatement preparedStatement = connection.prepareStatement(update)) {
            int idPublisher = book.getPublisher().getId();
            int idCategory = book.getCategory().getId();
            int idLocation = book.getLocation().getId();
            preparedStatement.setInt(1,idPublisher);
            preparedStatement.setInt(2, idCategory);
            preparedStatement.setInt(3, idLocation);
            String name = book.getName();
            String img = book.getImage();
            String description = book.getDescription();
            String status = book.getStatus();
            int id = book.getId();
            preparedStatement.setString(4,name);
            preparedStatement.setString(5, img);
            preparedStatement.setString(6, description);
            preparedStatement.setString(7, status);
            preparedStatement.setInt(8,id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void create(Book book) {
        try (PreparedStatement preparedStatement = connection.prepareStatement(create)) {
            int idPublisher = book.getPublisher().getId();
            int idCategory = book.getCategory().getId();
            int idLocation = book.getLocation().getId();
            preparedStatement.setInt(1,idPublisher);
            preparedStatement.setInt(2, idCategory);
            preparedStatement.setInt(3, idLocation);
            preparedStatement.setString(4, book.getName());
            preparedStatement.setString(5, book.getImage());
            preparedStatement.setString(6, book.getDescription());
            preparedStatement.setString(7, book.getStatus());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

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
