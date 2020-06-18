<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!doctype html>
<html lang="en">
<head>
<jsp:include page="../header.jsp" />
<title>Employer Search</title>
</head>
    <title>Title</title>
</head>
<body>
<div class="container">
		<jsp:include page="./navbar.jsp" />
		<h1 class="display-4">Results</h1>
		<table class="table table-hover">
			<tr>
		    	<th>First Name</td>
		    	<th>Last Name</td>
		    	<th>Phone</td>
	    		<th>Email</td>
	    		<th style='text-align:center'>Admin Action</th>
		    </tr>
			
			<tr>
		        <td><c:out value="${lists.name}"/></td>
		        <td><c:out value="${lists.surname}"/></td>
		        <td><c:out value="${lists.phone}"/></td>
		        <td><c:out value="${lists.email}"/></td>
		        <td style='text-align:center'><button type="submit" class="btn btn-danger">Block User</button></td>
		    </tr>
			
		</table>
	</div>
	<jsp:include page="../footer.jsp" />
</body>
</html>
