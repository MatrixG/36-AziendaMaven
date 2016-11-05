<%@ page import = "it.alfasoft.service.ServiziRubrica" %>
<%@ page import = "it.alfasoft.bean.Utente" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

    
    
    <jsp:useBean id = "voce" class = "it.alfasoft.bean.Voce" scope = "request" />
    <jsp:setProperty property = "*" name = "voce" />
    
    <%
    
    if (voce.isValid()){
    	
    	ServiziRubrica service = new ServiziRubrica();
    	voce.setUtente(((Utente)session.getAttribute("utente")));
    	if (service.aggiungiVoce(voce)){
    		%>//
    		<jsp:forward page="../voceAggiunta.jsp" />
    		<%
    	}
    }
    	
    	request.setAttribute("error", "1");
		%>
		<jsp:forward page="../nuovaVoceRubrica.jsp" />
