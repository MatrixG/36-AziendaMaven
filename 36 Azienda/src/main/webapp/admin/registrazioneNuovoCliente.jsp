<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html >


<c:choose>
  <c:when test="${utente.isValid() && utente.getRuolo() == 0}">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="Stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/styles.css">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<title>Aggiungi una Voce</title>
</head>
<body>

	<div id="Container">

		<div id="header">
			<h1>Aggiungi un nuovo Utente</h1>

		</div>


		<div class="menu">

			<jsp:include page="menu/menuLateraleAdmin.jsp"></jsp:include>

		</div>
		<div id="content">
			<h1>Registrazione Nuovo Cliente</h1>

			<form action="do/doRegistrazioneCliente.jsp" method="post">

				Nome: <input type="text" name="nome" required /><br> 
				Cognome: <input type="text" name="cognome" required /><br> 
				Ragione Sociale: <input type="text" name="ragSociale" required /><br>
				Partita IVA: <input type="text" name="pIva" required /><br>
				Username: <input type="text" name="username" required /><br>
				Password: <input type="password" name="password" required /><br>

				<input type="submit" value="Registra" />
			</form>

			<%
			if (request.getAttribute("error") != null){
			%>		
			<c:choose>
				<c:when test="${error == 1}">
       				<br>Errore nell'inserimento del Cliente!
    			</c:when>
				<c:when test="${error == 2}">
       				<br>Username già utilizzato
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
</body>
</html>

	</c:when>
	<c:otherwise>
		<c:redirect url="../sessioneScaduta.jsp"></c:redirect>
 	</c:otherwise>
</c:choose>