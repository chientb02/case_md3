<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 8/31/2023
  Time: 8:17 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Book</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
<div class="container">
    <h1 style="text-align: center">Các loại sách trong thư viện</h1>
    <a class="btn btn-primary" href="/BookServlet?action=create">create</a>
    <table class="table table-hover">
        <tr>
            <th>STT</th>
            <th>Tên sản phẩm</th>
            <th>Danh mục sản phẩm</th>

        </tr>
        <c:forEach items="${productList}" var="C">
            <tr>
                <td>${C.getProductID()}</td>
                <td>${C.getProductName()}</td>
                <td>${C.category.categoryName}</td>

                <td><a  class="btn btn-warning" href="Product_SV?action=update&&productID=${C.getProductID()}">Update</a></td>
                <td><a class="btn btn-danger" href="Product_SV?action=delete&&productID=${C.getProductID()}">Delete</a></td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
