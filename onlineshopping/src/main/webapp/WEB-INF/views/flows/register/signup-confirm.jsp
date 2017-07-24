<%@include file="../shared/flows-header.jsp"%>
	<div class="row">
		<div class="col-sm-6">
			<div class="panel panel-primary">
				<div class="panel-heading">
					<h4>Personal Detail</h4>
				</div>
				<div class="panel-body">
					
				</div>
				<div class="panel-footer">
					<a href="${flowExecutionUrl}&_eventId_registerEntry" class="btn btn-primary">Personal Info</a>					
				</div>
			</div>
		</div>
		
		<div class="col-sm-6">
			<div class="panel panel-primary">
				<div class="panel-heading">
					<h4>Billing Address</h4>
				</div>
				<div class="panel-body">
					
				</div>
				<div class="panel-footer">
					<a href="${flowExecutionUrl}&_eventId_billing2" class="btn btn-primary">Address</a>
				</div>
			</div>
		</div>
	</div>
	
	<div class="row">
		<div class="col-sm-4 col-sm-offset-4">
			<div class="text-center">
				<a href="${flowExecutionUrl}&_eventId_success" class="btn btn-primary">Confirm</a>
			</div>
		</div>	
	</div>
<%@include file="../shared/flows-footer.jsp"%>