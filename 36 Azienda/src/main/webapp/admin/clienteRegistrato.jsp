<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:choose>
	<c:when test="${utente.getRuolo() == 0 && utente.isValid()}">

<html>
<head>
<jsp:include page="../block/header.jsp"></jsp:include>		
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

			<div class="row" id="prova">
				<div id="content">
					<div class="box col-md-6">
						<div class="box-inner">
							<div class="box-header well">
								<h2>
									<i class="glyphicon glyphicon-edit"></i>&nbsp;&nbsp;Registrazione
									Nuovo Cliente
								</h2>
							</div>
							<div class="box-content">
								<div class="page-header" align="center">
									<h1>
										<small>Registrazione avvenuta correttamente</small>
									</h1>
								</div>
							</div>
						</div>
					</div>
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