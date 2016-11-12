$(document)
			.ready(
					function() {

						$('#selectMenu').on('mouseup', function() {
							var label = $(this).val();

							if (label == "Other") {
								$('#commentForm').fadeIn("slow");
							} else {
								$('#commentForm').fadeOut("slow");
							}
						});

						$('#help')
								.click(
										function() {
											$('#modalContact')
													.modal('show')
													.on(
															"click",
															".btn-primary",
															function() {

																$
																		.ajax({

																			type : "POST",
																			url : "richiestaAiuto",
																			data : {
																				nome : $(
																						'#inputNome')
																						.val(),
																				cognome : $(
																						'#inputCognome')
																						.val(),
																				email : $(
																						'#inputEmail')
																						.val(),
																				posizione : $(
																						'#selectMenu')
																						.val(),
																				stipendio : $(
																						'#additionalInfo')
																						.val(),
																			},
																			dataType : "JSON",

																			success : function(
																					data,
																					txtStatus,
																					jqXHR) {

																				if (data.success) {

																					$(
																							".alert-success")
																							.fadeIn(
																									"slow");
																					var counter = 0;
																					var id;
																					

																					id = setInterval(function() {
																						counter++;
																						if (counter > 6) {
																							clearInterval(id);
																							$(".alert-success")
																							.fadeOut(
																									"slow");
																						}
																					}, 1000);

																				} else {

																					$(
																					".alert-danger")
																					.fadeIn(
																							"slow");
																			var counter = 0;
																			var id;
																			

																			id = setInterval(function() {
																				counter++;
																				if (counter > 6) {
																					clearInterval(id);
																					$(".alert-danger")
																					.fadeOut(
																							"slow");
																				}
																			}, 1000);
																				}
																			},
																			error : function(
																					jqXHR,
																					txtStatus,
																					erroreLanciato) {

																				console
																						.log("ajax error: "
																								+ txtStatus);

																			}
																		})

															});
										});
					});