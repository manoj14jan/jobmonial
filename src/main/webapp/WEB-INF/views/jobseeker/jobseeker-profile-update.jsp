<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!doctype html>
<html lang="en">
<head>
<jsp:include page="../header.jsp" />
<title>Job Seeker Registration</title>
<style type="text/css">
.invalid-feedback {
	display: block !important;
	width: 100%;
	margin-top: .25rem;
	font-size: 80%;
	color: #dc3545;
}
</style>
</head>
<body>
	<div class="container">
		<jsp:include page="./jobseeker-navbar.jsp" />
		<jsp:include page="./jobseeker-form.jsp" />
	</div>
	<jsp:include page="../footer.jsp" />
</body>
</html>