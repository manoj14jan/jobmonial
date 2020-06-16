<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!doctype html>
<html lang="en">
<head>
<jsp:include page="./header.jsp" />
<title>Job Seeker Registration</title>
</head>
<body>
	<div class="container">
		<jsp:include page="./navbar.jsp" />
		<div class="jumbotron">
			<h1 class="display-4">Registration Completed Successfully</h1>
			<p class="lead">Now goto the login page. Login with you Username:
				"${user.username}" and Password:*******</p>
			<hr class="my-4">
			<p>Have a great job search. send an email to Admin for support or
				suggestion</p>
			<p class="lead">
				<a class="btn btn-primary btn-lg"
					href="${pageContext.request.contextPath}/home" role="button">GO
					TO LOGIN PAGE</a>
			</p>
		</div>
	</div>
	<jsp:include page="./footer.jsp" />
</body>
</html>