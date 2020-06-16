<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html lang="en">
<head>
<jsp:include page="../header.jsp" />
<title>Job Seeker Registration</title>
</head>
<body>
	<div class="container">
		<jsp:include page="./jobseeker-navbar.jsp" />
		<form:form modelAttribute="jobSeeker">
			<div class="card">
				<div class="card-body">
					<h5 class="card-title">Job Seeker Registration</h5>
					<h6 class="card-subtitle mb-2 text-muted">Fields are required
						which mark with *</h6>
					<form>

						<div class="form-group">
							<label for="firstName">First Name*</label>
							<form:input path="firstName" cssClass="form-control"
								id="firstName" aria-describedby="firstName"
								placeholder="Enter First Name" />
						</div>

						<div class="form-group">
							<label for="lastName">Last Name</label>
							<form:input path="lastName" cssClass="form-control" id="lastName"
								aria-describedby="lastName" placeholder="Enter Last Name" />
						</div>

						<div class="form-group">
							<label for="phone">Phone*</label>
							<form:input path="phone" cssClass="form-control" id="phone"
								aria-describedby="phone" placeholder="Enter Phone" />
						</div>

						<div class="form-group">
							<label for="email">Email*</label>
							<form:input path="email" type="text" class="form-control"
								id="email" aria-describedby="email" placeholder="Enter Email" />
						</div>

						<div class="form-group">
							<label for="profileTitle">Profile Title</label>
							<form:input path="profileTitle" cssClass="form-control"
								id="skills" aria-describedby="profileTitle"
								placeholder="Enter Profile Title" />
							<small id="profileTitleHelp" class="form-text text-muted">e.g.
								Senior Java Developer, Microsoft Developer ...</small>
						</div>

						<div class="form-group">
							<label for="skills">Skills</label>
							<form:input path="skills" cssClass="form-control" id="skills"
								aria-describedby="skills" placeholder="Enter Skills" />
							<small id="skillsHelp" class="form-text text-muted">e.g.
								Java, J2EE, Spring, Hibernate, HTML .....</small>
						</div>

						<div class="form-group">
							<label for="experience">Experience</label>
							<form:input path="experience" cssClass="form-control"
								id="experience" aria-describedby="experience"
								placeholder="Enter Experience" />
							<small id="passwordHelp" class="form-text text-muted">How
								many years of experience do you have?</small>
						</div>

						<div class="form-group">
							<label for="aboutYou">About You</label>
							<form:textarea path="aboutYou" cssClass="form-control"
								id="aboutYou" rows="3" aria-describedby="aboutYou"
								placeholder="Enter About You" />
							<small id="aboutYouHelp" class="form-text text-muted">Write
								about yourself</small>
						</div>

						<button type="submit" class="btn btn-primary">Submit</button>
					</form>
				</div>
			</div>
		</form:form>

	</div>
	<jsp:include page="../footer.jsp" />
</body>
</html>



