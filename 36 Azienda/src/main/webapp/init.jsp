<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="it.alfasoft.service.Servizi"%>
<%@ page import="it.alfasoft.bean.Utente"%>
<%@ page import="it.alfasoft.bean.Voce"%>
<%@ page import="java.util.ArrayList"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>InitPage</title>
</head>
<body>

	<%
		Servizi service = new Servizi();
		String psw = service.convertiPsw("1987");
		Utente u = new Utente("Boaretto", "Alessandro", 0, "matrixg", psw, new ArrayList<Voce>());
		Utente admin = service.loginUtente(u);

		if (admin == null) {
			
			if (service.initialize(u)) {
	%>
	<h1>User Inizializzato!!</h1>
	<%
		}
		}
	%>



</body>
</html>