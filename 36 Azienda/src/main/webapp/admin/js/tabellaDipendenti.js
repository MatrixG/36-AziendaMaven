/**
 * 
 */

$(document).ready(function() {
	
	$(".btn btn-danger").click(function() {
		
		$("#my_dialog").dialog({
			
			buttons: {
				"Yes": function() {
					$(this).dialog("close");
					
				},
				
				"No": function() {
					$(this).dialog("close");
					
				}
			}
			
		});
		
	});
	
});