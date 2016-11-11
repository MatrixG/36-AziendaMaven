<%@page import = "it.alfasoft.service.ServiziRubrica"%>
<%@page import = "it.alfasoft.bean.Utente"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

    <%
    
    ServiziRubrica service = new ServiziRubrica();
    request.setAttribute("voci", service.getVoci(((Utente)session.getAttribute("utente")).getId()));	
    
    
    %>
    
    <jsp:forward page="../elencoContatti.jsp">
      <jsp:param value="" name=""/>
    </jsp:forward>