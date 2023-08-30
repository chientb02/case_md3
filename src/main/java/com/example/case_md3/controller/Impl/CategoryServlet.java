package com.example.case_md3.controller.Impl;
import com.example.case_md3.controller.extendInterface.ICategory;
import com.example.case_md3.model.Category;
import com.example.case_md3.service.Impl.CategoryService;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "CategoryServlet", value = "/category")
public class CategoryServlet extends HttpServlet implements ICategory {
    CategoryService categoryService;
    @Override
    public void init() throws ServletException {
        categoryService = new CategoryService();
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
         req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "":
                display(req, resp);
                break;
            case "create":
                create(req, resp);
                break;
            case "update":
                update(req, resp);
                break;
        }
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                createPost(req, resp);
                break;
            case "update":
                updatePost(req, resp);
                break;
        }
    }
    @Override
    public void create(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Category> listCategory = categoryService.findAll();
        request.setAttribute("listCategory",listCategory);
        RequestDispatcher rq = request.getRequestDispatcher("category/create.jsp");
        rq.forward(request, response);
    }

    @Override
    public void display(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Category> categoryList = categoryService.findAll();
        request.setAttribute("categoryList", categoryList);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("category/list.jsp");
        requestDispatcher.forward(request, response);
    }

    @Override
    public void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Category category = categoryService.findOne(id);
        request.setAttribute("category", category);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("category/update.jsp");
        requestDispatcher.forward(request, response);
    }

    @Override
    public void createPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        categoryService.create(request);
        response.sendRedirect("/category");
    }

    @Override
    public void updatePost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        categoryService.update(request);
        response.sendRedirect("/category");
    }
}



