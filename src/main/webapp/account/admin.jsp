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
    <title>Title</title>
</head>
<body>
<form action="/account?action=search" method="post">
    <div style="display: flex; justify-content: center">
        <div style="margin-top: 20px">
            <!--  tim kiem-->
            <center class="navbar-collapse" id="navbarSupportedContent">
                <input name="search" style="width: 300px" class="form-control me-2" placeholder="Search">
            </center>
        </div>
        <div>
            <!--check-->
            <button style=" color:  #9f8383; width: 50px; border-radius: 20px; border: none; margin-top: 20px">
                <svg xmlns="http://www.w3.org/2000/svg" width="30" height="30" fill="currentColor"
                     class="bi bi-check2-circle" viewBox="0 0 16 16">
                    <path d="M2.5 8a5.5 5.5 0 0 1 8.25-4.764.5.5 0 0 0 .5-.866A6.5 6.5 0 1 0 14.5 8a.5.5 0 0 0-1 0 5.5 5.5 0 1 1-11 0z"/>
                    <path d="M15.354 3.354a.5.5 0 0 0-.708-.708L8 9.293 5.354 6.646a.5.5 0 1 0-.708.708l3 3a.5.5 0 0 0 .708 0l7-7z"/>
                </svg>
            </button>
        </div>
    </div>
</form>
<div class="container" style="width: 50%">
  <h1 style="text-align: center">List Account</h1>
  <a style="margin-left: 1px" class="btn btn-primary" href="/account?action=role">List role</a>
  <table style="border-collapse: collapse; border: 1px" class="table table-hover">
    <tr style="margin-top: 500px">
      <th>Id</th>
      <th>Email</th>
      <th>Pass</th>
      <th>Role</th>
        <th colspan="2"></th>
    </tr>
    <c:forEach items="${acc}" var="a">
      <tr>
        <td><c:out value="${a.getId()}"/></td>
        <td><c:out value="${a.getEmail()}"/></td>
        <td><c:out value="${a.getPassword()}"/></td>
        <td><c:out value="${a.getRoles().getPermission()}"/></td>
          <td><a class="btn btn-warning" href="/account?action=adminEdit&&id=${a.getId()}">Update</a></td>
          <td><button class="btn btn-danger" onclick="deleteA(${a.getId()})">Delete</button></td>
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

