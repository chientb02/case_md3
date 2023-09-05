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
<a style="border-radius: 10px; color: #ff3f70; background-color: white; font-size: medium" class="btn btn-info" class="btn btn-info" href="/account?action=listAd">Quay lại</a>
<div class="container" style="width: 50%">
  <h1 style="text-align: center">Tìm theo tên</h1>
  <a style="margin-left: 1px" class="btn btn-primary" href="category?action=role">Danh sách quyền</a>
  <table style="border-collapse: collapse; border: 1px" class="table table-hover">
    <tr style="margin-top: 500px">
      <th>STT</th>
      <th>Email</th>
      <th>Mật khẩu</th>
      <th>Quyền</th>
      <th colspan="2"></th>
    </tr>
    <c:forEach items="${accounts}" var="a">
      <tr>
        <td><c:out value="${a.getId()}"/></td>
        <td><c:out value="${a.getEmail()}"/></td>
        <td><c:out value="${a.getPassword()}"/></td>
        <td><c:out value="${a.getRoles().getPermission()}"/></td>
        <td><a class="btn btn-warning" href="account?action=adminEdit&&id=${a.getId()}">Cập nhật</a></td>
        <td><button class="btn btn-danger" onclick="deleteA(${a.getId()})">Xóa</button></td>
      </tr>
    </c:forEach>
  </table>
</div>
</body>
<script>
  function deleteA(id) {
    if (confirm("Are you sure?")) {
      window.location.href = "account?action=delete&&id=" + id
    }
  }
</script>
</html>

