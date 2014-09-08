package com.dineshonjava.struts2.mail.action;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.opensymphony.xwork2.ActionSupport;

/**
 * @author Dinesh Rajput
 *
 */
public class MailAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	private String from;
	   private String password;
	   private String to;
	   private String subject;
	   private String body;

	   static Properties properties = new Properties();
	   static
	   {
	      properties.put("mail.smtp.host", "smtp.gmail.com");
	      properties.put("mail.smtp.socketFactory.port", "465");
	      properties.put("mail.smtp.socketFactory.class",
	                     "javax.net.ssl.SSLSocketFactory");
	      properties.put("mail.smtp.auth", "true");
	      properties.put("mail.smtp.port", "465");
	   }

	   public String execute() 
	   {
	      String ret = SUCCESS;
	      System.out.println("Struts2Mail entering...");
	      try
	      {
			     System.out.println("from " + from);	         
			     System.out.println("to " + to);	         
			     System.out.println("subject " + subject);	         
			     System.out.println("body " + body);	
			     
	    	  Session session = Session.getDefaultInstance(properties,  
	            new javax.mail.Authenticator() {
		            protected PasswordAuthentication 
		            getPasswordAuthentication() {
		            return new 
		            PasswordAuthentication(from, password);
	            }});

	         Message message = new MimeMessage(session);
	         message.setFrom(new InternetAddress(from));
	         message.setRecipients(Message.RecipientType.TO, 
	            InternetAddress.parse(to));
	         message.setSubject(subject);
	         message.setText(body);
	         Transport.send(message);
	         System.out.println("Email should be sent successfully");
	      }
	      catch(Exception e)
	      {
	         ret = ERROR;
	         System.out.println(e.toString());	         
	         e.printStackTrace();
	      }
	      return ret;
	   }

	   public String getFrom() {
	      return from;
	   }

	   public void setFrom(String from) {
	      this.from = from;
	   }

	   public String getPassword() {
	      return password;
	   }

	   public void setPassword(String password) {
	      this.password = password;
	   }

	   public String getTo() {
	      return to;
	   }

	   public void setTo(String to) {
	      this.to = to;
	   }

	   public String getSubject() {
	      return subject;
	   }

	   public void setSubject(String subject) {
	      this.subject = subject;
	   }

	   public String getBody() {
	      return body;
	   }

	   public void setBody(String body) {
	      this.body = body;
	   }

	   public static Properties getProperties() {
	      return properties;
	   }

	   public static void setProperties(Properties properties) {
		   MailAction.properties = properties;
	   }
}
