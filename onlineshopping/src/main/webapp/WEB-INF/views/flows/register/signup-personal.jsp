<%@include file="../shared/flows-header.jsp"%>
<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<!-- content -->
<div class="content">
	<!-- Page Content -->
	<!-- Home JSP -->
	<div class="container">
		<div class="row">
			<div class="col-md-offset-2 col-md-8">
				<div class="panel panel-primary">

					<!-- header -->
					<div class="panel-heading">

						<h4>Sign up</h4>

					</div>

					<!-- body -->
					<div class="panel-body">
						<sf:form method="POST" class="form-horizontal" id="registerForm" modelAttribute="user">
						
						
						</sf:form>
					</div>
				</div>
			</div>
		</div>
	</div>

	<%@include file="../shared/flows-footer.jsp"%>