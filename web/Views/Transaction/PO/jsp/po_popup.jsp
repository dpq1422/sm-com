<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/Views/Transaction/PO/css/po_popup.css" />
</head>
<body>

<div style="display: none; z-index: 1000;" class="Custome_Popup_Window"
		id="po_popup">
		<div class="Cus_Popup_Outline po_popup_outline">
			<div class="Popup_Tilte_NewGroup Gen_Popup_Title"
				style="border-radius: 0px;">
				<div style="padding: 0px 0px 0px 15px; float: left" id="po_tl">PO</div>
                                <div style="float: right;width:100px;">
                                    <a onclick="this.href='po_pdf_download?trans_id='+$('#trans_id').val()+'&from='+$('#popup_buyer_name').val()+'&to='+$('#to_company_popup').val()+'&date='+$('#dt').val()+'&typ='+$('#typ').val()+$('#outside_supplier_address').val()" target="_blank"><img src="Views/Transaction/TransCommon/images/open.png" style="margin-top:10px;"></a>    
				<div class="Popup_Close_NewGroup Gen_Cus_Popup_Close"></div>
                                </div>
			</div>

			<div id="po_form_popup_content" style="margin:0px;float:left;height:auto;"
				class="po_form_content">
				<!-- This is the PO form details 
				<div class="to_comp">
					<label class="label"
						style="padding-left: 20px; width: 45px; color: white; line-height: 25px;">To:</label>
					<input type="text" id="to_company_popup" disabled style="width: 890px;"
						class="textbox" onkeyup="getNRVendor();">
				</div>-->                                
				<div class="po_popup_form" id="po_popup_form" style="margin-top:10px;overflow:auto;float:left;height:700px;width:99%;">
				
					<input type="hidden" id="po_id" />
					
					<input type="hidden" id="trans_id" />
					
					<input type="hidden" id="reply_to_comp" />
					
					<input type="hidden" id="reply_to_user" />
					
					<input type="hidden" id="status" />
					
					<input type="hidden" id="items_count" />
					
					<input type="hidden" id="popupSNo">
                                        
                                        <input type="hidden" id="dt">
                                        
                                        <input type="hidden" id="typ"/>
                                        
                                        <input type="hidden" id="outside_supplier_address"/>
					
					<div class="po_buyer_det">
						<div class="sub_heading">Buyer Details</div>

						<div class="trans_row" style="float: left;">
							<label class="trans_label"> Buyers Name </label> <input
								type="text" class="textbox_disable" id="popup_buyer_name" disabled/>
						</div>

						<div class="trans_row">
							<label class="trans_label"> Country </label> <input type="text"
								class="textbox_disable" id="popup_buyer_country" disabled/>
						</div>

						<div class="trans_row">
							<label class="trans_label"> State/Province </label> <input type="text"
								class="textbox_disable" id="popup_buyer_state" disabled/>
						</div>

						<div class="trans_row">
							<label class="trans_label"> City </label> <input type="text"
								class="textbox_disable" id="popup_buyer_city" disabled/>
						</div>

						<div class="trans_row">
							<label class="trans_label"> Address </label> <input type="text"
								class="textbox_disable" id="popup_buyer_addr" disabled/>
						</div>

						<div class="trans_row">
							<label class="trans_label"> Zip Code/Postal Code </label> <input type="text"
								class="textbox_disable" id="popup_buyer_zipcode" disabled/>
						</div>

						<div class="sub_heading" style="margin-top: 20px;">Request
							For PO</div>

						<div class="trans_row">
							<label class="trans_label"> PO Reference </label> <input
								type="text" class="textbox_disable" id="popup_po_ref" disabled/>
						</div>


					</div>
					<div class="addr_sep"></div>
					<div class="po_supplier_det">
						<div class="sub_heading">Supplier Details</div>

						<div class="trans_row">
							<div class="checkContainer">
								<input type="checkbox" class="checkbox" id="popup_outside_supplier">
								<div></div>
							</div>
							<label for="outside_supplier" class="trans_label"
								style="line-height: 19px; margin-left: 5px;">Outside
								Supplier</label>
						</div>

						<div class="popup_supplier_address" style="width: 100%; height: 300px;">
							
							<div class="trans_row">
								<label class="trans_label"> Supplier Name </label> <input type="text"
									class="textbox_disable" id="to_company_popup" disabled/>
							</div>
							
							<div class="trans_row">
								<label class="trans_label"> Country </label> <input type="text"
									class="textbox_disable" id="popup_supplier_country" disabled/>
							</div>

							<div class="trans_row">
								<label class="trans_label"> State/Province </label> <input type="text"
									class="textbox_disable" id="popup_supplier_state" disabled/>
							</div>

							<div class="trans_row">
								<label class="trans_label"> City </label> <input type="text"
									class="textbox_disable" id="popup_supplier_city" disabled/>
							</div>

							<div class="trans_row">
								<label class="trans_label"> Address </label> <input type="text"
									class="textbox_disable" id="popup_supplier_addr" disabled/>
							</div>

							<div class="trans_row">
								<label class="trans_label"> Zip Code/Postal Code </label> <input type="text"
									class="textbox_disable" id="popup_supplier_zipcode" disabled/>
							</div>

						</div>

						<div class="popup_outside_sup_email_content"
							style="width: 480px; height: 300px; display: none">

							<div class="trans_row" style="margin-top: 100px;">
								<label class="trans_label"> Email </label> <input type="text"
									class="textbox" id="popup_email" />
							</div>

						</div>

						<div class="trans_row" style="margin-top: 50px;">
							<label class="trans_label"> Recurring </label> <select
								id="popup_recurring" class="selectbox" style="width: 165px;" disabled>
								<option value="weekly">None</option>
								<option value="weekly">Weekly</option>
								<option value="monthly">Monthly</option>
								<option value="annually">Annually</option>
							</select>
						</div>
					</div>
					
					<div class="items_head">
						<label class="trans_label" style="width:38px;margin-right:22px;">S.No</label>
						<label class="trans_label" style="width:188px;margin-right: 10px;">Item Description</label>
						<label class="trans_label" style="width:98px;margin-right:20px;">Part Number</label>
						<label class="trans_label" style="width:98px;margin-right: 52px;">Quantity</label>
						<label class="trans_label" style="width:118px;margin-right: -3px;">Ship Date</label>
						<label class="trans_label" style="width:118px;margin-right:4px;">Price per unit</label>
						<label class="trans_label" style="width:100px;margin-right:20px;">Multiplier</label>
					</div>
					<div class="items" id="popup_items">
					</div>

					<div
						style="width: 900px; float: left; margin-left: 40px; height: 50px;">
						<input id="popup_add_item_btn" type="button"
							class="add_item general-button" value="Add Item" style="display:none;"/>
					</div>
					
					
					<div class="price_det" id="price_det">
						<div class="price_det_content">
								<label class="price_det_lbl" id="tot_list_price_lbl"> Total List Price: </label>
					
								<label class="price_det_lbl" id="popup_tot_list_price_amt"> 0 </label>
						</div>
						<div class="price_det_content">
							<label class="price_det_lbl" id="tax_lbl"> Tax in Percentage: </label>
					
							<label class="price_det_lbl" id="popup_tax_amt" style="min-width:35px;width:auto;"></label><label>%</label>
						</div>
						<div class="price_det_content">
							<label class="price_det_lbl" id="tot_price_lbl"> Total Price: </label>
					
							<label class="price_det_lbl" id="popup_tot_price_amt" ></label>
						</div>
					</div>
					
					<div class="inquires" id="popup_inquires">
						
					</div>
					
					<div class="new_inquire" id="po_popup_new_inquire">
						<div class="inquire_row">
							<label class="inquire_by"> Inquire: </label>
							<textarea class="inquire_det" id="new_inquire_message">  </textarea>
							<input type="button" class="gen-btn-blue" style="margin-left:30px;margin-top:7px;" id="po_inquire_send"  value="Send" >
							<label class="po_error" style="width:300px;margin-left: 125px;margin-top: 10px;" id="inquire_error"></label>
						</div>
					</div>
					
					<div id="supplier_ctrls" class="supplier_controls">
						<input type="button" class="gen-btn-blue" style="margin-left:30px;" id="po_accept_btn" value="Accept">
						<input type="button" class="gen-btn-red" style="margin-left:30px;" id="po_reject_btn" value="Reject">
						<input type="button" class="gen-btn-blue" style="margin-left:30px;"  id="supp_po_inquire_btn" value="Inquire">
					</div>
					
					<div id="buyer_ctrls" class="buyer_controls">
						<input type="button" class="gen-btn-blue"  style="margin-left:30px;" id="po_edit_btn" value="Edit">
						<input type="button" class="gen-btn-blue"  style="margin-left:30px;" id="buy_po_inquire_btn" value="Inquire">
					</div>
					
					<div class="po_close" id="po_close" >
							<input type="button" class="gen-btn-blue"  style="margin-left:30px;" id="po_close_btn" value="Close">
					</div>
					
					<div class="po_update" id="po_update" style="display:none;">
						<input type="button" class="gen-btn-blue"  style="margin-left:30px;" id="po_update_btn" value="Update" > 
					</div>
					
					<div class="new_inquire" id="reject_reason" style="display:none">
					<div class="inquire_row">
							<label class="inquire_by"> Reason: </label>
							<textarea class="inquire_det" id="reject_reason_text">  </textarea>
							<input type="button" class="gen-btn-blue" style="margin-left:30px;margin-top:7px;" id="reject_reason_send"  value="Send" >
						</div>
						
					</div>
				
					<!--<div id="inquire_ctrls" class="inquire_controls" >
						  <input type="button" class="gen-btn-Gray" style="margin-left:30px;" id="po_inquire_cancel" value="Cancel">
						<input type="button" class="gen-btn-blue" style="margin-left:30px;" id="po_inquire_send"  value="Send" >
					</div>-->
					
					<div class="po_error" id="po_popup_form_error"> 
					</div>
			

				</div>

			</div>
		</div>
	</div>

	

</body>
</html>