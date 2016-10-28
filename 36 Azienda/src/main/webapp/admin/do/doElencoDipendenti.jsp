<%@page import = "it.alfasoft.service.Servizi"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

    <%
    
    Servizi service = new Servizi();
    
    request.setAttribute("dipendenti", service.getTuttiDipendenti());
    
    %>
    
    <jsp:forward page="../elencoDipendenti.jsp">
      <jsp:param value="" name=""/>
    </jsp:forward>