/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.io.IOException;
import java.util.Properties;

import java.io.IOException;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
/**
 *
 * @author GMT
 */
public class MailDao {
    

	//SETUP MAIL SERVER PROPERTIES
	//DRAFT AN EMAIL
	//SEND EMAIL
		
	Session newSession = null;
	MimeMessage mimeMessage = null;
//	public static void main(String args[]) throws AddressException, MessagingException, IOException
//	{
//		Mail mail = new Mail();
//		mail.setupServerProperties();
//		mail.draftEmail();
//		mail.sendEmail();
//	}

	public void sendEmail() throws MessagingException {
		          try {
//                String fromUser = "hoanganh1410tb@gmail.com";  //Enter sender email id
//		String fromUserPassword = "14102000k";  //Enter sender gmail password , this will be authenticated by gmail smtp server
		String fromUser = "letandang01062001@gmail.com";  //Enter sender email id
		String fromUserPassword = "gtnajdbkfcyudevz";
                
                String emailHost = "smtp.gmail.com";
		Transport transport = newSession.getTransport("smtp");
		transport.connect(emailHost, fromUser, fromUserPassword);
		transport.sendMessage(mimeMessage, mimeMessage.getAllRecipients());
		transport.close();
		System.out.println("Email successfully sent!!!");
            } catch (Exception e) {
                e.printStackTrace();
            }
	}

	public MimeMessage draftEmail(String mail, String mess) throws AddressException, MessagingException, IOException {
		String[] emailReceipients = {mail};  //Enter list of email recepients
		String emailSubject = "L???y l???i m???t kh???u DADSOFT";
		String emailBody = "Your password: "+mess+"";
		mimeMessage = new MimeMessage(newSession);
		
		for (int i =0 ;i<emailReceipients.length;i++)
		{
			mimeMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(emailReceipients[i]));
		}
		mimeMessage.setSubject(emailSubject);
	   
      // CREATE MIMEMESSAGE 
	    // CREATE MESSAGE BODY PARTS 
	    // CREATE MESSAGE MULTIPART 
	    // ADD MESSAGE BODY PARTS ----> MULTIPART 
	    // FINALLY ADD MULTIPART TO MESSAGECONTENT i.e. mimeMessage object 
	    
	    
		 MimeBodyPart bodyPart = new MimeBodyPart();
		 bodyPart.setContent(emailBody,"text/html");
		 MimeMultipart multiPart = new MimeMultipart();
		 multiPart.addBodyPart(bodyPart);
		 mimeMessage.setContent(multiPart);
		 return mimeMessage;
	}

	public void setupServerProperties() {
		Properties properties = System.getProperties();
		properties.put("mail.smtp.port", "587");
		properties.put("mail.smtp.auth", "true");
		properties.put("mail.smtp.starttls.enable", "true");
		newSession = Session.getDefaultInstance(properties,null);
	}
}
