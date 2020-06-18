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
    <jsp:include page="./navbar.jsp" />
    <div class="jumbotron">
        <form:form modelAttribute="employer">
            <div class="card">
                <div class="card-body">
                    <h5 class="card-title">Employer Search</h5>
                    <div class="form-group">
                        <form:input path="name" cssClass="form-control" id="name"
                        aria-describedby="name" placeholder="Username, or" />
                        <form:errors path="name" cssClass="invalid-feedback" element="div" />
                    </div>
                    <%-- <div class="form-group">
                        <form:input path="company" cssClass="form-control" id="company"
                        aria-describedby="company" placeholder="Job Title" />
                        <form:errors path="company" cssClass="invalid-feedback" element="div" />
                    </div> --%>

                    <button type="submit" class="btn btn-primary">Submit</button>

                </div>
            </div>
        </form:form>
    </div>
</div>
<jsp:include page="../footer.jsp" />
</body>
</html>


