<nav class="navbar navbar-expand-lg navbar-dark"
	style="background-color: #0179a8; border-bottom: 1px solid #346cb0">
	<a class="navbar-brand" href="${pageContext.request.contextPath}/">Genuine Hire</a>
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
				<a class="nav-link" href="#">Search Jobs</a>
			</li>
			<li class="nav-item dropdown">
				<a class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
					role="button" data-toggle="dropdown" aria-haspopup="true"
					aria-expanded="false"> Employer </a>
				<div class="dropdown-menu" aria-labelledby="navbarDropdown">
					<a class="dropdown-item"
						href="${pageContext.request.contextPath}/home">Employer Login</a>
					<a class="dropdown-item"
						href="${pageContext.request.contextPath}/register/employer">Employer
						Registration</a>
				</div>
			</li>
			<li class="nav-item dropdown">
				<a class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
					role="button" data-toggle="dropdown" aria-haspopup="true"
					aria-expanded="false"> Job Seeker </a>
				<div class="dropdown-menu" aria-labelledby="navbarDropdown">
					<a class="dropdown-item"
						href="${pageContext.request.contextPath}/home">Job Seeker
						Login</a>
					<a class="dropdown-item"
						href="${pageContext.request.contextPath}/register/jobseeker">Job
						Seeker Registration</a>
				</div>
			</li>
		</ul>
	</div>
</nav>