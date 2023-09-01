<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 8/31/2023
  Time: 4:04 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>

<div class="container">
    <div style="display:flex; justify-content: flex-start;">
        <h1><a class="nav-link" href="/book">Trang chủ</a></h1>
        <h1 style="text-align: center; padding:6px; margin-left: 100px;">Các loại sách trong thư viện</h1>
    </div>
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
        <c:forEach items="${books}" var="B">
            <tr>
                <td>${B.getId()}</td>
                <td>${B.getName()}</td>
                <td>${B.getPublisher().getName()}</td>
                <td>${B.getCategory().getName()}</td>
                <td>${B.getLocation().getDetails()}</td>
                <td>
                    <image src="${B.getImage()}" style="width: 30px ; height: auto"></image>
                </td>
                <td>${B.getDescription()}</td>
                <td>${B.getStatus()}</td>
                <td width="auto"><a class="btn btn-warning" href="/showBookServlet?action=showBookDetail&&id=${B.getId()}">Xem thông tin sách</a>
                </td>
            </tr>
        </c:forEach>

    </table>
</div>

</body>
</html>
