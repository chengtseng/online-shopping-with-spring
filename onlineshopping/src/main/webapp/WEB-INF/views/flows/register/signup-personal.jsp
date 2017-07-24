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
						<sf:form method="POST" class="form-horizontal" id="registerForm"
							modelAttribute="user">
							<div class="form-group">
								<label class="control-label col-md-4" for="firstName">First
									Name</label>
								<div class="col-md-8">
									<!-- change input to sf:input, name attribute -> path(match model attributes' name) -->
									<sf:input type="text" path="firstName" id="firstName"
										placeholder="First Name" class="form-control" />
								</div>
							</div>

							<div class="form-group">
								<label class="control-label col-md-4" for="lastName">Last
									Name</label>
								<div class="col-md-8">
									<!-- change input to sf:input, name attribute -> path(match model attributes' name) -->
									<sf:input type="text" path="lastName" id="lastName"
										placeholder="Last Name" class="form-control" />
								</div>
							</div>

							<div class="form-group">
								<label class="control-label col-md-4" for="email">Email</label>
								<div class="col-md-8">
									<!-- change input to sf:input, name attribute -> path(match model attributes' name) -->
									<sf:input type="text" path="email" id="email"
										placeholder="email" class="form-control" />
								</div>
							</div>
							
							<div class="form-group">
								<label class="control-label col-md-4" for="phone">Phone</label>
								<div class="col-md-8">
									<sf:input type="text" id="phone" path="phone"
										placeholder="phone" class="form-control" />
								</div>
							</div>

							<div class="form-group">
								<label class="control-label col-md-4" for="password">Password</label>
								<div class="col-md-8">
									<sf:input type="text" id="password" path="password"
										placeholder="password" class="form-control" />
								</div>
							</div>

						
							<div class="form-group">
								<label  class=" control-label radio-inline col-md-4" for="radioButtons" >User Type</label> 
								
								<div id="radioButtons">
									<label	class="radio-inline"> 
										<sf:radiobutton id="normalUser" path="role" value="USER"  checked="checked"/>Normal User	
									</label>
								
									<label class="radio-inline">
										 <sf:radiobutton id="suuplier" path="role" value="SUPPLIER"/> Supplier 
									</label>								
								</div>								
							</div>
							
							<div class="form-group">
								<div class="col-md-offset-1 col-md-10">
									<button type="submit" name="_eventId_billing" id="submit" class="btn btn-primary form-control">Next <span class="glyphicon glyphicon-chevron-right"></span></button>
								</div>
							</div>
						</sf:form>
					</div>
				</div>
			</div>
		</div>
	</div>

	<%@include file="../shared/flows-footer.jsp"%>