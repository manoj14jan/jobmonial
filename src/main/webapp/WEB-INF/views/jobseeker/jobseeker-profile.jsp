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
			<div class="card">
				<div class="card-body">
					<h5 class="card-title">${jobSeeker.firstName}</h5>
					 <h6 class="card-subtitle mb-2 text-muted">${jobSeeker.profileTitle}</h6>
					<p class="card-text">${jobSeeker.aboutYou}</p>
				</div>
				<ul class="list-group list-group-flush">
					<li class="list-group-item">job Seeker Id:
						${jobSeeker.jobSeekerId}</li>
					<li class="list-group-item">First Name: ${jobSeeker.firstName}</li>
					<li class="list-group-item">Last Name: ${jobSeeker.lastName}</li>
					<li class="list-group-item">Skills: ${jobSeeker.skills}</li>

					<li class="list-group-item">Phone: ${jobSeeker.phone}</li>
					<li class="list-group-item">Email: ${jobSeeker.email}</li>
					<li class="list-group-item">Experience ${jobSeeker.experience}</li>

					<li class="list-group-item">Username:
						${jobSeeker.user.username}</li>
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