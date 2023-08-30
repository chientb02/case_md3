package com.example.case_md3.DAO.Impl;

import com.example.case_md3.DAO.extendInterface.ILocationDAO;
import com.example.case_md3.model.Location;
import com.example.case_md3.service.MyConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class LocationDAO implements ILocationDAO {

    private Connection connection ;

    public LocationDAO() {
        connection = new MyConnection().getConnection();
    }
    private String DISPLAY_ALL = "select * from location";
    private String FIND_ONE = "select * from location where id =?";
    private String UPDATE = "update location set name = ?, details= ? where id = ?";
    private String CREATE = "insert into location(name,details) values (?,?)";

    @Override
    public List<Location> findAll() {
        List<Location> locations = new ArrayList<>();
        try(PreparedStatement preparedStatement = connection.prepareStatement(DISPLAY_ALL)){
            ResultSet resultSet = preparedStatement.executeQuery() ;
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String details = resultSet.getString("details");
                locations.add( new Location(id,name,details));
            }
        }catch (Exception e ){
            e.printStackTrace();
        }
        return locations;
    }

    @Override
    public Location findOne(int id) {
        Location location = null ;
        try(PreparedStatement preparedStatement = connection.prepareStatement(FIND_ONE)){
            preparedStatement.setInt(1 , id);
            ResultSet resultSet =preparedStatement.executeQuery();
            while (resultSet.next()) {
                int idL = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String details = resultSet.getString("details");
                location= new Location(idL,name,details);
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
        return location;
    }

    @Override
    public void update(Location location) {
        try(PreparedStatement preparedStatement = connection.prepareStatement(UPDATE)) {
            preparedStatement.setString(1,location.getName());
            preparedStatement.setString(2,location.getDetails());
            preparedStatement.setInt(3,location.getId());
            preparedStatement.executeUpdate();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void create(Location location) {
        try(PreparedStatement preparedStatement = connection.prepareStatement(CREATE)) {

            preparedStatement.setString(1,location.getName());
            preparedStatement.setString(2,location.getDetails());
            preparedStatement.executeUpdate();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {

    }
}
