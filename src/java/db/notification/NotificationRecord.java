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
package db.notification;

import java.sql.Timestamp;
import utils.ErrorMaster;



/**
 * File:  NotificationRecord.java 
 *
 * Created on Sep 24, 2013 2:05:11 PM
 */
public class NotificationRecord
{
	// Id of the notification. This is the auto incremented id
	public long notificationId_;
	
	//receiver key of the notification
	public String receiverKey_;

	//receiver Regnkey of the notification
	public String receiverRegnKey_;
	
	//senderkey of the notification
	public String senderKey_;	
	
	//sender Regnkey of the notification
	public String senderRegnKey_;
	
	//notification Type of the notification
	public String notificationType_;
	
	//notification TypeId of the notification
	public String notificationTypeId_;
	
	//notification Message of the notification
	public String notificationMessage_;
	
	//notification createdTime
	public Timestamp createdTimestamp_;
	
	

	/*
	 * Method : NotificationRecord -- constructor
	 * 
	 * Input  : None
	 * 
	 * Return : None
	 * 
	 * Purpose:
	 */
	public NotificationRecord()
	{
		notificationId_ = -1;
	}

	/*
	 * Method : show( ) 
	 * 
	 * Input : None 
	 * 
	 * Return : None
	 * 
	 * Purpose: It is used to print the all class variable values in console
	 */

	public void show( )
	{
            ErrorMaster errorMaster_ = null;

if( errorMaster_ == null ) errorMaster_ = new ErrorMaster( );
		errorMaster_.insert( "notificationId 		=" + notificationId_ );
		
		errorMaster_.insert( "receiverKey     	=" + receiverKey_ );
		
		errorMaster_.insert( "receiverRegnKey     =" + receiverRegnKey_ );
		
		errorMaster_.insert( "senderKey				=" + senderKey_ );
		
		errorMaster_.insert( "senderRegnKey		=" + senderRegnKey_ );
		
		errorMaster_.insert( "notificationType		=" + notificationType_ );
		
		errorMaster_.insert( "notificationTypeId	=" + notificationTypeId_ );
	
		errorMaster_.insert( "notificationMessage		=" + notificationMessage_ );
		
		errorMaster_.insert( "CreatedTimestamp 		=" + createdTimestamp_ );
	}
	
	/*
	 * Method : clear( ) 
	 * 
	 * Input : None 
	 * 
	 * Return : None
	 * 
	 * Purpose: To reset the class variables.
	 */
	
	public void clear( )
	{
		notificationId_	 			= -1;
		
		receiverKey_ 				= null;
		
		receiverRegnKey_ 		= null;
		
		senderKey_ 					= null;
		
		senderRegnKey_			= null;
		
		notificationType_ 			= null;
		
		notificationTypeId_ 		= null;
		
		notificationMessage_	= null;
		
		createdTimestamp_ 	= null;
	}
}

