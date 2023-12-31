package com.example.case_md3.DAO.Impl;

import com.example.case_md3.DAO.extendInterface.IBorrowingListDAO;
import com.example.case_md3.model.Account;
import com.example.case_md3.model.Borrowing_Book;
import com.example.case_md3.model.Borrowing_List;
import com.example.case_md3.service.MyConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class BorrowingListDAO implements IBorrowingListDAO {
    private Connection connection;
    private AccountDAO accountDAO;

    public BorrowingListDAO() {
        connection = new MyConnection().getConnection();
        accountDAO = new AccountDAO();
    }

    private String SELECT_ALL = "select * from borrowing_list;" ;
    private String SELECT_ONE  = "select * from borrowing_list where id = ? ;" ;
    private String SELECT_BY_ACC = "select * from borrowing_list where idUser = ? ;" ;

    private String CREATE = "insert into borrowing_list(idUser) value (?);";
    @Override
    public List<Borrowing_List> findAll() {
        List<Borrowing_List> borrowingLists = new ArrayList<>();
        try (PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int idBor = resultSet.getInt("id");
                int idUser = resultSet.getInt("idUser");
                borrowingLists.add(new Borrowing_List(idBor, accountDAO.findOne(idUser)));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return borrowingLists;
    }

    @Override
    public Borrowing_List findOne(int id) {
        Borrowing_List borrowingLists = null;
        try(PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ONE)){
            preparedStatement.setInt(1,id);
            ResultSet resultSet = preparedStatement.executeQuery() ;
            while (resultSet.next()) {
                int idBor = resultSet.getInt("id");
                int idUser = resultSet.getInt("idUser");
                borrowingLists = new Borrowing_List(idBor, accountDAO.findOne(idUser));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return borrowingLists;
    }

    @Override
    public void update(Borrowing_List borrowingList) {

    }

    @Override
    public void create(Borrowing_List borrowingList) {
        try(PreparedStatement preparedStatement = connection.prepareStatement(CREATE)) {
            preparedStatement.setInt(1,borrowingList.getUser().getId());
            preparedStatement.executeUpdate();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {

    }

    @Override
    public Borrowing_List findByAccount(Account account) {
        Borrowing_List borrowingLists = null;
        try(PreparedStatement preparedStatement = connection.prepareStatement(SELECT_BY_ACC)){
            preparedStatement.setInt(1,account.getId());
            ResultSet resultSet = preparedStatement.executeQuery() ;
            while (resultSet.next()) {
                int idBor = resultSet.getInt("id");
                int idUser = resultSet.getInt("idUser");
                borrowingLists = new Borrowing_List(idBor,accountDAO.findOne(idUser));
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
        return borrowingLists;
    }
}
