package com.example.case_md3.service.Impl;

import com.example.case_md3.DAO.Impl.LocationDAO;
import com.example.case_md3.model.Location;
import com.example.case_md3.service.extendInterface.ILocationService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;
public class LocationService implements ILocationService {
    private LocationDAO locationDAO ;

    public LocationService() {
        locationDAO = new LocationDAO();
    }

    @Override
    public List<Location> findAll() {
        return locationDAO.findAll();
    }

    @Override
    public Location findOne(HttpServletRequest request) throws ServletException, IOException {
     int id = Integer.parseInt(request.getParameter("id"));
        return locationDAO.findOne(id);
    }

    @Override
    public void update(HttpServletRequest request) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name") ;
        String details = request.getParameter("details") ;
        Location location = new Location(id,name,details);
        locationDAO.update(location);
    }

    @Override
    public void create(HttpServletRequest request) throws ServletException, IOException {
        String name = request.getParameter("name") ;
        String details = request.getParameter("details") ;
        Location location = new Location(name,details);
        locationDAO.create(location);
    }
}
