<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 8/24/2023
  Time: 3:46 PM
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
    <h1 style="text-align: center">Create Category</h1>
    <form style="width: 500px; margin: auto"
          action="location?action=create" method="post">
        <div class="mb-3">
            <label for="location" class="form-label">Name</label>
            <input type="text" class="form-control" id="location"
                   name="name" required>
            <input type="text" class="form-control"
                   name="details" required>
        </div>
        <button class="btn btn-primary" type="submit">Create</button>
    </form>
</div>
<a style="margin-left: 100px; margin-top: 100px" class="btn btn-info" href="/location">Back to list</a>
</body>
</html>



