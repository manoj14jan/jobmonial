<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%--
  Created by IntelliJ IDEA.
  User: Perry Luigi
  Date: 6/17/2020
  Time: 4:00 PM
  To change this template use File | Settings | File Templates.
--%>

<html>
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
    <jsp:include page="navbar.jsp" />
    <div class="jumbotron">
        <form:form modelAttribute="jobSeeker">
            <div class="card">
                <div class="card-body">
                    <h5 class="card-title">JobSeeker Search</h5>

                    <div class="form-group">
                        <form:input path="profileTitle" cssClass="form-control" id="profileTitle"
                        aria-describedby="profileTitle" placeholder="Job Title" />
                        <form:errors path="profileTitle" cssClass="invalid-feedback" element="div" />
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


