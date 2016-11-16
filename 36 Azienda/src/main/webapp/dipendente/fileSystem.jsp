<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<link rel="stylesheet" href="${pageContext.request.contextPath}/font-awesome/css/font-awesome.min.css">
<c:choose>
	<c:when test="${utente.getRuolo() == 1 && utente.isValid()}">

<html>
<head>
<jsp:include page="../block/header.jsp"></jsp:include>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/dipendente/js/gestioneCartelle.js"></script>
</head>	
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
				<div class="box col-md-11" align="center">
				<label hidden="true" id="temp">${utente.getId()}</label>
				
					<div class="box-inner">
						<div class="box-header well">
							<h2>
								<i class="glyphicon glyphicon-info-sign"></i> Cartella Personale
							</h2>
						</div>
						<div class="box-content row">
							<div class="col-sm-8">
								<button id = "createFolder" class="btn btn-default btn-sm">
									<i class="glyphicon glyphicon-plus"></i> Aggiungi Cartella
								</button>
								<button id = "deleteFolder" class="btn btn-default btn-sm">
									<i class="glyphicon glyphicon-trash"></i> Elimina Cartella
								</button>
								<button class="btn btn-default btn-sm">
									<i class="glyphicon glyphicon-arrow-up"></i> Cartella Superiore
								</button>
							</div>
						</div>
						<div class="box-content row">
							<div class="col-lg-7 col-md-12"></div>
							<i class="fa fa-camera-retro fa-4x"></i>
						</div>
					</div>
				</div>
			</div>
		</div>
		<!--/#content.col-md-0-->

	</div>

	<div class="modal fade" id="modalCreateFolder" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">

		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">×</button>
					<h3>Aggiungi Cartella</h3>
				</div>
				<div class="modal-body">
					<div class="form-group">
						<label for="inputNome">Nome:</label> <input type="text"
							class="form-control" id="inputNome" placeholder="Nome"
							name="nome">
					</div>
				</div>
				<div class="modal-footer">
					<a href="#" class="btn btn-default" data-dismiss="modal">Annulla</a>
					<a href="#" class="btn btn-primary" data-dismiss="modal">Crea</a>
				</div>
			</div>
		</div>
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