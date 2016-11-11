<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="it.alfasoft.bean.Cliente"%>

<c:choose>
	<c:when test="${utente.getRuolo() == 0 && utente.isValid()}">

<html>
<head>
<jsp:include page="../block/header.jsp"></jsp:include>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/admin/js/tabellaDipendenti.js"></script>
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
				<div class="box col-md-9">
					<div class="box-inner">
						<div class="box-header well" data-original-title="">
							<h2>
								<i class="glyphicon glyphicon-user"></i> Elenco dei Dipendenti
							</h2>
						</div>
					</div>
					<div class="box-content"></div>
					<table
						class="table table-striped table-bordered bootstrap-datatable datatable responsive">
						<thead>
							<tr>
								<th><div align="center">Nome</div></th>
								<th><div align="center">Cognome</div></th>
								<th><div align="center">Email</div></th>
								<th><div align="center">Posizione</div></th>
								<th><div align="center">Stipendio</div></th>
								<th><div align="center">Modifica</div></th>
							</tr>
						</thead>
						<tbody>

							<c:forEach var="d" items="${dipendenti}">
								<tr>
									<td><div align="center">${d.nome}</div></td>
									<td><div align="center">${d.cognome}</div></td>
									<td><div align="center">${d.username}</div></td>
									<td><div align="center">${d.posizione}</div></td>
									<td><div align="center">${d.stipendio}</div></td>
									<td class="center"><div align="center">
											<a class="btn btn-info" href="#"> <i
												class="glyphicon glyphicon-edit icon-white"></i> Edit
											</a>&nbsp;<a class="btn btn-danger" href="#"> <i
												class="glyphicon glyphicon-trash icon-white"></i> Delete
											</a>
										</div></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
			<!--/#content.col-md-0-->

		</div>
	</div>

	<div class="modal fade" id="modalDel" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">

		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">×</button>
					<h3>Cancella Dipendente</h3>
				</div>
				<div class="modal-body">
					<p>Sei sicuro di voler continuare?</p>
				</div>
				<div class="modal-footer">
					<a href="#" class="btn btn-default" data-dismiss="modal">Annulla</a>
					<a href="#" class="btn btn-primary" data-dismiss="modal">Cancella</a>
				</div>
			</div>
		</div>
	</div>

	<div class="modal fade" id="modalModify" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">

		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">×</button>
					<h3>Modifica Dipendente</h3>
				</div>
				<div class="modal-body">
					<div class="form-group">
						<label for="inputNome">Nome:</label> <input type="text"
							class="form-control" id="inputNome" placeholder="Nome"
							name="nome" >
					</div>
					<div class="form-group">
						<label for="inputCognome">Cognome:</label> <input type="text"
							class="form-control" id="inputCognome" placeholder="Cognome"
							name="cognome">
					</div>
					<div class="form-group">
						<label for="inputStipendio">Stipendio:</label> <input type="text"
							class="form-control" id="inputStipendio" placeholder="Stipendio"
							name="stipendio">
					</div>
					<div class="form-group">
						<label for="inputPosizione">Posizione:</label> <input type="text"
							class="form-control" id="inputPosizione" placeholder="Posizione"
							name="posizione">
					</div>
					<div class="form-group">
						<label for="inputEmail">Email address:</label> <input type="email"
							class="form-control" id="inputEmail" placeholder="Enter email"
							name="username">
					</div>
					<div class="form-group">
						<label for="inputPassword">Password:</label> <input
							type="password" class="form-control" id="inputPassword"
							placeholder="Password" name="password">
					</div>
				</div>
				<div class="modal-footer">
					<a href="#" class="btn btn-default" data-dismiss="modal">Annulla</a>
					<a href="#" class="btn btn-primary" data-dismiss="modal">Modifica</a>
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