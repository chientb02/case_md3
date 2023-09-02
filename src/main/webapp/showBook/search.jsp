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
        <a class="btn btn-warning" href="/book" style="margin-top: 30px;">Trang chủ</a>
    </div>
<c:forEach items="${books}" var="B">

    <h1 style="text-align: center">${B.getName()}</h1>
    <table class="table table-hover">
        <tr style="width: 400px" >
            <td rowspan="7" style="width: 40%">
                <image src="${B.getImage()}" style="width: 30% ; height: auto"></image>
            </td>
        </tr>

        <tr>
            <td style="font-size: 30px; width: 60%"> Tên nhà xuất bản: ${B.getPublisher().getName()}</td><br>
        </tr>
        <tr >
            <td style="font-size: 30px; width: 60%">Loại sách: ${B.getCategory().getName()}</td><br>
        </tr>
        <tr >
            <td style="font-size: 30px; width: 60%">Vị trí tại:  ${B.getLocation().getDetails()}</td><br>
        </tr>
        <tr >
            <td style="font-size: 30px; width: 60%">Miêu tả:  ${B.getDescription()}</td><br>
        </tr>
        <tr >
            <td style="font-size: 30px; width: 60%">Trạng thái sách:  ${B.getStatus()}</td><br>
        </tr>

        </c:forEach>
    </table>
    <a class="btn btn-warning" href="borrowingBook?action=create&&id=${book.getId()}">Mượn sách</a>
    <a class="btn btn-warning" href="showBookServlet?action=goBack">Xem sách khác</a>
</div>

</body>
</html>
