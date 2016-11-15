$(document).ready(function() {
	
	$('#additionalInfo').keypress(function () {
	    var left = 300 - $(this).val().length;
	    if (left < 0) {
	        left = 0;
	    }
	    $('#labelInfo').text(left + ' char left');
	});
	
	$('#inputNome').keypress(function(e) {
		
		popOverFormAlpha($(this), e);				
	});
	
	$('#inputNome').focusout(function() {
		
		inUscitaDaInputForm($(this));
	});
	
	$('#inputCognome').keypress(function(e) {
		
		popOverFormAlpha($(this), e);		
	});

	$('#inputCognome').focusout(function() {
		
		inUscitaDaInputForm($(this));
	});
	
	$('#inputEmail').keypress(function(e) {
		
		popOverFormMail($(this), e);		
	});
	
	$('#inputEmail').focusout(function() {
		
		checkMailSintaxOnExitForm($(this));
	});
	
	$('#selectMenu').change(function(){
		
		sendButtonUpdate();
	});

	$('#selectMenu').on('mouseup', function() {
		var label = $(this).val();

		if ($(this).val() == 4) {
			$('#commentForm').fadeIn("slow");
		} else {
			$('#commentForm').fadeOut("slow");
		}
	});

	$('#help').click(function() {
		$('#modalContact').modal('show').on(
			"click",".btn-primary",	function() {

			$.ajax({

				type : "POST",
				url : "richiestaAiuto",
				data : {
					nome : $('#inputNome').val(),
					cognome : $('#inputCognome').val(),
					email : $('#inputEmail').val(),
					posizione : $('#selectMenu').val(),
					stipendio : $('#additionalInfo').val(),
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

function popOverFormAlpha (tObj, e) {
	
	if (checkSoloParole(e)){
		
		tObj.popover("hide");
		
	}else{
		
		tObj.attr('data-content','Only alphabetical characters are allowed');
		tObj.popover("show");
    	e.preventDefault();
	}
}

function popOverFormMail (tObj, e) {
	
	if (checkMailChar(e)){

		tObj.popover("hide");
		
	}else{
		
		tObj.attr('data-content','This character is not allowed in a mail address');
		tObj.popover("show");
    	e.preventDefault();
	}
}

function checkMailSintaxOnExitForm (tObj) {
	
	if (!tObj.val()){
		tObj.next().attr('class', 'glyphicon form-control-feedback');
    	tObj.parent('div').attr('class','form-group');
		return;
	}	
	
	var regex = /^(([^<>()\[\]\.,;:\s@\"]+(\.[^<>()\[\]\.,;:\s@\"]+)*)|(\".+\"))@(([^<>()[\]\.,;:\s@\"]+\.)+[^<>()[\]\.,;:\s@\"]{2,})$/i;
	
    if (regex.test(tObj.val())) {	
    	
		tObj.parent('div').attr('class','form-group has-success has-feedback');
		tObj.next().attr('class','glyphicon form-control-feedback glyphicon-ok');
		sendButtonUpdate();
		
    }else{

		tObj.parent('div').attr('class','form-group has-error has-feedback');
		tObj.next().attr('class','glyphicon form-control-feedback glyphicon-remove');
		sendButtonUpdate();
    }
}

function inUscitaDaInputForm (tObj){
	
	sendButtonUpdate();
	tObj.popover("hide");
	if (tObj.val()){

		tObj.parent('div').addClass('has-success has-feedback');
		tObj.parent('div').append('<span class="glyphicon glyphicon-ok form-control-feedback"></span>');
		
	}else{
		
		tObj.parent('div').removeClass('has-success has-feedback');
		tObj.next().remove();
	}
}

function checkSoloParole(e){
	
	var regex = new RegExp("^[a-zA-Z]+$");
    var str = String.fromCharCode(!e.charCode ? e.which : e.charCode);
    if (regex.test(str)) {
    
    	sendButtonUpdate();
    	return true;
    }
    sendButtonUpdate();
    return false;
}

function checkMailChar(e){

	var regex = new RegExp("^[a-zA-Z0-9!#$%&'*+-/=?^_`{|}~.@]+$");	
    var str = String.fromCharCode(!e.charCode ? e.which : e.charCode);
    if (regex.test(str)) {
    	
    	
    	return true;
    }
    return false;
}

function sendButtonUpdate(){
	
	var regex = /^(([^<>()\[\]\.,;:\s@\"]+(\.[^<>()\[\]\.,;:\s@\"]+)*)|(\".+\"))@(([^<>()[\]\.,;:\s@\"]+\.)+[^<>()[\]\.,;:\s@\"]{2,})$/i;
	
//	console.log($('#selectMenu').val() != 0);
	console.log($('#inputNome').val());
	console.log(regex.test($('#emailForm').val()));
	if ($('#inputNome').val() && $('#inputCognome').val() && regex.test($('#emailForm').val()) &&
			$('#selectMenu').val() != 0 ){
		
		$('#buttonSend').removeClass('disabled');
		
//		$('#buttonSend').prop('disabled', false);
		
	}else{
//		$('#buttonSend').prop('disabled', true);
		$('#buttonSend').addClass('disabled');
	}
}