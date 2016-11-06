$(document).ready(function() {

	$('.btn-danger').click(function() {

		var row = $(this).closest("tr");
		var email = "email=" + row.find("td > div").eq(2).html();

		$('#modalDel').modal('show').on("click", ".btn-primary", function() {

			$.ajax({

				type : "POST",
				url : "../cancellaDipendente",
				data : email,
				dataType : "JSON",

				success : function(data, txtStatus, jqXHR) {

					if (data.success) {

						row.fadeOut("slow");

					} else {

						alert("Error on removing!");
					}
				},
				error : function(jqXHR, txtStatus, erroreLanciato) {

					console.log("ajax error: " + txtStatus);

				}
			})
		});
	});

	 $('.btn-info').click(function() {
	
		 	var row = $(this).closest("tr");
			
			var userInput = row.find("td > div").eq(2).html();
			
			$('#inputNome').val(row.find("td > div").eq(0).html());
			$('#inputCognome').val(row.find("td > div").eq(1).html());
			$('#inputEmail').val(row.find("td > div").eq(2).html());
			$('#inputPosizione').val(row.find("td > div").eq(3).html());
			$('#inputStipendio').val(row.find("td > div").eq(4).html());

			$('#modalModify').modal('show').on(
					"click",
					".btn-primary",
					function() {

						$.ajax({

							type : "POST",
							url : "../modificaDipendente",

							data : {
								nome : $('#inputNome').val(),
								cognome : $('#inputCognome').val(),
								email : $('#inputEmail').val(),
								posizione : $('#inputPosizione').val(),
								stipendio : $('#inputStipendio').val(),
								emailUser : userInput
							},

							dataType : "JSON",

							success : function(data, txtStatus, jqXHR) {

								if (data.success) {

									row.find("td > div").eq(0).html(
											$('#inputNome').val());
									row.find("td > div").eq(1).html(
											$('#inputCognome').val());
									row.find("td > div").eq(2).html(
											$('#inputEmail').val());
									row.find("td > div").eq(3).html(
											$('#inputPosizione').val());
									row.find("td > div").eq(4).html(
											$('#inputStipendio').val());
									//row.toggle("highlight");

								} else {

									alert("Error on modifying!");
								}
							},
							error : function(jqXHR, txtStatus, erroreLanciato) {

								console.log("ajax error: " + txtStatus);

							}
						})

					});

	 });
});