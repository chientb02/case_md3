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
        <h1><a class="nav-link" href="book">Trang chủ</a></h1>
        <h1 style="text-align: center; padding:6px; margin-left: 100px;">Các loại sách trong thư viện</h1>
    </div>
    <table class="table table-hover">
        <tr>
            <th>STT</th>
            <th>Tên sách</th>
            <th>Trạng thái</th>
            <th>Ngày mượn</th>
            <th ></th>
        </tr>
        <c:forEach items="${borrowing}" var="B" varStatus="stt">
            <tr>
                <td>${stt.count}</td>
                <td>${B.getBook().getName()}</td>
                <td>${B.getStatus()}</td>
                <td>${B.getDateBorrowing().toString()}</td>
                <td width="auto"><a class="btn btn-warning" href="/borrowingBook?action=update&&id=${B.getId()}">Trả sách</a>
                </td>
            </tr>
        </c:forEach>

    </table>
</div>

</body>
</html>
