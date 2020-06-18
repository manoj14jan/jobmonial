<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
<head>
    <jsp:include page="../header.jsp" />
    <title>Job Seeker Registration</title>
</head>
<body>
<div class="container">
    <jsp:include page="./employer-navbar.jsp" />
    <c:forEach items="${jobseekers}" var="elem">
        <div class="card">
            <div class="card-body">
                Name and Surname: <h5 class="card-title"> ${elem.firstName} ${elem.lastName}</h5>
                Profile Title: <h6 class="card-subtitle mb-2 text-muted">${elem.profileTitle}</h6>
                <p class="card-text">Skills: ${elem.skills}</p>
                <a href="${pageContext.request.contextPath}/employer/hire/${elem.jobSeekerId}/save" class="btn btn-outline-secondary btn-lg btn-block btn-sm">Hire</a>
            </div>
        </div>
    </c:forEach>
</div>
<jsp:include page="../footer.jsp" />
</body>
</html>
