<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 8/30/2023
  Time: 4:37 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Tạo sách</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>

<div class="container">
  <h1 style="text-align: center">Tạo mới sách</h1>
  <form style="width: 500px; margin: auto"
        action="/book?action=createPost" method="post">
    <div class="mb-3">
      <label class="form-label">Lựa chọn nhà xuất bản</label>
      <select class="form-select" name="idPublisher" >
        <c:forEach items="${publishers}" var="p">
          <option value="${p.getId()}"><c:out value="${p.getName()}"/></option>
        </c:forEach>
      </select>
    </div>
    <div class="mb-3">
      <label class="form-label">Lựa chọn loại sách</label>
      <select class="form-select" name="idCategory" >
        <c:forEach items="${categories}" var="c">
          <option value="${c.getId()}"><c:out value="${c.getName()}"/></option>
        </c:forEach>
      </select>
    </div>
    <div class="mb-3">
      <label class="form-label">Lựa chọn vị trí sách</label>
      <select class="form-select" name="idLocation" >
        <c:forEach items="${locations}" var="L">
          <option value="${L.getId()}"><c:out value="${L.getDetails()}"/></option>
        </c:forEach>
      </select>
    </div>

    <div class="mb-3">
      <label for="name" class="form-label">Nhập tên sách</label>
      <input type="text" class="form-control"
             id="name" name="name" required>
    </div>
    <div class="mb-3">
      <label for="image" class="form-label">Nhập vào link hình ảnh</label>
      <input type="text" class="form-control"
             id="image" name="image" required>
    </div>
    <div class="mb-3">
      <label for="description" class="form-label">Miêu tả sách</label>
      <input type="text" class="form-control"
             id="description" name="description" required>
    </div>
    <div class="mb-3">
      <label for="status" class="form-label">Trạng thái sách</label>
      <input type="text" class="form-control"
             id="status" name="status" required>
    </div>


    <button class="btn btn-primary" type="submit">Create</button>
    <button class="btn btn-secondary" type="reset">Reset</button>
  </form>
</div>

</body>
</html>
