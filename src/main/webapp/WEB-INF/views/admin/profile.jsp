<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!doctype html>
<html lang="en">
<head>
<jsp:include page="../header.jsp" />
<title>Admin Home</title>
</head>
<body>
	<div class="container">
		<jsp:include page="./navbar.jsp" />
		<div class="jumbotron">
			<div class="card">
				<div class="card-body">
					<h5 class="card-title">${user.firstName}</h5>
					 <h6 class="card-subtitle mb-2 text-muted">${user.profileTitle}</h6>
					<p class="card-text">${user.aboutYou}</p>
				</div>
				<ul class="list-group list-group-flush">
					<li class="list-group-item">job Seeker Id:
						${user.jobSeekerId}</li>
					<li class="list-group-item">First Name: ${user.firstName}</li>
					<li class="list-group-item">Last Name: ${user.lastName}</li>
					<li class="list-group-item">Skills: ${user.skills}</li>

					<li class="list-group-item">Phone: ${user.phone}</li>
					<li class="list-group-item">Email: ${user.email}</li>
					<li class="list-group-item">Experience ${user.experience}</li>

					<li class="list-group-item">Username:
						${user.user.username}</li>
					<li class="list-group-item">Password: ********</li>

				</ul>
				<div class="card-body">
					<a href="#" class="card-link">Edit Profile</a>
					<a href="#" class="card-link">Delete Profile</a>
				</div>
			</div>
		</div>
	</div>
	<jsp:include page="../footer.jsp" />
</body>
</html>