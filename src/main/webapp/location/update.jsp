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
    <h1 style="text-align: center">Thay đổi vị trí</h1>
    <form style="width: 500px; margin: auto" method="post"
          action="/location?action=update&&id=${location.getId()}">
        <div class="mb-3">
            <label for="location" class="form-label">Tên</label>
            <input type="text" class="form-control" id="location"
                   name="name" value="${location.getName()}" required>
            <input type="text" class="form-control"
                   name="details" value="${location.getDetails()}" required>
        </div>
        <button class="btn btn-primary" type="submit">Cập nhật</button>
    </form>
    <a style="margin-left: 100px; margin-top: 100px" class="btn btn-info" href="/location">Quay lại</a>
</div>
</body>
</html>