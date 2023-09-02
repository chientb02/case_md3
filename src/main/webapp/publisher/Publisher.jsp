<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 8/30/2023
  Time: 3:04 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Hiển thị trang publisher</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

</head>
<body>
<a style="margin-left: 100px; margin-top: 100px" class="btn btn-info" href="/book?action=adminHome">Back to list</a>
<div class="container">
    <h1 style="text-align: center">Danh sách nhà xuất bản</h1>
    <a class="btn btn-primary" href="/Publisher?action=create">create</a>
    <table class="table table-hover">
        <tr>
            <th>STT</th>
            <th>Tên nhà xuất bản</th>

        </tr>
        <c:forEach items="${publishers}" var="P">
            <tr>
                <td>${P.getId()}</td>
                <td>${P.getName()}</td>

                <td><a  class="btn btn-warning" href="/Publisher?action=update&&id=${P.getId()}">Update</a></td>
            </tr>
        </c:forEach>
    </table>
</div>

</body>
</html>
