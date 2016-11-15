<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


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

		<a class="navbar-brand"><span>Alfasoft 2016©</span></a>

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
				<div hidden="true" class="alert alert-warning">
					<strong>Attention!</strong> Incorrect Username or Password!
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
					<button id="buttonX" type="button" class="close"
						data-dismiss="modal">×</button>
					<h3>Contact Us</h3>
				</div>
				<div class="modal-body">
					<div class="form-group">
						<label for="inputNome">Name:</label> <input type="text"
							class="form-control" id="inputNome" data-container="body"
							data-toggle="popover" data-content="" data-placement="top"
							data-trigger="manual" maxlength="40" placeholder="Name">
						<span hidden="false" class="glyphicon form-control-feedback"></span>
					</div>
					<div class="form-group">
						<label for="inputCognome">Surname:</label> <input type="text"
							class="form-control" id="inputCognome" data-container="body"
							data-toggle="popover" data-content="" data-placement="top"
							data-trigger="manual" maxlength="40" placeholder="Surname">
						<span hidden="true" class="glyphicon form-control-feedback"></span>
					</div>
					<div class="form-group" id="emailForm">
						<label for="inputEmail">Email address:</label> <input type="email"
							class="form-control" id="inputEmail" data-container="body"
							data-toggle="popover" data-content="" data-placement="top"
							data-trigger="manual" maxlength="40" placeholder="Enter email">
						<span hidden="true" class="glyphicon form-control-feedback"></span>
					</div>
					<div class="form-group">
						<label for="selectMenu">Problem Type:</label> <select
							id="selectMenu" data-container="body" data-toggle="popover"
							data-content="" data-placement="top" data-trigger="manual"
							class="form-control">
							<option value="0">Select one of these</option>
							<option value="1">Lost my Username</option>
							<option value="2">Lost my Password</option>
							<option value="3">Lost my Username and Password</option>
							<option value="4">Other</option>
						</select>
					</div>
					<div id="commentForm" hidden="true" class="form-group">
						<label for="textArea">Additional informations:</label>
						<textarea id="textArea" data-container="body"
							data-toggle="popover" data-content="" data-placement="top"
							data-trigger="manual" class="form-control" rows="5"
							maxlength="300"></textarea>
						<p id="labelInfo" align="right">400 char left</p>
					</div>
				</div>
				<div class="modal-footer">
					<a id="buttonCancel" class="btn btn-default" data-dismiss="modal">Cancel</a>
					<a id="buttonSend" class="btn btn-primary" data-dismiss="modal">Send</a>
				</div>
			</div>
		</div>
	</div>

	<c:if test="${error != null}">
		<c:choose>
			<c:when test="${error == 1 }">
				<script type="text/javascript">
					var counter = 0;
					var id;
					$(".alert-warning").fadeIn("slow");

					id = setInterval(function() {
						counter++;
						if (counter > 6) {
							clearInterval(id);
							$(".alert-warning").fadeOut("slow");
						}
					}, 1000);
				</script>
			</c:when>
		</c:choose>
	</c:if>

</body>

<jsp:include page="block/scriptEnd.jsp"></jsp:include>
<script src="jsMine/login2.js">
	
</script>
</html>