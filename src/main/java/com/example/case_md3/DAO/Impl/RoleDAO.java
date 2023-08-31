package com.example.case_md3.DAO.Impl;
import com.example.case_md3.DAO.extendInterface.IRoleDAO;
import com.example.case_md3.model.Roles;
import com.example.case_md3.service.MyConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RoleDAO implements IRoleDAO {
    String SELECT_ALL = "select * from roles";
    String SELECT_BY_ID = "select * from roles where id = ?";
    String ADD_ROLES = "insert into roles(permission) value (?);";
    String UPDATE_ROLES = "update category set permission = ? where id = ?";
    String DELETE_ROLES = "delete from roles where id = ?;";
    Connection connection;
    public RoleDAO(){
        connection = new MyConnection().getConnection();
    }
    @Override
    public List<Roles> findAll() {
        List<Roles> roles = new ArrayList<>();
        try (PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("permission");
                roles.add(new Roles(id, name));
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return roles;
    }

    @Override
    public Roles findOne(int id) {
        Roles roles = null;
        try (PreparedStatement preparedStatement = connection.prepareStatement(SELECT_BY_ID)) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int idDB = resultSet.getInt("id");
                String name = resultSet.getString("permission");
                roles = new Roles(idDB,name);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return roles;
    }

    @Override
    public void update(Roles roles) {
        try (PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_ROLES)) {
            preparedStatement.setString(1, roles.getPermission());
            preparedStatement.setInt(2, roles.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void create(Roles roles) {
        try (PreparedStatement preparedStatement = connection.prepareStatement(ADD_ROLES)) {
            preparedStatement.setString(1, roles.getPermission());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {
        try (PreparedStatement preparedStatement = connection.prepareStatement(DELETE_ROLES)) {
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}


