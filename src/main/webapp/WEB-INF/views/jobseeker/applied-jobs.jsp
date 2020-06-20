<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
			<div class="card">
				<ul class="list-group list-group-flush">
					<c:forEach items="${jobs}" var="job">
						<li class="list-group-item">
							<h4>${job.jobName}</h4>
							Job Description: ${job.jobDescription}
							<br>
							Skills: ${job.skills}
							<br>
							Salary: ${job.salary}
							<br>

							<a
								href="${pageContext.request.contextPath}/jobseeker/apply/${job.id}"
								class="card-link">Withdraw Application</a>
						</li>
					</c:forEach>

				</ul>
			</div>
		</div>
	</div>
	<jsp:include page="../footer.jsp" />
</body>
</html>