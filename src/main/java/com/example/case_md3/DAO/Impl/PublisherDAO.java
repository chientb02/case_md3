package com.example.case_md3.DAO.Impl;

import com.example.case_md3.DAO.IDAO;
import com.example.case_md3.controller.Impl.PublisherServlet;
import com.example.case_md3.model.Publisher;
import com.example.case_md3.service.MyConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PublisherDAO implements IDAO <Publisher>  {
    private Connection connection;
    private String ShowListPublisher = "select  * from publisher; ";
    private String findOne = "select  * from publisher where id=?; ";
    private String create = "insert into publisher (name) values (?); ";
    private  String update= "update publisher set name= ?where id=?;";

    public PublisherDAO() {
        connection = new MyConnection().getConnection();
    }

    @Override
    public List findAll() {
        List<Publisher> publisherList = new ArrayList<>();
        try ( PreparedStatement preparedStatement = connection.prepareStatement(ShowListPublisher);){
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int id = Integer.parseInt(resultSet.getString("id"));
                String name = resultSet.getString("name");
                Publisher publisher = new Publisher(id,name);
                publisherList.add(publisher);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return publisherList;
    }
    @Override
    public Publisher findOne(int id) {
        Publisher publisher= null;
        try (PreparedStatement preparedStatement = connection.prepareStatement(findOne)) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int idPublisher = resultSet.getInt("id");
                String name = resultSet.getString("name");
                 publisher = new Publisher(idPublisher, name);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return publisher;
    }


    @Override
    public void update(Publisher publisher) {
        try (PreparedStatement preparedStatement = connection.prepareStatement(update)) {
            preparedStatement.setString(1, publisher.getName());
            preparedStatement.setInt(2, publisher.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void create(Publisher publisher) {
        try (PreparedStatement preparedStatement = connection.prepareStatement(create)) {
            preparedStatement.setString(1, publisher.getName());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }



    @Override
    public void delete(int id) {

    }
}
