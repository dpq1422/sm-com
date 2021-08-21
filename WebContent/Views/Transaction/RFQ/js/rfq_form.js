
sNo=0;
itemsCount = 0;

var rfqObj = new Object();


/* This method is used to add the rfq item in rfq form
 * from rfq item popup view
 */
function saveItem()
{
	var itemDet= "";
	
	var itemDesc = $("#popup_item_desc").val();
	
	var partNo   = $("#popup_part_no").val();
	
	var quantity = $("#popup_quantity").val();

	var quantityUnit = $("#quantity_unit").text();
	
	var shipDate = $("#popup_ship_date").val();
	
	
	if( itemDesc == "" )
	{
		$("#rfq_item_form_error").text("Enter the Item description.");
		
		$("#popup_item_desc").focus();
		
		return;
	}
	else if( partNo == ""  )
	{
		$("#rfq_item_form_error").text("Enter the Part No.");
		
		$("#popup_part_no").focus();
		
		return;
	}
	else if( quantity == ""  )
	{
		$("#rfq_item_form_error").text("Enter the Quantity ");
		
		$("#popup_quantity").focus();
		
		return;
	}
	
	else if( shipDate == ""  )
	{
		$("#rfq_item_form_error").text("The shipping date is not selected");
		
		$("#popup_ship_date").focus();
		
		return;
	}
	else if( !isNumber(quantity) )
	{
		$("#rfq_item_form_error").text("Please use only numbers and periods ");
		
		$("#popup_quantity").focus();
		
		return;
	}
	
	$("#rfq_item_form_error").text("");
	
	$("#rfq_add_item_popup").hide();
	
	
	
	// Add item button clicked from RFQ creation form
	if( $("#from_form").val()=="RFQForm")
	{
		sNo=sNo+1;
		
		itemsCount = itemsCount+1;
		
		itemDet += '<div id="item'+itemsCount+'" class="item" style="width:900px;float:left;margin-left:40px;margin-right:20px;">';
		
		itemDet += '<input type="text" class="textbox" id="sno'+itemsCount+'" style="width:30px;margin-right:20px;" disabled value="'+sNo+'";/>';
		
		itemDet += '<input type="text" class="textbox" maxlength=80 id="item_desc'+itemsCount+'" style="width:175px;margin-right:20px;" disabled  value="'+itemDesc+'";/>';
		itemDet += '<input type="text" class="textbox" maxlength=80 id="part_no'+itemsCount+'" style="width:90px;margin-right:20px;" disabled value="'+partNo+'";/>';
		itemDet += '<input type="text" class="textbox" maxlength=7 id="quantity'+itemsCount+'" style="width:90px;" disabled value="'+quantity+'";/>';
		itemDet += '<div class="quantity_unit" id="quantity_unit'+itemsCount+'" >'+quantityUnit+'</div>';
		itemDet += '<input type="text" class="textbox" id="ship_date'+itemsCount+'" style="width:110px;margin-right:20px;" disabled value="'+shipDate+'";/>';
		itemDet += '<input type="button" class="del_btn" id="del_btn_'+itemsCount+'" style="width:110px;margin-right:20px;" onclick="deleteItem('+itemsCount+');"/></div>';
		
		$("#items").append(itemDet);
	}
	else  // Add item button clicked from RFQ Edit from poup view
	{
		
	
		sNo=parseInt($("#popupSNo").val()) +1;
		
		itemsCount = parseInt($("#items_count").val()) +1;
		
		$("#items_count").val(itemsCount);
		
		$("#popupSNo").val(sNo);
		
		
		itemDet += '<div id="popup_item'+itemsCount+'" class="item" style="width:900px;float:left;margin-left:40px;margin-right:20px;">';
		
		itemDet += '<input type="text" class="textbox" id="sno'+itemsCount+'" style="width:30px;margin-right:20px;" disabled value="'+sNo+'";/>';
		
		itemDet += '<input type="text" class="textbox" maxlength=80 id="popup_item_desc'+itemsCount+'" style="width:175px;margin-right:20px;" disabled  value="'+itemDesc+'";/>';
		itemDet += '<input type="text" class="textbox" maxlength=80 id="popup_part_no'+itemsCount+'" style="width:90px;margin-right:20px;" disabled value="'+partNo+'";/>';
		itemDet += '<input type="text" class="textbox" maxlength=7 id="popup_quantity'+itemsCount+'" style="width:90px;" disabled value="'+quantity+'";/>';
		itemDet += '<div class="quantity_unit" id="popup_quantity_unit'+itemsCount+'" >'+quantityUnit+'</div>';
		itemDet += '<input type="text" class="textbox" id="popup_ship_date'+itemsCount+'" style="width:110px;margin-right:20px;" disabled value="'+shipDate+'";/>';
		itemDet += '<input type="button" class="del_btn" id="del_btn_'+itemsCount+'" style="width:110px;margin-right:20px;" onclick="deletePopupItem('+itemsCount+');"/></div>';
		
		$("#popup_items").append(itemDet);
	}
	
	
}





