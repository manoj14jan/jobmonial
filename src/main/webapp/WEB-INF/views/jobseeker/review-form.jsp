<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html lang="en">
<head>
    <jsp:include page="../header.jsp" />
    <title>Job Seeker Registration</title>
</head>
<body>
<div class="container">
    <jsp:include page="./jobseeker-navbar.jsp" />
    <form:form modelAttribute="review">
        <div class="card">
            <div class="card-body">
                <h5 class="card-title">Review form</h5>
                <h6 class="card-subtitle mb-2 text-muted">Fields are required
                    which mark with *</h6>
                <form>
                    <div class="form-group">
                        <label for="company_code">company code*</label>
                        <form:input path="company_code" cssClass="form-control"
                                    id="company_code" aria-describedby="company_code"
                                    placeholder="company code" />
                    </div>

                    <div class="form-group">
                        <label for="interview_rating">interview rating*</label>
                        <form:input path="interview_rating" cssClass="form-control"
                                    id="interview_rating" aria-describedby="interview_rating"
                                    placeholder="rate 1 to 5" />
                    </div>

                    <div class="form-group">
                        <label for="salary_Rating">salary rating*</label>
                        <form:input path="salary_Rating" cssClass="form-control"
                                    id="salary_Rating" aria-describedby="salary_Rating"
                                    placeholder="rate 1 to 5" />
                    </div>


                    <div class="form-group">
                        <label for="work_life_Balance">work life Balance*</label>
                        <form:input path="work_life_Balance" cssClass="form-control" id="work_life_Balance"
                                    aria-describedby="work_life_Balance" placeholder="Enter Last Name" />

                    <div class="form-group">
                        <label for="comments">Comments*</label>
                        <form:textarea path="comments" cssClass="form-control"
                                       id="comments" rows="3" aria-describedby="comments"
                                       placeholder="write how the company's service was" />
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
