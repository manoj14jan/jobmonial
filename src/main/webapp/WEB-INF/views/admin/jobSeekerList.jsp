<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!doctype html>
<html lang="en">
<head>
<jsp:include page="../header.jsp" />
<title>JobSeeker Search</title>
</head>
    <title>Title</title>
</head>
<body>
<div class="container">
		<jsp:include page="./navbar.jsp" />
		<h1 class="display-4">Results</h1>
		<table style="width: 100%;" class="table table-hover">
			<tr>
		    	<th>First Name</td>
		    	<th>Last Name</td>
		    	<th>Email</td>
		    	<th>Experience</td>
		    	<th>Phone</td>
		    	<th>Profile Type</td>
		    	<th style='text-align:center'>Admin Action</th>
		    </tr>
			<c:forEach items="${lists}" var="list">
				<tr>
			        <td><c:out value="${list.firstName}"/></td>
			        <td><c:out value="${list.lastName}"/></td>
			        <td><c:out value="${list.email}"/></td>
			        <td><c:out value="${list.experience}"/></td>
			        <td><c:out value="${list.phone}"/></td>
			        <td><c:out value="${list.profileTitle}"/></td>
			        <td style='text-align:center'><button type="submit" class="btn btn-danger">Block User</button></td>
			    </tr>
			</c:forEach>
		</table>
	</div>
	<jsp:include page="../footer.jsp" />
</body>
</html>
