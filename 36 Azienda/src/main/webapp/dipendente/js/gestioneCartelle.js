$(document).ready(function() {
	
	$.ajax({

		type : "POST",
		url : "initGestioneCartelle",
		data : {
			set : $("#temp").html()
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
	
	
	
	$('#createFolder').click(function(){
		
		
		$('#modalCreateFolder').modal('show').on("click", ".btn-primary", function() {
			
			
			
		});
	});
	
	
});

