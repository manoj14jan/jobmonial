<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!doctype html>
<html lang="en">
<head>
<jsp:include page="../header.jsp" />
<title>Job Seeker Home</title>
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
		<jsp:include page="./employer-navbar.jsp" />
		<div class="jumbotron">
			<form:form modelAttribute="job" method="post"
				action="${pageContext.request.contextPath}/employer/job/post">
				<form:hidden path="id" />
				<div class="card">
					<div class="card-body">
						<h5 class="card-title">Add a Job</h5>
						<h6 class="card-subtitle mb-2 text-muted">Fields are required
							which mark with *</h6>

						<div class="form-group">
							<label for="jobName">Job Title*</label>
							<form:input path="jobName" cssClass="form-control" id="jobName"
								aria-describedby="jobName" placeholder="Enter Job Name" />
							<form:errors path="jobName" cssClass="invalid-feedback"
								element="div" />
						</div>

						<div class="form-group">
							<label for="jobDescription">Job Description*</label>
							<form:textarea path="jobDescription" cssClass="form-control"
								id="jobDescription" rows="3" aria-describedby="jobDescription"
								placeholder="Enter job description" />
							<form:errors path="jobDescription" cssClass="invalid-feedback"
								element="div" />
						</div>

						<div class="form-group">
							<label for="skills">Skills</label>
							<form:input path="skills" cssClass="form-control" id="skills"
								aria-describedby="skills" placeholder="Enter Skills" />
							<form:errors path="skills" cssClass="invalid-feedback"
								element="div" />
							<small id="skillsHelp" class="form-text text-muted">e.g.
								Java, J2EE, Spring, Hibernate, HTML .....</small>
						</div>

						<div class="form-group">
							<label for="salary">Job Salary*</label>
							<form:input path="salary" cssClass="form-control" id="salary"
								aria-describedby="salary" placeholder="Enter Salary" />
							<form:errors path="salary" cssClass="invalid-feedback"
								element="div" />
						</div>

						<button type="submit" class="btn btn-primary">Submit</button>
					</div>
				</div>
			</form:form>
		</div>
	</div>

	<jsp:include page="../footer.jsp" />
</body>
</html>
