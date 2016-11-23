<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/font-awesome/css/font-awesome.min.css">
<c:choose>
	<c:when test="${utente.getRuolo() == 1 && utente.isValid()}">

<html>
<head>
	<jsp:include page="../block/header.jsp"></jsp:include>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/dipendente/js/gestioneCartelle.js"></script>
	
	<style>
	
	.myDiv {
	
		background-color: orange;
	}
	
	</style>
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
				<div class="box col-md-9 center">
					<label hidden="true" id="temp">${utente.getId()}</label> <label
						hidden="true" id="parentId"></label><label hidden="true"
						id="folderKey"></label>
					<div class="box-inner">
						<div class="box-header well">
							<h2>
								<i class="glyphicon glyphicon-info-sign"></i> Cartella Personale
							</h2>
						</div>
						<div class="box-content row">
							<div class="col-sm-8 myDiv">
								<button id="createFolder" class="btn btn-success btn-sm">
									<i class="glyphicon glyphicon-plus"></i> Aggiungi Cartella
								</button>
								<button id="deleteFolder" class="btn btn-danger btn-sm">
									<i class="glyphicon glyphicon-trash"></i> Elimina Cartella
								</button>
								<button id="upFolder" class="btn btn-info btn-sm">
									<i class="glyphicon glyphicon-arrow-up"></i> Cartella Superiore
								</button>
							</div>
							<div class="col-sm-6">

								<button id="selectAll" class="btn btn-primary btn-sm">
									<i class="glyphicon glyphicon-plus"></i> Seleziona Tutto
								</button>
								<button id="Annulla" class="btn btn-primary btn-sm">
									<i class="glyphicon glyphicon-trash"></i> Annulla
								</button>
								<button id="Cancella" class="btn btn-primary btn-sm">
									<i class="glyphicon glyphicon-arrow-up"></i> Cancella
								</button>
							</div>
						</div>
					</div>
					<div class="box-inner">
						<div class="box-header well">
							<div class="col-sm-8">
								<h2 id="directory"></h2>
							</div>

						</div>
						<div id="folderDiv" class="box-content row">
							<br />
						</div>
					</div>
					<div hidden="true" class="alert alert-success"></div>
					<div hidden="true" class="alert alert-warning"></div>
				</div>
			</div>
		</div>

	</div>

	<div class="modal fade" id="modalCreateFolder" tabindex="-1"
		role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">

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
					<a href="#" id="creaButton" class="btn btn-primary"
						data-dismiss="modal">Crea</a>
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