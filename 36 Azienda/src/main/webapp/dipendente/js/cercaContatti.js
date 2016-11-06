$(document).ready(function() {

	$.ajax({

		type : "POST",
		url : "initCercaVoce",
		data : {
			set : $("#ruolo").html()
		},

		dataType : "JSON",

		success : function(data, txtStatus, jqXHR) {

			if (data.success) {

			} else {

				alert("Errore nella inizializzazione!");
			}
		},
		error : function(jqXHR, txtStatus, erroreLanciato) {

			console.log("ajax error: " + txtStatus);

		}
	})

	// alert($("#ruolo").html());

	$('#inputCerca').keyup(function(e) {
		
		var regex = new RegExp("^[a-zA-Z0-9\b]+$");
	    var str = String.fromCharCode(!e.charCode ? e.which : e.charCode);
	    if (regex.test(str)) {

		$.ajax({

			type : "POST",
			url : "cercaVoce",
			data : {
				testo : $(this).val()
			},

			dataType : "JSON",

			success : function(data, txtStatus, jqXHR) {
				
				var dim = data.length;
				$("#myTable tr").remove();
				for (var i = 0; i < dim; i++){
					
					$('#myTable').append('<tr><td>' + data[i].nome + '</td><td>' + data[i].cognome + '</td><td>' +
							data[i].telefono + '</td></tr>');
				}
				

			},
			error : function(jqXHR, txtStatus, erroreLanciato) {

				console.log("ajax error: " + txtStatus);

			}
		})
		
	    }

	});

});