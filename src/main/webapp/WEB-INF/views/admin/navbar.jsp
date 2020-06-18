<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<nav class="navbar navbar-expand-lg navbar-dark"
	style="background-color: #0179a8; border-bottom: 1px solid #346cb0">
	<a class="navbar-brand" href="${pageContext.request.contextPath}/">Genuine
		Hire</a>
	<button class="navbar-toggler" type="button" data-toggle="collapse"
		data-target="#navbarSupportedContent"
		aria-controls="navbarSupportedContent" aria-expanded="false"
		aria-label="Toggle navigation">
		<span class="navbar-toggler-icon"></span>
	</button>

	<div class="collapse navbar-collapse" id="navbarSupportedContent">
		<ul class="navbar-nav mr-auto">
			<li class="nav-item active">
				<a class="nav-link" href="${pageContext.request.contextPath}/home">
					Home
					<span class="sr-only">(current)</span>
				</a>
			</li>
			<li class="nav-item">
				<a class="nav-link" href="${pageContext.request.contextPath}/admin/profile">My Profile</a>
			</li>

			<li class="nav-item">
				<a class="nav-link" href="${pageContext.request.contextPath}/admin/add">Add Admin</a>
			</li>

			<li class="nav-item dropdown">
				<a class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
					role="button" data-toggle="dropdown" aria-haspopup="true"
					aria-expanded="false"> Search </a>
				<div class="dropdown-menu" aria-labelledby="navbarDropdown">
					<a class="dropdown-item"
						href="${pageContext.request.contextPath}/admin/jobSeekerSearch">Job Seeker
						Search</a>
					<a class="dropdown-item"
						href="">Employer Search</a>
				</div>
			</li>

		</ul>

		<form action="<%=request.getContextPath()%>/logout" method="post"
			class="form-inline my-2 my-lg-0">
<%-- 			<div class="btn my-2 my-sm-0" style="color:#fff">Welcome, <sec:authentication property="name"/></div>
 --%>			<button class="btn btn-outline-light my-2 my-sm-0" type="submit">Logout</button>
		</form>
	</div>
</nav>