/* This method is used to delete the item from RFQ form */
function deleteItem( itemsCount )
{
	$("#item"+itemsCount).toggle();
	$("#item"+itemsCount).remove();
	
	sNo = sNo -1;
}


function validateRFQ()
{
	var regnKey = $("#regnkey").val();
	
	var userKey = $("#EmailAddress").val();
	
	var toRegnKey =  $("#selected_ven_key").val();
	
	var quoteRef = $("#quote_ref").val();
	
	rfqObj.fromRegnKey = regnKey;
	rfqObj.fromUserKey = userKey;
	rfqObj.toRegnKey   = toRegnKey;
	rfqObj.quoteRef    = quoteRef;
	
	if( $('#outside_supplier').is(":checked") )
	{
		rfqObj.isOutsideSupplier = 1;
		
		rfqObj.outsideSupplierEmail = $("#email").val();
		
		if(rfqObj.outsideSupplierEmail == "" )
		{
			$("#rfq_form_error").text("Outside Supplier E-Mail field is empty");
			
			$("#email").focus();
			
			return;
		}
	}
	else
	{
		rfqObj.isOutsideSupplier = 0;
		
		if( $("#to_company").val() == "" || toRegnKey == ""  )
		{
			$("#rfq_form_error").text("Select the Supplier to send the RFQ Form.");
			
			$("#to_company").focus();
			
			return;
		}
		else if( !$('#rfq_terms_cond').is(":checked") )
		{
			$("#rfq_form_error").text("Accept Terms and Conditions to proceed.");
			
			$("#rfq_terms_cond").focus();
			
			return;
		}
		
	}
	
	
	var items = new Array();
	
	for(var i=1;i<=itemsCount;i++ )
	{
		if ($("#item"+i).length>0) 
		{
		    var item = new Object();
		    item.itemDesc = $("#item_desc"+i).val();
		    item.partNo =$("#part_no"+i).val();
		    item.quantity =$("#quantity"+i).val();
		    item.quantityUnit =$("#quantity_unit"+i).text();
		    item.shipDate =$("#ship_date"+i).val();
		    
		    items.push( item );
		}
	}
	
	
	rfqObj.items = items;
	
	 if( items.length == 0 )
	{
		$("#rfq_form_error").text("Add at least one item to proceed.");
		
		return;
	}
	 
	
	if( $('#outside_supplier').is(":checked") )
	{
		showWarning( "Do you want to send the SupplyMedium invitation E-Mail to an \"Outside supplier\"?" );
	}
	else
	{
		rfqObj.outsideSupplierMailFlag = 0;
		
		sendRFQ();
	}
}

function deleteConfirm()
{
	rfqObj.outsideSupplierMailFlag = 1;
	
	sendRFQ();
}

function cancelInfo()
{
	
	rfqObj.outsideSupplierMailFlag = 0;
	
	sendRFQ();
}

/* This method is used to send the new RFQ form to selected supplier
 * from registered supplier list.
 */
function sendRFQ()
{
	 var rfqData = JSON.stringify(rfqObj);
	 
	 showAjaxLoader();
	
	$.ajax({
		   type: "POST",
		   url: getBaseURL()+"/RFQServlet",
		   dataType: 'json',
		   data: {
			   'RequestType':"RFQCreation",
			   'RFQ': rfqData,
			   
			   },
		   success: function( resJSON )
		   {
			   hideAjaxLoader();
			   
			   if(resJSON.result == "success")
				{
				   resetRFQForm();
				   
				   ShowToast( resJSON.message,2000 );
				   
				   fetchRFQRequest();
				}

				else 
				{
					 ShowToast( resJSON.message,2000 );
				}
			   
		   },
		   error : function(xhr, textStatus, errorThrown) 
		    {
			   hideAjaxLoader();
			   
			   alert("Exception");
			}
		 });
}


/* This method is used to reset the RFQ from details */
function resetRFQForm()
{
	$("#to_company").val("");
	
	$("#outside_supplier").attr("checked",false);
	
	$("#supplier_country").val("");
	
	$("#supplier_state").val("");
	
	$("#supplier_city").val("");
	
	$("#supplier_addr").val("");
	
	$("#supplier_zipcode").val("");
	
	$("#email").val("");
	
	$("#rfq_terms_cond").attr("checked",false);
	
	$("#items").empty();
	
	$("#rfq_form_error").text("");
	
	 $("#selected_ven_key").val("");
	 
	 $("#quote_ref").val("");
	 
	 sNo = 0;
}

/* this method is used to reset the error label */
function resetErrorLbl()
{
	$("#rfq_form_error").text("");
	
}