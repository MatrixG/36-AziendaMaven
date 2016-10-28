<%@ page import="it.alfasoft.bean.Cliente"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


<c:choose>
  <c:when test="${utente.isValid() && utente.getRuolo() == 2}">	

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="Stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/styles.css">

<title>Home Cliente</title>
</head>
<body>

	<div id="Container">
<%-- 		<%Cliente c = (Cliente) session.getAttribute("cliente"); %> <%= c.getNome()  %> --%>
		
		<div id="header">
			<h1>Benvenuto <c:out value=" ${utente.getNome()}"></c:out></h1>

		</div>


		<div class="menu">

			<jsp:include page="menu/menuLateraleCliente.jsp"></jsp:include>

		</div>
		<div id="content">
			<h1>Welcome to Cliente HomePage</h1>
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