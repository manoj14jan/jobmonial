<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Perry Luigi
  Date: 6/17/2020
  Time: 5:27 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:forEach items="${lists}" var="list">
    <tr>
        <td>Seeker FirstName: <c:out value="${list.firstName}"/></td>|
        <td>Seeker LastName: <c:out value="${list.lastName}"/></td>|
        <td>Seeker Email: <c:out value="${list.email}"/></td>|
        <td>Seeker Experince: <c:out value="${list.experience}"/></td>|
        <td>Seeker Phone: <c:out value="${list.phone}"/></td>|
        <td>Seeker ProfileType: <c:out value="${list.profileTitle}"/></td>|
        <br>

    </tr>
</c:forEach>
</body>
</html>
