<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!doctype html>
<html lang="en">
<head>
<jsp:include page="../header.jsp" />
<title>Registration Form</title>
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
		<jsp:include page="./navbar.jsp" />
		<div class="jumbotron">
			<form:form modelAttribute="user"
				action="${pageContext.request.contextPath}/admin/add">

				<form:hidden path="role" value="ROLE_ADMIN"/>

				<div class="card">
					<div class="card-body">
						<h5 class="card-title">Add new Admin</h5>

						<div class="form-group">
							<form:input path="username" cssClass="form-control" id="username"
								aria-describedby="username" placeholder="Enter username" />
							<form:errors path="username" cssClass="invalid-feedback"
								element="div" />
						</div>

						<div class="form-group">
							<form:password path="password" cssClass="form-control"
								id="password" placeholder="Enter password" />
							<form:errors path="password" cssClass="invalid-feedback"
								element="div" />
						</div>

						<div class="form-group">
							<form:password path="retypePassword" cssClass="form-control"
								id="retypePassword" aria-describedby="retypePassword"
								placeholder="Retype Password" />
							<form:errors path="retypePassword" cssClass="invalid-feedback"
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