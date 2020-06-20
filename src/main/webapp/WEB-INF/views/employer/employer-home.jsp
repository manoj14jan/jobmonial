<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html lang="en">
<head>
<jsp:include page="../header.jsp" />
<title>Job Seeker Registration</title>
</head>
<body>
	<div class="container">
		<jsp:include page="./employer-navbar.jsp" />
		<c:forEach items="${jobs}" var="elem">
			<div class="card">
				<div class="card-body">
					<h5 class="card-title">${elem.jobName}</h5>
					<p class="card-text">Job Description:${elem.jobDescription}<br>
					Skills: ${elem.skills}<br>
					Salary: ${elem.salary}<br>
					
					</p>
					<div class="bd-example">
						<a
							href="${pageContext.request.contextPath}/employer/job/${elem.id}/edit"
							class="btn btn-outline-secondary">Edit</a>
						<a
							href="${pageContext.request.contextPath}/employer/job/${elem.id}/delete"
							class="btn btn-outline-danger">Delete</a>
					</div>
				</div>
			</div>
		</c:forEach>
	</div>
	<jsp:include page="../footer.jsp" />
</body>
</html>
