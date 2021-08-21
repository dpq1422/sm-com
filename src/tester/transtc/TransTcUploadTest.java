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
package tester.transtc;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import core.notification.NotificationCenterData;
import core.regn.CompanyRegnKey;
import core.regn.UserProfileKey;
import core.transtc.TransTcUploadData;
import ctrl.notification.NotificationController;
import ctrl.transtc.TransTcUploadController;

/**
 * File:  TransTcUploadTest.java 
 *
 * Created on Oct 19, 2013 5:59:41 PM
 */
public class TransTcUploadTest
{
	
	/*
	 * Method : TransTcUploadTest -- constructor
	 * 
	 * Input  : None
	 * 
	 * Return : None
	 * 
	 * Purpose:
	 */
	public TransTcUploadTest( )
	{
		
	}
	
	public void execute()
	{
		fetchTest();
		updateTest();
		
	}
	
	/*
	 * Method : updateTest()
	 * 
	 * Input  : None
	 * 
	 * Return : None
	 * 
	 * Purpose: it is used to update yne transaction term and condition. 
	 */
	public void updateTest()
	{
		TransTcUploadController controller=new TransTcUploadController( );
		TransTcUploadData transTcUploadData=new TransTcUploadData( );
		transTcUploadData.regnKey_.companyPhoneNo_="9751856585";
		transTcUploadData.transType_="quote";
		transTcUploadData.tc_="term quote";
		
		int result=controller.update( transTcUploadData );
		
		System.out.println( " TransTc result="+result);
		if(result==10300)
		{
			System.out.println( "TransTc UpdateTest successfully completed");
			
			System.out.println( "TransTc Updated successfully");
		}
		
		else
		{
			System.out.println( "TransTc Update test failed" );
		}
	}
	
	
	
	
	public void fetchTest()
	{
		TransTcUploadController controller = new TransTcUploadController( );
		
		List<TransTcUploadData> tranlists = new ArrayList<TransTcUploadData>( );
	
		
		CompanyRegnKey regnKey=new CompanyRegnKey( );
		regnKey.companyPhoneNo_="9751856585";
		
		String trans_type="rfq";
		
		
		TransTcUploadData tcData = new TransTcUploadData( );
		
		
		
		tcData.regnKey_=regnKey;
		tcData.transType_=trans_type;
		
		int result = controller.get( tcData, tranlists );
		
		if( result == 10320  )
		{
			System.out.println( "TransactionTc fetch test successfully completed" );
			
			for( TransTcUploadData transTcUploadData : tranlists )
            {
				transTcUploadData.show( );
            }
			
		}
		
		else
		{
			System.out.println( "TransactionTc fetch test failed" );
		}
			
	}
	
	

}