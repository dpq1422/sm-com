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
package tester.newsroom;

import java.util.ArrayList;
import java.util.List;

import core.newsroom.WatchListData;
import core.regn.UserProfileKey;
import ctrl.newsroom.WatchListController;

/**
 * File:  WatchListTest.java 
 *
 * Created on 02-Sep-2013 4:00:45 PM
 */
public class WatchListTest
{

	/*
	 * Method : WatchListTest -- constructor
	 * 
	 * Input  : None
	 * 
	 * Return : None
	 * 
	 * Purpose:
	 */
	public WatchListTest()
	{
	}
	
	
	/*
	 * Method : addTest()
	 * 
	 * Input  : None
	 * 
	 * Return : None
	 * 
	 * Purpose: it is used to add the new watch list. 
	 */
	public void addTest()
	{
		WatchListController controller = new WatchListController( );
		
		WatchListData watchListData = new WatchListData( );
		
		watchListData.watchListName_ = "My third watchlist";
		
		watchListData.ownerKey_.email_ = "smadmn1@gmail.com";
		
		watchListData.regnKey_.companyPhoneNo_ = "4044082222";
		
		int result = controller.add( watchListData );
		
		System.out.println( "watchlist result id="+result );
		
		if( result == 10100  )
		{
			System.out.println( "Wacthlist add test successfully completed" );
			
			System.out.println( "Wacthlist added successfully" );
		}
		else if (result == 10103) 
		{
			System.out.println( "Wacthlist add test successful" );
			
			System.out.println( "Wacthlist already exist" );
		}
		else
		{
			System.out.println( "Wacthlist add test failed" );
		}
			
	}
	
	/*
	 * Method : deleteTest()
	 * 
	 * Input  : None
	 * 
	 * Return : None
	 * 
	 * Purpose: it is used to delete the watch list. 
	 */
	public void deleteTest()
	{
		WatchListController controller = new WatchListController( );
		
		long watchListId = 3;
		
		int result = controller.remove( watchListId );
		
		if( result == 10110  )
		{
			System.out.println( "Wacthlist delete test successfully completed" );
			
		}
		
		else
		{
			System.out.println( "Wacthlist delete test failed" );
		}
			
	}
	
	/*
	 * Method : fetchTest()
	 * 
	 * Input  : None
	 * 
	 * Return : None
	 * 
	 * Purpose: it is used to fetch the watch lists for given user key. 
	 */
	public void fetchTest()
	{
		WatchListController controller = new WatchListController( );
		
		List<WatchListData> watchLists = new ArrayList<WatchListData>( );
	
		UserProfileKey userProfileKey = new UserProfileKey( );
		
		userProfileKey.email_ = "smadmn1@gmail.com";
		
		int result = controller.get( userProfileKey, watchLists );
		
		if( result == 10120  )
		{
			System.out.println( "Wacthlist fetch test successfully completed" );
			
			for( WatchListData watchListData : watchLists )
            {
	            watchListData.show( );
            }
			
		}
		
		else
		{
			System.out.println( "Wacthlist delete test failed" );
		}
			
	}
	

}