<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import = "it.alfasoft.bean.Cliente" %>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>

<c:choose>
	<c:when test="${utente.getRuolo() == 1 && utente.isValid()}">

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

			<div class="row">

				<div class="box col-md-9">
					<div class="box-inner">
						<div class="box-header well" data-original-title="">
							<h2>
								<i class="glyphicon glyphicon-user"></i> Elenco dei Contatti
							</h2>
						</div>
					</div>
					<div class="box-content"></div>
					<table class="table table-striped table-bordered responsive">
						<thead>
							<tr>
								<th>Nome</th>
								<th>Cognome</th>
								<th>Telefono</th>
							</tr>
						</thead>
						<tbody>

							<c:forEach var="v" items="${voci}">
								<tr>
									<td>${v.nome}</td>
									<td>${v.cognome}</td>
									<td>${v.telefono}</td>
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