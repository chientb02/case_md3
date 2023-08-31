package com.example.case_md3.service.Impl;
import com.example.case_md3.DAO.Impl.RoleDAO;
import com.example.case_md3.model.Roles;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;

public class RolesService {
    RoleDAO roleDAO;
    public RolesService(){
        roleDAO = new RoleDAO();
    }
    public List<Roles> findAll() {
        return roleDAO.findAll();
    }

    public Roles findOne(int id) {
        return roleDAO.findOne(id);
    }

    public void update(HttpServletRequest request) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String permission = request.getParameter("permission");
        Roles roles = new Roles(id, permission);
        roles.setPermission(permission);
        roleDAO.update(roles);
    }

    public void create(HttpServletRequest request) throws ServletException, IOException {
        String permission = request.getParameter("permission");
        Roles roles = new Roles(permission);
        roleDAO.create(roles);
    }
}
