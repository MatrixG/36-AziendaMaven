<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>


<!-- left menu starts -->
<div class="col-sm-2 col-lg-2">
	<div class="sidebar-nav">
		<div class="nav-canvas">
			<div class="nav-sm nav nav-stacked"></div>
			<ul class="nav nav-pills nav-stacked main-menu">
				<li class="nav-header">Men�</li>
				<li><a class="ajax-link"
					href="${pageContext.request.contextPath}/dipendente/homePageDipendente.jsp"><i
						class="glyphicon glyphicon-home"></i><span> Home</span></a></li>
				<li><a class="ajax-link"
					href="${pageContext.request.contextPath}/dipendente/nuovaVoceRubrica.jsp"><i
						class="glyphicon glyphicon-plus"></i><span> Nuovo Contatto</span></a></li>
				<li><a class="ajax-link"
					href="${pageContext.request.contextPath}/dipendente/do/doElencoContatti.jsp"><i
						class="glyphicon glyphicon-list"></i><span> Lista Contatti</span></a></li>
				<li><a class="ajax-link"
					href="${pageContext.request.contextPath}/dipendente/cercaContatto.jsp"><i
						class="glyphicon glyphicon-search"></i><span> Cerca Contatto</span></a></li>
				<li><a class="ajax-link"
					href="${pageContext.request.contextPath}/dipendente/fileSystem.jsp"><i
						class="glyphicon glyphicon-folder-open"></i><span> Archiviazione</span></a></li>
			</ul>
		</div>
	</div>
</div>
<!--/span-->
<!-- left menu ends -->

