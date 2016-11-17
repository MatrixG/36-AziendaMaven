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
				
//				console.log(data.parentId);
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
//	
//	$("div").on("dblclick", "i.fa-folder", function(){
//	    var children = $(this).children('h6');
//		console.log(children.text());
//	});
	
//	$('i').on("dblclick", function(){
//		
//		console.log(1);
//	}):

	$('#folderDiv').on("dblclick", "i.fa-folder" ,function(){
		
		console.log($(this).chilren('h6').text);
	});
	
	
	$('.fa-folder').dblclick(function() {
		
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
//				console.log(data.length);
//				console.log(data[0]);
				$('#folderDiv').empty();
				$('#folderDiv').append('<br/>');
				$('#parentId').text(data[0]);
				for (var i = 1; i < dim; i++){
					$('#folderDiv').append('<div class="col-sm-2"><i id = "'+ data[i].nome +'" class="fa fa-folder fa-3x"></i><h6>' + data[i].nome + '</h6></div>');
				}
//				$("#myTable tr").remove();
//				for (var i = 0; i < dim; i++){
//					
//					$('#myTable').append('<tr><td>' + data[i].nome + '</td><td>' + data[i].cognome + '</td><td>' +
//							data[i].telefono + '</td></tr>');
//				}
			},
			error : function(jqXHR, txtStatus, erroreLanciato) {

				console.log("ajax error: " + txtStatus);
			}
		})
		
	});
});