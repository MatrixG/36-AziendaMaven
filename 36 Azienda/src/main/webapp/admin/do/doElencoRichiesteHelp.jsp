<%@page import = "it.alfasoft.service.Servizi"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

    <%
    
    Servizi service = new Servizi();
      
    request.setAttribute("utentiHelp", service.getTuttiHelp());
    
    %>
    
    <jsp:forward page="../elencoRichiesteHelp.jsp"></jsp:forward>