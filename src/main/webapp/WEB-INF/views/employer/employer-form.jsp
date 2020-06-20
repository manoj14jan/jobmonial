<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html lang="en">
<head>
<jsp:include page="../header.jsp" />
<title>Employer Registration</title>
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
			<form:form modelAttribute="employer" method="post"
				action="${pageContext.request.contextPath}/employer/profile/save">
				<form:hidden path="id" />
				<div class="card">
					<div class="card-body">
						<h5 class="card-title">Employer Registration</h5>
						<h6 class="card-subtitle mb-2 text-muted">Fields are required
							which mark with *</h6>
						<form>
							<div class="form-group">
								<label for="name">Company Name*</label>
								<form:input path="companyName" cssClass="form-control"
									id="companyName" aria-describedby="companyName"
									placeholder="Enter Company Name" />
								<form:errors path="companyName" cssClass="invalid-feedback"
									element="div" />
							</div>

							<div class="form-group">
								<label for="aboutYou">About Company</label>
								<form:textarea path="aboutCompany" cssClass="form-control"
									id="aboutYou" rows="3" aria-describedby="aboutYou"
									placeholder="Enter About You" />
								<form:errors path="aboutCompany" cssClass="invalid-feedback"
									element="div" />
								<small id="aboutYouHelp" class="form-text text-muted">Write
									about company</small>
							</div>

							<div class="form-group">
								<label for="name">First Name*</label>
								<form:input path="name" cssClass="form-control" id="name"
									aria-describedby="name" placeholder="Enter First Name" />
									<form:errors path="name" cssClass="invalid-feedback"
									element="div" />
							</div>

							<div class="form-group">
								<label for="surname">Last Name</label>
								<form:input path="surname" cssClass="form-control" id="surname"
									aria-describedby="surname" placeholder="Enter Last Name" />
								<form:errors path="surname" cssClass="invalid-feedback"
									element="div" />
							</div>

							<div class="form-group">
								<label for="phone">Phone*</label>
								<form:input path="phone" cssClass="form-control" id="phone"
									aria-describedby="phone" placeholder="Enter Phone" />
								<form:errors path="phone" cssClass="invalid-feedback"
									element="div" />
							</div>

							<div class="form-group">
								<label for="email">Email*</label>
								<form:input path="email" type="text" class="form-control"
									id="email" aria-describedby="email" placeholder="Enter Email" />
								<form:errors path="email" cssClass="invalid-feedback"
									element="div" />
							</div>
							<button type="submit" class="btn btn-primary">Submit</button>
						</form>
					</div>
				</div>
			</form:form>
		</div>
	</div>
	<jsp:include page="../footer.jsp" />
</body>
</html>
