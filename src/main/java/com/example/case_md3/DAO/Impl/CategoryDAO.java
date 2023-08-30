package com.example.case_md3.DAO.Impl;
import com.example.case_md3.DAO.extendInterface.ICategoryDAO;
import com.example.case_md3.model.Category;
import com.example.case_md3.service.MyConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategoryDAO implements ICategoryDAO {
    String SELECT_ALL = "select * from category";
    String SELECT_BY_ID = "select * from category where id = ?";
    String ADD_PRODUCT = "insert into category(name) value (?);";
    String UPDATE_PRODUCT = "update category set name = ? where id = ?";
    String DELETE_PRODUCT = "delete from category where id = ?";
    Connection connection;
    public CategoryDAO(){
        connection = new MyConnection().getConnection();
    }
    @Override
    public List<Category> findAll() {
        List<Category> categories = new ArrayList<>();
        try (PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                categories.add(new Category(id, name));
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return categories;
    }

    @Override
    public Category findOne(int id) {
        Category category = null;
        try (PreparedStatement preparedStatement = connection.prepareStatement(SELECT_BY_ID)) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int idDB = resultSet.getInt("id");
                String name = resultSet.getString("name");
                category = new Category(idDB,name);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return category;
    }

    @Override
    public void update(Category category) {
        try (PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_PRODUCT)) {
            preparedStatement.setString(1, category.getName());
            preparedStatement.setInt(2, category.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void create(Category category) {
        try (PreparedStatement preparedStatement = connection.prepareStatement(ADD_PRODUCT)) {
            preparedStatement.setString(1, category.getName());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {
        try (PreparedStatement preparedStatement = connection.prepareStatement(DELETE_PRODUCT)) {
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}


