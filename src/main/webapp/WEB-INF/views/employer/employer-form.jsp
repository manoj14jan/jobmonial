<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html lang="en">
<head>
    <jsp:include page="../header.jsp" />
    <title>Employer Registration</title>
</head>
<body>
<div class="container">
    <jsp:include page="./employer-navbar.jsp" />
    <form:form modelAttribute="employer" method="post" action="${pageContext.request.contextPath}/employer/profile/save">
        <div class="card">
            <form:errors path="*" cssClass="alert alert-danger"/>
        </div>
        <div class="card">
            <div class="card-body">
                <h5 class="card-title">Employer Registration</h5>
                <h6 class="card-subtitle mb-2 text-muted">Fields are required
                    which mark with *</h6>
                <form>

                    <div class="form-group">
                        <label for="name">First Name*</label>
                        <form:input path="name" cssClass="form-control"
                                    id="name" aria-describedby="name"
                                    placeholder="Enter First Name" />
                    </div>

                    <div class="form-group">
                        <label for="surname">Last Name</label>
                        <form:input path="surname" cssClass="form-control" id="surname"
                                    aria-describedby="surname" placeholder="Enter Last Name" />
                    </div>

                    <div class="form-group">
                        <label for="phone">Phone*</label>
                        <form:input path="phone" cssClass="form-control" id="phone"
                                    aria-describedby="phone" placeholder="Enter Phone" />
                    </div>

                    <div class="form-group">
                        <label for="email">Email*</label>
                        <form:input path="email" type="text" class="form-control"
                                    id="email" aria-describedby="email" placeholder="Enter Email" />
                    </div>

                    <div class="form-group">
                        <label for="aboutYou">About You</label>
                        <form:textarea path="aboutYou" cssClass="form-control"
                                       id="aboutYou" rows="3" aria-describedby="aboutYou"
                                       placeholder="Enter About You" />
                        <small id="aboutYouHelp" class="form-text text-muted">Write
                            about yourself</small>
                    </div>

                    <button type="submit" class="btn btn-primary">Submit</button>
                </form>
            </div>
        </div>
    </form:form>

</div>
<jsp:include page="../footer.jsp" />
</body>
</html>
