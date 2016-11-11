<!DOCTYPE html>
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<jsp:include page="block/header.jsp"></jsp:include>
<title>Sessione Scaduta</title>

</head>

<body>
	<div class="ch-container center">
		<div class="row">
			<div class="box col-md-4 center login-header">
				<div class="box-inner">
					<div class="box-header well" data-original-title="">
						<h2>
							<i class="glyphicon glyphicon-exclamation-sign"></i> Sessione
							Scaduta
						</h2>
					</div>
					<div class="box-content">
						<div class="box-content">
							La sessione è scaduta!<br /> A breve verrai
							reindirizzato...<br /> <br />

							<div class="progress progress-striped progress-success active">
								<div id="bar" class="progress-bar" style="width: 0%;"></div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<jsp:include page="block/scriptEnd.jsp"></jsp:include>
</body>


<script type="text/javascript">

	var counter = 0;
	var id;

	

	id = setInterval(function() {
		counter++;
		if (counter > 5) {
			clearInterval(id);
			window.location.href = 'login.jsp';
		} else {
			$('#bar').width((counter*2).toString() + "0%");
			
		}
	}, 1000);
</script>

</html>

