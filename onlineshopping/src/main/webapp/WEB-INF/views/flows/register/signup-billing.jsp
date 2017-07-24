<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@include file="../shared/flows-header.jsp"%>

	<div class="container">
		<div class="row">
			<div clas="col-md-6 col-md-offset-3">
				<div class="panel panel-primary">
					<!-- header -->
					<div class="panel-heading">
						<h4>Sign Up : Address</h4>
					</div>
					
					<!-- body -->
					<div class="panel-body">
						<sf:form method="POST" class="form-horizontal" id="billing"	modelAttribute="address">
							<!-- address 1 -->
							<div class="form-group">
								<label class="control-label col-md-4" for="addressLineOne">Address Line One</label>
								<div class="col-md-8">
									<sf:input id="addressLineOne" type="text" path="addressLineOne" class="form-control" placeholder="Enter Address Line One"></sf:input>
									<sf:errors path="addressLineOne" cssClass="help-block" element="em" />
								</div>							
							</div>
							<!-- address 2 -->
							<div class="form-group">
								<label class="control-label col-md-4" for="addressLineTwo">Address Line Two</label>
								<div class="col-md-8">
									<sf:input id="addressLineTwo" type="text" path="addressLineTwo" class="form-control" placeholder="Enter Address Line Two"></sf:input>
									<sf:errors path="addressLineTwo" cssClass="help-block" element="em" />
								</div>							
							</div>
							<!-- city -->
							<div class="form-group">
								<label class="control-label col-md-4" for="city">City</label>
								<div class="col-md-8">
									<sf:input id="city" type="text" path="city" class="form-control" placeholder="City"></sf:input>
									<sf:errors path="city" cssClass="help-block" element="em" />
								</div>							
							</div>
							
							<!-- state -->
							<div class="form-group">
								<label class="control-label col-md-4" for="state">State</label>
								<div class="col-md-8">
									<sf:input id="state" type="text" path="state" class="form-control" placeholder="State"></sf:input>
									<sf:errors path="state" cssClass="help-block" element="em" />
								</div>							
							</div>
							
							<!-- country -->
							<div class="form-group">
								<label class="control-label col-md-4" for="country">Country</label>
								<div class="col-md-8">
									<sf:input id="country" type="text" path="country" class="form-control" placeholder="Country"></sf:input>
									<sf:errors path="country" cssClass="help-block" element="em" />
								</div>							
							</div>
							
							<!-- zip -->
							<div class="form-group">
								<label class="control-label col-md-4" for="zip">Zip code</label>
								<div class="col-md-8">
									<sf:input id="zip" type="text" path="zipCode" class="form-control" placeholder="Zip Code"></sf:input>
									<sf:errors path="zipCode" cssClass="help-block" element="em" />
								</div>							
							</div>
							
							<!-- go back to personal info / register success -->
							<div class="form-group ">
								<div class="col-md-offset-4 col-md-4 ">
									<!-- back to personal -->
									<button type="submit" name="_eventId_registerEntry" id="backToPersonal" class="btn btn-primary form-control"><span class="glyphicon glyphicon-chevron-left"></span>Back to personal info</button>
								</div>								
								<div class="col-md-4 ">									
									<!-- confirm success -->
									<button type="submit" name="_eventId_confirm" id="confirm" class="btn btn-warning form-control">Done! Let's confirm!!</button>										
								</div>								
							</div>
						</sf:form>
					</div>
					
					
				</div>
			</div>
		</div>
	</div>

<%@include file="../shared/flows-footer.jsp"%>