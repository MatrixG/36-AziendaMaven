<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>



<c:choose>
	<c:when test="${utente.getRuolo() == 0 && utente.isValid()}">

<html>
<head>
<jsp:include page="../block/header.jsp"></jsp:include>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/admin/js/checkInsertEmploy.js"></script>
</head>


<body>

	<jsp:include page="../block/topBar.jsp"></jsp:include>

	<div class="row">

		<jsp:include page="menu/menuLaterale.jsp"></jsp:include>

		<div id="content" class="col-lg-10 col-sm-10">
			<!-- content starts -->
			<div>
				<ul class="breadcrumb">
					<li><a href="#">Home</a></li>
					<li><a href="#">Dashboard</a></li>
				</ul>
			</div>

			<div class="row">

				<div id="content" class="col-md-12 col-md-offset-2">
					<div class="box col-md-6">
						<div class="box-inner">
							<div class="box-header well">
								<h2>
									<i class="glyphicon glyphicon-edit"></i>&nbsp;&nbsp;Registrazione
									Nuovo Dipendente
								</h2>
							</div>
							<div class="box-content">
								<form role="form"
									action="${pageContext.request.contextPath}/admin/do/doRegistrazioneDipendente.jsp"
									method="post">

									<div class="form-group">
										<label for="inputNome">Nome: </label><input
											type="text" class="form-control" id="inputNome"
											placeholder="Nome" name="nome" title="Prova messaggio">
									</div>
									<div class="form-group">
										<label for="inputCognome">Cognome:</label><input type="text"
											class="form-control" id="inputCognome" placeholder="Cognome"
											name="cognome">
									</div>
									<div class="form-group">
										<label for="inputStipendio">Stipendio:</label><input
											type="text" class="form-control" id="inputStipendio"
											placeholder="Stipendio" name="stipendio">
									</div>
									<div class="form-group">
										<label for="inputPosizione">Posizione:</label><input
											type="text" class="form-control" id="inputPosizione"
											placeholder="Posizione" name="posizione">
									</div>
									<div class="form-group">
										<label for="inputEmail">Email address:</label><input
											type="email" class="form-control" id="inputEmail"
											placeholder="Enter email" name="username">
									</div>
									<div class="form-group">
										<label for="inputPassword">Password:</label><input
											type="password" class="form-control" id="inputPassword"
											placeholder="Password" name="password">
									</div>
									<div align="right">
										<button type="submit" class="btn btn-default">Registra</button>
									</div>
								</form>
							</div>

							<%
								if (request.getAttribute("error") != null) {
							%>
							<c:choose>
								<c:when test="${error == 1}">
									<br>Errore nell'inserimento del Dipendente!
    			</c:when>
								<c:when test="${error == 2}">
									<br>Username gi� utilizzato
   				</c:when>
							</c:choose>
							<%
								}
							%>

						</div>
					</div>
				</div>
			</div>
		</div>
		<!--/#content.col-md-0-->

	</div>


	<hr>
	<jsp:include page="../block/footer.jsp"></jsp:include>

	<jsp:include page="../block/scriptEnd.jsp"></jsp:include>
</body>
		</html>

	</c:when>
	<c:otherwise>
		<c:redirect url="../sessioneScaduta.jsp"></c:redirect>
	</c:otherwise>
</c:choose>