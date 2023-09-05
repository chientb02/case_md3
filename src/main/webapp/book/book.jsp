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
    <a class="btn btn-primary" href="/book?action=create">Tạo mới sách</a>
    <a class="btn btn-primary" href="/category">Các Thể Loại</a>
    <a class="btn btn-primary" href="/location">Vị trí</a>
    <a class="btn btn-primary" href="/Publisher">Các Nhà Xuất Bản</a>
    <a class="btn btn-primary" href="/account?action=listAd">Danh sách tài khoản</a>
    <table class="table table-hover">
        <tr>
            <th>STT</th>
            <th>Tên sách</th>
            <th>Tên nhà xuất bản</th>
            <th>Loại sách</th>
            <th>Vị trí sách</th>
            <th>hình ảnh</th>
            <th>Mô tả sách</th>
            <th>Trạng thái sách</th>
            <th colspan="2"></th>
        </tr>
        <c:forEach items="${books}" var="B" varStatus="aa">
            <tr>
                <td>${aa.count}</td>
                <td>${B.getName()}</td>
                <td>${B.getPublisher().getName()}</td>
                <td>${B.getCategory().getName()}</td>
                <td>${B.getLocation().getDetails()}</td>
                <td><img src="${B.getImage()}" alt="" style="width:60px;"></td>
                <td>${B.getDescription()}</td>
                <td>${B.getStatus()}</td>
                <td><a  class="btn btn-warning" href="book?action=update&&id=${B.getId()}">Update</a></td>
                <td><a class="btn btn-danger" href="book?action=delete&&id=${B.getId()}">Delete</a></td>
            </tr>
        </c:forEach>
    </table>
</div>
<a style="margin-left: 100px; margin-top: 100px" class="btn btn-info" href="/account">Log Out</a>
</body>
</html>
