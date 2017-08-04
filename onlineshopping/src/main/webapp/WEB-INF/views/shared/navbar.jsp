<%@taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
	<div class="container">
		<!-- Brand and toggle get grouped for better mobile display -->
		<div class="navbar-header">
			<button type="button" class="navbar-toggle" data-toggle="collapse"
				data-target="#bs-example-navbar-collapse-1">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a id="home" class="navbar-brand" href="${contextRoot}">Start Bootstrap</a>
		</div>
		<!-- Collect the nav links, forms, and other content for toggling -->
		<div class="collapse navbar-collapse"
			id="bs-example-navbar-collapse-1">
			<ul class="nav navbar-nav">
				<li id="about"><a href="${contextRoot}/about">About</a></li>				
				
				<li id="contact"><a href="${contextRoot}/contact">Contact</a></li>
				
				<!-- all products link -->
				<li id="listProducts"><a href="${contextRoot}/show/all/products">View products</a></li>
				
				<!-- manage product link -->
				<security:authorize access="hasAuthority('ADMIN')">
					<li id="manageProducts"><a href="${contextRoot}/manage/products">Manage products</a></li>
				</security:authorize>
			</ul>
			
			<ul class ="nav navbar-nav navbar-right">
				
				<security:authorize access="isAnonymous()">
					<li id="register">
						<a href="${contextRoot}/register">Sign up</a>
					</li>
					
					<li id="logIn">
						<a href="${contextRoot}/login">Log in</a>
					</li>
				</security:authorize>
				
				<security:authorize access="isAuthenticated()">
				<li class="dropdown">
				 	<a href="javascript:void(0)" 
				 		class="btn dropdown-toggle" 
				 		id="dropdownMenu1" 
				 		data-toggle="dropdown">
				 		${userModel.getFullName()}
				 		<span class="caret"></span>
				 	</a>
				 	<ul class="dropdown-menu">
				 		<!-- only user will see the drop down -->
				 		<security:authorize access="hasAuthority('USER')">
					 		<li>
					 			<a href="${contextRoot}/cart">
					 				<span class="glyphicon glyphicon-shopping-cart"></span>
					 				<span class="badge">${userModel.getCart().getCartLines()}</span>   
					 				&#036; ${userModel.getCart().getGrandTotal()}
					 			</a>	
					 			<a href="javascript:void(0)"> my profile</a>							 		
					 		</li>
					 		
					 		<li class="divider" role="separator"></li>	
				 		</security:authorize>
				 		<li>
				 			<a href="${contextRoot}/logout">Logout</a>
				 		</li>			 	
				 	</ul>
				</li>
				</security:authorize>		
			</ul>
		</div>
		<!-- /.navbar-collapse -->
	</div>
	<!-- /.container -->
</nav>

<script>
	window.userRole = '${userModel.getRole()}';
</script>

