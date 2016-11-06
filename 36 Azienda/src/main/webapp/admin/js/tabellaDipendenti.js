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
		
		$('#inputNome').val(row.find("td > div").eq(0).html());
		$('#inputCognome').val(row.find("td > div").eq(1).html());
		$('#inputEmail').val(row.find("td > div").eq(2).html());
		$('#inputPosizione').val(row.find("td > div").eq(3).html());
		$('#inputStipendio').val(row.find("td > div").eq(4).html());

		
		$('#modalModify').modal('show').on("click", ".btn-primary", function() {
			
			
			
		});
	});
});