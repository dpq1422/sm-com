/**
 * - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
 * Copyright (c) 2006-2013 Tekton Technologies (P) Ltd. All Rights Reserved.
 * This product and related documentation is protected by copyright and
 * distributed under licenses restricting its use, copying, distribution and
 * decompilation. No part of this product or related documentation may be
 * reproduced in any form by any means without prior written authorization of
 * Tekton Technologies (P) Ltd. and its licensors, if any.
 * - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
 */
package core.vendorregn;

import core.regn.CompanyRegnKey;
import utils.ErrorMaster;

/**
 * File:  NRVendorSearchData.java 
 *
 * Created on Jun 26, 2013 3:14:32 PM
 */

/*
 * Class: NRVendorSearchData
 * 
 * Purpose: This is the domain object to perform searching
 * operation to fetch non registered vendors
 */

public class NRVendorSearchData
{

	public CompanyRegnKey regnKey_;
	public String	searchStr_;
	public String requestSendorType_;
        private static ErrorMaster errorMaster_ = null;


	
	/*Constructor*/
	
	public NRVendorSearchData( )
	{
		regnKey_ = new CompanyRegnKey( );
		searchStr_ = null;
		requestSendorType_ = null;
                if( errorMaster_ == null ) errorMaster_ = new ErrorMaster( );
	}
	
	/*
	 * Method: show
	 * 
	 * Input: None
	 * 
	 * Ouput: void
	 * 
	 * Purpose: This method the prints the variable values in console
	 */
	
	public void show( )
	{
		errorMaster_.insert( "regnKey_			= " + regnKey_.toString( ) );
		errorMaster_.insert( "searchStr_ 		= " + searchStr_ );
		errorMaster_.insert( "requestSendorType_ = " + requestSendorType_ );
	}
	
	/*
	 * Method: clear
	 * 
	 * Input: None
	 * 
	 * Output: void
	 * 
	 * Purpose: This method clears the class variables from memory
	 * 
	 */
	
	public void clear( )
	{
		regnKey_ = null;
		searchStr_ = null;
		requestSendorType_ = null;
	}
}
