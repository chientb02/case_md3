
<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 8/24/2023
  Time: 3:49 PM
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
<div class="container">
    <h1 style="text-align: center">Update Category</h1>
    <form style="width: 500px; margin: auto" method="post"
          action="category?action=update&&id=${category.getId()}">
        <div class="mb-3">
            <label for="category" class="form-label">Name</label>
            <input type="text" class="form-control" id="category"
                   name="category" value="${category.getName()}" required>
        </div>
        <button class="btn btn-primary" type="submit">Update</button>
    </form>
    <a style="margin-left: 100px; margin-top: 100px" class="btn btn-info" href="/category">Back to list</a>
</div>
</body>
</html>
