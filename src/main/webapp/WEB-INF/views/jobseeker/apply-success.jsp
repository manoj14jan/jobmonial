<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!doctype html>
<html lang="en">
<head>
<jsp:include page="../header.jsp" />
<title>Job Seeker Home</title>
</head>
<body>
	<div class="container">
		<jsp:include page="./jobseeker-navbar.jsp" />
		<div class="jumbotron">
			<h4>you have applied the job "${job.jobName}" Successfully</h4>
			<hr class="my-4">
			<p class="lead">Employer will contact you soon for further
				process</p>
			<p class="lead">
				<a class="btn btn-primary btn-lg"
					href="${pageContext.request.contextPath}/jobseeker/appliedjobs" role="button">GO
					TO Applied Jobs</a>
			</p>
		</div>
	</div>
	<jsp:include page="../footer.jsp" />
</body>
</html>