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
		<img
			src="<c:url value="/resource/images/software-developer-job.webp"></c:url>"
			class="img-fluid" alt="Responsive image">
		<div class="jumbotron">

			<h1 class="display-4" >Genuine Matchmaker of Talent and Job</h1>
			<a class="btn btn-primary btn-lg" role="button" href="${pageContext.request.contextPath}/register/jobseeker">Job
				Seeker Registration</a>
			<a class="btn btn-primary btn-lg" role="button" href="${pageContext.request.contextPath}/register/employer">Employer
				Registration</a>
			<a class="btn btn-primary btn-lg" role="button" href="${pageContext.request.contextPath}/unsecure/jobsearch">Search
				Jobs</a>
		</div>
	</div>
	<jsp:include page="./footer.jsp" />
</body>
</html>