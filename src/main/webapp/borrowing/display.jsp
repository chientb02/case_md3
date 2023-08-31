<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: min
  Date: 31/08/2023
  Time: 3:39 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table>
    <tr>
        <th>id</th>
        <th>book</th>
        <th>status</th>
        <th>date_borrowing</th>
    </tr>
    <c:forEach items="${borrowing}" var="bor" >
        <tr>
        <td><c:out value="${bor.getId()}" /> aaa</td>
        <td><c:out value="${bor.getBook().getName()}" /> </td>
        <td><c:out value="${bor.getStatus()}" /> </td>
        <td><c:out value="${bor.getDateBorrowing().toString()}" /> </td>
            <td><a class="btn btn-danger" href="borrowingBook?action=update&&id=${bor.getId()}">add to cart</a></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
