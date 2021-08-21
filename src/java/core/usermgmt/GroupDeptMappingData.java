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
package core.usermgmt;

import core.dept.DeptKey;
import utils.ErrorMaster;

/**
 * File:  GroupDeptMappingData.java 
 *
 * Created on Mar 5, 2013 4:55:36 PM
 */
public class GroupDeptMappingData
{
	public GroupKey	groupRelKey_;
	public DeptKey	deptRelKey_;
        private static ErrorMaster errorMaster_ = null;



	/*
	 * Method : show( ) Input : None Return : void
	 * 
	 * Purpose: It is used to print the all class variable values in console
	 */

	public void show( )
	{
            if( errorMaster_ == null ) errorMaster_ = new ErrorMaster( );
		errorMaster_.insert( "groupRelKey_		= " + groupRelKey_ );
		errorMaster_.insert( "deptRelKey_		= " + deptRelKey_ );
	}

	/*
	 * Method : clear( ) Input : None Return : None
	 * 
	 * Purpose: It is used to reset all class variable values
	 */

	public void clear( )
	{
		this.groupRelKey_ = null;
		this.deptRelKey_ = null;
	}
}
