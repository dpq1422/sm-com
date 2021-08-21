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
package utils;

import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.AuthenticationFailedException;
import javax.mail.Authenticator;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.SendFailedException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;



/**
 * File:  MailerSynchronize.java 
 *
 * Created on 16-Nov-2013 10:48:22 AM
 */
public class MailerSynchronize
{
	private boolean    debug   = false;

	private String     huname_ = "";
	
	private String     hupass_ = "";

	private String     from_, message_, sub_, host_;

	private String [ ] toVect_;
	
	private String pathname_="";
	
	private String filename_="";

	/*
	 * Method : MailerSynchronize.java() -- constructor
	 * 
	 * Input  : None
	 * 
	 * Return : None
	 * 
	 * Purpose:
	 */
	public MailerSynchronize( String [ ] to, String subject, String message, String path, String fileName  )
	{
		
		
		this.from_ 	= AppConfigReader.instance( ).get( "EMAIL_FROM" );

		this.host_ 	= AppConfigReader.instance( ).get( "EMAIL_HOST" );
		

		this.huname_ = AppConfigReader.instance( ).get( "EMAIL_USERNAME" );

		this.hupass_ = AppConfigReader.instance( ).get( "EMAIL_PASSWORD" );
		
		this.toVect_ = to;
		
		this.message_ = message;
		
		this.sub_ = subject;
		
		this.pathname_=path;
		
		this.filename_=fileName;
	}
	
