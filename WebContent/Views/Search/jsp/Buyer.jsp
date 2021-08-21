<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Search Buyer</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/Views/Utils/css/Custome_Buttons.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/Views/Search/css/Buyer.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/Views/Utils/css/jquery.mCustomScrollbar.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/Views/Utils/css/commonlayout.css" />
	<link rel="stylesheet"
	href="${pageContext.request.contextPath}/Views/Utils/css/elements.css" />

</head>
<body>

<script type="text/JavaScript">
$("#content_loader").hide();
</script>

<%@include file="../../../session_check.jsp"%>
<input type="hidden" value="Nothing" >
	<div class="pagetitlecontainer">
	<div class="pagetitle">Search Buyers</div>
	</div>
	<div  id="searchBuyer" class="content_container" style="padding-top: 0px;float:left;">	
		<div class="pageContent" style="width: 1010px;font-family: Verdana, Arial, sans-serif;padding-top:50px;min-height:700px;" >
		
			<div id="search_buyer_content" style="display:none;">
			<div style="position: relative;float: none;">
				<form id="basic_search_form" style="width:100%;float:left;">
					<div class="searchWindow">
					
								
						<div class="searchRow" style="float:left;width:605px;">
						
							<div style="width:520px;float:left">
							
								<input id="searchTextBox" name="searchTextBox"  placeholder="Search by name, categories, item description" type="text"  />
								
								<label for="searchTextBox" class="error" style=""></label>
								
							</div>
							
							<input  type="button" class="searchbtn" align="right"  style="margin-right:15px;" onclick="basicSearch();"/>
							
							
						</div>
						
						<div class="searchRow" style="float:left;">
							<div style="width:250px;float:right;height:50px;padding-top:3px;">
								<select id="basic_search_cat" name="basic_search_cat" class="selectbox" style="width:250px;">
								
								</select>
								
								<label for="basic_search_cat" class="error" ></label>
								
							</div>
						</div>
						
								
						<div class="searchrow" style="float:left;">
							<div class="checkContainer">
								<input id="searchRegistered" type="checkbox" />
								<div></div>
							</div>
						
							<label for="searchRegistered" style="line-height: 19px;">Search within registered buyers only</label>
						
						</div>					
					
					</div>
				</form>
				
				<form id="advance_search_form" >
				<input id="btnadvancedSearch" type="button" class="general-button btn-Advanced-down" align="right" value="Advanced search" />
				<div class="advancedSearchContainer">						
						<div class="advancedRow" style="margin-top: 15px;margin-left:100px;">
							<select id="Advanced_Selectbox" class="selectbox" style="width:200px;background-color:white;">
							</select>
						</div>
						<div  class="advancedRow">
							<label class="advacedLabel" for="advanPartNumber">Part Number</label>
							<input type="text" id="advanPartNumber1" class="advan_textbox" />
							<input id="btnAddItem" type="button" class="general-button btn-Reset" value="Add Item" />  
						</div>
						<div id="PartNumbercontainer" class="advancedRow">
							<label class="advacedLabel" for="advanName">Name</label>
							<input type="text" id="advanName1" class="advan_textbox" />
						</div>
						<div class="advancedRow">
							<label class="advacedLabel"></label>
							<div class="checkContainer">
								<input id="advancedCheck" type="checkbox" />
								<div></div>
							</div>
							<label for="advancedCheck" style="line-height: 19px">Show Result only if all of the items are found</label>
							
						</div>
						<div class="advancedRow" style="margin-bottom: 2px;">
							<div>
							<div style="margin-left: 99px" class="checkContainer">
								<input type="checkbox"  id="regBuyerCheck"/>
								<div></div>
							</div>
							<label for="regBuyerCheck" style="line-height: 19px">Search within registered buyers only</label>
							<input id="btnReset" style="margin: 0px 10px 0px 0px" type="button" class="general-button btn-Reset" value="Reset" />  
							<input id="btnSearchNow"  style="width: 110px;margin: 0px 5px 0px 0px" type="button" class="general-button gen-btn-Orange" value="Search Now" onclick="advanceSearch();"/>
								
							</div>
						</div>
				</div>
				</form>
			</div>	
			<div class="searchHeading">
				Search Results
			</div>
			
			<div class="noResult" id="searchResults">No buyers found for this search criteria</div>
			<div style="width:1010px;height:auto;float:left;">
			<div class="searchRegistertedResult">
					<div  >
							<span class="searchSubHeading">Registered Buyer List</span>
							<span class="searchNoResults" style="text-decoration: none;" id="reg_comp_count"></span>
					</div>
					<div id="regSearchResult"  class="SearchResult" >
						
					</div>
					<div style="margin-top: 30px;">
						<input id="btnnonGenerateRFQ" type="button" value="Create Quote" class="general-button gen-btn-Orange" />
					</div>
						
			</div>
			
			<div class="searchNonRegistertedResult">
					<div  >
							<span class="searchSubHeading">Non-Registered Buyer List</span>
							<span class="searchNoResults" style="text-decoration: none;" id="non_reg_comp_count"></span>
					</div>
					<div id="nonregSearchResult" class="SearchResult">
					
					</div>
					<div style="margin-top: 30PX;">
						<!-- <input id="btnnonGenerateRFQ" type="button" value="Generate Quote" class="general-button gen-btn-Orange" /> -->
						<input id="btnContact" type="button" value="Contact" class="general-button gen-btn-Orange" />
						 
					</div>
			</div>
			</div>
		</div>
		
		</div>
		<div id="search_ad" class="ad_container"></div>	
		
	</div>

<%@include file="Popup_AddItem.jsp" %>

<%@include file="../../Utils/jsp/Cus_Toast.jsp" %>

<%@include file="../../Utils/jsp/footer.jsp"%>

<script>
$.getScript( "${pageContext.request.contextPath}/Views/Search/js/Buyer.js", function( data, textStatus, jqxhr ) {});
</script>



</body>
</html>