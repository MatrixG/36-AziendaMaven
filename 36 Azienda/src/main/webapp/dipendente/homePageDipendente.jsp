<%@ page import="it.alfasoft.bean.Utente"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


<c:choose>
  <c:when test="${utente.isValid() && utente.getRuolo() == 1}">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="Stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/styles.css">

<title>Home Dipendente</title>
</head>
<body>

	<div id="Container">

		<div id="header">
			<% Utente u = (Utente)session.getAttribute("utente"); %>
			<h1>Benvenuto <%= u.getNome() %></h1>

		</div>


		<div class="menu">

			<jsp:include page="menu/menuLateraleDipendente.jsp"></jsp:include>

		</div>
		<div id="content">
			<h1>Welcome to Dipendente HomePage</h1>
		</div>
		<div id="footer">
			<h1>Footer</h1>

		</div>
	</div>
</body>
</html>

 </c:when>
	<c:otherwise>
		<c:redirect url="../sessioneScaduta.jsp"></c:redirect>
	  </c:otherwise>
</c:choose>