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
    <jsp:include page="./employer-navbar.jsp" />
    <div class="jumbotron">
        <div class="card">
            <div class="card-body">
                <h5 class="card-title">${employer.name}</h5>
                <p class="card-text">${employer.aboutYou}</p>
            </div>
            <ul class="list-group list-group-flush">
                <li class="list-group-item">job Seeker Id:
                    ${employer.id}</li>
                <li class="list-group-item">First Name: ${employer.name}</li>
                <li class="list-group-item">Last Name: ${employer.surname}</li>

                <li class="list-group-item">Phone: ${employer.phone}</li>
                <li class="list-group-item">Email: ${employer.email}</li>

                <li class="list-group-item">Username:
                    ${employer.user.username}</li>
                <li class="list-group-item">Password: ********</li>

            </ul>
            <div class="card-body">
                <a href="${pageContext.request.contextPath}/employer/profile/update" class="card-link">Edit Profile</a>
                <a href="${pageContext.request.contextPath}/employer/profile/delete" class="card-link">Delete Profile</a>
            </div>
        </div>
    </div>
</div>
<jsp:include page="../footer.jsp" />
</body>
</html>
