<%@ page import="it.alfasoft.service.Servizi"%>
<%@ page import="it.alfasoft.bean.Utente"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


    <jsp:useBean id="utente" class = "it.alfasoft.bean.Utente" scope = "session" />
    <jsp:setProperty property="*" name="utente"/>
    
    <%
		
    	Servizi service = new Servizi();
// 		Setto lo username tutto minuscolo
		utente.setUsername(utente.getUsername().toLowerCase());
		String psw = utente.getPassword();
    	psw = service.convertiPsw(psw);
    	utente.setPassword(psw);
    	Utente u = service.loginUtente(utente);
    	if (u != null){
    		request.setAttribute("scelta", u.getRuolo());
    		%>
    		    <jsp:forward page="doChooseLogin.jsp"></jsp:forward>
    		<%
    	} else {
		    %>
		    <c:set var="error" scope = "request" value = "1"></c:set>
		    <jsp:forward page="login.jsp"></jsp:forward>
		    <%
		}
		    %>