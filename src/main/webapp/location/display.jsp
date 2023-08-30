<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
      integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<html>
<head>
    <title>Title</title>
</head>
<body>
<div class="container" style="width: 30%">
    <h1 style="text-align: center">List Location</h1>
    <a style="margin-left: 1px" class="btn btn-primary" href="location?action=create">Create</a>
    <table style="border-collapse: collapse; border: 1px" class="table table-hover">
        <tr style="margin-top: 500px" >
            <th>STT</th>
            <th>Name</th>
            <th>Details</th>
            <th>Option</th>
        </tr>
        <c:forEach items="${locations}" var="l" varStatus="stt">
            <tr>
                <td><c:out value="${stt.count}"/></td>
                <td><c:out value="${l.getName()}"/></td>
                <td><c:out value="${l.getDetails()}"/></td>
                <td><a class="btn btn-warning" href="location?action=update&&id=${l.getId()}">Update</a></td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
