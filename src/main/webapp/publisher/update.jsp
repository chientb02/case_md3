<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 8/30/2023
  Time: 7:02 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>update</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>

<div class="container">
    <h1 style="text-align: center">Cập nhật nhà xuất bản</h1>
    <form style="width: 500px; margin: auto"
          action="/Publisher?action=updatePost" method="post">
        <div class="mb-3">
            <label for="name" class="form-label">Tên nhà xuất bản</label>
            <input type="text" class="form-control"
                   id="name" name="name" required>
        </div>
        <button class="btn btn-primary" type="submit">Cập nhật</button>
        <button class="btn btn-secondary" type="reset">Reset</button>
    </form>
</div>

</body>
</html>
