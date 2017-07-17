<!-- Spring form library -->
<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<spring:url var="css" value="/resources/css" />
<div class="container">

	<div class="row">
		<c:if test="${not empty message}">
			<div class="col-xs-12">
				<div class="alert alert-success alert-dismissible">
					<button type="button" class="close" data-dismiss="alert">&times;</button>
					${message}
				</div>
			</div>
		</c:if>

		<div class="col-md-offset-2 col-md-8">

			<div class="panel panel-primary">

				<div class="panel-heading">

					<h4>Product Management</h4>

				</div>

				<div class="panel-body">
					<!-- FORM ELEMENT : Spring form-->
					<!-- use the model and view "product" object to map the form to the Product object -->
					<!-- modelAttribute attribute is the key which specifies a name of the model object that backs this form -->
					<sf:form class="form-horizontal" modelAttribute="product"
						action="${contextRoot}/manage/products" method="POST"
						enctype="multipart/form-data">
						<div class="form-group">
							<label class="control-label col-md-4" for="name">Enter
								Product Name</label>
							<div class="col-md-8">
								<!-- change input to sf:input, name attribute -> path(match model attributes' name) -->
								<sf:input type="text" path="name" id="name"
									placeholder="Product Name" class="form-control" />
								<sf:errors path="name" cssClass="help-block" element="em" />
							</div>
						</div>
						<div class="form-group">
							<label class="control-label col-md-4" for="brand">Enter
								Brand Name</label>
							<div class="col-md-8">
								<sf:input type="text" path="brand" id="brand"
									placeholder="Brand Name" class="form-control" />
								<sf:errors path="brand" cssClass="help-block" element="em" />
							</div>
						</div>
						<div class="form-group">
							<label class="control-label col-md-4" for="description">Product
								Description</label>
							<div class="col-md-8">
								<sf:textarea path="description" id="description"
									class="form-control"></sf:textarea>
								<sf:errors path="description" cssClass="help-block" element="em" />
							</div>
						</div>
						<div class="form-group">
							<label class="control-label col-md-4" for="unit-price">Unit
								price</label>
							<div class="col-md-8">
								<sf:input type="text" path="unitPrice" id="unitPrice"
									placeholder="Unit Price" class="form-control" />
								<sf:errors path="unitPrice" cssClass="help-block" element="em" />
							</div>
						</div>
						<div class="form-group">
							<label class="control-label col-md-4" for="quantity-available">Quantity
								Available</label>
							<div class="col-md-8">
								<sf:input type="text" path="quantity" id="quantity-available"
									placeholder="Quantity Available" class="form-control" />
							</div>
						</div>

						<!-- element for image upload -->
						<div class="form-group">
							<label class="control-label col-md-4" for="file">Select
								an Image</label>
							<div class="col-md-8">
								<sf:input type="file" placeholder="DDD" path="file" id="file"
									class="form-control" />
								<sf:errors path="file" cssClass="help-block" element="em" />
							</div>
						</div>

						<!-- show the browse input for file upload -->
						<div class="form-group">
							<label class="control-label col-md-4" for="category">Category</label>
							<div class="col-md-8">
								<sf:select class="form-control" id="categoryId"
									path="categoryId" items="${categories}" itemLabel="name"
									itemValue="id">
								</sf:select>
							</div>
						</div>

						<c:if test="${product.id == 0 }">
							<div class="form-group">
								<br />
								<div class="form-group">
									<div class="col-md-offset-1 col-md-10">
										<button type="button" data-toggle="modal"
											data-target="#CategoryModal" class="btn btn-warning btn-xs">Add
											Category</button>
									</div>
								</div>
							</div>
						</c:if>




						<div class="form-group">
							<div class="col-md-offset-1 col-md-10">
								<input type="submit" name="submit" id="submit" value="Submit"
									class="btn btn-primary form-control" />
							</div>
						</div>

						<!-- hidden attribute:
						set the other fields as the hidden otherwise it will return the default 
						values instead of original values.  
						-->
						<sf:hidden path="id" />
						<sf:hidden path="code" />
						<sf:hidden path="supplierId" />
						<sf:hidden path="active" />
						<sf:hidden path="purchases" />
						<sf:hidden path="views" />
					</sf:form>

				</div>

			</div>

		</div>

	</div>
	<!-- all products -->
	<div class="row">

		<div class="col-xs-12">
			<h3>Products in store</h3>
		</div>

		<div class="col-xs-12">
			<div style="overflow: auto">

				<table id="adminProductsTable"
					class="table table-striped table-bordered">
					<thead>
						<tr>
							<th>Id</th>
							<th>&#160;</th>
							<th>Name</th>
							<th>Brand</th>
							<th>Unit Price</th>
							<th>Quantity</th>
							<th>Active</th>
							<th>Edit</th>
						</tr>
					</thead>

					<tfoot>
						<tr>
							<th>Id</th>
							<th>&#160;</th>
							<th>Name</th>
							<th>Brand</th>
							<th>Unit Price</th>
							<th>Quantity</th>
							<th>Active</th>
							<th>Edit</th>
						</tr>

					</tfoot>

				</table>


			</div>
		</div>
	</div>

	<!-- Category dialog -->
	<div class="row">
		<!-- button : data-target="#CategoryModal" -->
		<div class="modal fade" id="CategoryModal" role="dialog" tabindex="-1">
			<div class="modal-dialog" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal">
							<span>&times;</span>
						</button>
						<h4 class="modal-title">Add New Category</h4>
					</div>
					<div class="modal-body">
						<!-- Category form -->
						<sf:form id="categoryForm" class="form-horizontal" modelAttribute="newCategory"
							action="${contextRoot}/manage/category" method="POST"
							enctype="multipart/form-data">
							
							<div class="form-group">
								<label for="c_name" class="control-label col-md-4">Category
									Name</label>
								<div class="col-md-8">
									<sf:input type="text" id="c_name" path="name"
										class="form-control" />
								</div>
							</div>
							
							<div class="form-group">
								<label for="c_description" class="control-label col-md-4">Category
									Description</label>
								<div class="col-md-8">
									<sf:textarea cols="" rows="5" id="c_description" path="description" class="form-control" />
								</div>
							</div>
							
							<div class="form-group">								
								<div class="col-md-offset-4 col-md-8">
									<input type="submit" value="Add the new Category" class="btn btn-primary" />
								</div>
							</div>
							
						</sf:form>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>