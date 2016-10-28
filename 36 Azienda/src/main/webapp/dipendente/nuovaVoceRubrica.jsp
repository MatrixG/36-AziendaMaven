<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html >

<c:choose>
  <c:when test="${utente.isValid() && utente.getRuolo() == 1}">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="Stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/styles.css">

<title>Aggiungi una contatto</title>
</head>
<body>

	<div id="Container">

		<div id="header">
			<h1>Pagina personale di <%= request.getAttribute("name")%></h1>

		</div>


		<div class="menu">

			<jsp:include page="menu/menuLateraleDipendente.jsp"></jsp:include>

		</div>
		<div id="content">
			<h1>Aggiungi un contatto</h1>

			<form action="do/doAggiungiVoce.jsp" method="post">

				Nome: <input type="text" name="nome" required  /><br> 
				Cognome: <input type="text" name="cognome" /><br> 
				Telefono: <input type="text" name="telefono" required /><br><br>
				
				<input type="submit" value="Aggiungi Contatto" />
			</form>

			<%
			if (request.getAttribute("error") != null){
			%>		
			<c:choose>
				<c:when test="${error == 1}">
       				<br>Errore nell'inserimento del Contatto!
    			</c:when>
			</c:choose>
			<%
			}
			%>

		</div>
		<div id="footer2">
			<h1>Footer</h1>

		</div>


	</div>
	<!--  end of container -->
</body>
</html>

 </c:when>
<c:otherwise>
	<c:redirect url="../sessioneScaduta.jsp"></c:redirect>
  </c:otherwise>
</c:choose>