package com.example.case_md3.DAO.Impl;

import com.example.case_md3.DAO.extendInterface.IBorrowingBook;
import com.example.case_md3.model.Account;
import com.example.case_md3.model.Book;
import com.example.case_md3.model.Borrowing_Book;
import com.example.case_md3.model.Borrowing_List;
import com.example.case_md3.service.MyConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class BorrowingBookDAO implements IBorrowingBook  {
    private Connection connection ;
    private BorrowingListDAO borrowingListDAO ;
    private BookDAO bookDAO ;

    public BorrowingBookDAO() {
        connection = new MyConnection().getConnection();
        borrowingListDAO = new BorrowingListDAO() ;
        bookDAO = new BookDAO();
    }
    private String  SELECT_ALL = "select * from borrowing_book";
    private String SELECT_ONE = "select * from borrowing_book where id = ?" ;
    private String SELECT_BY_USER = "select * from borrowing_book where borrowing_list = ?";
    private String CREATE = "insert into borrowing_book (book, status, borrowing_list ,date_borrowing) VALUES  (?,?,?,?)";
    private String UPDATE = "update borrowing_book set status = ? where id = ?;" ;
    @Override
    public List<Borrowing_Book> findAll() {
        List<Borrowing_Book> books = new ArrayList<>() ;
        try (PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL) ){
            ResultSet resultSet = preparedStatement.executeQuery();
            int idBor = resultSet.getInt("id");
            int idBook = resultSet.getInt("book") ;
            String status = resultSet.getString("status");
            int idUser = resultSet.getInt("borrowing_list");
            LocalDateTime date = resultSet.getObject("date_borrowing",LocalDateTime.class);
            books.add(new Borrowing_Book(idBor,bookDAO.findOne(idBook),status,borrowingListDAO.findOne(idUser),date));
        }catch (Exception e) {
            e.printStackTrace();
        }
        return books;
    }

    @Override
    public Borrowing_Book findOne(int id) {
        Borrowing_Book books = null ;
        try (PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ONE) ){
            preparedStatement.setInt(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();
            int idBor = resultSet.getInt("id");
            int idBook = resultSet.getInt("book") ;
            String status = resultSet.getString("status");
            int idUser = resultSet.getInt("borrowing_list");
            LocalDateTime date = resultSet.getObject("date_borrowing",LocalDateTime.class);
            books = new Borrowing_Book(idBor,bookDAO.findOne(idBook),status,borrowingListDAO.findOne(idUser),date);
        }catch (Exception e) {
            e.printStackTrace();
        }
        return books;
    }

    @Override
    public void update(Borrowing_Book borrowingBook) {
        try(PreparedStatement preparedStatement = connection.prepareStatement(UPDATE)){
            preparedStatement.setString(1,borrowingBook.getStatus());
            preparedStatement.setInt(2,borrowingBook.getId());
            preparedStatement.executeUpdate();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Override
    public void create(Borrowing_Book borrowingBook) {
        try(PreparedStatement preparedStatement = connection.prepareStatement(CREATE)){
            preparedStatement.setInt(1,borrowingBook.getBook().getId());
            preparedStatement.setString(2,borrowingBook.getStatus());
            preparedStatement.setInt(3,borrowingBook.getBorrowingList().getId());
            preparedStatement.setString(4,borrowingBook.getDateBorrowing().toString());
            preparedStatement.executeUpdate();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Override
    public void delete(int id) {

    }

    @Override
    public List<Borrowing_Book> findByUser(Account account) {
        List<Borrowing_Book> books = null ;
        try (PreparedStatement preparedStatement = connection.prepareStatement(SELECT_BY_USER) ){
            preparedStatement.setInt(1,account.getId());
            ResultSet resultSet = preparedStatement.executeQuery();
            int idBor = resultSet.getInt("id");
            int idBook = resultSet.getInt("book") ;
            String status = resultSet.getString("status");
            int idUser = resultSet.getInt("borrowing_list");
            LocalDateTime date = resultSet.getObject("date_borrowing",LocalDateTime.class);
            books.add( new Borrowing_Book(idBor,bookDAO.findOne(idBook),status,borrowingListDAO.findOne(idUser),date));
        }catch (Exception e) {
            e.printStackTrace();
        }
        return books;
    }
}
