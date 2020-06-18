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
    <form:form modelAttribute="job" method="post" action="${pageContext.request.contextPath}/employer/job/update">
        <form:hidden path="id"/>
        <form:hidden path="companyName"/>
        <form:hidden path="employer.id"/>

        <div class="card">
            <form:errors path="*" cssClass="alert alert-danger"/>
        </div>

        <div class="card">
            <div class="card-body">
                <h5 class="card-title">Update Job</h5>
                <h6 class="card-subtitle mb-2 text-muted">Fields are required which mark with *</h6>

                <div class="form-group">
                    <label for="jobName">Job Name*</label>
                    <form:input path="jobName" cssClass="form-control" id="jobName" aria-describedby="jobName" placeholder="Enter Job Name" />
                </div>

                <div class="form-group">
                    <label for="jobDescription">Job Description*</label>
                    <form:input path="jobDescription" cssClass="form-control" id="jobDescription" aria-describedby="jobDescription" placeholder="Enter Job Description" />
                </div>

                <div class="form-group">
                    <label for="salary">Job Salary*</label>
                    <form:input path="salary" cssClass="form-control" id="salary" aria-describedby="salary" placeholder="Enter Job Salary" />
                </div>
                <button type="submit" class="btn btn-outline-primary">Submit</button>
            </div>
        </div>
    </form:form>
</div>
<jsp:include page="../footer.jsp" />
</body>
</html>
