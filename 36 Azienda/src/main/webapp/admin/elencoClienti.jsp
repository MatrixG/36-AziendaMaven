<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="it.alfasoft.bean.Cliente"%>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>

<c:choose>
	<c:when test="${utente.getRuolo() == 0 && utente.isValid()}">

		<html>
<jsp:include page="../block/header.jsp"></jsp:include>

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

			<div class="row" id="prova">

				<div class="box col-md-10">
					<div class="box-inner">
						<div class="box-header well" data-original-title="">
							<h2>
								<i class="glyphicon glyphicon-user"></i> Elenco dei Clienti
							</h2>
						</div>
					</div>
					<div class="box-content"></div>
					<table id = "tableClienti" class="table table-striped table-bordered bootstrap-datatable datatable responsive">
						<thead>
							<tr>
								<th><div align="center">Nome</div></th>
								<th><div align="center">Cognome</div></th>
								<th><div align="center">Email</div></th>
								<th><div align="center">Partita IVA</div></th>
								<th><div align="center">Ragione Sociale</div></th>
								<th><div align="center">Modifica</div></th>
							</tr>
						</thead>
						<tbody>

							<c:forEach var="c" items="${clienti}">
								<tr>
									<td><div align="center">${c.nome}</div></td>
									<td><div align="center">${c.cognome}</div></td>
									<td><div align="center">${c.username}</div></td>
									<td><div align="center">${c.pIva}</div></td>
									<td><div align="center">${c.ragSociale}</div></td>
									<td class="center"><div align="center"><a class="btn btn-info" href="#"> <i
											class="glyphicon glyphicon-edit icon-white"></i> Edit
									</a> <a class="btn btn-danger" href="#"> <i
											class="glyphicon glyphicon-trash icon-white"></i> Delete
									</a></div></td>
								</tr>
							</c:forEach>

						</tbody>
					</table>
				</div>
			</div>
			<!--/#content.col-md-0-->

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