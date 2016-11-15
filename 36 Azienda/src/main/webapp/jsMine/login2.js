$(document).ready(function() {
	
	$('#inputNome').focus(function(){
		
		$('#buttonSend').attr('disabled', false);
		$(this).popover('hide');
	});
	
	$('#inputCognome').focus(function(){
		
		$('#buttonSend').attr('disabled', false);
		$(this).popover('hide');
	});
	
	$('#inputEmail').focus(function(){
		
		$('#buttonSend').attr('disabled', false);
		$(this).popover('hide');
	});
	
	$('#selectMenu').focus(function(){
		
		$('#buttonSend').attr('disabled', false);
		$(this).popover('hide');
	});
	
	$('#textArea').focus(function(){
		
		$('#buttonSend').attr('disabled', false);
		$('.popover').popover('hide');
	});
	
	$('#buttonCancel').click(function(){
		
		$('.popover').popover('hide');
	});
	
	$('#buttonX').click(function(){
		
		$('.popover').popover('hide');
	});

	
	$('#buttonSend').mousedown(function(e){
		
		var go = 0;
		
		if (checkAlphabeticalForm($('#inputNome'))){
			go++;
		}
		
		if (checkAlphabeticalForm($('#inputCognome'))){
			go++;
		}
		
		if (checkEmailForm($('#inputEmail'))){
			go++;
		}
		
		var tObj = $('#selectMenu');
		if (tObj.val() != 0){
			if ((tObj.val() == 4) && $('#textArea').val()) {
				
				$('#textArea').parent('div').removeClass('has-error');
				$('#textArea').parent('div').addClass('has-success');
				go++;
				
			}else{
				
				$('#textArea').attr('data-content','You have to specify your problem');
				$('#textArea').popover("show");
				$('#textArea').parent('div').removeClass('has-success');
				$('#textArea').parent('div').addClass('has-error');
				
			}
			
			tObj.parent('div').removeClass('has-error');
			tObj.parent('div').addClass('has-success');
			if (tObj.val() != 4){
				go++;
			}
			
			
		}else{
			
			tObj.attr('data-content','Select one field');
			tObj.popover("show");
			tObj.parent('div').removeClass('has-success');
			tObj.parent('div').addClass('has-error');
		}
		
		if (go != 4){
			$(this).attr('disabled', true);
		}
	});
	
	
	$('#additionalInfo').keypress(function () {
	    var left = 300 - $(this).val().length;
	    if (left < 0) {
	        left = 0;
	    }
	    $('#labelInfo').text(left + ' char left');
	});
	
	
	$('#selectMenu').on('mouseup', function() {
		
		var label = $(this).val();

		if ($(this).val() == 4) {
			$('#commentForm').fadeIn("slow");
		} else {
			$('#commentForm').fadeOut("slow");
		}
	});
	
	//
	//Ajax submitting form method on send click
	
	$('#help').click(function() {
		
		$('#buttonSend').attr('disabled', false);
		cleanForm($('#inputNome'));
		cleanForm($('#inputCognome'));
		cleanForm($('#inputEmail'));
		cleanForm($('#selectMenu'));
		$('#selectMenu').val('0');
		cleanForm($('#textArea'));
		$('#commentForm').hide();
		
		$('#modalContact').modal('show').on(
			"click",".btn-primary",	function() {
				
			$.ajax({

				type : "POST",
				url : "richiestaAiuto",
				data : {
					nome : $('#inputNome').val(),
					cognome : $('#inputCognome').val(),
					email : $('#inputEmail').val(),
					problema : $("#selectMenu option:selected").text(),
					messaggio : $('#additionalInfo').val(),
					from: "Login",
				},
				
				dataType : "JSON",

				success : function(data,txtStatus,jqXHR) {

					if (data.success) {

						$(".alert-success").fadeIn("slow");
						
						var counter = 0;
						var id;
																
						id = setInterval(function() {
						counter++;
						if (counter > 6) {
							clearInterval(id);
							$(".alert-success").fadeOut("slow");
						}}, 1000);

				} else {

					$(".alert-danger").fadeIn("slow");
					var counter = 0;
					var id;
														
					id = setInterval(function() {
					
						counter++;
						if (counter > 6) {
							clearInterval(id);
							$(".alert-danger").fadeOut("slow");
						}}, 1000);
				}},
				error : function(jqXHR,txtStatus,erroreLanciato) {

					console.log("ajax error: " + txtStatus);

				}	
			})
		});							
	});
});

function checkAlphabeticalForm(tObj){
	
	if (!tObj.val()){
		
		tObj.attr('data-content','This field cannot be empty!');
		tObj.popover("show");
		tObj.parent('div').removeClass('has-success');
		tObj.parent('div').addClass('has-error has-feedback');
		tObj.next().removeClass('glyphicon-ok');
		tObj.next().addClass('glyphicon-remove');
		return false;
		
	}else if (checkPermesseSoloParole(tObj.val())){
		
		tObj.parent('div').removeClass('has-error');
		tObj.parent('div').addClass('has-success has-feedback');
		tObj.next().removeClass('glyphicon-remove');
		tObj.next().addClass('glyphicon-ok');
		return true;
		
	}else{
		
		tObj.attr('data-content','Only alphabetical character are allowed!');
		tObj.popover("show");
		tObj.parent('div').removeClass('has-success');
		tObj.parent('div').addClass('has-error has-feedback');
		tObj.next().removeClass('glyphicon-ok');
		tObj.next().addClass('glyphicon-remove');
		return false;
	}
}

function checkEmailForm (tObj){
	
	if (!tObj.val()){
		tObj.attr('data-content','This field cannot be empty!');
		tObj.popover("show");
		tObj.parent('div').removeClass('has-success');
		tObj.parent('div').addClass('has-error has-feedback');
		tObj.next().removeClass('glyphicon-ok');
		tObj.next().addClass('glyphicon-remove');
		return false;
	
	}else if(checkMail(tObj.val())){
		
		tObj.parent('div').removeClass('has-error');
		tObj.parent('div').addClass('has-success has-feedback');
		tObj.next().removeClass('glyphicon-remove');
		tObj.next().addClass('glyphicon-ok');
		return true;
		
	}else{
		
		tObj.attr('data-content','Mail address is not valid!');
		tObj.popover("show");
		tObj.parent('div').removeClass('has-success');
		tObj.parent('div').addClass('has-error has-feedback');
		tObj.next().removeClass('glyphicon-ok');
		tObj.next().addClass('glyphicon-remove');
		return false;
	}
}
	
function checkPermesseSoloParole(temp){
	
	var regex = new RegExp("^[a-zA-Z]+$");
    
    return regex.test(temp);
}

function checkMail(email) {
	
	var regex = /^(([^<>()\[\]\.,;:\s@\"]+(\.[^<>()\[\]\.,;:\s@\"]+)*)|(\".+\"))@(([^<>()[\]\.,;:\s@\"]+\.)+[^<>()[\]\.,;:\s@\"]{2,})$/i;
	
    return regex.test(email);
}

function cleanForm(tObj) {
	
	tObj.val('');
	tObj.next().removeClass('glyphicon-ok');
	tObj.next().removeClass('glyphicon-remove');
	tObj.parent('div').removeClass('has-success');
	tObj.parent('div').removeClass('has-error');
}
