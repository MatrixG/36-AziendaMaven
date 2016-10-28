<%@ page import = "it.alfasoft.service.Servizi" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

    
    
    <jsp:useBean id = "dipendente" class = "it.alfasoft.bean.Dipendente" scope = "request" />
    <jsp:setProperty property = "*" name = "dipendente" />
    
    <%
    
    if (dipendente.isValid()){
    	
    	Servizi service = new Servizi();
    	
//     	Setto lo username tutto minuscolo
    	dipendente.setUsername(dipendente.getUsername().toLowerCase());
    	String psw = dipendente.getPassword();
    	psw = service.convertiPsw(psw);
    	dipendente.setPassword(psw);
    	
//      Chech se username già utilizzato
    	if (!service.checkUsername(dipendente.getUsername())) {
    		
    		request.setAttribute("error", "2");
    		%>
    		<jsp:forward page="../registrazioneNuovoDipendente.jsp" />
    		<%
    	}
    	
    	if (service.registraDipendente(dipendente)){
    		%>
    		<jsp:forward page="../dipendenteRegistrato.jsp" />
    		<%
    	}else{
    		
    		request.setAttribute("error", "1");
    		%>
    		<jsp:forward page="../registrazioneNuovoDipendente.jsp" />
    		<%
    	}
    }else{
    	request.setAttribute("error", "1");
		%>
		<jsp:forward page="../registrazioneNuovoDipendente.jsp" />
		<%
    }
     %>