package com.example.case_md3.service.Impl;
import com.example.case_md3.DAO.Impl.CategoryDAO;
import com.example.case_md3.model.Category;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;

public class CategoryService {
    CategoryDAO categoryDAO;
    public CategoryService(){
        categoryDAO = new CategoryDAO();
    }
    public List<Category> findAll() {
        return categoryDAO.findAll();
    }

    public Category findOne(int id) {
        return categoryDAO.findOne(id);
    }

    public void update(HttpServletRequest request) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("category");
        Category category = findOne(id);
        category.setName(name);
        categoryDAO.update(category);
    }

    public void create(HttpServletRequest request) throws ServletException, IOException {
        String name = request.getParameter("category");
        Category category = new Category(name);
        categoryDAO.create(category);
    }
}




