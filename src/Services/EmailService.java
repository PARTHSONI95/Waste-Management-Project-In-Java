/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author SHREE GANESH
 */
public class EmailService {
    
   public static void email(String to, String subject, String msg) {    
      // Recipient's email ID needs to be mentioned.
      //String to = "parthsangita95@yahoo.in";

      // Sender's email ID needs to be mentioned
      String from = "parthsangita95@gmail.com";

      // Assuming you are sending email from localhost
      String host = "localhost";

      // Get system properties
      Properties properties = System.getProperties();

      // Setup mail server
      properties.setProperty("mail.host", "smtp.gmail.com");
      properties.setProperty("mail.smtp.port", "465");
      properties.setProperty("mail.defaultEncoding", "UTF-8");
      //properties.setProperty("mail.smtp.user", "parthsangita95@gmail.com");
      //properties.setProperty("mail.smtp.password", "XXXXXXXX");
      properties.setProperty("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
      properties.setProperty("mail.smtp.socketFactory.fallback", "false");
      properties.setProperty("mail.smtp.ssl.enable", "true");
      properties.setProperty("mail.smtp.socketFactory.port", "465");
      properties.setProperty("mail.smtp.auth", "true");
      properties.setProperty("mail.smtp.starttls.enable", "true");
      
      properties.setProperty("mail.smtp.starttls.required", "true");
      properties.setProperty("mail.smtp.starttls.enable", "true");
      
      
      
      
      // Get the default Session object.
      Session session = Session.getDefaultInstance(properties);

      try {
         // Create a default MimeMessage object.
         MimeMessage message = new MimeMessage(session);

         // Set From: header field of the header.
         message.setFrom(new InternetAddress(from));

         // Set To: header field of the header.
         message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

         // Set Subject: header field
         message.setSubject(subject);

         // Now set the actual message
         message.setText(msg);

         // Send message
         Transport.send(message,"parthsangita95@gmail.com","Shreeram*1");
         System.out.println("Sent message successfully....");
      } catch (MessagingException mex) {
         mex.printStackTrace();
      }
   }
    
}
