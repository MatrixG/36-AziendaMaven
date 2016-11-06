$(document).ready(function() {
	
	alert($("#ruolo").html());
	
	$('#inputCerca').keyup(function() {
		
		$.ajax({

			type : "POST",
			url : "cercaVoce",
			data : {
				testo: 	$(this).val(),
				set: 	$("#ruolo").html() },

			dataType : "JSON",

			success : function(data, txtStatus, jqXHR) {

				if (data.success) {

					

				} else {

					
				}
			},
			error : function(jqXHR, txtStatus, erroreLanciato) {

				console.log("ajax error: " + txtStatus);

			}
		})
		
		
	});
	
	
});

function get(name){
	   if(name=(new RegExp('[?&]'+encodeURIComponent(name)+'=([^&]*)')).exec(location.search))
	      return decodeURIComponent(name[1]);
	}