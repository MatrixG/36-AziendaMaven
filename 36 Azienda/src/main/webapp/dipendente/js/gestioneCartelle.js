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
				
				console.log(data.parentId);
				$('#parentId').text(data.parentId);
				
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
	
	
	
	$('.fa-folder').dblclick(function() {
		
		alert($(this).prop('id'));
		
		$.ajax({

			type : "POST",
			url : "apriCartella",
			data : {
				folder : $(this).prop('id'),
				parentId : $('#parentId').text()
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
		
	});
	
	
});

