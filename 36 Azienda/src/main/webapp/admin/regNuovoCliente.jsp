<!DOCTYPE html>
<%-- <%@ page import="it.alfasoft.bean.Utente"%> --%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:choose>
  <c:when test="${utente.getRuolo() == 0 && utente.isValid()}">
  
<html>
<jsp:include page="../block/header.jsp"></jsp:include>

<body>
<jsp:include page="../block/topBar.jsp"></jsp:include>

<div class = "row">

<jsp:include page="menu/menuLaterale.jsp"></jsp:include>

<div id="content" class="col-lg-10 col-sm-10">
            <!-- content starts -->
            <div>
    <ul class="breadcrumb">
        <li>
            <a href="#">Home</a>
        </li>
        <li>
            <a href="#">Dashboard</a>
        </li>
    </ul>
</div>

<div class = "row">

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


</div>
    </div><!--/#content.col-md-0-->

</div>
  
    
<hr>
<jsp:include page="../block/footer.jsp"></jsp:include>

<jsp:include page="../block/scriptEnd.jsp"></jsp:include>
</body>
</html>    

</c:when>
	<c:otherwise>
		<c:redirect url="../sessioneScaduta.jsp"></c:redirect>
  	</c:otherwise>
</c:choose>