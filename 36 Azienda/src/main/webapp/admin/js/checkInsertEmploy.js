$(document).ready(function() {
	
	$('#inputNome').keypress(function(e) {
		
		var regex = new RegExp("[0-9]");
		var str = String.fromCharCode(!e.charCode ? e.which : e.charCode);
		if (regex.test(str)) {
			
			e.preventDefault();

			$("spanNome").show();
			
			//$(this).closest("span").text = "Prova";
//			var prova = $(this).closest("label-warning");
//			alert(prova.attr('class'));
//			$(this).closest("span").fadeIn();
			//var toAppend = $(this).closest("div");
			//toAppend.after( '<span class="label label-warning">Prova</span>' );
			//$( '<span class="label label-warning">Prova</span>' ).insertAfter(toAppend);
			//toAppend.append('<span class="label label-warning">Prova</span>');
		}
	});
	
	
});

