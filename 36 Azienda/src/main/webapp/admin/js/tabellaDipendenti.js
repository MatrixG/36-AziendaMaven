
$(document).ready(function() {
	
	$('.btn-danger').click(function() {
		
		//var currentLi = $(this).parent().parent().parent().find("td > div").eq(2).html();
		var row = $(this).closest("tr");
		var email = "email=" + row.find("td > div").eq(2).html();
		
		$('#modalDel').modal('show').on("click", ".btn-primary", function() {
			
			$.ajax( {
				
				type: "POST",
				url : "../cancellaDipendente",
				data : email,
				dataType : "JSON",
				
				success: function(data,txtStatus,jqXHR){
					  /// se tutto va bene e riceviamo i dati dal server
					//alert(email);
					  if(data.success){
						  
						  row.fadeOut("slow");
						  
						  
					  }else{
						  
						  alert("Error on removing!");
					  }
					  
					  
				  },
				  
				  error: function(jqXHR,txtStatus,erroreLanciato){
					  // se sucesso qualcosa 
					  
					  console.log("ajax error: " +txtStatus);
					  
					  
				  }
				
				
			})
			
		});
		
	});
	
});

