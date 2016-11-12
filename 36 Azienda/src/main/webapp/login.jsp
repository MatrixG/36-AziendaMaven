<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<jsp:include page="block/header.jsp"></jsp:include>
<title>Login Page</title>

<style>
body {
	background-image: url(images/background-blue3.jpg);
}
</style>

</head>
<body>

	<div class="ch-container">

		<a class="navbar-brand"><span>Alfasoft S.r.l. 2016©</span></a>

		<div class="row">
			<div class="col-md-12 center login-header"></div>
			<!--/span-->
		</div>
		<!--/row-->

		<div class="row">
			<br /> <br /> <br />
			<div class="well col-md-5 center login-box">

				<form class="form-horizontal" action="doLogin.jsp" method="post">
					<fieldset>
						<div class="input-group input-group-lg">
							<span class="input-group-addon"><i
								class="glyphicon glyphicon-user red"></i></span> <input type="text"
								class="form-control" placeholder="Username" name="username">
						</div>
						<div class="clearfix"></div>
						<br>

						<div class="input-group input-group-lg">
							<span class="input-group-addon"><i
								class="glyphicon glyphicon-lock red"></i></span> <input type="password"
								class="form-control" placeholder="Password" name="password">
						</div>
						<div class="clearfix"></div>
						<div class="clearfix"></div>

						<p class="center col-md-5">
							<button type="submit" class="btn btn-primary">Login</button>
						</p>
						<a id="help">Need Help?</a>

					</fieldset>

				</form>
				<br />
				<div hidden="true" class="alert alert-success">
					<strong>Success!</strong> You'll have an answer in the coming hours
				</div>
				<div hidden="true" class="alert alert-danger">
					<strong>Attention!</strong> The request was not submitted!
				</div>
			</div>
			<!--/span-->
		</div>
		<!--/row-->


	</div>
	<!--/.fluid-container-->

	<div class="modal fade" id="modalContact" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">

		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">×</button>
					<h3>Contact Us</h3>
				</div>
				<div class="modal-body">
					<div class="form-group">
						<label for="inputNome">Name:</label> <input type="text"
							class="form-control" id="inputNome" placeholder="Nome"
							name="nome">
					</div>
					<div class="form-group">
						<label for="inputCognome">Surname:</label> <input type="text"
							class="form-control" id="inputCognome" placeholder="Cognome"
							name="cognome">
					</div>
					<div class="form-group">
						<label for="inputEmail">Email address:</label> <input type="email"
							class="form-control" id="inputEmail" placeholder="Enter email"
							name="username">
					</div>
					<div class="form-group">
						<label for="selectMenu">Problem Type:</label> <select
							id="selectMenu" class="form-control">
							<option>Select one of these</option>
							<option>Lost my Username</option>
							<option>Lost my Password</option>
							<option>Lost my Username and Password</option>
							<option>Other</option>
						</select>
					</div>
					<div id="commentForm" hidden="true" class="form-group">
						<label for="additionalInfo">Additional informations:</label>
						<textarea class="form-control" rows="5" id="additionalInfo"></textarea>
					</div>
				</div>
				<div class="modal-footer">
					<a class="btn btn-default" data-dismiss="modal">Cancel</a> <a
						id="buttonSend" class="btn btn-primary" data-dismiss="modal">Send</a>
				</div>
			</div>
		</div>
	</div>

</body>

<jsp:include page="block/scriptEnd.jsp"></jsp:include>
<script src="jsMine/login.js">
	
</script>
</html>