	public int sendMailWithAttachment(  )
	{
		
		Properties prop = new Properties( );
//		prop.put( "mail.smtp.starttls.enable", "true" );
		prop.put( "mail.smtp.host", host_ );
                prop.put( "mail.smtp.port", 25 );
		prop.put( "mail.smtp.auth", "true" );

		Authenticator auth = new SMTPAuthenticator( );

		Session session = Session.getDefaultInstance( prop, auth );
		
		session.setDebug( debug );

		Message message = new MimeMessage( session );
		
		InternetAddress fromAdd = null;
		
		try
        {
			 fromAdd = new InternetAddress( from_ );
        }
        catch( AddressException ex )
        {
        	ErrorLogger.instance( ).logMsg( "Exception InternetAddress - AddressException "+ex.getMessage( ));	
        }
		catch( Exception ex )
        {
			ErrorLogger.instance( ).logMsg( "Exception InternetAddress - Exception "+ex.getMessage( ));	
        }
		
		
		
		try
		{
			message.setFrom( fromAdd );
		}
		catch( MessagingException ex )
		{
			ErrorLogger.instance( ).logMsg( "Exception Message setFrom - MessagingException "+ex.getMessage( ));	
		
		}
		
		catch( IllegalStateException  ex )
		{
			ErrorLogger.instance( ).logMsg( "Exception Message setFrom - IllegalWriteException "+ex.getMessage( ));	
		
		}
		catch( Exception  ex )
		{
			ErrorLogger.instance( ).logMsg( "Exception Message setFrom - Exception "+ex.getMessage( ));	
		
		}
			

			

		InternetAddress [ ] toAdd = new InternetAddress[toVect_.length];
		
		try
        {
			
			
			for( int i = 0; i < toVect_.length; i++ )
			{
				toAdd[i] = new InternetAddress( toVect_[i] );
			}
        }
        catch( AddressException ex )
        {
        	ErrorLogger.instance( ).logMsg( "Exception InternetAddress - AddressException "+ex.getMessage( ));	
        }
		catch( Exception ex )
        {
			ErrorLogger.instance( ).logMsg( "Exception InternetAddress - Exception "+ex.getMessage( ));	
        }
		
		
		try
        {
			message.setRecipients( Message.RecipientType.TO, toAdd );
        }
        catch( MessagingException ex )
        {
        	ErrorLogger.instance( ).logMsg( "Exception message setRecipients - MessagingException "+ex.getMessage( ));	
        }
		
		catch( IllegalStateException  ex )
        {
			ErrorLogger.instance( ).logMsg( "Exception message setRecipients - IllegalStateException "+ex.getMessage( ));	
        }
		catch( Exception  ex )
        {
			ErrorLogger.instance( ).logMsg( "Exception message setRecipients - Exception "+ex.getMessage( ));	
        }
		
		try
        {
			message.setSubject( sub_ );
        }
        catch( MessagingException ex )
        {
        	ErrorLogger.instance( ).logMsg( "Exception message setSubject - MessagingException "+ex.getMessage( ));	
        }
		
		catch( Exception  ex )
        {
			ErrorLogger.instance( ).logMsg( "Exception message setSubject - Exception "+ex.getMessage( ));	
        }
		
		Multipart multipart = null;

		try
        {
			// 3) create MimeBodyPart object and set your message content
			BodyPart messageBodyPart1 = new MimeBodyPart( );

			messageBodyPart1.setText( message_ );
			
			messageBodyPart1.setContent( message_, "text/html" );
			
		
			// 4) create new MimeBodyPart object and set DataHandler object
			// to this object
			MimeBodyPart messageBodyPart2 = new MimeBodyPart( );

			String filename = pathname_;// change accordingly

			DataSource source = new FileDataSource( filename );

			messageBodyPart2.setDataHandler( new DataHandler( source ) );

			messageBodyPart2.setFileName( filename_ );
			
			/*messageBodyPart2.attachFile(new File(filename));
			
			messageBodyPart2.setHeader("Content-Type", "text/plain; charset=\"us-ascii\"; name=\"rfq.xml\"");*/

			// 5) create Multipart object and add MimeBodyPart objects to
			// this object
			multipart = new MimeMultipart( );

			multipart.addBodyPart( messageBodyPart1 );

			multipart.addBodyPart( messageBodyPart2 );
        }
        catch( MessagingException ex )
        {
        	ErrorLogger.instance( ).logMsg( "Exception MimeMultipart - MessagingException "+ex.getMessage( ));	
        }
		
		catch( Exception  ex )
        {
			ErrorLogger.instance( ).logMsg( "Exception MimeMultipart - Exception "+ex.getMessage( ));	
        }
			
		
		try
        {
			// 6) set the multiplart object to the message object
			message.setContent( multipart );
        }
        catch( MessagingException ex )
        {
        	ErrorLogger.instance( ).logMsg( "Exception message setSubject - MessagingException "+ex.getMessage( ));	
        }
		
		catch( Exception  ex )
        {
			ErrorLogger.instance( ).logMsg( "Exception message setSubject - Exception "+ex.getMessage( ));	
        }


		Transport transport = null;
		
		try
		{
			transport = session.getTransport( "smtp" );
			
			transport.connect( host_, from_, hupass_ );
		}
		catch( AuthenticationFailedException ex )
		{
			ErrorLogger.instance( ).logMsg( "Exception Transport connect - AuthenticationFailedException "+ex.getMessage( ));	
		}
		catch (MessagingException ex ) 
		{
			ErrorLogger.instance( ).logMsg( "Exception Transport connect- MessagingException "+ex.getMessage( ) );	
		}
		catch (IllegalStateException ex ) 
		{
			ErrorLogger.instance( ).logMsg( "Exception Transport connect- IllegalStateException "+ex.getMessage( ) );	
		}
		catch (Exception ex ) 
		{
			ErrorLogger.instance( ).logMsg( "Exception Transport connect - Exception "+ex.getMessage( ) );	
		}
		
		
		try
		{
			transport.sendMessage( message, message.getAllRecipients( ) );
		}
		catch( SendFailedException  ex )
		{
			ErrorLogger.instance( ).logMsg( "Exception Transport sendMessage - SendFailedException "+ex.getMessage( ));	
			
			ex.printStackTrace( );
		}
		catch (MessagingException ex ) 
		{
			ErrorLogger.instance( ).logMsg( "Exception Transport sendMessage- MessagingException "+ex.getMessage( ) );	
			
			ex.printStackTrace( );
		}
		
		catch (Exception ex ) 
		{
			ErrorLogger.instance( ).logMsg( "Exception Transport sendMessage - Exception "+ex.getMessage( ) );	
		}
		
		try
		{
			transport.close( );
		}
		
		catch (MessagingException ex ) 
		{
			ErrorLogger.instance( ).logMsg( "Exception Transport close- MessagingException "+ex.getMessage( ) );	
		}
		
		catch (Exception ex ) 
		{
			ErrorLogger.instance( ).logMsg( "Exception Transport close - Exception "+ex.getMessage( ) );	
		}
		
		return 0;
	
	}
	
	
	private class SMTPAuthenticator extends javax.mail.Authenticator
	{

		@Override
		public PasswordAuthentication getPasswordAuthentication( )
		{
			String username = huname_;
			String password = hupass_;
			return new PasswordAuthentication( username, password );
		}
	}

}

