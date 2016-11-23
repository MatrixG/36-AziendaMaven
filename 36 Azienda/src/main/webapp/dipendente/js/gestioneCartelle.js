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
				$('#folderKey').text(data.folderKey);
				
			} else {

				alert("Errore nella inizializzazione!");
			}
		},
		error : function(jqXHR, txtStatus, erroreLanciato) {

			console.log("ajax error: " + txtStatus);

		}
	})
	
	$('#createFolder').click(function(){
		
		$('#inputNome').val('');
		$('#modalCreateFolder').modal('show');
	});
	
	$('#creaButton').click(function (){
		
		$('#modalCreateFolder').modal('hide');
		
		$.ajax({

			type : "POST",
			url : "creaCartella",
			data : {
				key : $('#folderKey').text(),
				userId : $('#temp').text(),
				newName : $('#inputNome').val()
			},

			dataType : "JSON",

			success : function(data, txtStatus, jqXHR) {
				
				var dim = data.length;
				var message = data[0];
				if (message.localeCompare('ok') == 0){
					
					$('#folderDiv').empty();
					$('#folderDiv').append('<br/>');
					for (var i = 1; i < dim; i++){
						$('#folderDiv').append('<div class="col-sm-2"><i id = "'+ data[i].nome +'" class="fa fa-folder fa-3x"></i><h6>' + data[i].nome + '</h6></div>');
					
					}
					$(".alert-success").empty();
					$(".alert-success").append('<strong>Cartella Creata!</strong>');
					$(".alert-success").fadeIn("slow");
					
					var counter = 0;
					var id;
															
					id = setInterval(function() {
					counter++;
					if (counter > 6) {
						clearInterval(id);
						$(".alert-success").fadeOut("slow");
					}}, 1000);
				}else{
					
					$(".alert-warning").empty();
					$(".alert-warning").append('<strong>'+ data[0] +'</strong>');
					$(".alert-warning").fadeIn("slow");
					
					var counter = 0;
					var id;
															
					id = setInterval(function() {
					counter++;
					if (counter > 6) {
						clearInterval(id);
						$(".alert-warning").fadeOut("slow");
					}}, 1000);
					
				}

			
			},
			error : function(jqXHR, txtStatus, erroreLanciato) {

				console.log("ajax error: " + txtStatus);
				
			}
		})
	});
	
	

	$('#folderDiv').on("dblclick", "i.fa-folder" ,function(){
		
//		$(this).next().text('esempio');
		$('#folderKey').text($(this).next().text() + $('#parentId').text());
		
		$.ajax({

			type : "POST",
			url : "apriCartella",
			data : {
				key : $('#folderKey').text()
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
				key : $('#folderKey').text()
			},

			dataType : "JSON",

			success : function(data, txtStatus, jqXHR) {
				
				var dim = data.length;

				$('#folderDiv').empty();
				$('#folderDiv').append('<br/>');
				$('#parentId').text(data[0]);
				$('#folderKey').text(data[1]);
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