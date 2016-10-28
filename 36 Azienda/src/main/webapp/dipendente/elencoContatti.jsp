<%@ page import = "it.alfasoft.bean.Cliente" %>
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


<title>Admin Page</title>
</head>
<body>

	<div id="Container">

		<div id="header">
			<h1>Home Page Admin</h1>

		</div>


		<div class="menu">

			<jsp:include page="menu/menuLateraleDipendente.jsp"></jsp:include>

		</div>
		<div id="content">
			<h1>Elenco utenti</h1>

	<table border="1px" align="center">

		<thead>

			<tr>
              <th>Nome</th> <th>Cognome</th>
              <th>Username</th> <th>Partita IVA</th>
              <th>Ragione Sociale</th>
			</tr>

		</thead>
		
	     <c:forEach var="c"   items="${clienti}">
	        <tr>
	        <td>
	        ${c.nome}
	        </td> 
	        <td>
	        ${c.cognome}
	        </td>
	        <td>
	        ${c.username}
	        </td>
	        <td>
	        ${c.pIva}
	        </td>
	        <td>
	        ${c.ragSociale}
	        </td>
	        </tr>
	     </c:forEach>
	
	</table>
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