<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!doctype html>
<html lang="en">
<head>
<jsp:include page="../header.jsp" />
<title>Admin Login</title>
</head>
<body>
	<div class="container">
		<jsp:include page="./navbar.jsp" />
		<h1 class="display-4" >Welcome, <sec:authentication property="name"/></h1>
	</div>
	<jsp:include page="../footer.jsp" />
</body>
</html>
</html>