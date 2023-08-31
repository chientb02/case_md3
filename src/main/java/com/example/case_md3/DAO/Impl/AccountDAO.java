package com.example.case_md3.DAO.Impl;
import com.example.case_md3.DAO.extendInterface.IAccountDAO;
import com.example.case_md3.model.Account;
import com.example.case_md3.model.Roles;
import com.example.case_md3.service.MyConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AccountDAO implements IAccountDAO {
    String SELECT_ALL = "select * from acc";
    String SELECT_BY_ID = "select * from acc where id = ?";
    String SELECT_BY_ACCOUNT = "select * from acc where email = ?;";
    String ADD_ACCOUNT = "insert into acc(email, pass, idPermission) value (?,?,?);";
    String UPDATE_ACCOUNT = "update acc set pass = ? where id = ?";
    String DELETE_ACCOUNT = "delete from acc where id = ?";
    Connection connection;
    RoleDAO roleDAO;
    public AccountDAO(){
        roleDAO = new RoleDAO();
        connection = new MyConnection().getConnection();
    }
    @Override
    public List<Account> findAll() {
        List<Account> accounts = new ArrayList<>();
        try (PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String email = resultSet.getString("email");
                String pass = resultSet.getString("pass");
                int idPermission = resultSet.getInt("idPermission");
                Roles roles = roleDAO.findOne(idPermission);
                accounts.add(new Account(id, email, pass, roles));
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return accounts;
    }

    @Override
    public Account findOne(int id) {
        Account account = null;
        try (PreparedStatement preparedStatement = connection.prepareStatement(SELECT_BY_ID)) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int idDb = resultSet.getInt("id");
                String email = resultSet.getString("email");
                String pass = resultSet.getString("pass");
                int idPermission = resultSet.getInt("idPermission");
                Roles roles = roleDAO.findOne(idPermission);
                account = new Account(idDb, email, pass, roles);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return account;
    }
    public Account finOneByAccount(String gmail){
        Account account = null;
        try (PreparedStatement preparedStatement = connection.prepareStatement(SELECT_BY_ACCOUNT)) {
            preparedStatement.setString(1, gmail);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int idDb = resultSet.getInt("id");
                String email = resultSet.getString("email");
                String passDB = resultSet.getString("pass");
                int idPermission = resultSet.getInt("idPermission");
                Roles roles = roleDAO.findOne(idPermission);
                account = new Account(idDb, email, passDB, roles);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return account;
    }

    @Override
    public void update(Account account) {
        try (PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_ACCOUNT)) {
            preparedStatement.setString(1, account.getPassword());
            preparedStatement.setInt(2, account.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void create(Account account) {
        try (PreparedStatement preparedStatement = connection.prepareStatement(ADD_ACCOUNT)) {
            preparedStatement.setString(1, account.getEmail());
            preparedStatement.setString(2, account.getPassword());
            preparedStatement.setInt(3, account.getRoles().getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {
        try (PreparedStatement preparedStatement = connection.prepareStatement(DELETE_ACCOUNT)) {
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}


