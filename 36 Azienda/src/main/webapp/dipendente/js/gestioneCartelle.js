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
				
				$('#parentId').text(data.parentId);
				$('#parentKey').text(data.parentKey);
				
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

	$('#folderDiv').on("dblclick", "i.fa-folder" ,function(){
		
//		$(this).next().text('esempio');
		$('#parentKey').text($(this).next().text() + $('#parentId').text());
		
		$.ajax({

			type : "POST",
			url : "apriCartella",
			data : {
				key : $('#parentKey').text()
			},

			dataType : "JSON",

			success : function(data, txtStatus, jqXHR) {
				
				var dim = data.length;

				$('#folderDiv').empty();
				$('#folderDiv').append('<br/>');
				$('#parentId').text(data[0]);
				for (var i = 1; i < dim; i++){
					$('#folderDiv').append('<div class="col-sm-2"><i id = "'+ data[i].nome +'" class="fa fa-folder fa-3x"></i><h6>' + data[i].nome + '</h6></div>');
				}
			},
			error : function(jqXHR, txtStatus, erroreLanciato) {

				console.log("ajax error: " + txtStatus);
			}
		})
	});
	
	$('#upFolder').click(function() {
		
		$.ajax({

			type : "POST",
			url : "cartellaSuperiore",
			data : {
				key : $('#parentKey').text()
			},

			dataType : "JSON",

			success : function(data, txtStatus, jqXHR) {
				
				var dim = data.length;

				$('#folderDiv').empty();
				$('#folderDiv').append('<br/>');
				$('#parentId').text(data[0]);
				$('#parentKey').text(data[1]);
				for (var i = 2; i < dim; i++){
					$('#folderDiv').append('<div class="col-sm-2"><i id = "'+ data[i].nome +'" class="fa fa-folder fa-3x"></i><h6>' + data[i].nome + '</h6></div>');
				}
			},
			error : function(jqXHR, txtStatus, erroreLanciato) {

				console.log("ajax error: " + txtStatus);
			}
		})
		
	});
});