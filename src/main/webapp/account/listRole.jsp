<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 8/31/2023
  Time: 3:23 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
      integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

<html>
<head>
  <title>Đăng nhập- Đăng kí</title>
</head>
<body>
<a style="margin-left: 100px; margin-top: 100px" class="btn btn-info" href="/book?action=adminHome">Quay lại</a>
<div class="container" style="width: 50%">
  <h1 style="text-align: center">Danh sách quyền</h1><table style="border-collapse: collapse; border: 1px" class="table table-hover">
  <a style="margin-left: 1px" class="btn btn-primary" href="account?action=roleCreate">Tạo mới</a>
  <tr style="margin-top: 500px">
      <th>STT</th>
      <th>Quyền</th>
      <th colspan="1"></th>
    </tr>
    <c:forEach items="${roles}" var="l">
      <tr>
        <td><c:out value="${l.getId()}"/></td>
        <td><c:out value="${l.getPermission()}"/></td>
        <td><a class="btn btn-warning" href="account?action=roleUpdate&&id=${l.getId()}">Cập nhật</a></td></tr>
    </c:forEach>
  </table>
</div>
</body>
</html>

