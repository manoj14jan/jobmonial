<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!doctype html>
<html lang="en">
<head>
<jsp:include page="./header.jsp" />
<title>Genuine Hire Login</title>
</head>
<body>
	<div class="container">
		<jsp:include page="./navbar.jsp" />
		<div class="jumbotron">

			<div class="card">
				<div class="card-body">
					<h5 class="card-title">Login Form</h5>
					<h6 class="card-subtitle mb-2 text-muted">Fields are required
						which mark with *</h6>

					<form action="<%=request.getContextPath()%>/doLogin" method="post">
						<c:if test="${param.error ne null}">
							<div class="alert alert-danger" role="alert">Invalid
								Username and Password.</div>
						</c:if>
						<c:if test="${param.logout ne null}">
							<div class="alert alert-danger" role="alert">You have been
								logged out.</div>
						</c:if>
						<input type="hidden" name="${_csrf.parameterName}"
							value="${_csrf.token}" />
						<div class="form-group">
							<label for="loginUserId">Username</label>
							<input type="text" class="form-control" id="loginUserId"
								name="loginUserId" placeholder="Enter Username"
								aria-describedby="loginUserIdHelp">
							<small id="emailHelp" class="form-text text-muted">Enter
								your Username</small>
						</div>
						<div class="form-group">
							<label for="loginUserSecret">Password</label>
							<input type="password" class="form-control"
								name="loginUserSecret" placeholder="Enter Password"
								id="loginUserSecret">
						</div>
						<button type="submit" class="btn btn-primary">Sign In</button>
					</form>
				</div>
			</div>
		</div>
	</div>
	<jsp:include page="./footer.jsp" />
</body>
</html>

