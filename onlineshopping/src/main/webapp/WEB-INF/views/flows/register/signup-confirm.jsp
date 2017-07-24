<%@include file="../shared/flows-header.jsp"%>
<div class="row">
	<div class="col-sm-6">
		<div class="panel panel-primary">
			<div class="panel-heading">
				<h4>Personal Detail</h4>
			</div>
			<div class="panel-body">
				<div class="text-center">				
					<h4>Name: ${registerModel.getUser().getFirstName()}&#160
						${registerModel.getUser().getLastName()}</h4>
					<h4>Email: ${registerModel.getUser().getEmail()}</h4>
					<h4>Phone: ${registerModel.getUser().getPhone()}</h4>
					<h4>Role: ${registerModel.getUser().getRole()}</h4>
					<h4>Password:
					<c:forEach begin="0" end="${registerModel.getUser().getPassword().length() - 1}" var="val">
    					<c:out value="*"/>
					</c:forEach></h4>
				</div>
			</div>
			<div class="panel-footer">
				<a href="${flowExecutionUrl}&_eventId_registerEntry"
					class="btn btn-primary">Personal Info</a>
			</div>
		</div>
	</div>

	<div class="col-sm-6">
		<div class="panel panel-primary">
			<div class="panel-heading">
				<h4>Billing Address</h4>
			</div>
			<div class="panel-body"></div>
				<div class="text-center">
					<h4>Address: ${registerModel.getAddress().getAddressLineOne()},&#160${registerModel.getAddress().getAddressLineTwo() }</h4>
					<h4>City: ${registerModel.getAddress().getCity()}</h4>
					<h4>State: ${registerModel.getAddress().getState()}</h4>
					<h4>Country: ${registerModel.getAddress().getCountry()}</h4>
				</div>				
			<div class="panel-footer">
				<a href="${flowExecutionUrl}&_eventId_billing2"
					class="btn btn-primary">Address</a>
			</div>
		</div>
	</div>
</div>

<div class="row">
	<div class="col-sm-4 col-sm-offset-4">
		<div class="text-center">
			<a href="${flowExecutionUrl}&_eventId_submit"	class="btn btn-primary">Confirm</a>
		</div>
	</div>
</div>
<%@include file="../shared/flows-footer.jsp"%>