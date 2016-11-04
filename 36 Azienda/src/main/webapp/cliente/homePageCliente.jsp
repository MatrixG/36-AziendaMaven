<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>

<c:choose>
  <c:when test="${utente.getRuolo() == 2 && utente.isValid()}">
  
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

<div class = "row" id="prova">

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