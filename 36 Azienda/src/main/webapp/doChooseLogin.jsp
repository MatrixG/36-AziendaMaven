<%@ page import="it.alfasoft.service.Servizi"%>
<%@ page import="it.alfasoft.bean.Utente"%>
<%@ page import="it.alfasoft.bean.Dipendente"%>
<%@ page import="it.alfasoft.bean.Cliente"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Redirect Page</title>
</head>
<body>

	<%
	Servizi service = new Servizi();
	%>
	
	<c:choose>
		<c:when test="${scelta == 0}">
			<%
			Utente u = (Utente) session.getAttribute("utente");
			u = (Utente) service.riempiUtente(u.getUsername(), (Integer)request.getAttribute("scelta"));
			session.setAttribute("utente", u);
			%>
       		<jsp:forward page="admin/homePageAdmin.jsp"></jsp:forward>
   		</c:when>
		<c:when test="${scelta == 1}">
			<%
			Utente u = (Utente) session.getAttribute("utente");
			Dipendente d =(Dipendente) service.riempiUtente(u.getUsername(), (Integer)request.getAttribute("scelta"));
			session.setAttribute("utente", d);
			%>
			<jsp:forward page="dipendente/homePageDipendente.jsp"></jsp:forward>
    	</c:when>
    	<c:when test="${scelta == 2}">
    		<%
			Utente u = (Utente) session.getAttribute("utente");
			Cliente c =(Cliente) service.riempiUtente(u.getUsername(), (Integer)request.getAttribute("scelta"));
			session.setAttribute("utente", c);
			%>
			<jsp:forward page="cliente/homePageCliente.jsp"></jsp:forward>
    	</c:when>
    	<c:otherwise>
    		<%
    		request.setAttribute("error", "1");
		    %>
		    <jsp:forward page="login.jsp"></jsp:forward>
    	</c:otherwise>
	</c:choose>
</body>
</html>