<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

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
		<div class="jumbotron">
			<form:form modelAttribute="jobSeeker"
				action="${pageContext.request.contextPath}/jobseeker/profile">
				<form:hidden path="jobSeekerId"/>
				<div class="card">
					<div class="card-body">
						<h5 class="card-title">Job Seeker Registration</h5>
						<h6 class="card-subtitle mb-2 text-muted">Fields are required
							which mark with *</h6>


						<div class="form-group">
							<label for="firstName">First Name*</label>
							<form:input path="firstName" cssClass="form-control"
								id="firstName" aria-describedby="firstName"
								placeholder="Enter First Name" />
							<form:errors path="firstName" cssClass="invalid-feedback"
								element="div" />
						</div>

						<div class="form-group">
							<label for="lastName">Last Name</label>
							<form:input path="lastName" cssClass="form-control" id="lastName"
								aria-describedby="lastName" placeholder="Enter Last Name" />
							<form:errors path="lastName" cssClass="invalid-feedback"
								element="div" />
						</div>

						<div class="form-group">
							<label for="phone">Phone*</label>
							<form:input path="phone" cssClass="form-control" id="phone"
								aria-describedby="phone" placeholder="Enter Phone" />
							<form:errors path="phone" cssClass="invalid-feedback"
								element="div" />
							<small id="phoneHelp" class="form-text text-muted"> Phone
								format must be (555) 555-1234</small>
						</div>

						<div class="form-group">
							<label for="email">Email*</label>
							<form:input path="email" type="text" class="form-control"
								id="email" aria-describedby="email" placeholder="Enter Email" />
							<form:errors path="email" cssClass="invalid-feedback"
								element="div" />

						</div>

						<div class="form-group">
							<label for="profileTitle">Profile Title</label>
							<form:input path="profileTitle" cssClass="form-control"
								id="profileTitle" aria-describedby="profileTitle"
								placeholder="Enter Profile Title" />
							<form:errors path="profileTitle" cssClass="invalid-feedback"
								element="div" />
							<small id="profileTitleHelp" class="form-text text-muted">e.g.
								Senior Java Developer, Microsoft Developer ...</small>
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
							<label for="experience">Experience</label>
							<form:input path="experience" cssClass="form-control"
								id="experience" aria-describedby="experience"
								placeholder="Enter Experience" />
							<form:errors path="experience" cssClass="invalid-feedback"
								element="div" />
							<small id="experienceHelp" class="form-text text-muted">How
								many years of experience do you have?</small>
						</div>

						<div class="form-group">
							<label for="aboutYou">About You</label>
							<form:textarea path="aboutYou" cssClass="form-control"
								id="aboutYou" rows="3" aria-describedby="aboutYou"
								placeholder="Enter About You" />
							<form:errors path="aboutYou" cssClass="invalid-feedback"
								element="div" />
							<small id="aboutYouHelp" class="form-text text-muted">Write
								about yourself</small>
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

