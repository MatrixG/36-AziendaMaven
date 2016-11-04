<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>


<!-- left menu starts -->
<div class="col-sm-2 col-lg-2">
	<div class="sidebar-nav">
		<div class="nav-canvas">
			<div class="nav-sm nav nav-stacked"></div>
			<ul class="nav nav-pills nav-stacked main-menu">
				<li class="nav-header">Menù</li>
				<li><a class="ajax-link"
					href="${pageContext.request.contextPath}/admin/homePageAdmin.jsp"><i
						class="glyphicon glyphicon-home"></i><span> Home</span></a></li>
				<li class="accordion"><a href="#"><i
						class="glyphicon glyphicon-plus"></i><span> Aggiungi</span></a>
					<ul class="nav nav-pills nav-stacked" id="menuAggiungi">
						<li><a
							href="${pageContext.request.contextPath}/admin/registrazioneNuovoCliente.jsp">Cliente</a></li>
						<li><a href="${pageContext.request.contextPath}/admin/registrazioneNuovoDipendente.jsp">Dipendente</a></li>
					</ul></li>
				<li class="accordion"><a href="#"><i
						class="glyphicon glyphicon-list"></i><span> Elenco</span></a>
					<ul class="nav nav-pills nav-stacked">
						<li><a
							href="${pageContext.request.contextPath}/admin/do/doElencoClienti.jsp">Clienti</a></li>
						<li><a href="${pageContext.request.contextPath}/admin/do/doElencoDipendenti.jsp">Dipendenti</a></li>
					</ul></li>
			</ul>
		</div>
	</div>
</div>
<!--/span-->
<!-- left menu ends -->

